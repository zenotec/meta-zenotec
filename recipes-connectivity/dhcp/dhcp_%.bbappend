FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

PR := "${PR}.1"

inherit update-rc.d systemd

INITSCRIPT_NAME = "dhcp-server"
INITSCRIPT_PARAMS = "defaults 70"

SYSTEMD_SERVICE_${PN} = "dhcpd.service"


