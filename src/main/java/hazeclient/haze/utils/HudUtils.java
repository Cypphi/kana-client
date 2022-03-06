package hazeclient.haze.utils;

import org.jetbrains.annotations.NotNull;

public class HudUtils {

    public static String splitString(@NotNull String string) {
        String[] chars = string.split("");
        String finalstring = "";

        for(String ch : chars) {
            if(StringUtils.isUpperCase(ch)) {
                finalstring = StringUtils.concat(finalstring, " ");
            }
            finalstring = StringUtils.concat(finalstring, ch);
        }

        return finalstring;
    }


}
