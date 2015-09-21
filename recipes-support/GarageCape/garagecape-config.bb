SUMMARY = "ZenoTec ZenHome Garage Cape configuration"
DESCRIPTION = "ZenHome Garage Cape configuration files"

AUTHOR = "Kevin Mahoney"
HOMEPAGE = "http://www.zenotec.net/GarageCape"

LICENSE = "CLOSED"

DEPENDS = "init-ifupdown lighttpd"

SRC_URI = "\
    file://interfaces \
    file://index.php \
    file://open_door.sh.in \
    file://close_door.sh.in \
    file://is_door_open.sh.in \
    file://is_door_closed.sh.in \
"

do_install() {

    install -d ${D}${sysconfdir}/network
    install -m 0644 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces

    install -d ${D}/www/pages
    install -m 755 ${WORKDIR}/index.php ${D}/www/pages

    install -d ${D}/${sbindir}

    install -m 755 ${WORKDIR}/open_door.sh.in ${D}/${sbindir}/open_door.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/open_door.sh

    install -m 755 ${WORKDIR}/close.sh.in ${D}/${sbindir}
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/close_door.sh

    install -m 755 ${WORKDIR}/is_door_open.sh.in ${D}/${sbindir}/is_door_open.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/is_door_open.sh

    install -m 755 ${WORKDIR}/is_door_closed.sh.in ${D}/${sbindir}/is_door_close.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/is_door_close.sh

}

RRECOMMENDS_${PN} = "\
    lighttpd \
    lighttpd-module-fastcgi \
"

FILES_${PN} += "\
    ${sbindir}/open_door.sh \
    ${sbindir}/close_door.sh \
    ${sbindir}/is_door_open.sh \
    ${sbindir}/is_door_closed.sh \
    /www/pages/index.php \
"

CONFFILES_${PN} = "\
    ${sysconfdir}/network/interfaces \
"

