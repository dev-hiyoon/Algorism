package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6 {
    public static void main(String[] args) {
        System.out.println("###################### result: " + getStr("1988-08-29        956 system.zip\n" +
                "1976-09-16     126976 old-photos.tgz\n" +
                "1987-02-03     118784 logs.rar\n" +
                "1961-12-04  703594496 very-long-filename.rar\n" +
                "1980-08-03          2 DELETE-THIS.TXT\n" +
                "2014-08-23        138 important.rar\n" +
                "2001-08-26     595968 MOONLIGHT-SONATA.FLAC\n" +
                "1967-11-30     245760 archive.rar\n" +
                "1995-10-13        731 file.tgz\n" +
                "1995-10-12        731 file.tgz1"));
    }

    private static String getStr(String S) {
        int result = 0;
        long size = 240 * 1024;
        LocalDate searchDate = LocalDate.parse("1995-10-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String lines[] = S.split("\\r?\\n");
        for (String line : lines) {
            String fileExt = line.substring(22, line.length()).trim();
            fileExt = fileExt.substring(fileExt.length() - 3, fileExt.length());
            if (fileExt.equals("rar") || fileExt.equals("tgz") || fileExt.equals("zip")) {
                LocalDate modifyDate = LocalDate.parse(line.substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (modifyDate.isBefore(searchDate)) {
                    if (Long.valueOf(line.substring(11, 21).trim()) < size) {
                        System.out.println("############## a: " + line.substring(11, 21).trim() + ", b: " + line);
                        result++;
                    }
                }

//                List<String> arrLine = Arrays.stream(line.split(" ")).filter(x -> x.length() > 1).collect(Collectors.toList());
//                LocalDate modifyDate = LocalDate.parse(arrLine.get(0), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//                if (modifyDate.isBefore(searchDate)) {
//                    if (Long.valueOf(arrLine.get(1)) < 240 * 1024) {
//                        System.out.println("############## a: " + arrLine.get(1) + ", b: " + line);
//                        result++;
//                    }
//                }
            }
        }

        return result == 0 ? "NO FILES" : String.valueOf(result);
    }
}
