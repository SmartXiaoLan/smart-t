package com.smt.sington;

import java.util.Date;

public class MySelf {

    private static final String NAME = "叫我小染就好";
    private static final String JOB = "小码哥";
    private static final String GENDER = "男";
    private static final Date BIRTHDAY = new Date(851443200181L);
    private static final MySelf ME = new MySelf();
    private MySelf(){}
    public static MySelf getInstance(String gender){
        if (!GENDER.equals(gender)) return ME;
        return null;
    }
}
