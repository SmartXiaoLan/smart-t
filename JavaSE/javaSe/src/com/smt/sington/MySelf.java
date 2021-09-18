package com.smt.sington;

import java.util.Date;

public class MySelf {
    //内涵代码献上😏
    private final String NAME = "叫我小染就好";
    private final String JOB = "小码哥";
    private final String STATUS = "😍";
    private final Date BIRTHDAY = new Date(851443200181L);
    private static final MySelf ME = new MySelf();
    private MySelf(){}
    public static MySelf getInstance(String gender){
        return ME;
    }
}
