FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

PR := "${PR}.1"

SRC_URI_append = " \
    file://hostapd.conf \
"

do_install_prepend() {
    cp ${WORKDIR}/hostapd.conf ${S}/hostapd.conf
}

