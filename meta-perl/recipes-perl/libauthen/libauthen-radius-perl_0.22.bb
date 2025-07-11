SUMMARY = "Authen::Radius - provide simple Radius client facilities"
DESCRIPTION = "The Authen::Radius module provides a simple class that \
    allows you to send/receive Radius requests/responses to/from a \
    Radius server. \
"

HOMEPAGE = "https://metacpan.org/release/MANOWAR/RadiusPerl"
SECTION = "libs"

LICENSE = "Artistic-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78ab6ea0cba1f1ec1680ebb149e3bc11"

DEPENDS = "perl"

SRC_URI = "${CPAN_MIRROR}/authors/id/M/MA/MANOWAR/RadiusPerl-${PV}.tar.gz \
           file://test.pl-adjust-for-ptest.patch \
           file://run-ptest \
"
SRC_URI[sha256sum] = "3b276506986ccaa4949d92b13ce053a0017ad11562a991cc753364923fe81ca7"

S = "${UNPACKDIR}/Authen-Radius-${PV}"

inherit cpan ptest

do_install_ptest() {
    install -m 0755 ${S}/test.pl ${D}${PTEST_PATH}
}

RDEPENDS:${PN} += "\
    libdata-hexdump-perl \
    perl-module-digest-md5 \
    perl-module-data-dumper \
    perl-module-io-select \
    perl-module-io-socket \
"
RDEPENDS:${PN}-ptest += " \
    ${@bb.utils.contains('PTEST_ENABLED', '1', 'freeradius', '', d)} \
"

BBCLASSEXTEND = "native"

python() {
    if bb.utils.contains('PTEST_ENABLED', '1', 'True', 'False', d) and \
       'networking-layer' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('ptest requires meta-networking to be present.')
}
