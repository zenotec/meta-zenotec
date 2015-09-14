FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.14:${THISDIR}/${PN}-3.14/${MACHINE}:"

PR := "${PR}.1"

# Add ZenoTec machines 
COMPATIBLE_MACHINE_beaglebone = "beaglebone"
COMPATIBLE_MACHINE_raspberrypi = "raspberrypi"
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
    file://zenotec.cfg \
    file://sensors.cfg \
    file://80211.cfg \
    file://batman-adv.cfg \
    file://${MACHINE}.cfg \
"
###############################################################################


###############################################################################


###############################################################################

# Make machine specific so we don't break stock beaglebone and other supported linux-yocto machines

SRC_URI_append_beaglebone = "\
    ${SRC_URI_CFG} \
    file://0001-force-nonposted-mode.patch \
    file://am335x-bone-common.dtsi \
    file://am335x-boneblack.dts \
"

SRC_URI_append_raspberrypi = "\
    ${SRC_URI_CFG} \
"

SRC_URI_append_z-bbb = "\
    file://defconfig \
    ${SRC_URI_CFG} \
    file://0001-force-nonposted-mode.patch \
    file://am335x-bone-common.dtsi \
    file://am335x-boneblack.dts \
"

SRC_URI_append_z-qemu = "\
    ${SRC_URI_CFG} \
"

do_copy_devicetree() {
    cp ${WORKDIR}/am335x-bone-common.dtsi ${WORKDIR}/linux/arch/${ARCH}/boot/dts
    cp ${WORKDIR}/am335x-boneblack.dts ${WORKDIR}/linux/arch/${ARCH}/boot/dts
}

do_install_prepend_beaglebone() {
    do_copy_devicetree
}

do_install_prepend_z-bbb() {
    do_copy_devicetree
}

