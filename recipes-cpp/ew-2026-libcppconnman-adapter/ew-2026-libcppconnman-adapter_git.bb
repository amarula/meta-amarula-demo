SUMMARY = "Wrapper of libcppconnman for Flutter FFI"
LICENSE = "CLOSED"

SECTION = "libs"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/amarula/ew_flutter_demo.git;branch=v2026;protocol=https;destsuffix=git"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS += "libcppconnman"

OECMAKE_SOURCEPATH = "${S}/libcppconnman_adapter"
EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"
