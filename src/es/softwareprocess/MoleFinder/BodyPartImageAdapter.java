package es.softwareprocess.MoleFinder;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

// Stolen from http://developer.android.com/resources/tutorials/views/hello-gallery.html
public class BodyPartImageAdapter extends BaseAdapter {
    int mGalleryItemBackground;
    private Context mContext;

    private Integer[] mImageIds = {
  
    };

    public BodyPartImageAdapter(Context c) {
        mContext = c;
        //TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
        //mGalleryItemBackground = attr.getResourceId(
        //        R.styleable.HelloGallery_android_galleryItemBackground, 0);
        //attr.recycle();
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);

        imageView.setImageResource(mImageIds[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(150, 100));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(mGalleryItemBackground);

        return imageView;
    }


}