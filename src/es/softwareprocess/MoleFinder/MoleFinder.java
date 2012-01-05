package es.softwareprocess.MoleFinder;

import java.io.Serializable;
import java.util.HashMap;

import android.content.Intent;

public class MoleFinder implements Serializable {
	static public String name = "MoleFinder";
	transient static private MoleFinder moleFinderSingleton = null;
	static public MoleFinder getMoleFinder(Intent intent) {
		if (moleFinderSingleton == null) {
			moleFinderSingleton = (MoleFinder)(intent.getExtras().get("molefinder"));			
		}
		return getMoleFinder();
	}
	static public MoleFinder getMoleFinder() {		
		if (moleFinderSingleton == null) {
			moleFinderSingleton = new MoleFinder();
		}
		return moleFinderSingleton;
	}

	HashMap<String, BodyPart> bodyParts = new HashMap<String, BodyPart>();

	// Adds a body part so you can attach images to it
	void addBodyPart( String text ) {
		bodyParts.put(text, new BodyPart(text));
	}

	public BodyPart[] getBodyPartsAsArray() {
		return bodyParts.values().toArray(new BodyPart[0]);
	}
	
	// over eager?
	public void save() {
		// TODO Auto-generated method stub
		
	}	
}
