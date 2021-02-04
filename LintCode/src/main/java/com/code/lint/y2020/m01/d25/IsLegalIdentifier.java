package com.code.lint.y2020.m01.d25;

import java.util.regex.Pattern;

/**
 * @Author: hyy
 * @Date: 2020-01-25 21:59
 */

public class IsLegalIdentifier {

    /**
     * @param str: The identifier need to be judged.
     * @return: Return if str is a legal identifier.
     */
    public boolean isLegalIdentifier(String str) {
        String pa = "^[a-zA-Z][a-z0-9A-Z_]+";
        return Pattern.matches(pa,str);
    }
}
