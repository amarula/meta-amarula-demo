SUMMARY = "Thermostat library for flutter demo"
LICENSE = "CLOSED"

SECTION = "libs"

DEPENDS += "protobuf boost jsoncpp libsocketcan protobuf-native"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/amarula/ew_flutter_demo.git;branch=v2025;protocol=https;destsuffix=git"

S = "${WORKDIR}/git/${PN}"

do_install:append () {
    install -d ${D}/home/root
    install -m 0644 ${S}/cfg/can_settings.ini ${D}/home/root/can_settings.ini
}

FILES:${PN} += "/home/root/can_settings.ini"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DFLUTTERCAN_EXAMPLE=ON"
