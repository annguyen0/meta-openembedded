DESCRIPTION = "Provide XPath 1.0 and 2.0 selectors for Python's ElementTree XML data structures, both for the standard ElementTree library and for the lxml.etree library."
HOMEPAGE = "https://github.com/sissaschool/elementpath"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5dbb7fb7d72da3921202dd7b995d3ecf"

SRC_URI[sha256sum] = "5822a2560d99e2633d95f78694c7ff9646adaa187db520da200a8e9479dc46ae"

PYPI_PACKAGE = "elementpath"
inherit pypi setuptools3

RDEPENDS:${PN} += " \
    python3-xml \
    python3-core \
    python3-numbers \
    python3-datetime \
    python3-stringold \
"

BBCLASSEXTEND = "native nativesdk"
