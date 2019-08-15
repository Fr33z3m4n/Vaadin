package de.fastwebs24;

import java.io.Serializable;

public class Person implements Serializable {

	private Integer number;
	
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
