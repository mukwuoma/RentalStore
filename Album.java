package mediaRentalManager;

/**
 * Class that implements the Media interface that provides the expected
 * functionality for the Albums in the Media Rental Manager. An album has a
 * title, an artist, a number of copies that are available for rent, and songs
 * associated with the album.
 * 
 * @author Munachimso Ukwuoma 2020©
 *
 */

public class Album implements Media {

	private String title, artist;
	private int numOfCopies;
	private String songs;

	/**
	 * Constructor that initializes that new Albums with a title, a number of copies
	 * available an artist and songs.
	 * 
	 * @param title
	 * @param numOfCopies
	 * @param artist
	 * @param songs
	 */

	public Album(String title, int numOfCopies, String artist, String songs) {
		this.title = title;
		this.artist = artist;
		this.numOfCopies = numOfCopies;
		this.songs = songs;

	}

	/**
	 * Gets the all the songs in the specified album.
	 * 
	 * @return Songs in the album
	 */

	public String getSongs() {
		return songs;
	}

	/**
	 * Sets the all the songs in the specified album.
	 * 
	 * @param songs
	 */

	public void setSongs(String songs) {
		this.songs = songs;
	}

	/**
	 * Gets the artist of the specified album.
	 * 
	 * @return Artist of the album.
	 */

	public String getArtist() {
		return artist;
	}

	/**
	 * Sets the artist of the specified album.
	 * 
	 * @param artist
	 */

	public void setArtist(String artist) {
		this.artist = artist;

	}

	/**
	 * Sets the title of the specified album.
	 * 
	 * @param title
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the number of copies available for the specified album;
	 * 
	 * @param numOfCopies
	 */
	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	/**
	 * Gets the number of copies available for the specified album.
	 * 
	 * @return Number of copies available.
	 */

	@Override
	public int getNumOfCopies() {

		return numOfCopies;
	}

	/**
	 * Gets the name of the specified album.
	 * 
	 * @return Title of the album.
	 */

	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * Returns all the information associated with the album class as a string.
	 */

	public String toString() {
		return "Title: " + title + ", Copies Available: " + numOfCopies + ", Artist: " + artist + ", Songs: " + songs
				+ "\n";
	}

	/**
	 * Sorts data based by title in lexicographical order.
	 */

	@Override
	public int compareTo(Media obj) {
		return this.title.compareTo(obj.getTitle());
	}

	/**
	 * Counter to decrease the number of copies available when a customer rents
	 * media.
	 * 
	 * 
	 * @return Updated number of copies available.
	 */

	@Override
	public int counter() {
		this.numOfCopies--;
		return numOfCopies;
	}

	/**
	 * Counter to increase the number of copies available when a customer returns a
	 * rented media.
	 * 
	 * @return Updated number of copies available.
	 */

	@Override
	public int counterForReturning() {
		this.numOfCopies++;
		return numOfCopies;
	}

}
