#!/usr/bin/python -t

import subprocess
import sys

isp_gateway = sys.argv[1]
host = "8.8.8.8"

ping = subprocess.Popen(
    ["ping", "-c", "4", isp_gateway, host],
    stdout = subprocess.PIPE,
    stderr = subprocess.PIPE
)

out, error = ping.communicate()
if "100% packet loss" in out: 
	print "GATEWAY "+isp_gateway+" CRITICAL\n" + out
	sys.exit(2)
print "GATEWAY "+isp_gateway+" OK\n" + out
sys.exit(0)
