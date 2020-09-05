SECTION = "shadow"
LICENSE = "MIT-X"
LIC_FILES_CHKSUM = "file://LICENSE;md5=04c3ca13a702147c62db90f556c5b3ca"
SRC_URI = " \
 http://dl.suckless.org/${BPN}/${BPN}-${PV}.tar.gz \
"

inherit pkgconfig

SRC_URI[sha256sum] = "d42d3ceceb4d6a65e32e90a5336e3d446db612c3fbd9ebc1780bc6c9a03346a6"

DEPENDS += "libx11 libxft fontconfig ncurses-native"

RDEPENDS_${PN} += "libx11-locale"

do_compile() {
    make INCS='-I. `pkg-config --cflags x11 fontconfig xft`' LIBS='-lm -lutil `pkg-config --libs x11 fontconfig xft`'
}
do_install() {
    make install DESTDIR=${D} PREFIX=/usr TERMINFO=${D}${datadir}/terminfo
}

FILES_${PN} += " \
  ${datadir}/terminfo \
"
