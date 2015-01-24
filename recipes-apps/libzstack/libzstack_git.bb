SUMMARY = "ZenoTec Network Application Stack"
DESCRIPTION = "ZenoTec Network Application Stack"
AUTHOR = "Kevin Mahoney <kevin.mahoney@zenotec.net>"

LICENSE = "CLOSED"

DEPENDS = "boost"

PV = "0.1+git${SRCPV}"

SRCREV = "7cdb2266d3f9d9a5fc3c9bae09d7f1ea33bf68a9"
SRC_URI = "\
    git://git@zenotec.mynetgear.com/srv/git/zenoutils.git;protocol=ssh;branch=daisy \
"

B = "${WORKDIR}/build"
S = "${WORKDIR}/git"

inherit autotools

