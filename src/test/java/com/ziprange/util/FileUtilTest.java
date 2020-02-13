package com.ziprange.util;

import com.ziprange.model.ZipCodeRange;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FileUtilTest {

    @Test
    void test_readFileByJdk8() throws Exception {
        List<String> resultList = FileUtil.readFileByJdk8("zip_code_range.txt");

        assertThat(resultList, notNullValue());
        assertThat(resultList, hasSize(1));

        List<ZipCodeRange> zipCodeRanges = ZipCodeUtil.convertToZipCodeRangeList(resultList.get(0));
        assertThat(zipCodeRanges, hasSize(3));

        assertThat(zipCodeRanges.get(0).getStart(), equalTo(94133));
        assertThat(zipCodeRanges.get(0).getEnd(), equalTo(94133));

        assertThat(zipCodeRanges.get(1).getStart(), equalTo(94200));
        assertThat(zipCodeRanges.get(1).getEnd(), equalTo(94299));

        assertThat(zipCodeRanges.get(2).getStart(), equalTo(94600));
        assertThat(zipCodeRanges.get(2).getEnd(), equalTo(94699));
    }
}