package com.ziprange;

import com.ziprange.model.ZipCodeRange;
import com.ziprange.util.FileUtil;
import com.ziprange.util.ZipCodeUtil;

import java.util.List;

public class MainApp {

    public static void main(String[] args) throws Exception {
        ZipCodeMerger zipCodeMerger = new ZipCodeMerger();

        if (args.length < 1) {
            throw  new IllegalArgumentException("Input param is invalid!");
        }

        String filePath = args[0];

        List<String> inputList = FileUtil.readAbsolutePathFileByJdk8(filePath);
        List<ZipCodeRange> resultList = zipCodeMerger.merge(ZipCodeUtil.convertToZipCodeRangeList(inputList.get(0)));

        for (ZipCodeRange zipCodeRange : resultList) {
            System.out.print(zipCodeRange);
        }
    }
}
