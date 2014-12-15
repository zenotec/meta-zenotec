SUMMARY = "Edimax EW-7811Un Wireless Nano USB Adapter device driver"
DESCRIPTION = "Edimax EW-7811Un Wireless Nano USB Adapter device driver"

AUTHOR = "Kevin Mahoney <kevin.mahoney@entropic.com>"
HOMEPAGE = "www.edimax.com"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;md5=fe095a4d8ce4f6ac099ed0681de77097"

DEPENDS = "virtual/kernel"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES += "kernel-module-8192cu"

SRCREV = "a53c4ece2757c54515d603206046abd1fe88f240"
SRC_URI = " \
   git://github.com/gnab/rtl8812au.git;protocol=https \
"

S = "${WORKDIR}/git"

inherit module

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

