package com.lcl.hw.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rain on 2016/12/16 8:20.
 */
@Component
public class RegUtils {
    public static void main(String[] args) {
        String regs = "^((13[0-9])|(15[^4])|(17[0-8])|(18[0,2,3,5-9])|(147))\\d{8}$";
        Pattern pattern = Pattern.compile(regs);
        Matcher matcher = pattern.matcher("13026332122");
        System.out.println(matcher.matches());
    }
}
