#!/usr/bin/env python
import PCF8591 as ADC
import RPi.GPIO as GPIO
import time
import threading
import requests
from time import gmtime, strftime

DO = 17
GPIO.setmode(GPIO.BCM)
countdown = 0
server_url="http://10.95.6.191:8081"
#server_url="http://192.168.1.6:8080"

countState = 0

#for safety increase the value some seconds over the real signal timeout
#timeSignalOn=195
timeSignalOn=185
#resist Value of the real-world signal
resistValue=70

releaseValue=140

#log state
log="error"

def setup():
	ADC.setup(0x48)
	GPIO.setup(DO, GPIO.IN)

def log(msg):
#	if(log=="debug"):
	output = open("/home/pi/photores/photores.log",'ab')
	output.write("["+strftime("%Y-%m-%d %H:%M:%S", gmtime()) +"] - "+ str(msg)+"\n")	
	output.close()

def count_down():
	global countdown
#	global countState
	if countdown==0:	
		while countdown < timeSignalOn:
			time.sleep(1)
			countdown = countdown + 1
#			log("seconds till 0 : "+ str(timeSignalOn-countdown))
		countdown = 0
#		countState=0

def release():
	#countState
#	log('Detected Photores Threshold...RELEASE')
        url = server_url+'/signal?remainTime=0'
        try:
                r = requests.put(url, data = {})
                r.text
		global countState
		countState=0
        except:
                log("error: network unreachable")

def screen():
#	log('Detected Photores Threshold...SCREEN')
	url = server_url+'/signal?remainTime='+str(timeSignalOn)
	try:
		r = requests.put(url, data = {})
		r.text
		global countState
		countState=1
	except:
		log("error: network unreachable")
	t = threading.Thread(target=count_down)
	t.start()
	#count_down()
	#loop()

def loop():
	global countState
	while True:
#		log('Photres Value: '+ str(ADC.read(0)))
		if ADC.read(0) < resistValue:
        		#t = threading.Thread(target=screen)
        		#t.start()
			if(countState == 0):
				screen()
			#break
		if ADC.read(0) > releaseValue:
			if(countState==1):
				release()
		time.sleep(1)

if __name__ == '__main__':
	try:
		setup()
#		loop = threading.Thread(target=loop)
#		loop.start()
		loop()
	except KeyboardInterrupt: 
		pass	
