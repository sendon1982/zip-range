package com.ziprange.util;

import com.ziprange.model.ZipCodeRange;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class ZipCodeUtilTest {

    @Test
    void test_convertToZipCodeRangeList_nullInput() {
        List<ZipCodeRange> zipCodeRanges = ZipCodeUtil.convertToZipCodeRangeList(null);
        assertThat(zipCodeRanges, hasSize(0));
    }

    @Test
    void test_convertToZipCodeRangeList_invalidInput() {
        List<ZipCodeRange> zipCodeRanges = ZipCodeUtil.convertToZipCodeRangeList("[94133,1]");
        assertThat(zipCodeRanges, hasSize(0));
    }

    @Test
    void test_convertToZipCodeRangeList() {
        List<ZipCodeRange> zipCodeRanges = ZipCodeUtil.convertToZipCodeRangeList("[94133,94133] [94200,94299] [94600,94699]");

        assertThat(zipCodeRanges, notNullValue());
        assertThat(zipCodeRanges, hasSize(3));

        assertThat(zipCodeRanges.get(0).getStart(), equalTo(94133));
        assertThat(zipCodeRanges.get(0).getEnd(), equalTo(94133));

        assertThat(zipCodeRanges.get(1).getStart(), equalTo(94200));
        assertThat(zipCodeRanges.get(1).getEnd(), equalTo(94299));

        assertThat(zipCodeRanges.get(2).getStart(), equalTo(94600));
        assertThat(zipCodeRanges.get(2).getEnd(), equalTo(94699));
    }
}