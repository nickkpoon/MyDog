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
    public static ArrayList<PetObject> mPets = new ArrayList<>();
    private SwipeStack swipeStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_stack);
        //dummy data just to test
        swipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        swipeStack.setAdapter(new SwipeStackAdapter(mPets));

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

        private List<PetObject> mData;

        public SwipeStackAdapter(List<PetObject> data) {
            this.mData=data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int position) {
            String name = mPets.get(position).name;
            return name;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            PetObject pet = mPets.get(position);
            convertView = getLayoutInflater().inflate(R.layout.card, parent, false);
            TextView textView = (TextView) convertView.findViewById(R.id.textViewCard);
            textView.setText(pet.name);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewCard);
            imageView.setImageURI(pet.petPic);

            return convertView;
        }
    }
}
