package com.example.JavaPractice.file;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: jcx
 * @update: 2023-02-27 10:01
 * @Version 1.0
 **/
public class CSV {
    public static void main(String[] args) throws Exception {
        String inputFileName = "C:\\Users\\40346\\Desktop\\毕业论文\\GraduationProject\\commodityData\\七彩虹（Colorful）iGame GeForce RTX 3060 Ti Ultra W OC G6X 电竞光追游戏设计电脑显卡.csv";
        String outputFileName = "C:\\Users\\40346\\Desktop\\毕业论文\\GraduationProject\\commodityData\\七彩虹（Colorful）iGame GeForce RTX 3060 Ti Ultra W OC G6X 电竞光追游戏设计电脑显卡.csv";

        // 读取CSV文件
        CSVReader reader = new CSVReader(new FileReader(inputFileName));
        List<String[]> lines = reader.readAll();
        reader.close();

        // 去除重复行
        Set<String> seen = new HashSet<>();
        for (int i = lines.size() - 1; i >= 0; i--) {
            String[] line = lines.get(i);
            String key = String.join(",", line);
            if (seen.contains(key)) {
                lines.remove(i);
            } else {
                seen.add(key);
            }
        }

        // 写入CSV文件
        CSVWriter writer = new CSVWriter(new FileWriter(outputFileName));
        writer.writeAll(lines);
        writer.close();
    }

}