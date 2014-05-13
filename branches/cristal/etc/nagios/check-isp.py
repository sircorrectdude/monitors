#!/usr/bin/python -t

import subprocess
import sys

isp_gateway = sys.argv[1]
isp_gateway_ip = sys.argv[2]
host = "8.8.8.8"

ping = subprocess.Popen(
    ["ping", "-c", "2", isp_gateway_ip],
    stdout = subprocess.PIPE,
    stderr = subprocess.PIPE
)
out, error = ping.communicate()
print out

arping = subprocess.Popen(
    ["arping", "-c", "2", "-T", host, isp_gateway],
    stdout = subprocess.PIPE,
    stderr = subprocess.PIPE
)

out, error = arping.communicate()
print out
if "0 packets received" in out:
        print "GATEWAY "+isp_gateway+" CRITICAL "
        sys.exit(2)
print "GATEWAY "+isp_gateway+" OK "
sys.exit(0)
