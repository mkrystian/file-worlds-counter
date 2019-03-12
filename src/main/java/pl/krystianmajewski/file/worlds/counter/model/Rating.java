package pl.krystianmajewski.file.worlds.counter.model;

import java.math.BigDecimal;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
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
}
