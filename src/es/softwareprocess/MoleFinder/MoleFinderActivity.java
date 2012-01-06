package es.softwareprocess.MoleFinder;

import es.softwareprocess.MoleFinder.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MoleFinderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button)findViewById(R.id.browseBodyPhotos);
        button.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {				
				Intent intent = new Intent(MoleFinderActivity.this, PhotoCollectionsActivity.class);
				startActivity(intent);
			}		
		});
        
        Button addButton = (Button)findViewById(R.id.addNewBodyPart);
        addButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {				
				Intent intent = new Intent(MoleFinderActivity.this, NewBodyPartActivity.class);				
				startActivity(intent);
			}
		});

    }
}