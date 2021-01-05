package mediaRentalManager;

public class Movie implements Media {
	/**
	 * Class that implements the Media interface that provides the expected
	 * functionality for the Movies in the Media Rental Manager. A movie has a
	 * title, a number of copies that are available for rent, and a rating (e.g.,
	 * "PG").
	 */
	private String title;
	private int numOfCopies;
	private String rating;

	/**
	 * Constructor that initializes that new Movies with a title, a number of copies
	 * available and a rating. Throws and exception if an invalid rating is
	 * provided.
	 * 
	 * @param title
	 * @param numOfCopies
	 * @param rating
	 */
	public Movie(String title, int numOfCopies, String rating) {
		this.title = title;
		this.numOfCopies = numOfCopies;

		if (rating.equals("PG") || rating.equals("R") || rating.equals("NR")) {
			this.rating = rating;

		} else {
			throw new IllegalArgumentException("Invalid Rating!");
		}

	}

	/**
	 * Gets the rating of the specified movie.
	 * 
	 * @return Rating of the current movie
	 */

	public String getRating() {
		return rating;
	}

	/**
	 * Sets the rating of the specified movie.
	 * 
	 * @param rating
	 */

	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Sets the title of the specified movie.
	 * 
	 * @param title
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the number of copies available of the specified movie.
	 * 
	 * @param numOfCopies
	 */

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	/**
	 * Gets the number of copies available.
	 * 
	 * @return
	 */
	public int getNumOfCopies() {
		return numOfCopies;
	}

	/**
	 * Gets the title of the specified movie;
	 * 
	 * @return title of the current movie
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * Returns all the information associated with the movie class as a string.
	 * 
	 * @return Formats the movie.
	 */

	public String toString() {
		return "Title: " + title + ", Copies Available: " + numOfCopies + ", Rating: " + rating + "\n";
	}

	/**
	 * Sorts data based by title in lexicographical order.
	 * 
	 * @return
	 */

	@Override
	public int compareTo(Media other) {
		return title.compareTo(other.getTitle());
	}

	/**
	 * Counter to decrease the number of copies available when a customer rents
	 * media.
	 * 
	 */
	@Override
	public int counter() {
		this.numOfCopies--;
		return numOfCopies;
	}

	/**
	 * Counter to increase the number of copies available when a customer returns a
	 * rented media.
	 */

	@Override
	public int counterForReturning() {
		this.numOfCopies++;
		return numOfCopies;
	}

}
