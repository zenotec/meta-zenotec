FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

PR := "${PR}.1"

RDEPENDS_${PN}_append = "\
    lighttpd-module-fastcgi \
"

