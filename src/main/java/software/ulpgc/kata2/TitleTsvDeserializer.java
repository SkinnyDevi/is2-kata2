package software.ulpgc.kata2;

public class TitleTsvDeserializer implements TitleDeserializer {
    @Override
    public Title deserialize(String data) {
        return this.deserialize(data.split("\t"));
    }

    private Title deserialize(String[] fields) {
        return new Title(
                fields[3],
                toBoolean(fields[4]),
                toInteger(fields[5]),
                toInteger(fields[7])
        );
    }

    private boolean toBoolean(String field) {
        return toInteger(field) == 0;
    }

    private int toInteger(String field) {
        if (field.equals("\\N")) return 0;
        return Integer.parseInt(field);
    }
}