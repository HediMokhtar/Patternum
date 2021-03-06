

package org.apache.commons.lang3;


public class SystemUtils {
    private static final java.lang.String OS_NAME_WINDOWS_PREFIX = "Windows";

    private static final java.lang.String USER_HOME_KEY = "user.home";

    private static final java.lang.String USER_DIR_KEY = "user.dir";

    private static final java.lang.String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";

    private static final java.lang.String JAVA_HOME_KEY = "java.home";

    public static final java.lang.String AWT_TOOLKIT = org.apache.commons.lang3.SystemUtils.getSystemProperty("awt.toolkit");

    public static final java.lang.String FILE_ENCODING = org.apache.commons.lang3.SystemUtils.getSystemProperty("file.encoding");

    @java.lang.Deprecated
    public static final java.lang.String FILE_SEPARATOR = org.apache.commons.lang3.SystemUtils.getSystemProperty("file.separator");

    public static final java.lang.String JAVA_AWT_FONTS = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.awt.fonts");

    public static final java.lang.String JAVA_AWT_GRAPHICSENV = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.awt.graphicsenv");

    public static final java.lang.String JAVA_AWT_HEADLESS = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.awt.headless");

    public static final java.lang.String JAVA_AWT_PRINTERJOB = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.awt.printerjob");

    public static final java.lang.String JAVA_CLASS_PATH = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.class.path");

    public static final java.lang.String JAVA_CLASS_VERSION = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.class.version");

    public static final java.lang.String JAVA_COMPILER = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.compiler");

    public static final java.lang.String JAVA_ENDORSED_DIRS = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.endorsed.dirs");

    public static final java.lang.String JAVA_EXT_DIRS = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.ext.dirs");

    public static final java.lang.String JAVA_HOME = org.apache.commons.lang3.SystemUtils.getSystemProperty(org.apache.commons.lang3.SystemUtils.JAVA_HOME_KEY);

    public static final java.lang.String JAVA_IO_TMPDIR = org.apache.commons.lang3.SystemUtils.getSystemProperty(org.apache.commons.lang3.SystemUtils.JAVA_IO_TMPDIR_KEY);

    public static final java.lang.String JAVA_LIBRARY_PATH = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.library.path");

    public static final java.lang.String JAVA_RUNTIME_NAME = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.runtime.name");

    public static final java.lang.String JAVA_RUNTIME_VERSION = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.runtime.version");

    public static final java.lang.String JAVA_SPECIFICATION_NAME = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.specification.name");

    public static final java.lang.String JAVA_SPECIFICATION_VENDOR = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.specification.vendor");

    public static final java.lang.String JAVA_SPECIFICATION_VERSION = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.specification.version");

    private static final org.apache.commons.lang3.JavaVersion JAVA_SPECIFICATION_VERSION_AS_ENUM = org.apache.commons.lang3.JavaVersion.get(org.apache.commons.lang3.SystemUtils.JAVA_SPECIFICATION_VERSION);

    public static final java.lang.String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.util.prefs.PreferencesFactory");

    public static final java.lang.String JAVA_VENDOR = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vendor");

    public static final java.lang.String JAVA_VENDOR_URL = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vendor.url");

    public static final java.lang.String JAVA_VERSION = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.version");

    public static final java.lang.String JAVA_VM_INFO = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vm.info");

    public static final java.lang.String JAVA_VM_NAME = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vm.name");

    public static final java.lang.String JAVA_VM_SPECIFICATION_NAME = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vm.specification.name");

    public static final java.lang.String JAVA_VM_SPECIFICATION_VENDOR = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vm.specification.vendor");

    public static final java.lang.String JAVA_VM_SPECIFICATION_VERSION = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vm.specification.version");

    public static final java.lang.String JAVA_VM_VENDOR = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vm.vendor");

    public static final java.lang.String JAVA_VM_VERSION = org.apache.commons.lang3.SystemUtils.getSystemProperty("java.vm.version");

    @java.lang.Deprecated
    public static final java.lang.String LINE_SEPARATOR = org.apache.commons.lang3.SystemUtils.getSystemProperty("line.separator");

    public static final java.lang.String OS_ARCH = org.apache.commons.lang3.SystemUtils.getSystemProperty("os.arch");

    public static final java.lang.String OS_NAME = org.apache.commons.lang3.SystemUtils.getSystemProperty("os.name");

    public static final java.lang.String OS_VERSION = org.apache.commons.lang3.SystemUtils.getSystemProperty("os.version");

    @java.lang.Deprecated
    public static final java.lang.String PATH_SEPARATOR = org.apache.commons.lang3.SystemUtils.getSystemProperty("path.separator");

    public static final java.lang.String USER_COUNTRY = (org.apache.commons.lang3.SystemUtils.getSystemProperty("user.country")) == null ? org.apache.commons.lang3.SystemUtils.getSystemProperty("user.region") : org.apache.commons.lang3.SystemUtils.getSystemProperty("user.country");

    public static final java.lang.String USER_DIR = org.apache.commons.lang3.SystemUtils.getSystemProperty(org.apache.commons.lang3.SystemUtils.USER_DIR_KEY);

    public static final java.lang.String USER_HOME = org.apache.commons.lang3.SystemUtils.getSystemProperty(org.apache.commons.lang3.SystemUtils.USER_HOME_KEY);

    public static final java.lang.String USER_LANGUAGE = org.apache.commons.lang3.SystemUtils.getSystemProperty("user.language");

    public static final java.lang.String USER_NAME = org.apache.commons.lang3.SystemUtils.getSystemProperty("user.name");

    public static final java.lang.String USER_TIMEZONE = org.apache.commons.lang3.SystemUtils.getSystemProperty("user.timezone");

    public static final boolean IS_JAVA_1_1 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("1.1");

    public static final boolean IS_JAVA_1_2 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("1.2");

    public static final boolean IS_JAVA_1_3 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("1.3");

    public static final boolean IS_JAVA_1_4 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("1.4");

    public static final boolean IS_JAVA_1_5 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("1.5");

    public static final boolean IS_JAVA_1_6 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("1.6");

    public static final boolean IS_JAVA_1_7 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("1.7");

    public static final boolean IS_JAVA_1_8 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("1.8");

    @java.lang.Deprecated
    public static final boolean IS_JAVA_1_9 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("9");

    public static final boolean IS_JAVA_9 = org.apache.commons.lang3.SystemUtils.getJavaVersionMatches("9");

    public static final boolean IS_OS_AIX = org.apache.commons.lang3.SystemUtils.getOSMatchesName("AIX");

    public static final boolean IS_OS_HP_UX = org.apache.commons.lang3.SystemUtils.getOSMatchesName("HP-UX");

    public static final boolean IS_OS_400 = org.apache.commons.lang3.SystemUtils.getOSMatchesName("OS/400");

    public static final boolean IS_OS_IRIX = org.apache.commons.lang3.SystemUtils.getOSMatchesName("Irix");

    public static final boolean IS_OS_LINUX = (org.apache.commons.lang3.SystemUtils.getOSMatchesName("Linux")) || (org.apache.commons.lang3.SystemUtils.getOSMatchesName("LINUX"));

    public static final boolean IS_OS_MAC = org.apache.commons.lang3.SystemUtils.getOSMatchesName("Mac");

    public static final boolean IS_OS_MAC_OSX = org.apache.commons.lang3.SystemUtils.getOSMatchesName("Mac OS X");

    public static final boolean IS_OS_MAC_OSX_CHEETAH = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.0");

    public static final boolean IS_OS_MAC_OSX_PUMA = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.1");

    public static final boolean IS_OS_MAC_OSX_JAGUAR = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.2");

    public static final boolean IS_OS_MAC_OSX_PANTHER = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.3");

    public static final boolean IS_OS_MAC_OSX_TIGER = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.4");

    public static final boolean IS_OS_MAC_OSX_LEOPARD = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.5");

    public static final boolean IS_OS_MAC_OSX_SNOW_LEOPARD = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.6");

    public static final boolean IS_OS_MAC_OSX_LION = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.7");

    public static final boolean IS_OS_MAC_OSX_MOUNTAIN_LION = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.8");

    public static final boolean IS_OS_MAC_OSX_MAVERICKS = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.9");

    public static final boolean IS_OS_MAC_OSX_YOSEMITE = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.10");

    public static final boolean IS_OS_MAC_OSX_EL_CAPITAN = org.apache.commons.lang3.SystemUtils.getOSMatches("Mac OS X", "10.11");

    public static final boolean IS_OS_FREE_BSD = org.apache.commons.lang3.SystemUtils.getOSMatchesName("FreeBSD");

    public static final boolean IS_OS_OPEN_BSD = org.apache.commons.lang3.SystemUtils.getOSMatchesName("OpenBSD");

    public static final boolean IS_OS_NET_BSD = org.apache.commons.lang3.SystemUtils.getOSMatchesName("NetBSD");

    public static final boolean IS_OS_OS2 = org.apache.commons.lang3.SystemUtils.getOSMatchesName("OS/2");

    public static final boolean IS_OS_SOLARIS = org.apache.commons.lang3.SystemUtils.getOSMatchesName("Solaris");

    public static final boolean IS_OS_SUN_OS = org.apache.commons.lang3.SystemUtils.getOSMatchesName("SunOS");

    public static final boolean IS_OS_UNIX = (((((((((org.apache.commons.lang3.SystemUtils.IS_OS_AIX) || (org.apache.commons.lang3.SystemUtils.IS_OS_HP_UX)) || (org.apache.commons.lang3.SystemUtils.IS_OS_IRIX)) || (org.apache.commons.lang3.SystemUtils.IS_OS_LINUX)) || (org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX)) || (org.apache.commons.lang3.SystemUtils.IS_OS_SOLARIS)) || (org.apache.commons.lang3.SystemUtils.IS_OS_SUN_OS)) || (org.apache.commons.lang3.SystemUtils.IS_OS_FREE_BSD)) || (org.apache.commons.lang3.SystemUtils.IS_OS_OPEN_BSD)) || (org.apache.commons.lang3.SystemUtils.IS_OS_NET_BSD);

    public static final boolean IS_OS_WINDOWS = org.apache.commons.lang3.SystemUtils.getOSMatchesName(org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX);

    public static final boolean IS_OS_WINDOWS_2000 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " 2000"));

    public static final boolean IS_OS_WINDOWS_2003 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " 2003"));

    public static final boolean IS_OS_WINDOWS_2008 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " Server 2008"));

    public static final boolean IS_OS_WINDOWS_2012 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " Server 2012"));

    public static final boolean IS_OS_WINDOWS_95 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " 95"));

    public static final boolean IS_OS_WINDOWS_98 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " 98"));

    public static final boolean IS_OS_WINDOWS_ME = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " Me"));

    public static final boolean IS_OS_WINDOWS_NT = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " NT"));

    public static final boolean IS_OS_WINDOWS_XP = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " XP"));

    public static final boolean IS_OS_WINDOWS_VISTA = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " Vista"));

    public static final boolean IS_OS_WINDOWS_7 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " 7"));

    public static final boolean IS_OS_WINDOWS_8 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " 8"));

    public static final boolean IS_OS_WINDOWS_10 = org.apache.commons.lang3.SystemUtils.getOSMatchesName(((org.apache.commons.lang3.SystemUtils.OS_NAME_WINDOWS_PREFIX) + " 10"));

    public static final boolean IS_OS_ZOS = org.apache.commons.lang3.SystemUtils.getOSMatchesName("z/OS");

    public static java.io.File getJavaHome() {
        return new java.io.File(java.lang.System.getProperty(org.apache.commons.lang3.SystemUtils.JAVA_HOME_KEY));
    }

    public static java.lang.String getHostName() {
        return org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS ? java.lang.System.getenv("COMPUTERNAME") : java.lang.System.getenv("HOSTNAME");
    }

    public static java.io.File getJavaIoTmpDir() {
        return new java.io.File(java.lang.System.getProperty(org.apache.commons.lang3.SystemUtils.JAVA_IO_TMPDIR_KEY));
    }

    private static boolean getJavaVersionMatches(final java.lang.String versionPrefix) {
        return org.apache.commons.lang3.SystemUtils.isJavaVersionMatch(org.apache.commons.lang3.SystemUtils.JAVA_SPECIFICATION_VERSION, versionPrefix);
    }

    private static boolean getOSMatches(final java.lang.String osNamePrefix, final java.lang.String osVersionPrefix) {
        return org.apache.commons.lang3.SystemUtils.isOSMatch(org.apache.commons.lang3.SystemUtils.OS_NAME, org.apache.commons.lang3.SystemUtils.OS_VERSION, osNamePrefix, osVersionPrefix);
    }

    private static boolean getOSMatchesName(final java.lang.String osNamePrefix) {
        return org.apache.commons.lang3.SystemUtils.isOSNameMatch(org.apache.commons.lang3.SystemUtils.OS_NAME, osNamePrefix);
    }

    private static java.lang.String getSystemProperty(final java.lang.String property) {
        try {
            return java.lang.System.getProperty(property);
        } catch (final java.lang.SecurityException ex) {
            java.lang.System.err.println((("Caught a SecurityException reading the system property '" + property) + "'; the SystemUtils property value will default to null."));
            return null;
        }
    }

    public static java.io.File getUserDir() {
        return new java.io.File(java.lang.System.getProperty(org.apache.commons.lang3.SystemUtils.USER_DIR_KEY));
    }

    public static java.io.File getUserHome() {
        return new java.io.File(java.lang.System.getProperty(org.apache.commons.lang3.SystemUtils.USER_HOME_KEY));
    }

    public static boolean isJavaAwtHeadless() {
        return java.lang.Boolean.TRUE.toString().equals(org.apache.commons.lang3.SystemUtils.JAVA_AWT_HEADLESS);
    }

    public static boolean isJavaVersionAtLeast(final org.apache.commons.lang3.JavaVersion requiredVersion) {
        return org.apache.commons.lang3.SystemUtils.JAVA_SPECIFICATION_VERSION_AS_ENUM.atLeast(requiredVersion);
    }

    static boolean isJavaVersionMatch(final java.lang.String version, final java.lang.String versionPrefix) {
        if (version == null) {
            return false;
        }
        return version.startsWith(versionPrefix);
    }

    static boolean isOSMatch(final java.lang.String osName, final java.lang.String osVersion, final java.lang.String osNamePrefix, final java.lang.String osVersionPrefix) {
        if ((osName == null) || (osVersion == null)) {
            return false;
        }
        return (org.apache.commons.lang3.SystemUtils.isOSNameMatch(osName, osNamePrefix)) && (org.apache.commons.lang3.SystemUtils.isOSVersionMatch(osVersion, osVersionPrefix));
    }

    static boolean isOSNameMatch(final java.lang.String osName, final java.lang.String osNamePrefix) {
        if (osName == null) {
            return false;
        }
        return osName.startsWith(osNamePrefix);
    }

    static boolean isOSVersionMatch(final java.lang.String osVersion, final java.lang.String osVersionPrefix) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(osVersion)) {
            return false;
        }
        final java.lang.String[] versionPrefixParts = osVersionPrefix.split("\\.");
        final java.lang.String[] versionParts = osVersion.split("\\.");
        for (int i = 0; i < (java.lang.Math.min(versionPrefixParts.length, versionParts.length)); i++) {
            if (!(versionPrefixParts[i].equals(versionParts[i]))) {
                return false;
            }
        }
        return true;
    }

    public SystemUtils() {
        super();
    }
}

