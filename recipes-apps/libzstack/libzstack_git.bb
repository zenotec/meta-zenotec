SUMMARY = "ZenoTec Network Application Stack"
DESCRIPTION = "ZenoTec Network Application Stack"
AUTHOR = "Kevin Mahoney <kevin.mahoney@zenotec.net>"

LICENSE = "CLOSED"

DEPENDS = "boost"

PV = "0.1+git${SRCPV}"

SRCREV = "90954cdaf897d3576bea3d5915d3ac43f5bc859e"
SRC_URI = "\
    git://git@zenotec.mynetgear.com/srv/git/zenoutils.git;protocol=ssh;branch=daisy \
"

B = "${WORKDIR}/build"
S = "${WORKDIR}/git"

inherit autotools

