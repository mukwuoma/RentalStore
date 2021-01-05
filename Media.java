package mediaRentalManager;

/**
 * Interface that the defines the similar methods from the Movie and album
 * class.
 * 
 * @author munachimsoukwuoma
 */
public interface Media extends Comparable<Media> {

	/**
	 * Gets the number of copies available for each media type.
	 * 
	 * @return Number of copies available.
	 */
	public int getNumOfCopies();

	/**
	 * Gets the title for each media type.
	 * 
	 * @return Specified title.
	 */

	public String getTitle();

	/**
	 * Sorts data based on specified media type.
	 * 
	 * @param other
	 * @return A negative number if other media precedes the media in
	 *         lexicographical order.
	 */

	public int compareTo(Media other);

	/**
	 * Counter to decrease the number of copies available when a customer rents
	 * media.
	 * 
	 * 
	 * @return Updated number of copies available.
	 */
	public int counter();

	/**
	 * Counter to increase the number of copies available when a customer returns a
	 * rented media.
	 * 
	 * @return Updated number of copies available.
	 */
	public int counterForReturning();

}
