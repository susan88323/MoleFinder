package es.softwareprocess.MoleFinder;

import java.io.Serializable;
import java.util.ArrayList;

public class BodyPart implements Serializable {
	public String name;
	ArrayList<BodyPartPhoto> bodyPartPhotos;
	public BodyPart(String name) {
		this.name = name;
		bodyPartPhotos = new ArrayList<BodyPartPhoto>();
	}
	public String name() {
		return name;
	}
	public String toString() {
		return name();
	}
	public void addPhoto(BodyPartPhoto bodyPartPhoto) {		
		bodyPartPhotos.add(bodyPartPhoto);
	}
}
