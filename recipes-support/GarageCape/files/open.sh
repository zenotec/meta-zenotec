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

is_closed.sh > /dev/null
ret=${?}
if [ ${ret} -eq 0 ]; then
    echo 0 > ${class_dir}/gpio${gpio_ctrl}/value
    sleep 1
    echo 1 > ${class_dir}/gpio${gpio_ctrl}/value
    sleep 1
    echo 0 > ${class_dir}/gpio${gpio_ctrl}/value
fi

is_open.sh > /dev/null
ret=${?}
exit ${ret}

