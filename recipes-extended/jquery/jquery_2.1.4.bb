SUMMARY = "jQuery"
DESCRIPTION = "jQuery is a fast, small, and feature-rich JavaScript library. \
It makes things like HTML document traversal and manipulation, event handling, \
animation, and Ajax much simpler with an easy-to-use API that works across a \
multitude of browsers. With a combination of versatility and extensibility, \
jQuery has changed the way that millions of people write JavaScript."

AUTHOR = "Kevin Mahoney <kevin.mahoney@zenotec.net>"
HOMEPAGE = "https://jquery.com/"

LICENSE = ""
DEPENDS = ""

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}"

SRC_URI = "\
    file://LICENSE.txt \
    file://${PN}-${PV}.min.js \
"

LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE.txt;md5=40f3ad02940d5b48e29b1b598e71b822"

SRC_URI[md5sum] = "f9c7afd05729f10f55b689f36bb20172"
SRC_URI[sha256sum] = "f16ab224bb962910558715c82f58c10c3ed20f153ddfaa199029f141b5b0255c"

do_install() {
    install -d ${D}/www/pages
    install -d ${D}/www/pages/scripts
    install -m 755 ${WORKDIR}/${PN}-${PV}.min.js ${D}/www/pages/scripts/jquery.js
}

FILES_${PN} += "\
    /www/pages/scripts/jquery.js \
"

