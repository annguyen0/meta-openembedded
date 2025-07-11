DESCRIPTION = "A header-only lightweight C++ command line option parser."
HOMEPAGE = "https://github.com/jarro2783/cxxopts"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8de00431559a76a1b43f6fd44f8f6689"

SRC_URI = "git://github.com/jarro2783/cxxopts.git;protocol=https;branch=master"
SRCREV = "44380e5a44706ab7347f400698c703eb2a196202"


inherit cmake

EXTRA_OECMAKE:append = " \
-DCXXOPTS_BUILD_EXAMPLES=OFF \
-DCXXOPTS_BUILD_TESTS=OFF \
-DCXXOPTS_ENABLE_INSTALL=ON \
-DCXXOPTS_ENABLE_WARNINGS=OFF \
-DCXXOPTS_USE_UNICODE_HELP=OFF \
"
