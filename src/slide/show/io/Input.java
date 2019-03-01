package slide.show.io;

import slide.show.model.Photo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private List<Photo> photoList;

    public Input() {
        this.photoList = new ArrayList<>();
    }

    public List<Photo> readFile(final String path) {
        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            boolean isPassedFirstLine = false;
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (isPassedFirstLine) {
                    final Photo photo = new Photo();
                    final int lineLength = line.length();

                    final String[] splitter = line.split(" ");
                    final String alignment = splitter[0];
                    final int count = Integer.parseInt(splitter[1]);
                    final String[] tags = line.substring(4, lineLength).split(" ");
                    final List<String> tagList = new ArrayList<>();

                    for (String tag : tags) {
                        tagList.add(tag);
                    }

                    photo.setAlignment(alignment);
                    photo.setCount(count);
                    photo.setTags(tagList);
                    this.photoList.add(photo);
                }

                isPassedFirstLine = true;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return this.photoList;
    }
}
