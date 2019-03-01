package slide.show.slideshow;

import slide.show.file.Position;
import slide.show.model.Photo;
import slide.show.model.Slideshow;

import java.util.ArrayList;
import java.util.List;

public class Maker {

    private final List<Slideshow> slideshows;

    public Maker() {
        slideshows = new ArrayList<>();
    }

    public List<Slideshow> createSlideshow(final List<Photo> photos) {
        List<Integer> indexesOfPhoto = new ArrayList<>();
        List<String> tagsInPhoto = null;
        Slideshow slideshow;

        for (int i = 0; i < photos.size(); i++) {
            final Photo photo = photos.get(i);

            if (photo.getAlignment().equals(Position.HORIZONTAL)) {
                final List<Integer> indexOfPhoto = new ArrayList<>();
                final List<String> tagsOfPhoto = photos.get(i).getTags();

                indexOfPhoto.add(i);
                slideshow = new Slideshow(indexOfPhoto, tagsOfPhoto);
                this.slideshows.add(slideshow);
            }
            else if (photo.getAlignment().equals(Position.VERTICAL)) {
                List<String> tagsOfTwoVerticalPhotos;

                if (indexesOfPhoto.size() == 1) {
                    if (hasCommonTags(photo.getTags(), tagsInPhoto)) {
                        tagsOfTwoVerticalPhotos = mergeLists(photo.getTags(), tagsInPhoto);

                        indexesOfPhoto.add(i);
                        slideshow = new Slideshow(indexesOfPhoto, tagsOfTwoVerticalPhotos);
                        this.slideshows.add(slideshow);

                        indexesOfPhoto = new ArrayList<>();
                        tagsInPhoto.clear();
                    }

                } else {
                    indexesOfPhoto.add(i);
                    tagsInPhoto = photo.getTags();
                }
            }
        }

        return this.slideshows;
    }

    public List<String> getPhotoIndexesFromSlideshow(final List<Slideshow> slideshowList) {
        final List<String> photoIndexes = new ArrayList<>();

        for (Slideshow slide : slideshowList) {
            String index;

            if (slide.getListOfPhotoIndexes().size() == 1) {
                index = slide.getListOfPhotoIndexes().get(0) + "";
            } else {
                String index0 = slide.getListOfPhotoIndexes().get(0) + " ";
                String index1 = slide.getListOfPhotoIndexes().get(1) + "";
                index = index0 + index1;
            }

            photoIndexes.add(index);
        }

        return photoIndexes;
    }

    private boolean hasCommonTags(final List<String> left, final List<String> right) {
        for (String tag : left) {
            if (right.contains(tag)) {
                return true;
            }
        }

        return false;
    }

    private List<String> mergeLists(final List<String> left, final List<String> right) {
        final List<String> mergedList = new ArrayList<>();

        for (String tag : left) {
            mergedList.add(tag);
        }

        for (String tag : right) {
            if (!mergedList.contains(tag)) {
                mergedList.add(tag);
            }
        }

        return mergedList;
    }

}
