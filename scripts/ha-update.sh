#!/bin/sh
#Example:
#ha-update.sh http://IP-ADDRESS:8123 PASSWORD off

ha_server=$1
ha_api_password=$2
ha_state=$3
cmd_curl="curl -X POST -d '{\"state\":\"$ha_state\"}' $ha_server/api/states/switch.garage_door -H \"x-ha-access: $ha_api_password\""
cmd_curl_output=`eval $cmd_curl`
echo $cmd_curl_output > /home/root/ha-update.log
exit
