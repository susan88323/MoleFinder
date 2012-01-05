package es.softwareprocess.MoleFinder;

import java.io.Serializable;

import android.net.Uri;

public class BodyPartPhoto implements Serializable {
	public Uri imageFileUri;
	public long time;
	public BodyPartPhoto(Uri file, long time) {
		this.time = time;
		this.imageFileUri = file;
	}
}
