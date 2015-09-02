#!/bin/bash

if [ ${#} -ne 1 ]; then
  echo "Please specify machine name"
  exit 1
fi

export MACHINE=${1}
source ${0/.sh} 
exit 0

