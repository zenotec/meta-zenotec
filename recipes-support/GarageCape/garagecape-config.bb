SUMMARY = "ZenoTec ZenHome Garage Cape configuration"
DESCRIPTION = "ZenHome Garage Cape configuration files"

AUTHOR = "Kevin Mahoney"
HOMEPAGE = "http://www.zenotec.net/GarageCape"

LICENSE = "CLOSED"

DEPENDS = "lighttpd"

SRC_URI = "\
    file://open.sh \
    file://close.sh \
    file://is_open.sh \
    file://is_closed.sh \
    file://index.php \
"

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${WORKDIR}/open.sh ${D}/${bindir}
    install -m 755 ${WORKDIR}/close.sh ${D}/${bindir}
    install -m 755 ${WORKDIR}/is_open.sh ${D}/${bindir}
    install -m 755 ${WORKDIR}/is_closed.sh ${D}/${bindir}

    install -d ${D}/www/pages
    install -m 755 ${WORKDIR}/index.php ${D}/www/pages
}

RRECOMMENS_${PN} = "\
    lighttpd-module-fastcgi \
"

FILES_${PN} += "\
    ${bindir}/open.sh \
    ${bindir}/close.sh \
    ${bindir}/is_open.sh \
    ${bindir}/is_closed.sh \
    /www/pages/index.php \
"
