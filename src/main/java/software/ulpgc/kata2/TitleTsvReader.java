package software.ulpgc.kata2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TitleTsvReader implements TitleReader {
    private final File file;

    public TitleTsvReader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            reader.readLine();
            return readWith(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> readWith(BufferedReader reader) throws IOException {
        List<Title> results = new ArrayList<>();
        TitleTsvDeserializer deserializer = new TitleTsvDeserializer();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            results.add(deserializer.deserialize(line));
        }

        return results;
    }
}