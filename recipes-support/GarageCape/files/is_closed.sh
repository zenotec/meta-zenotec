#!/bin/sh

gpio_ctrl=115
gpio_sens=117

class_dir="/sys/class/gpio"

if [ ! -d "${class_dir}/gpio${gpio_ctrl}" ]; then
    echo ${gpio_ctrl} > ${class_dir}/export
fi

if [ ! -d "${class_dir}/gpio${gpio_sens}" ]; then
    echo ${gpio_sens} > ${class_dir}/export
fi

if [ $(cat ${class_dir}/gpio${gpio_ctrl}/direction) != "out" ]; then
    echo out > ${class_dir}/gpio${gpio_ctrl}/direction
fi

if [ $(cat ${class_dir}/gpio${gpio_sens}/direction) != "in" ]; then
    echo in > ${class_dir}/gpio${gpio_sens}/direction
fi

if [ $(cat ${class_dir}/gpio${gpio_sens}/value) = "1" ]; then
    echo "Garage door is closed"
    exit 0
fi

exit 1

