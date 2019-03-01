package slide.show.score;

import slide.show.model.Slideshow;

import java.util.List;

public class Score {

    public int calculateScore(final List<Slideshow> slideshow) {
        int score = 0;

        for (int i = 0; i < slideshow.size() - 1; i++) {
            List<String> leftTags = slideshow.get(i).getListOfTags();
            List<String> rightTags = slideshow.get(i + 1).getListOfTags();

            int minimum = Math.min(commonCountsOfLeftAndRightTags(leftTags, rightTags),
                            Math.min(countsOfLeftHasRightNot(leftTags, rightTags),
                                    countsOfRightHasLeftNot(leftTags, rightTags)));

            score += minimum;
        }

        return score;
    }

    private int commonCountsOfLeftAndRightTags(final List<String> leftTags, final List<String> rightTags) {
        int count = 0;

        for (String tag : leftTags) {
            if (rightTags.contains(tag)) {
                count++;
            }
        }

        return count;
    }

    private int countsOfLeftHasRightNot(final List<String> leftTags, final List<String> rightTags) {
        int count = 0;

        for (String tag : leftTags) {
            if (!rightTags.contains(tag)) {
                count++;
            }
        }

        return count;
    }

    private int countsOfRightHasLeftNot(final List<String> leftTags, final List<String> rightTags) {
        int count = 0;

        for (String tag : rightTags) {
            if (!leftTags.contains(tag)) {
                count++;
            }
        }

        return count;
    }
}
