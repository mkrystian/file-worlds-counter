package pl.krystianmajewski.file.worlds.counter.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Rating implements Comparable<Rating> {

	private final Filename filename;
	private final BigDecimal matchingPercentage;

	public Rating(Filename filename, BigDecimal matchingPercentage) {
		this.filename = filename;
		this.matchingPercentage = matchingPercentage;
	}

	@Override
	public int compareTo(Rating o) {
		return this.matchingPercentage.compareTo(o.matchingPercentage);
	}

	@Override
	public String toString() {
		return String.format("filename: %s, rating: %s", filename, matchingPercentage);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rating rating = (Rating) o;
		return Objects.equals(filename, rating.filename) &&
				Objects.equals(matchingPercentage, rating.matchingPercentage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(filename, matchingPercentage);
	}
}
