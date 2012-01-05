package es.softwareprocess.MoleFinder;

import android.app.Activity;
import android.app.ListActivity;
import android.net.Uri;
import android.os.Bundle;

public class PhotoCollectionsActivity extends ListActivity {

	Uri imageFileUri;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photocollections);
        
    }
}