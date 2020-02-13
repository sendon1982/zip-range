package com.ziprange.constant;

public interface ZipCodeConstant {

    // Regex to extract numbers from string input
    public static final String ZIP_CODE_REGEX = "[0-9]{5},[0-9]{5}";

    // Zip code range split which is a comma
    public static final String ZIP_CODE_REGEX_SPLIT = ",";
}
