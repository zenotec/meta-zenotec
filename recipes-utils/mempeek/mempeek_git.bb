SUMMARY = "Memory peek utility"
DESCRIPTION = "Kernel module utility for reading physical memory space"
HOMEPAGE = "https://github.com/zenotec"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

DEPENDS = "virtual/kernel"

PV = "0.0.1+gitr${SRCREV}"

SRC_URI = "\
    git://github.com/zenotec/mempeek.git;protocol=https \
    file://0001-dev.patch \
"

SRCREV = "f553f0781867dd2cd2c8f9fed3baf12d348a9073"

S = "${WORKDIR}/git"

inherit module

