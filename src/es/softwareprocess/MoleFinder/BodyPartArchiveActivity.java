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

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameratest);
        
		MoleFinder mf = MoleFinder.getMoleFinder(getIntent());

	    Gallery gallery = (Gallery) findViewById(R.id.gallery);
	    gallery.setAdapter(new ImageAdapter(this));

	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView parent, View v, int position, long id) {
	            Toast.makeText(BodyPartArchiveActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });

       Button acceptButton = (Button)findViewById(R.id.Accept);
        
        acceptButton.setOnClickListener( new OnClickListener() {
            public void onClick(View v) {
            	finish();
            }        	
        });
    }

}