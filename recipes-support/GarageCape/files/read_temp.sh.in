#!/bin/sh

SENSORS="@BINDIR@/sensors"
I2CBUS=1
I2CADDR=48


if [ "x${1}x" = "x-fx" ]; then
  temp=$(${SENSORS} -A -f *-i2c-${I2CBUS}-${I2CADDR} | grep temp | awk '{print $2}')
else
  temp=$(${SENSORS} -A *-i2c-${I2CBUS}-${I2CADDR} | grep temp | awk '{print $2}')
fi

echo ${temp}

exit 0

