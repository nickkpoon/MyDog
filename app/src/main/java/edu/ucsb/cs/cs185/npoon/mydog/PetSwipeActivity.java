package edu.ucsb.cs.cs185.npoon.mydog;

import android.media.Image;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;

public class PetSwipeActivity extends AppCompatActivity implements link.fls.swipestack.SwipeStack.SwipeStackListener {
    public static ArrayList<PetObject> mPets = new ArrayList<>();
    private SwipeStack swipeStack;

    //Dummy Data for Slideshow

    PetObject a = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.pug),
            "Rex", "Pug", "He's friendly", 2, 1111111111, '5');
    PetObject b = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.corgy),
            "Bailey", "Corgy", "Very Engergetic", 1, 2123314512, '5');
    PetObject c = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.lab),
            "Charlie", "Lab", "Loves cuddling!", 4, 1472927821, '5');
    PetObject d = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.husky),
            "Buddy", "Husky", "Really Independent", 3, 1232222222, '5');
    PetObject e = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.bull),
            "Rosie", "Bull", "Always wants to play catch", 6, 1123456784, '5');



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_stack);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);



        //dummy data just to test
        mPets.add(a);
        mPets.add(b);
        mPets.add(c);
        mPets.add(d);
        mPets.add(e);
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
