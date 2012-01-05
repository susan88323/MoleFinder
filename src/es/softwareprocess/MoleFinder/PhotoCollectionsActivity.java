package es.softwareprocess.MoleFinder;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PhotoCollectionsActivity extends ListActivity {

	private BodyPart [] bpa = null;
	Uri imageFileUri;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.photocollections);
		MoleFinder mf = MoleFinder.getMoleFinder(getIntent());
        bpa = mf.getBodyPartsAsArray();
        setListAdapter(new ArrayAdapter<BodyPart>(this, R.layout.list_item, bpa));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
            // When clicked, show a toast with the TextView text
            Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(PhotoCollectionsActivity.this, BodyPartArchiveActivity.class);
			intent.putExtra("molefinder", MoleFinder.getMoleFinder());
			intent.putExtra("bodypart", bpa[position]);
			startActivity(intent);
          }
        });

    }
}