package pl.krystianmajewski.file.worlds.counter.model

import java.util.stream.Collectors

class RatingMother {

    static List<Rating> createRatings(Map<String, BigDecimal> filenamePercentageMap) {
        filenamePercentageMap.entrySet().stream()
                .map({ entry -> new Rating(new Filename(entry.getKey()), entry.getValue()) })
                .collect(Collectors.toList())
    }
}
