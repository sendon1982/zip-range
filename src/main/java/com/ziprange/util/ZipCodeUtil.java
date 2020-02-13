package com.ziprange.util;

import com.ziprange.constant.ZipCodeConstant;
import com.ziprange.model.ZipCodeRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Zip code util class to provide functions to handle zip code related utility functions.
 */
public class ZipCodeUtil {

    private ZipCodeUtil() {

    }

    /**
     * Convert a input string like "[94133,94133] [94200,94299]" into a lot of ZipCodeRange
     * which contains start and end range.
     *
     * @param input
     *
     * @return
     */
    public static List<ZipCodeRange> convertToZipCodeRangeList(String input) {
        if (input == null || input.trim().length() == 0) {
            return Collections.emptyList();
        }

        List<ZipCodeRange> zipCodeRanges = new ArrayList<>();

        Pattern pattern = Pattern.compile(ZipCodeConstant.ZIP_CODE_REGEX);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String group = matcher.group();

            String[] numberStringArray = group.split(ZipCodeConstant.ZIP_CODE_REGEX_SPLIT);
            if (numberStringArray == null || numberStringArray.length != 2) {
                throw new IllegalArgumentException("Invalid input param: " + group);
            }

            zipCodeRanges.add(new ZipCodeRange(Integer.parseInt(numberStringArray[0].trim()),
                    Integer.parseInt(numberStringArray[1].trim())));
        }

        return zipCodeRanges;
    }
}
