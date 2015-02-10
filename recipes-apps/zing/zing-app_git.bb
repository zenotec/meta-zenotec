SUMMARY = "Zing Application"
DESCRIPTION = "Zing Application"
AUTHOR = "Kevin Mahoney <kevin.mahoney@zenotec.net>"

LICENSE = "CLOSED"

DEPENDS = "libzstack"

PV = "0.1+git${SRCPV}"

SRCREV = "20999a760fc0f07d5de5a4257779f1b2cdc465f0"
SRC_URI = "\
    git://git@zenotec.mynetgear.com/srv/git/zing.git;protocol=ssh;branch=master \
"

B = "${WORKDIR}/build"
S = "${WORKDIR}/git"

inherit autotools

