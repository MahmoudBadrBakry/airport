package com.mbadr.tddjunit5.airport;

import java.util.Objects;

public class Passenger {

	private String name;
	private boolean vip;

	public Passenger(String name, boolean vip) {
		this.name = name;
		this.vip = vip;
	}

	public String getName() {
		return name;
	}

	public boolean isVip() {
		return vip;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Passenger passenger = (Passenger) o;

		if (vip != passenger.vip) return false;
		return Objects.equals(name, passenger.name);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (vip ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Passenger{" +
				"name='" + name + '\'' +
				", vip=" + vip +
				'}';
	}
}
