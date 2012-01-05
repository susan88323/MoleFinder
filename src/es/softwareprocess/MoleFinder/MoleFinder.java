package es.softwareprocess.MoleFinder;

import java.io.Serializable;
import java.util.HashMap;

import android.content.Intent;
import android.net.Uri;

public class MoleFinder implements Serializable {
	static public String name = "molefinder";
	transient static private MoleFinder moleFinderSingleton = null;
	static public MoleFinder getMoleFinder(Intent intent) {		
		MoleFinder mf = (MoleFinder)(intent.getExtras().get(name));
		if (mf!=null) {
			moleFinderSingleton = mf;				
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
	public void addPhotoToBodyPart(BodyPart bodyPart, Uri imageFileUri) {
		bodyPart.addPhoto(new BodyPartPhoto(imageFileUri,System.currentTimeMillis()));
	}	
}
