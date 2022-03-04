package hazeclient.haze.utils;

import org.jetbrains.annotations.NotNull;

public class StringUtils {

    public static boolean isUpperCase(@NotNull String s) {
        return s.toUpperCase().equals(s);
    }

    public static @NotNull String concat(String base, String add) {
        return base + add;
    }

}
