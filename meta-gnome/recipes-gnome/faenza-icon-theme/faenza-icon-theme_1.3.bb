DESCRIPTION = "An icon theme for Gnome"
SECTION = "x11/wm"
LICENSE = "GPL-3.0-only"
HOMEPAGE = "http://code.google.com/p/faenza-icon-theme/"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit allarch gtk-icon-cache

S = "${UNPACKDIR}"

SRC_URI = "https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/${BPN}/${BPN}_${PV}.zip"
SRC_URI[sha256sum] = "d4486fda0413f8a81a87e0dd2329f50f2a8a7cb4147b48cf147f0160add8174a"

do_install() {
    install -d ${D}${datadir}/icons
    for theme in `find -name 'Faenza*.tar.gz'`; do
        tar -xf ${theme} -C ${D}${datadir}/icons
    done
    tar -xf emesene-faenza-theme.tar.gz -C ${D}${datadir}
    mv -f ${D}${datadir}/emesene/themes ${D}${datadir}/themes
    rm -rf ${D}${datadir}/emesene
    chown -R root:root ${D}${datadir}
}

FILES:${PN} += "${datadir}/icons ${datadir}/themes"
