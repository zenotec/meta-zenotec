SUMMARY = "Zing Application"
DESCRIPTION = "Zing Application"
AUTHOR = "Kevin Mahoney <kevin.mahoney@zenotec.net>"

LICENSE = "CLOSED"

DEPENDS = "libzstack"

PV = "0.1+git${SRCPV}"

SRCREV = "e86513517e5fa782a0cec1584b730a54ae73e676"
SRC_URI = "\
    git://git@zenotec.mynetgear.com/srv/git/zing.git;protocol=ssh;branch=master \
"

B = "${WORKDIR}/build"
S = "${WORKDIR}/git"

inherit autotools

