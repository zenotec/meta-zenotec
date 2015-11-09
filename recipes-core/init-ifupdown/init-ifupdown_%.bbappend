FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR := "${PR}.1"

SRC_URI_append = "\
    file://interfaces \
    file://interfaces.ap \
    file://interfaces.wifi_client \
"

do_install_append () {
        install -d ${D}${sysconfdir}/network
        install -m 0644 ${WORKDIR}/interfaces.ap ${D}${sysconfdir}/network/interfaces.ap
        install -m 0644 ${WORKDIR}/interfaces.wifi_client ${D}${sysconfdir}/network/interfaces.wifi_client
}

