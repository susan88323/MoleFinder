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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
public class TakeAPhotoActivity extends Activity {
	BodyPart bodyPart = null;
	Uri imageFileUri;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameratest);
        
		MoleFinder mf = MoleFinder.getMoleFinder(getIntent());
		bodyPart = (BodyPart) getIntent().getExtras().get("bodypart");
        ImageButton button = (ImageButton)findViewById(R.id.TakeAPhoto);
        OnClickListener listener = new OnClickListener() {
            public void onClick(View v) {
                takeAPhoto();
            }
        }; 
        button.setOnClickListener(listener);

       Button acceptButton = (Button)findViewById(R.id.Accept);
        
        acceptButton.setOnClickListener( new OnClickListener() {
            public void onClick(View v) {
            	addPhoto();
            	finish();
            }        	
        });
        
        Button cancelButton = (Button)findViewById(R.id.Cancel);
        
        cancelButton.setOnClickListener( new OnClickListener() {
            public void onClick(View v) {        
            	finish();
            }        	
        });  

        //takeAPhoto();
    }

    void addPhoto() {
		Intent resultIntent = new Intent();

		MoleFinder mf = MoleFinder.getMoleFinder(getIntent());
		mf.addPhotoToBodyPart(bodyPart, imageFileUri);

		resultIntent.putExtra(MoleFinder.name, mf );
		
		setResult(Activity.RESULT_OK, resultIntent);

    }
    protected static String id = "ID"; 
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	protected static final int TAKE_A_PHOTO = 666;


    
    public void takeAPhoto() {
        
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String folder = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp";
        File folderF = new File( folder );
        if (!folderF.exists()) {        	
        	folderF.mkdir();
        }
        String imageFilePath =  folder + "/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        File imageFile = new File(imageFilePath);
        imageFileUri = Uri.fromFile(imageFile);
        
        //intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageFileUri);

        //fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri); // set the image file name

        // start the image capture Intent
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
    		TextView tv = (TextView)findViewById(R.id.Status);
    		if (resultCode == RESULT_OK) {
    			// Image captured and saved to fileUri specified in the Intent
    			tv.setText("Photo OK!");
    			ImageButton button = (ImageButton)findViewById(R.id.TakeAPhoto);    		
    			button.setImageDrawable(Drawable.createFromPath(imageFileUri.getPath()));
    			//button.setImageBitmap(thumbnail);
    			
    			
    			
    			
    		} else if (resultCode == RESULT_CANCELED) {
            // 	User cancelled the image capture
    			tv.setText("Photo Cancelled!");
    		} else {
    			// Image capture failed, advise user
    			tv.setText("Not sure what happened!! "+resultCode);	
    		}
    	}
    
    }

}