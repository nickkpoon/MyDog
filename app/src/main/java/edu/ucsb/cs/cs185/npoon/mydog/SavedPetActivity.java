package edu.ucsb.cs.cs185.npoon.mydog;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedPetActivity extends AppCompatActivity {

    public static ArrayList<PetObject> savedPets = new ArrayList<>();

    ListView savedPetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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

        savedPets.add(a);
        savedPets.add(b);
        savedPets.add(c);
        savedPets.add(d);
        savedPets.add(e);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_pet);

        savedPetsList = (ListView) findViewById(R.id.lv_savedPets);

        SavedPetsListAdapter savedPetsListAdapter = new SavedPetsListAdapter(getApplicationContext(), savedPets);
        savedPetsList.setAdapter(savedPetsListAdapter);
    }



}
