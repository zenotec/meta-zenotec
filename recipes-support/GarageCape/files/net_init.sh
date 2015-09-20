#!/bin/sh

ip addr add 10.10.10.1 dev wlan0
route add -net 10.10.10.0/24 dev wlan0
ifconfig wlan0 up
