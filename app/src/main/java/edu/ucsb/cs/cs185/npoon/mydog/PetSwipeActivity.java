package edu.ucsb.cs.cs185.npoon.mydog;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;

import static edu.ucsb.cs.cs185.npoon.mydog.SavedPetActivity.savedPets;

public class PetSwipeActivity extends AppCompatActivity implements link.fls.swipestack.SwipeStack.SwipeStackListener {
    public static ArrayList<PetObject> mPets = new ArrayList<>();
    private SwipeStack swipeStack;

    //Dummy Data for Slideshow


    PetObject a = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.lab),
            "Charlie", "Lab", "Loves cuddling!", 4, 1472927821, 'l');
    PetObject b = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.husky),
            "Buddy", "Husky", "Really Independent", 3, 1232222222, 'l');
    PetObject c = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.bull),
            "Rosie", "Bull", "Always wants to play catch", 6, 1123456784, 'm');
    PetObject d = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.pug),
            "Rex", "Pug", "He's friendly", 2, 1111111111, 's');
    PetObject e = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.corgy),
            "Bailey", "Corgy", "Very Energetic", 1, 2123314512, 's');


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_stack);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.splash_background)));


        //dummy data to fill initial stack
        if (mPets.isEmpty()) {
            mPets.add(a);
            mPets.add(b);
           // mPets.add(c);
           // mPets.add(d);
           // mPets.add(e);
        }

        FloatingActionButton fabLeftSwipe = (FloatingActionButton) findViewById(R.id.floatingActionButton5);
        fabLeftSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeStack.onViewSwipedToLeft();
            }
        });

        FloatingActionButton fabRightSwipe = (FloatingActionButton) findViewById(R.id.floatingActionButton4);
        fabRightSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeStack.onViewSwipedToRight();

            }
        });


        swipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        swipeStack.setAdapter(new SwipeStackAdapter(mPets));

    }

    @Override
    public void onViewSwipedToLeft(int position) {

    }

    @Override
    public void onViewSwipedToRight(int position) {
        savedPets.add(mPets.get(position));
        Toast.makeText(getApplicationContext(), "Pet saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStackEmpty() {
        mPets.clear();
        Intent intent = new Intent(getApplicationContext(), SavedPetActivity.class);
        startActivity(intent);
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
            TextView textViewMiddle = (TextView) convertView.findViewById(R.id.textView3);
            textViewMiddle.setText(pet.info);
            TextView textView = (TextView) convertView.findViewById(R.id.textViewCard);
            textView.setText(pet.name + ", " + pet.age);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewCard);
            imageView.setImageURI(pet.petPic);

            return convertView;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_saved_pets, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.viewSavedPets){
            Intent intent = new Intent(getApplicationContext(), SavedPetActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
