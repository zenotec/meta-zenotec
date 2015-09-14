SUMMARY = "Image with standard Linux packages"

inherit core-image

IMAGE_FEATURES += "\
    splash \
    package-management \
    ssh-server-dropbear \
"

IMAGE_INSTALL_append = "\
    linux-firmware \
    i2c-tools \
    lmsensors-sensors \
    ethtool \
    tcpdump \
    wireless-tools \
    bridge-utils \
    batctl \
"

