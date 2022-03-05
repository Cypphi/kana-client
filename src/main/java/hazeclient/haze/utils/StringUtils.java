package hazeclient.haze.utils;

import hazeclient.haze.Debug;
import org.jetbrains.annotations.NotNull;

public class StringUtils {

    public static boolean isUpperCase(@NotNull String s) {
        return s.toUpperCase().equals(s);
    }

    public static @NotNull String concat(String base, String add) {
        return base + add;
    }

    public static @NotNull Boolean isValidPrefixForFastChatOpen(@NotNull String prefix) {
        return prefix.length() == 1 && !isUpperCase(prefix) && Debug.FAST_CHAT_OPEN;
    }

}
