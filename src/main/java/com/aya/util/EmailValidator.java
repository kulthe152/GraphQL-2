package com.aya.util;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EmailValidator implements Predicate<String> {

    private static final Predicate<String> IS_EMAIL_VALID = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE).asPredicate();

    @Override
    public boolean test(String email) {
        int i = 20;
        int j = 24;
        int k = i + j;
        System.out.println(k);
        return IS_EMAIL_VALID.test(email);
    }
}
