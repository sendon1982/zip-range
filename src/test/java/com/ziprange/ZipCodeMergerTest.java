package com.ziprange;

import com.ziprange.model.ZipCodeRange;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class ZipCodeMergerTest {

    @Test
    void test_merge_empty() {
        ZipCodeMerger zipCodeMerger = new ZipCodeMerger();
        List<ZipCodeRange> resultList = zipCodeMerger.merge(null);

        assertThat(resultList, hasSize(0));
    }

    @Test
    void test_merge_oneItem() {
        ZipCodeMerger zipCodeMerger = new ZipCodeMerger();
        List<ZipCodeRange> resultList = zipCodeMerger.merge(Collections.singletonList(
                new ZipCodeRange(94226, 94699)
        ));

        assertThat(resultList, hasSize(1));
        assertThat(resultList.get(0).getStart(), equalTo(94226));
        assertThat(resultList.get(0).getEnd(), equalTo(94699));
    }

    @Test
    void test_merge_sampleInput() {
        ZipCodeMerger zipCodeMerger = new ZipCodeMerger();
        List<ZipCodeRange> resultList = zipCodeMerger.merge(Arrays.asList(
                new ZipCodeRange(94133, 94133),
                new ZipCodeRange(94200, 94299),
                new ZipCodeRange(94226, 94699)
        ));

        assertThat(resultList, hasSize(2));
        assertThat(resultList.get(0).getStart(), equalTo(94133));
        assertThat(resultList.get(0).getEnd(), equalTo(94133));

        assertThat(resultList.get(1).getStart(), equalTo(94200));
        assertThat(resultList.get(1).getEnd(), equalTo(94699));
    }

    @Test
    void test_merge_sampleInputRandomOrder() {
        ZipCodeMerger zipCodeMerger = new ZipCodeMerger();
        List<ZipCodeRange> resultList = zipCodeMerger.merge(Arrays.asList(
                new ZipCodeRange(94134, 94299),
                new ZipCodeRange(94133, 94133),
                new ZipCodeRange(94226, 94699)
        ));

        assertThat(resultList, hasSize(1));
        assertThat(resultList.get(0).getStart(), equalTo(94133));
        assertThat(resultList.get(0).getEnd(), equalTo(94699));
    }

    @Test
    void test_merge_noMerge() {
        ZipCodeMerger zipCodeMerger = new ZipCodeMerger();
        List<ZipCodeRange> resultList = zipCodeMerger.merge(Arrays.asList(
                new ZipCodeRange(94135, 94135),
                new ZipCodeRange(94133, 94133),
                new ZipCodeRange(94221, 94233)
        ));

        assertThat(resultList, hasSize(3));
        assertThat(resultList.get(0).getStart(), equalTo(94133));
        assertThat(resultList.get(0).getEnd(), equalTo(94133));

        assertThat(resultList.get(1).getStart(), equalTo(94135));
        assertThat(resultList.get(1).getEnd(), equalTo(94135));

        assertThat(resultList.get(2).getStart(), equalTo(94221));
        assertThat(resultList.get(2).getEnd(), equalTo(94233));
    }

    @Test
    void test_merge_sameRange() {
        ZipCodeMerger zipCodeMerger = new ZipCodeMerger();
        List<ZipCodeRange> resultList = zipCodeMerger.merge(Arrays.asList(
                new ZipCodeRange(94134, 94134),
                new ZipCodeRange(94134, 94134),
                new ZipCodeRange(94134, 94134)
        ));

        assertThat(resultList, hasSize(1));
        assertThat(resultList.get(0).getStart(), equalTo(94134));
        assertThat(resultList.get(0).getEnd(), equalTo(94134));
    }
}