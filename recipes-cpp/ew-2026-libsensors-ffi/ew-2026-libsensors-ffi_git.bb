SUMMARY = "Wrapper of libcppconnman for Flutter FFI"
LICENSE = "CLOSED"

SECTION = "libs"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/amarula/ew_flutter_demo.git;branch=v2026;protocol=https;destsuffix=git"

S = "${WORKDIR}/git"

inherit cmake

OECMAKE_SOURCEPATH = "${S}/libsensors_ffi"
EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"

do_install:append() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${S}/libsensors_ffi/sensors.cfg ${D}${sysconfdir}/sensors.cfg
}

FILES:${PN} += "${sysconfdir}/sensors.cfg"
