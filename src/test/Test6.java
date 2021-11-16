package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6 {
    public static void main(String[] args) {
        System.out.println("###################### result: " + getStr("\"\"\"\n" +
                "1988-08-29          956             system.zip\n" +
                "1976-09-16       126976         old-photos.tgz\n" +
                "1987-02-03       118784               logs.rar\n" +
                "1961-12-04    703594496 very-long-filename.rar\n" +
                "1980-08-03            2        DELETE-THIS.TXT\n" +
                "2014-08-23          138          important.rar\n" +
                "2001-08-26       595968  MOONLIGHT-SONATA.FLAC\n" +
                "1967-11-30       245760            archive.rar\n" +
                "1995-10-13          731               file.taz\n" +
                "\"\"\""));
    }

    private static int getStr(String N) {
        int result = 0;
        LocalDate searchDate = LocalDate.parse("1995-10-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String lines[] = N.split("\\r?\\n");
        for (String line : lines) {
            if (line.contains(".rar") || line.contains(".tgz") || line.contains(".zip")) {
                List<String> arrLine = Arrays.stream(line.split(" ")).filter(x -> x.length() > 1).collect(Collectors.toList());
                LocalDate modifyDate = LocalDate.parse(arrLine.get(0), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (modifyDate.isBefore(searchDate)) {
                    if (Long.valueOf(arrLine.get(1)) < 240 * 1024) {
                        System.out.println("EEEEEEEEEE");
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
