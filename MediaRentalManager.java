package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalManagerInt {

	private ArrayList<CustomerInfo> customer = new ArrayList<CustomerInfo>();
	private ArrayList<Media> media = new ArrayList<Media>();
	private int limitedPlanLimit = 2;

	@Override
	public void addCustomer(String name, String address, String plan) {

		CustomerInfo customerList = new CustomerInfo(name, address, plan);
		customer.add(customerList);
	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {

		Media movieList = new Movie(title, copiesAvailable, rating);
		media.add(movieList);
	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {

		Media albumList = new Album(title, copiesAvailable, artist, songs);
		media.add(albumList);
	}

	@Override
	public void setLimitedPlanLimit(int value) {
		this.limitedPlanLimit = value;
	}

	@Override
	public String getAllCustomersInfo() {

		Collections.sort(customer);
		String info = "***** Customers' Information *****\n";
		for (CustomerInfo c : customer) {
			info += c;
		}
		return info;
	}

	@Override
	public String getAllMediaInfo() {

		Collections.sort(media);
		String info = "***** Media Information *****\n";

		for (Media c : media) {
			info += c;
		}
		return info;

	}

	@Override
	public boolean addToQueue(String customerName, String mediaTitle) {

		for (CustomerInfo name : customer) {
			if (name.getName().equals(customerName) & !(name.getQueue().contains(mediaTitle))) {

				name.getQueue().add(mediaTitle);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeFromQueue(String customerName, String mediaTitle) {

		for (CustomerInfo name : customer) {
			if (name.getName().equals(customerName)) {
				name.getQueue().remove(mediaTitle);
				return true;
			}
		}
		return false;

	}

	@Override
	public String processRequests() {

		ArrayList<String> count = new ArrayList<String>();
		String requests = "";
		Collections.sort(customer);

		for (CustomerInfo name : customer) {
			if (name.getPlan().equals("UNLIMITED")) {

				for (String title : name.getQueue()) {
					if (available(title)) {
						addToRented(name.getName(), title);
						count.add(title);
						removeFromQueue(name.getName(),title);
						requests += "Sending " + title + " to " + name.getName() + "\n";
					}
				}

			} else if (name.getPlan().equals("LIMITED") && name.getRented().size() <= limitedPlanLimit) {

				for (String title : name.getQueue()) {
					if (name.getRented().size() < limitedPlanLimit && available(title)) {
						addToRented(name.getName(), title);
						count.add(title);

						requests += "Sending " + title + " to " + name.getName() + "\n";
					}

				}

			}
			for (String title : count) {
				name.getQueue().remove(title);
			}
			count.clear();

		}

		return requests;

	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {

		for (CustomerInfo name : customer) {
			if (name.getName().equals(customerName)) {
				returnMedia(mediaTitle);
				name.getRented().remove(mediaTitle);

				return true;
			}

		}
		return false;

	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {

		ArrayList<String> titles = new ArrayList<String>();

		if (title != null) {
			for (Media mediaTitle : media) {
				if (mediaTitle.getTitle().equals(title)) {
					titles.add(title);
				}
			}
		}
		if (rating != null) {
			for (Media mediaTitle : media) {
				if (mediaTitle instanceof Movie) {

					if (((Movie) mediaTitle).getRating().equals(rating)) {
						titles.add(mediaTitle.getTitle());
					}
				}
			}

		}
		if (artist != null) {
			for (Media mediaTitle : media) {
				if (mediaTitle instanceof Album) {
					if (((Album) mediaTitle).getArtist().equals(artist)) {
						titles.add(mediaTitle.getTitle());
					}
				}
			}
		}
		if (songs != null) {
			for (Media mediaTitle : media) {
				if (mediaTitle instanceof Album) {
					if (((Album) mediaTitle).getSongs().contains(songs)) {
						titles.add(mediaTitle.getTitle());

					}
				}
			}
		}
		if (title == null && rating == null && songs == null && artist == null) {
			for (Media mediaTitle : media) {
				titles.add(mediaTitle.getTitle());

			}
		}
		Collections.sort(titles);
		return titles;

	}

	/*
	 * Private method that check the availability of a media type and updates the
	 * number of copies available.
	 */
	private boolean available(String mediaTitle) {

		for (Media title : media) {
			if (title.getTitle().equals(mediaTitle) && title.getNumOfCopies() > 0) {
				title.counter();
				return true;
			}
		}
		return false;
	}

	/*
	 * Private method that checks updates the availability of copy once a customer
	 * returns a media type.
	 */
	private boolean returnMedia(String mediaTitle) {

		for (Media title : media) {

			if (title.getTitle().equals(mediaTitle)) {
				title.counterForReturning();
				return true;
			}
		}
		return false;
	}

	/*
	 * Private method that adds media to the rented queue.
	 */
	private boolean addToRented(String customerName, String mediaTitle) {

		for (CustomerInfo name : customer) {
			if (name.getName().equals(customerName)) {
				name.getRented().add(mediaTitle);
				return true;
			}
		}
		return false;
	}

}