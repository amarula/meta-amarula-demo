SUMMARY = "Flutter demo for 2026 EmbeddedWorld"
DESCRIPTION = "Flutter Application"
SECTION = "graphics"

LICENSE = "CLOSED"

RDEPENDS:${PN} += " \
    ew-2026-libcppconnman-adapter \
    ew-2026-libsensors-ffi \
    "

SRCREV = "${AUTOREV}"
SRC_URI = " \
    git://github.com/amarula/ew_flutter_demo.git;branch=v2026;protocol=https;destsuffix=git \
    file://ew-2026-flutter-demo \
    file://ew-2026-flutter-demo.service \
    "

S = "${WORKDIR}/git"

PUBSPEC_APPNAME = "ew_2026_flutter_demo"
FLUTTER_APPLICATION_INSTALL_SUFFIX = "ew_2026_flutter_demo"
FLUTTER_APPLICATION_PATH = ""

inherit flutter-app

do_install:append () {
    install -d ${D}/${bindir}
    install -m 0755 ${WORKDIR}/ew-2026-flutter-demo ${D}/${bindir}/ew-2026-flutter-demo

    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/ew-2026-flutter-demo.service ${D}/${systemd_unitdir}/system/ew-2026-flutter-demo.service
    fi
}

# -----------------------------------------------------------
# specific for service
inherit systemd
SYSTEMD_PACKAGES += " ${PN} "
SYSTEMD_SERVICE:${PN} = "ew-2026-flutter-demo.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
