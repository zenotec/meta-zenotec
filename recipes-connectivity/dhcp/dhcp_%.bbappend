FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR := "${PR}.1"

SRC_URI_append = "\
    file://dhcpd.conf \
    file://default-server \
"

inherit update-rc.d
INITSCRIPT_PACKAGES = "dhcp-server"
INITSCRIPT_NAME = "dhcp-server"
INITSCRIPT_PARAMS = "start 50 1 3 5 . stop 50 0 6 1 ."

