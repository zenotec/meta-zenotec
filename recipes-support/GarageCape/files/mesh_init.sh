#!/bin/sh 

lsmod | grep -q batman-adv
ret=${?}
if [ ${ret} -ne 0 ]; then
  modprobe batman-adv
fi

/etc/init.d/hostapd stop
sleep 1
ifconfig wlan0 mtu 1560
iwconfig wlan0 mode ad-hoc essid ZenHome ap 02:00:06:20:07:08 channel 1
batctl if add wlan0
ifconfig wlan0 up
ifconfig bat0 up
brctl addbr br-lan
brctl addif br-lan bat0
brctl addif br-lan eth0
ip addr add 192.168.10.1 dev br-lan
ifconfig br-lan up

