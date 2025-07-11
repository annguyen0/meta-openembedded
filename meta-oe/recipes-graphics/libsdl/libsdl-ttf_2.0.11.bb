SUMMARY = "Simple DirectMedia Layer truetype font library"
SECTION = "libs"
DEPENDS = "libsdl freetype"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://COPYING;md5=22800d1b3701377aae0b61ee36f5c303"

SRC_URI = "http://www.libsdl.org/projects/SDL_ttf/release/SDL_ttf-${PV}.tar.gz \
           file://use.pkg-config.for.freetype2.patch \
"
SRC_URI[sha256sum] = "724cd895ecf4da319a3ef164892b72078bd92632a5d812111261cde248ebcdb7"

S = "${UNPACKDIR}/SDL_ttf-${PV}"

inherit autotools pkgconfig

LDFLAGS += "-lm"

do_configure:prepend() {
    # make autoreconf happy
    touch ${S}/NEWS ${S}/AUTHORS ${S}/ChangeLog

    # Removing these files fixes a libtool version mismatch.
    MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"

    for i in ${MACROS}; do
        rm -f ${S}/acinclude/$i
    done
}
