package slide.show.model;

import java.util.List;

public class Photo {

    private String alignment;
    private int count;
    private List<String> tags;

    public Photo() {
    }

    public Photo(String alignment, int count, List<String> tags) {
        this.alignment = alignment;
        this.count = count;
        this.tags = tags;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "alignment='" + alignment + '\'' +
                ", count=" + count +
                ", tags=" + tags +
                '}';
    }
}
