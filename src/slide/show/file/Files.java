package slide.show.file;

import java.util.ArrayList;
import java.util.List;

public class Files {

    private final List<String> fileNames;

    private final static String READ_PATH =  "E:\\Hash Code 2019\\Cases\\";
    private final static String WRITE_PATH = "E:\\Hash Code 2019\\Output\\";
    private final static String FORMAT = ".txt";

    private final static String EXAMPLE = "a_example";
    private final static String LOVELY_LANDSCAPES = "b_lovely_landscapes";
    private final static String MEMORABLE_MOMENTS = "c_memorable_moments";
    private final static String PET_PICTURES = "d_pet_pictures";
    private final static String SHINY_SELFIES = "e_shiny_selfies";

    public Files() {
        this.fileNames = new ArrayList<>();

        this.fileNames.add(EXAMPLE);
        this.fileNames.add(LOVELY_LANDSCAPES);
        this.fileNames.add(MEMORABLE_MOMENTS);
        this.fileNames.add(PET_PICTURES);
        this.fileNames.add(SHINY_SELFIES);
    }

    public List<String> getFilesNames() {
        return this.fileNames;
    }

    public String getAbsolutePath(final String fileName) {
        return READ_PATH + fileName + FORMAT;
    }

    public String getWritePath(final String fileName) {
        return WRITE_PATH + fileName + FORMAT;
    }
}
