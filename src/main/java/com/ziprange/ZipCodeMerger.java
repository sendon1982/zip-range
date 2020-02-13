package com.ziprange;

import com.ziprange.model.ZipCodeRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is class is to provide method to merge zip code range function.
 */
public class ZipCodeMerger {

    /**
     * Merge zip code range into minimal required ranges.
     *
     * For example, if input range is [1,3], [2,4], this will end with [1,4]
     *
     * @param zipRanges     a list of zip code range
     *
     * @return              minimal required ranges
     */
    public List<ZipCodeRange> merge(List<ZipCodeRange> zipRanges) {
        // Return empty list of input list is null or empty
        if (zipRanges == null || zipRanges.size() == 0) {
            return Collections.emptyList();
        }

        // Return immediately if only one item in list
        if (zipRanges.size() == 1) {
            return zipRanges;
        }

        // Sort the list based on the start range
        Collections.sort(zipRanges);

        List<ZipCodeRange> resultList = new ArrayList<>();

        ZipCodeRange mergedRange = zipRanges.get(0);

        for (int i = 1; i < zipRanges.size(); i++) {
            ZipCodeRange comparedZipCodeRange = zipRanges.get(i);

            /**
             * Check if the first item's end range (+1 for Integer number continuum) is large equal to
             * second item's start range. If that is true, it needs to be merged.
             * Then merged result start range will be first item's start range, end range will be max value
             * between first's item end range and second item's end range
             */
            if (mergedRange.getEnd() + 1 >= comparedZipCodeRange.getStart()) {
                int maxEndRange = Math.max(mergedRange.getEnd(), comparedZipCodeRange.getEnd());
                    mergedRange.setEnd(maxEndRange);
            } else {
                resultList.add(mergedRange);
                mergedRange = zipRanges.get(i);
            }
        }

        resultList.add(mergedRange);

        return resultList;
    }
}
