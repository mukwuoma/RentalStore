package mediaRentalManager;

import java.util.ArrayList;

/**
 * Class that stores all the information associated with the customers. A
 * customer has a name, an address, a plan and two queues.
 * 
 * @author munachimsoukwuoma
 *
 */

public class CustomerInfo implements Comparable<CustomerInfo> {
	private String name;
	private String address;
	private String plan;
	private ArrayList<String> rented = new ArrayList<String>();
	private ArrayList<String> queue = new ArrayList<String>();

	/**
	 * Constructor that initializes the name, address, and plan.
	 * 
	 * @param name
	 * @param address
	 * @param plan
	 */

	public CustomerInfo(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		if (plan.equals("LIMITED") || plan.equals("UNLIMITED")) {
			this.plan = plan;

		} else {
			throw new IllegalArgumentException("Invalid Plan Selected!");
		}
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param copy
	 */

	public CustomerInfo(CustomerInfo copy) {
		this.name = copy.name;
		this.address = copy.address;
		this.plan = copy.plan;
	}

	/**
	 * Gets name associated with current customer.
	 * 
	 * @return Name of customer.
	 */
	public String getName() {
		return name;

	}

	/**
	 * Gets address associated with current customer.
	 * 
	 * @return Address of customer
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets plan associated with current customer.
	 * 
	 * @return Plan of customer.
	 */

	public String getPlan() {
		return plan;
	}

	/**
	 * Gets number of rented media associated with current customer.
	 * 
	 * @return Number of rented media.
	 */

	public int getNumRented() {
		return rented.size();
	}

	/**
	 * Gets number of queued media associated with current customer.
	 * 
	 * @return Number of queued media.
	 */

	public int getNumQueued() {
		return queue.size();
	}

	/**
	 * Gets rented media associated with the current customer.
	 * 
	 * @return Media rented by the customer.
	 */
	public ArrayList<String> getRented() {
		return rented;
	}

	/**
	 * Sets the rented media of the customer.
	 * 
	 * @param rented
	 */

	public void setRented(ArrayList<String> rented) {
		this.rented = rented;
	}

	/**
	 * Gets queued media associated with the current customer.
	 * 
	 * @return Media queued by the customer.
	 */

	public ArrayList<String> getQueue() {
		return queue;
	}

	/**
	 * Sets the queued media of the current customer.
	 * 
	 * @param queue
	 */
	public void setQueue(ArrayList<String> queue) {
		this.queue = queue;
	}

	/**
	 * Compares two customers.
	 * 
	 * @param obj
	 * @return True if to objects are the same.
	 */

	public boolean equals(CustomerInfo obj) {
		if (obj == this) {
			return true;
		}
		return name.equals(obj.name) && name.equals(obj.address) && name.equals(obj.plan);

	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address
	 */

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Sets the plan.
	 * 
	 * @param plan
	 */

	public void setPlan(String plan) {
		this.plan = plan;
	}

	/**
	 * Returns all the information associated with the CustomerInfo class as a
	 * string.
	 */

	public String toString() {
		return "Name: " + name + ", Address: " + address + ", Plan: " + plan + "\nRented: " + rented + "\nQueue: "
				+ queue + "\n";
	}

	/**
	 * Counter to decrease the number of copies available when a customer rents
	 * media.
	 * 
	 * @return A negative number if other customer name precedes the media in
	 *         lexicographical order.
	 */
	@Override
	public int compareTo(CustomerInfo obj) {
		return this.name.compareTo(((CustomerInfo) obj).name);
	}

}
