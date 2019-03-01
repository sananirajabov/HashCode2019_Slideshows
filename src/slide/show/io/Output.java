package slide.show.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {

    public void writeToFile(final int count, final List<String> photos, final String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append(count + "");
            bufferedWriter.newLine();

            for (int i = 0; i < count; i++) {
                if (photos.size() - 1 == i) {
                    bufferedWriter.append(photos.get(i));
                } else {
                    bufferedWriter.append(photos.get(i));
                    bufferedWriter.newLine();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
