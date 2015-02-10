SUMMARY = "Zing Application"
DESCRIPTION = "Zing Application"
AUTHOR = "Kevin Mahoney <kevin.mahoney@zenotec.net>"

LICENSE = "CLOSED"

DEPENDS = "virtual/kernel"

PV = "0.1+git${SRCPV}"

SRCREV = "50d8e45b599a0611e11e8c8ce9dab4e0129e85f2"
SRC_URI = "\
    git://git@zenotec.mynetgear.com/srv/git/zing.git;protocol=ssh;branch=master \
"

S = "${WORKDIR}/git/kmod"

inherit module

