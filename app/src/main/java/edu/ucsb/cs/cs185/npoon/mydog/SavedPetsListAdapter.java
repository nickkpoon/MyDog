package edu.ucsb.cs.cs185.npoon.mydog;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Jordan Ang on 6/12/2017.
 */

public class SavedPetsListAdapter extends ArrayAdapter<PetObject> {

    private ArrayList<PetObject> mList;

    public SavedPetsListAdapter(@NonNull Context context, ArrayList<PetObject> list) {
        super(context, 0, list);
        this.mList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PetObject mPet = mList.get(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_saved_pet, parent, false);
        }

        ImageView petImage = (ImageView) convertView.findViewById(R.id.iv_savedPetImage);
        TextView petName = (TextView) convertView.findViewById(R.id.tv_savedPetName);
        TextView petInfo = (TextView) convertView.findViewById(R.id.tv_savedPetInfo);

        Uri imageUri = mPet.petPic;
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(bitmap != null){
            petImage.setImageBitmap(bitmap);
        }

        petName.setText(mPet.name);

        petInfo.setText("Breed: " + mPet.breed + "    Age: " + mPet.age);

        return convertView;
    }
}
