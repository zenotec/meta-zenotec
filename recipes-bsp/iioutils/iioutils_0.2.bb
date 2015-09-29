SUMMARY = "Industrial I/O Utils"
DESCRIPTION = "Utility programs associate with the Linux kernel industrial I/O framework. Similar in purpose to lsusb."

AUTHOR = "Kevin Mahoney <kevin.mahoney@zenotec.net>"
HOMEPAGE = "http://sourceforge.net/projects/iioutils"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "\
    http://downloads.sourceforge.net/project/iioutils/iioutils/iioutils-0.2.tar.gz \
"

SRC_URI[md5sum] = "8a88b711d3d6a7fedd75af833c5470cb"
SRC_URI[sha256sum] = "a5009b02d80b7bb2dc073e339fd9bda961d1131f6b20127d8860c86d2578e09c"

S = "${WORKDIR}/${PN}"

inherit autotools

