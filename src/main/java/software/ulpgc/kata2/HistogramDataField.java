package software.ulpgc.kata2;

public record HistogramDataField(String name, int count) {
    @Override
    public String toString() {
        return "HistogramDataField{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}