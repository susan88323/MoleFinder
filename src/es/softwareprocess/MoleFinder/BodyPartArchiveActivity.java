package es.softwareprocess.MoleFinder;


import java.io.File;

import es.softwareprocess.MoleFinder.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
public class BodyPartArchiveActivity extends Activity {
	private BodyPart bp = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodypartarchive);
        bp = (BodyPart) getIntent().getExtras().get("bodypart");
		MoleFinder mf = MoleFinder.getMoleFinder(getIntent());

	    Gallery gallery = (Gallery) findViewById(R.id.gallery);
	    gallery.setAdapter(new BodyPartImageAdapter(this, bp));

	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView parent, View v, int position, long id) {
	            Toast.makeText(BodyPartArchiveActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });

       Button addPhotoButton = (Button)findViewById(R.id.addPhoto);
        
       addPhotoButton.setOnClickListener( new OnClickListener() {
            public void onClick(View v) {
            	// remember to jam in a result here
    			Intent intent = new Intent(BodyPartArchiveActivity.this, TakeAPhotoActivity.class);
				intent.putExtra("molefinder", MoleFinder.getMoleFinder());
				intent.putExtra("bodypart", bp);
				startActivity(intent);
				startActivityForResult(intent, TakeAPhotoActivity.TAKE_A_PHOTO);
            }        	
        });
    }
    @Override 
    public void onActivityResult(int requestCode, int resultCode, Intent newIntent) {     
      super.onActivityResult(requestCode, resultCode, newIntent); 
      switch(requestCode) { 
        case (TakeAPhotoActivity.TAKE_A_PHOTO) : { 
          if (resultCode == Activity.RESULT_OK) { 
        	  MoleFinder.getMoleFinder(newIntent);
        	  // update activity..        	  
          } 
          break; 
        } 
      } 
    }

}