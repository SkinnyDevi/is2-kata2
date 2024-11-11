package software.ulpgc.kata2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FromMapHistogramDataFieldBuilder implements HistogramDataFieldBuilder {
    private final Map<String, Integer> statistics;

    public FromMapHistogramDataFieldBuilder(Map<String, Integer> statistics) {
        this.statistics = statistics;
    }

    @Override
    public List<HistogramDataField> build() {
        List<HistogramDataField> fields = new ArrayList<>();
        for (String entry : this.statistics.keySet())
            fields.add(new HistogramDataField(entry, statistics.get(entry)));

        return fields;
    }
}