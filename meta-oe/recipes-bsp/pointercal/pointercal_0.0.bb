SUMMARY = "Touchscreen calibration data"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=4b5fcfc87fb615860d398b5e38685edf"

SRC_URI = "file://pointercal \
           file://COPYING"

S = "${UNPACKDIR}"

do_install() {
    # Only install file if it has a contents
    if [ -s ${S}/pointercal ]; then
        install -d ${D}${sysconfdir}/
        install -m 0644 ${S}/pointercal ${D}${sysconfdir}/
    fi
}

ALLOW_EMPTY:${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_DEFAULT_DEPS = "1"

BBCLASSEXTEND = "native nativesdk"
