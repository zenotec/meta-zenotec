#@TYPE: Machine
#@NAME: common_pc
#@DESCRIPTION: Machine configuration for running a common x86

PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles1 ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles2 ?= "mesa"

require conf/machine/include/qemu.inc
require conf/machine/include/tune-i586.inc

KERNEL_IMAGETYPE = "bzImage"

IMAGE_FSTYPES += "vmdk"

SERIAL_CONSOLE = ""

PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto"
PREFERRED_VERSION_linux-yocto ?= "3.14%"

XSERVER = "xserver-xorg \
           ${@base_contains('DISTRO_FEATURES', 'opengl', 'mesa-driver-swrast', '', d)} \
           xf86-input-vmmouse \
           xf86-input-keyboard \
           xf86-input-evdev \
           xf86-video-vmware"

MACHINE_FEATURES += "x86"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "v86d"