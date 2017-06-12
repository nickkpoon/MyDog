package edu.ucsb.cs.cs185.npoon.mydog;

import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;

public class PetSwipeActivity extends AppCompatActivity implements link.fls.swipestack.SwipeStack.SwipeStackListener {
    public static ArrayList<String> mData;
    public static ArrayList<Uri>mImgs;
    private SwipeStack swipeStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_stack);

        //dummy data just to test
        swipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        swipeStack.setAdapter(new SwipeStackAdapter(mData,mImgs));

    }

    @Override
    public void onViewSwipedToLeft(int position) {

    }

    @Override
    public void onViewSwipedToRight(int position) {

    }

    @Override
    public void onStackEmpty() {

    }

    public class SwipeStackAdapter extends BaseAdapter {

        private List<String> mData;
        private List<Uri> mImgs;

        public SwipeStackAdapter(List<String> data, List<Uri> imgs) {
            this.mData = data; this.mImgs=imgs;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.card, parent, false);
            TextView textView = (TextView) convertView.findViewById(R.id.textViewCard);
            textView.setText(mData.get(position));
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewCard);
            imageView.setImageURI(mImgs.get(position));

            return convertView;
        }
    }
}
