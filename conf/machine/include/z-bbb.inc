#@TYPE: Machine
#@NAME: ZenoTec Beaglebone Black custom machine
#@DESCRIPTION: Machine configuration for the ZenoTec customized Beaglebone Black


MACHINE_EXTRA_RRECOMMENDS = " kernel-modules kernel-devicetree"

MACHINE_EXTRA_RDEPENDS += "i2c-tools"

EXTRA_IMAGEDEPENDS += "u-boot"

DEFAULTTUNE ?= "cortexa8hf-neon"
include conf/machine/include/tune-cortexa8.inc

IMAGE_FSTYPES += "tar.bz2"

SERIAL_CONSOLE = "115200 ttyO0"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto"
PREFERRED_VERSION_linux-yocto ?= "3.14%"

KERNEL_IMAGETYPE = "uImage"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

SPL_BINARY = "MLO"
UBOOT_SUFFIX = "img"
UBOOT_MACHINE = "am335x_evm_config"
UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

MACHINE_FEATURES = "usbgadget usbhost vfat alsa"
