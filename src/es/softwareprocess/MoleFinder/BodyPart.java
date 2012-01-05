package es.softwareprocess.MoleFinder;

import java.io.Serializable;

public class BodyPart implements Serializable {
	public String name;
	public BodyPart(String name) {
		this.name = name;
	}
	public String name() {
		return name;
	}
	public String toString() {
		return name();
	}
}
