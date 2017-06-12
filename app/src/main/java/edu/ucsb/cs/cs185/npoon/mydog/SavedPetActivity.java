package edu.ucsb.cs.cs185.npoon.mydog;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;

import static edu.ucsb.cs.cs185.npoon.mydog.R.id.textView;

public class SavedPetActivity extends AppCompatActivity {

    public static ArrayList<PetObject> savedPets = new ArrayList<>();

    ListView savedPetsList;
    TextView tv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.splash_background)));





        PetObject a = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.germanshepherd),
                "Lucky", "German Shepherd", "He's friendly", 2, 1111111111, '5');
        PetObject b = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.poodle),
                "Ronn", "Poodle", "Very Engergetic", 1, 2123314512, '5');
        PetObject c = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.lab),
                "Angie", "Lab", "Loves cuddling!", 4, 1472927821, '5');
        PetObject d = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.husky),
                "Dixie", "Husky", "Really Independent", 3, 1232222222, '5');
        PetObject e = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.bull),
                "Colby", "Bull", "Always wants to play catch", 6, 1123456784, '5');
        PetObject f = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.terrier),
                "Donny", "Terrier", "Very Engergetic", 1, 2123314512, '5');
        PetObject g = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.rottweiler),
                "Chuck", "Rottweiler", "Loves cuddling!", 4, 1472927821, '5');
        PetObject h = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.beagle),
                "Farlough", "Beagle", "Really Independent", 3, 1232222222, '5');
        PetObject i = new PetObject(Uri.parse("android.resource://edu.ucsb.cs.cs185.npoon.mydog/drawable/" + R.drawable.goldenretriever),
                "Hemmy", "Golden Retriever", "Always wants to play catch", 6, 1123456784, '5');

        savedPets.add(a);
        savedPets.add(b);
        savedPets.add(c);
        savedPets.add(d);
        savedPets.add(e);
        savedPets.add(f);
        savedPets.add(g);
        savedPets.add(h);
        savedPets.add(i);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_pet);

        savedPetsList = (ListView) findViewById(R.id.lv_savedPets);


        SavedPetsListAdapter savedPetsListAdapter = new SavedPetsListAdapter(getApplicationContext(), savedPets);
        savedPetsList.setAdapter(savedPetsListAdapter);
    }



}
