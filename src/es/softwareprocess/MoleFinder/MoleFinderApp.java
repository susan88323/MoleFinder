package es.softwareprocess.MoleFinder;

import android.app.Application;
import android.content.Intent;

public class MoleFinderApp extends Application {

	public static final String LOG = "MoleFinderApp";
	transient static private MoleFinder moleFinderSingleton = null;
	static public MoleFinder getMoleFinder(Intent intent) {		
		MoleFinder mf = (MoleFinder)(intent.getExtras().get(MoleFinder.name));
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

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
