package slide.show.model;

import java.util.List;

public class Slideshow {

    private List<Integer> listOfPhotoIndexes;
    private List<String> listOfTags;

    public Slideshow() {
    }

    public Slideshow(List<Integer> listOfPhotoIndexes, List<String> listOfTags) {
        this.listOfPhotoIndexes = listOfPhotoIndexes;
        this.listOfTags = listOfTags;
    }

    public List<Integer> getListOfPhotoIndexes() {
        return listOfPhotoIndexes;
    }

    public void setListOfPhotoIndexes(List<Integer> listOfPhotoIndexes) {
        this.listOfPhotoIndexes = listOfPhotoIndexes;
    }

    public List<String> getListOfTags() {
        return listOfTags;
    }

    public void setListOfTags(List<String> listOfTags) {
        this.listOfTags = listOfTags;
    }

    @Override
    public String toString() {
        return "Slideshow{" +
                "listOfPhotoIndexes=" + listOfPhotoIndexes +
                ", listOfTags=" + listOfTags +
                '}';
    }
}
