FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.14:${THISDIR}/${PN}-3.14/${MACHINE}:"

PR := "${PR}.1"

# Add ZenoTec machines 
COMPATIBLE_MACHINE_z-bbb = "z-bbb"
COMPATIBLE_MACHINE_z-qemu = "z-qemu"

###############################################################################
#
# Kernel Configuration
#
# defconfig: Standard beaglebone black kernel configuration supported by TI
# zenotec.cfg: Common kernel configuration supporting all zenotec platforms
# "machine".cfg: Machine specific kernel configuration
#
SRC_URI_CFG = "\
    file://defconfig \
"
###############################################################################

###############################################################################
#
# Kernel Device Tree
#
SRC_URI_DTS = "\
    file://am335x-zenotec.dtsi \
    file://am335x-${MACHINE}.dts \
"
###############################################################################

###############################################################################
#
# Kernel Patches (common)
#
SRC_URI_PATCHES = "\
    file://0001-force-nonposted-mode.patch \
"
###############################################################################

# Make machine specific so we don't break stock beaglebone and other supported linux-yocto machines

SRC_URI_append_z-bbb = "\
    ${SRC_URI_CFG} \
    ${SRC_URI_DTS} \
    ${SRC_URI_PATCHES} \
"

SRC_URI_append_z-qemu = "\
"

do_copy_devicetree() {
    cp ${WORKDIR}/am335x-zenotec.dtsi ${WORKDIR}/linux/arch/${ARCH}/boot/dts
    cp ${WORKDIR}/am335x-${MACHINE}.dts ${WORKDIR}/linux/arch/${ARCH}/boot/dts
}

do_install_prepend_z-bbb() {
    do_copy_devicetree
}

do_install_prepend_z-qemu() {
}

