DESCRIPTION = "Control application for B.A.T.M.A.N. routing protocol kernel module for multi-hop ad-hoc mesh networks."
HOMEPAGE = "http://www.open-mesh.net/"
SECTION = "console/network"
PRIORITY = "optional"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;md5=51e08439be1b71d099d1919a391ed2dd"

RDEPENDS_${PN} = "kernel-module-batman-adv"
DEPENDS = "libnl"

SRC_URI = "\
    http://downloads.open-mesh.net/batman/stable/sources/batctl/batctl-${PV}.tar.gz \
"

SRC_URI[md5sum] = "d28ad89d71888ad6b99a1f6b30c9d47c"
SRC_URI[sha256sum] = "634d91189f96bda6d4ce6179dce90ad578566f29d3111b49d6e775d4f3591f04"

EXTRA_OEMAKE = 'STAGING_INC="${STAGING_INC}"'

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 batctl ${D}${bindir}
}

FILES_${PN} = "${bindir}/batctl"
