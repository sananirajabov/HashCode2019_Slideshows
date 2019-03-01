import slide.show.file.Files;
import slide.show.io.Input;
import slide.show.io.Output;
import slide.show.model.Photo;
import slide.show.model.Slideshow;
import slide.show.score.Score;
import slide.show.slideshow.Maker;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        final Input input = new Input();
        final Output output = new Output();
        final Files file = new Files();
        final Maker slideshowMaker = new Maker();
        final Score score = new Score();

        for (String fileName : file.getFilesNames()) {
            String path = file.getWritePath(fileName);

            List<Photo> photoList = input.readFile(file.getAbsolutePath(fileName));
            List<Slideshow> slideshows = slideshowMaker.createSlideshow(photoList);
            List<String> photoIndexes = slideshowMaker.getPhotoIndexesFromSlideshow(slideshows);

//            System.out.println(score.calculateScore(slideshows));
            output.writeToFile(photoIndexes.size(), photoIndexes, path);

            photoList.clear();
            slideshows.clear();
            photoIndexes.clear();
        }
    }
}
