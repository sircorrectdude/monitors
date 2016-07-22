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

#for safety increase the value some seconds over the real signal timeout
timeSignalOn=32

#resist Value of the real-world signal
resistValue=30

#log state
log="error"

def setup():
	ADC.setup(0x48)
	GPIO.setup(DO, GPIO.IN)

def log(msg):
	if(log=="debug"):
		output = open("/home/pi/photores/photores.log",'ab')
		output.write("["+strftime("%Y-%m-%d %H:%M:%S", gmtime()) +"] - "+ str(msg)+"\n")	
		output.close()

def count_down():
	global countdown
	if countdown==0:	
		while countdown < timeSignalOn:
			time.sleep(1)
			countdown = countdown + 1
			log("seconds till 0 : "+ str(timeSignalOn-countdown))
		countdown = 0	

def screen():
	log('Detected Photores Threshold...counting')
	url = 'http://192.168.1.6:8080/signal?remainTime='+str(timeSignalOn)
	try:
		r = requests.put(url, data = {})
		r.text
	except:
		log("error: network unreachable")
	#t = threading.Thread(target=count_down)
	#t.start()
	count_down()
	loop()

def loop():
	status = 1
	while True:
		log('Photres Value: '+ str(ADC.read(0)))
		if ADC.read(0) < resistValue:
			screen()
			break	
		time.sleep(1)

if __name__ == '__main__':
	try:
		setup()
		loop()
	except KeyboardInterrupt: 
		pass	
