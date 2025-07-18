SUMMARY = "GHex - a hex editor for GNOME"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"


DEPENDS = " \
    desktop-file-utils-native  \
    glib-2.0-native \
    gtk4 \
    itstool-native \
    libadwaita \
"

GIR_MESON_ENABLE_FLAG = 'enabled'
GIR_MESON_DISABLE_FLAG = 'disabled'

inherit gnomebase gsettings gtk-icon-cache gnome-help gettext gobject-introspection vala gi-docgen

SRC_URI[archive.sha256sum] = "ea16595dfba0a97b55dd106305d56ba2baee95de0b13b75e75966cc31f9b3ec9"

REQUIRED_DISTRO_FEATURES = "opengl"

FILES:${PN} += "${libdir} ${datadir}/metainfo"
