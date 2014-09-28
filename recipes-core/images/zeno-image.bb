SUMMARY = "Image with standard Linux packages"

inherit core-image

IMAGE_INSTALL += "opkg"
IMAGE_INSTALL += "dropbear"
IMAGE_INSTALL += "mempeek"

