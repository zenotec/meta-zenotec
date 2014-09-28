SUMMARY = "Edimax EW-7811Un Wireless Nano USB Adapter device driver"
DESCRIPTION = "Edimax EW-7811Un Wireless Nano USB Adapter device driver"

AUTHOR = "Kevin Mahoney <kevin.mahoney@entropic.com>"
HOMEPAGE = "www.edimax.com"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;md5=fe095a4d8ce4f6ac099ed0681de77097"

DEPENDS = "virtual/kernel"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES += "kernel-module-8192cu"

PKGVER = "v4.0.2_9000"
PKGREV = "20130911"

LOCALSRC1 = "file://${WORKDIR}/EW-7811Un_Linux_driver_v1.0.0.5/EW-7811Un_USB_linux_${PKGVER}.${PKGREV}.zip"
LOCALSRC2 = "file://${WORKDIR}/RTL8188C_8192C_USB_linux_v4.0.2_9000.20130911/driver/rtl8188C_8192C_usb_linux_${PKGVER}.${PKGREV}.tar.gz"

SRC_URI = " \
   http://www.edimax.com/edimax/mw/cufiles/files/download/Driver_Utility/transfer/Wireless/NIC/EW-7811Un/EW-7811Un_Linux_driver_v1.0.0.5.zip \
"
SRC_URI[md5sum] = "22ade158c574902a6c2dd8a13f63af38"
SRC_URI[sha256sum] = "68b30ef3ced7aae2b038a3505680f82b3f35e7839c10ef6f911066cf2d03e042"

S = "${WORKDIR}/rtl8188C_8192C_usb_linux_${PKGVER}.${PKGREV}"

inherit module

python do_unpack () {
    bb.build.exec_func('base_do_unpack', d)
    src_uri = d.getVar('SRC_URI')
    d.setVar('SRC_URI', '${LOCALSRC1}')
    bb.build.exec_func('base_do_unpack', d)
    d.setVar('SRC_URI', '${LOCALSRC2}')
    bb.build.exec_func('base_do_unpack', d)
    d.setVar('SRC_URI', src_uri)
}

do_compile() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    ${MAKE} V=1 \
        -C ${STAGING_KERNEL_DIR} \
        M=${S} \
        ARCH=arm \
        CROSS_COMPILE=${TARGET_PREFIX} \
        CONFIG_RTL8192CU=m \
        modules
}

do_install() {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/extra
    install -m644 ${S}/8192cu.ko ${D}/lib/modules/${KERNEL_VERSION}/extra
}

