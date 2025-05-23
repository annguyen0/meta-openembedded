SUMMARY = "FIDO 2.0 support library"
DESCRIPTION = "libfido2 provides library functionality and command-line tools to \
communicate with a FIDO device over USB, and to verify attestation and \
assertion signatures."
HOMEPAGE = "https://developers.yubico.com/libfido2"
LICENSE = "BSD-2-Clause"
SECTION = "libs/network"
DEPENDS = "libcbor openssl zlib udev"

LIC_FILES_CHKSUM = "file://LICENSE;md5=20be19aaa222f71738712b26f7f8717b"

SRC_URI = "https://developers.yubico.com/${BPN}/Releases/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "8c2b6fb279b5b42e9ac92ade71832e485852647b53607c43baaafbbcecea04e4"

inherit cmake pkgconfig manpages

PACKAGECONFIG[manpages] = "-DBUILD_MANPAGES:BOOL=ON,-DBUILD_MANPAGES:BOOL=OFF"

EXTRA_OECMAKE = "-DUDEV_RULES_DIR=${nonarch_base_libdir}/udev/rules.d -DBUILD_EXAMPLES:BOOL=OFF"

PACKAGE_BEFORE_PN = "${PN}-tools"

FILES:${PN}-tools = "${bindir}/fido2-*"
