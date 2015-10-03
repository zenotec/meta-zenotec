SUMMARY = "ZenoTec ZenHome Thermo Cape configuration"
DESCRIPTION = "ZenHome Thermo Cape configuration files"

AUTHOR = "Kevin Mahoney"
HOMEPAGE = "http://www.zenotec.net/ThermoCape"

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
    file://heat1_on.sh.in \
    file://heat2_on.sh.in \
    file://cool1_on.sh.in \
    file://cool2_on.sh.in \
    file://hum_on.sh.in \
    file://all_off.sh.in \
    file://read_temp.sh.in \
    file://read_lux.sh.in \
"

do_install() {

    install -d ${D}/www/pages
    install -m 755 ${WORKDIR}/index.php ${D}/www/pages

    install -d ${D}/${sbindir}

    install -m 755 ${WORKDIR}/heat1_on.sh.in ${D}/${sbindir}/heat1_on.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/heat1_on.sh

    install -m 755 ${WORKDIR}/heat2_on.sh.in ${D}/${sbindir}/heat2_on.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/heat2_on.sh

    install -m 755 ${WORKDIR}/cool1_on.sh.in ${D}/${sbindir}/cool1_on.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/cool1_on.sh

    install -m 755 ${WORKDIR}/cool2_on.sh.in ${D}/${sbindir}/cool2_on.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/cool2_on.sh

    install -m 755 ${WORKDIR}/hum_on.sh.in ${D}/${sbindir}/hum_on.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/hum_on.sh

    install -m 755 ${WORKDIR}/all_off.sh.in ${D}/${sbindir}/all_off.sh
    sed -i -e 's,@SBINDIR@,${sbindir},g' ${D}/${sbindir}/all_off.sh

    install -m 755 ${WORKDIR}/read_temp.sh.in ${D}/${sbindir}/read_temp.sh
    sed -i -e 's,@BINDIR@,${bindir},g' ${D}/${sbindir}/read_temp.sh

    install -m 755 ${WORKDIR}/read_lux.sh.in ${D}/${sbindir}/read_lux.sh
    sed -i -e 's,@BINDIR@,${bindir},g' ${D}/${sbindir}/read_lux.sh

}

RRECOMMENDS_${PN} = "\
    lighttpd \
    lighttpd-module-fastcgi \
"

FILES_${PN} += "\
    ${sbindir}/heat1_on.sh \
    ${sbindir}/heat2_on.sh \
    ${sbindir}/cool1_on.sh \
    ${sbindir}/cool2_on.sh \
    ${sbindir}/hum_on.sh \
    ${sbindir}/all_off.sh \
    ${sbindir}/read_temp.sh \
    ${sbindir}/read_lux.sh \
    /www/pages/index.php \
"

