#!/bin/bash 
 
usage () {
  echo "Usage: $(basename ${0}) <file> <dev>"
}

# Verify script is being run as root
if [ "$(whoami)" != "root" ]; then
  echo -e "\nERROR: Must be run as root."
  usage
  exit 1
fi

# Verify arguments
if [ ${#} -lt 2 ]; then
  echo -e "\nERROR: Missing argument."
  usage
  exit 1
fi
if [ ${#} -gt 2 ]; then
  echo -e "\nERROR: Unexpected argument."
  usage
  exit 1
fi

# Setup variables
file=$(basename ${1})
imagedir=$(dirname ${1})
dev=${2}
tmpdir="/tmp/mnt${dev}"

if [ ! -e ${dev} ]; then
  echo -e "ERROR: Device '${dev}' does not exist."
  exit 1  
fi
if [ ! -e ${dev}1 ] || [ ! -e ${dev}2 ]; then
  echo -e "ERROR: Device '${dev}' is not properly partitioned."
  exit 1  
fi

if [ ! -e ${imagedir}/${file} ] ; then
  echo "File '${file}' does not exist"
  exit 1  
fi

# Do work
set -e; \
  part=1; \
  mkdir -p ${tmpdir}${part}; \
  mount ${dev}${part} ${tmpdir}${part}; \
  rm -rf ${tmpdir}${part}/*; \
  cp ${imagedir}/MLO ${imagedir}/u-boot.img ${tmpdir}${part}; \
  sync; \
  umount ${tmpdir}${part};

set -e; \
  part=2; \
  mkdir -p ${tmpdir}${part}; \
  mount ${dev}${part} ${tmpdir}${part}; \
  rm -rf ${tmpdir}${part}/*; \
  tar xvf ${imagedir}/${file} -C ${tmpdir}${part}; \
  test -d rfs_overlay && cp -av rfs_overlay/* ${tmpdir}${part}; \
  sync; \
  umount ${tmpdir}${part};


exit ${?}

