
require zeno-base.bb

IMAGE_INSTALL_append = "\
    hostap-daemon \
    hostap-utils \
    dhcp-server \
    dhcp-client \
    lighttpd \
    php-cgi \
    jquery \
    thermocape-config \
"
