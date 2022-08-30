package com.pluralsight.tddjunit5.airport;

import java.util.*;

public abstract class Flight {

	private String id;
	protected Set<Passenger> passengerSet = new HashSet<>();

	public Flight(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Set<Passenger> getPassengersSet() {
		return Collections.unmodifiableSet(passengerSet);
	}

	public abstract boolean addPassenger(Passenger passenger);

	public abstract boolean removePassenger(Passenger passenger);

}
