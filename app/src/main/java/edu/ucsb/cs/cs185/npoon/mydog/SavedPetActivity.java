package edu.ucsb.cs.cs185.npoon.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedPetActivity extends AppCompatActivity {

    public static ArrayList<PetObject> savedPets = new ArrayList<>();

    ListView savedPetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_pet);

        savedPetsList = (ListView) findViewById(R.id.lv_savedPets);

        SavedPetsListAdapter savedPetsListAdapter = new SavedPetsListAdapter(getApplicationContext(), savedPets);
        savedPetsList.setAdapter(savedPetsListAdapter);
    }



}
