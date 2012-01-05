package es.softwareprocess.MoleFinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewBodyPartActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbodypart);
        Button button = (Button)findViewById(R.id.bodyPartOkButton);        
        button.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				EditText bodyPartText = (EditText)findViewById(R.id.bodyPartText);
				String text = bodyPartText.getEditableText().toString();
				MoleFinder mf = MoleFinder.getMoleFinder(getIntent());
				mf.addBodyPart( text );
				setResult(RESULT_OK);	
				Intent resultIntent = new Intent();
				resultIntent.putExtra(MoleFinder.name, mf );
				setResult(Activity.RESULT_OK, resultIntent);
				//MoleFinder.getMoleFinder().save();
				finish();
			}
		});
    }
}