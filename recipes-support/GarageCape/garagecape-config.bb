SUMMARY = "ZenoTec ZenHome Garage Cape configuration"
DESCRIPTION = "ZenHome Garage Cape configuration files"

AUTHOR = "Kevin Mahoney"
HOMEPAGE = "http://www.zenotec.net/GarageCape"

LICENSE = "CLOSED"

DEPENDS = "\
    lmsensors \
    lighttpd \
"

RDEPENDS_${PN} = "\
    lmsensors-sensors \
    lighttpd \
"

SRC_URI = "\
    file://index.php \
    file://open_door.sh.in \
    file://close_door.sh.in \
    file://is_door_open.sh.in \
    file://is_door_closed.sh.in \
    file://read_temp.sh.in \
    file://read_lux.sh.in \
    file://connect_to_wifi.sh.in \
"

do_install() {

    install -d ${D}/www/pages
    install -m 755 ${WORKDIR}/index.php ${D}/www/pages

    install -d ${D}/${sbindir}

    install -m 755 ${WORKDIR}/open_door.sh.in ${D}/${sbindir}/open_door.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/open_door.sh

    install -m 755 ${WORKDIR}/close_door.sh.in ${D}/${sbindir}/close_door.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/close_door.sh

    install -m 755 ${WORKDIR}/is_door_open.sh.in ${D}/${sbindir}/is_door_open.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/is_door_open.sh

    install -m 755 ${WORKDIR}/is_door_closed.sh.in ${D}/${sbindir}/is_door_closed.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/is_door_closed.sh

    install -m 755 ${WORKDIR}/read_temp.sh.in ${D}/${sbindir}/read_temp.sh
    sed -i -e 's,@BINDIR@,${bindir},g' ${D}/${sbindir}/read_temp.sh

    install -m 755 ${WORKDIR}/read_lux.sh.in ${D}/${sbindir}/read_lux.sh
    sed -i -e 's,@BINDIR@,${bindir},g' ${D}/${sbindir}/read_lux.sh

    install -m 755 ${WORKDIR}/connect_to_wifi.sh.in ${D}/${sbindir}/connect_to_wifi.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/connect_to_wifi.sh

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
    ${sbindir}/read_temp.sh \
    ${sbindir}/read_lux.sh \
    ${sbindir}/connect_to_wifi.sh \
    /www/pages/index.php \
"

