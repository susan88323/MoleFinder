package es.softwareprocess.MoleFinder;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

// Stolen from http://developer.android.com/resources/tutorials/views/hello-gallery.html
public class BodyPartImageAdapter extends BaseAdapter {
    int mGalleryItemBackground;
    BodyPart bodyPart;
    private Context mContext;

    public BodyPartImageAdapter(Context c, BodyPart bodyPart) {
        mContext = c;
        this.bodyPart = bodyPart;
        //TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
        //mGalleryItemBackground = attr.getResourceId(
        //        R.styleable.HelloGallery_android_galleryItemBackground, 0);
        //attr.recycle();
    }

    public int getCount() {
        return bodyPart.countPhotos();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    Bitmap bitmapOfBodyPart(int position) {
    	return BitmapFactory.decodeFile(bodyPart.getPhoto(position).getFilename());
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        
        Bitmap bmp = bitmapOfBodyPart(position);
        imageView.setImageBitmap(bmp);       
        imageView.setLayoutParams(new Gallery.LayoutParams(150, 100));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(mGalleryItemBackground);

        return imageView;
    }


}