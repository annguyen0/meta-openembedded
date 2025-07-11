SUMMARY = "Perl interface to iconv() codeset conversion function"
DESCRIPTION = "\
The Text::Iconv module provides a Perl interface to the iconv() \
function as defined by the Single UNIX Specification. The convert() \
method converts the encoding of characters in the input string from \
the fromcode codeset to the tocode codeset, and returns the result. \
Settings of fromcode and tocode and their permitted combinations are \
implementation-dependent. Valid values are specified in the system \
documentation."
SECTION = "libs"
HOMEPAGE = "https://metacpan.org/pod/Text::Iconv"
LICENSE = "Artistic-1.0 | GPL-1.0-or-later"
LIC_FILES_CHKSUM = "file://README;beginline=3;endline=6;md5=fadf2919c7128e887d26b4d905f90649"
RRECOMMENDS:${PN}:append:libc-glibc = " glibc-gconvs"

SRC_URI = "${CPAN_MIRROR}/authors/id/M/MP/MPIOTR/Text-Iconv-${PV}.tar.gz"

SRC_URI[sha256sum] = "5b80b7d5e709d34393bcba88971864a17b44a5bf0f9e4bcee383d029e7d2d5c3"

S = "${UNPACKDIR}/Text-Iconv-${PV}"

inherit cpan

FILES:${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/Text/Iconv/.debug/"
