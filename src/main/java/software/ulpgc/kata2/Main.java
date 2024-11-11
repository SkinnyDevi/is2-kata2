package software.ulpgc.kata2;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("./title.basics.tsv");
        List<Title> titles = new TitleTsvReader(file).read();
        titles.sort(Comparator.comparingInt(Title::startYear));

        Map<String, Integer> yearStats = getYearStats(titles);


        HorizontalHistogramTitleStatisticDisplayer histogram = new HorizontalHistogramTitleStatisticDisplayer(
                new FromMapHistogramDataFieldBuilder(yearStats),
                "Year Statistics Histogram"
        );
        histogram.display();
    }

    private static Map<String, Integer> getYearStats(List<Title> titles) {
        Map<String, Integer> yearStats = new LinkedHashMap<>();
        for (Title t: titles)
            yearStats.put(toString(t.startYear()), yearStats.getOrDefault(toString(t.startYear()), 0) + 1);

        return yearStats;
    }

    private static String toString(int i) {
        return String.valueOf(i);
    }
}