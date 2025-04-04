SUMMARY = "Install a Debian system into a subdirectory"
HOMEPAGE = "https://wiki.debian.org/Debootstrap"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=e7b45429ef05610abf91ac199fdb3a6e"

SRC_URI  = "\
    ${DEBIAN_MIRROR}/main/d/debootstrap/debootstrap_${PV}.tar.gz \
    file://0001-support-to-override-usr-sbin-and-usr-share.patch \
    file://0002-support-to-override-usr-bin-arch-test.patch \
    file://0003-do-not-hardcode-the-full-path-of-dpkg.patch \
"

SRC_URI[sha256sum] = "c95eb2aeb952b3fd09f4a07859115d40c4d04a8d551b3071b0a10fcd0db7ebc4"

S = "${WORKDIR}/debootstrap"

DEPENDS = " \
    virtual/fakeroot-native \
"

fakeroot do_install() {
    oe_runmake 'DESTDIR=${D}' install
    chown -R root:root ${D}${datadir}/debootstrap
}

BBCLASSEXTEND = "native nativesdk"
