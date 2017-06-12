package edu.ucsb.cs.cs185.npoon.mydog;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Toast;
import android.support.annotation.RequiresApi;
import android.util.Log;

import static android.app.Activity.RESULT_OK;
import static edu.ucsb.cs.cs185.npoon.mydog.PetSwipeActivity.mPets;


/**
 * Created by wpollek on 6/11/17.
 */

public class PetPostFragment extends Fragment {
    ImageView petImg;
    EditText petName;
    EditText petBreed;
    EditText petInfo;
    RadioButton smallPet;
    RadioButton medPet;
    RadioButton largePet;
    EditText phone;
    Button button;
    Button sendbutton;
    NumberPicker np;
    protected static final int CAMERA_REQUEST = 0;
    protected static final int GALLERY_PICTURE = 1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.pet_post_fragment, container, false);
        petImg = (ImageView) root.findViewById(R.id.petImg);
        button = (Button) root.findViewById(R.id.button);
        sendbutton = (Button) root.findViewById(R.id.sendButton);
        petInfo = (EditText) root.findViewById(R.id.petInfo);
        petName = (EditText) root.findViewById(R.id.petName);
        petBreed = (EditText) root.findViewById(R.id.petBreed);
        phone = (EditText) root.findViewById(R.id.phoneIn);
        smallPet = (RadioButton) root.findViewById(R.id.smallPet);
        medPet = (RadioButton) root.findViewById(R.id.medPet);
        largePet = (RadioButton) root.findViewById(R.id.largePet);
        smallPet.setChecked(false);
        medPet.setChecked(false);
        largePet.setChecked(false);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)

            @Override
            public void onClick(View v) {
                Uri uri = (Uri)petImg.getTag();
                String name = petName.getText().toString();
                String breed = petBreed.getText().toString();
                String info = petInfo.getText().toString();
                Integer age = np.getValue();

                Integer ph = null;
                if(!phone.getText().toString().isEmpty())
                    ph = Integer.parseInt(phone.getText().toString().trim());
                Character size = null;
                if(smallPet.isChecked()) {
                    size = 's';
                } else if(medPet.isChecked()) {
                    size = 'm';
                } else if(largePet.isChecked()) {
                    size = 'l';
                }
                Log.d("shitpost", name);
                if (uri!=null && !name.isEmpty() && !breed.isEmpty() && !info.isEmpty() && !age.toString().isEmpty() && !ph.toString().isEmpty() && size!=null) {
                    PetObject pet = new PetObject(uri,name,breed,info,age,ph,size);
                    mPets.add(0,pet);
                    Toast.makeText(getActivity(), "Pet created", Toast.LENGTH_SHORT).show();
                    getActivity().getFragmentManager().popBackStack();
                    for(int i=0; i<mPets.size(); i++){
                        Log.d("msg", mPets.get(i).name);
                    }
                }
                else{
                    Toast.makeText(getActivity(),"Must Complete ",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDialog();
            }
        });
        String[] nums = new String[361];
        for (int i = 0; i<nums.length;i++)
            nums[i]=Integer.toString(i);
        np = (NumberPicker) root.findViewById(R.id.numberPicker);
        np.setMinValue(0);
        np.setMaxValue(360);
        np.setWrapSelectorWheel(false);
        np.setValue(0);
        return root;
    }
    private void startDialog() {
        AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
                getActivity());
        myAlertDialog.setTitle("Upload Pictures Option");
        myAlertDialog.setMessage("How do you want to set your picture?");

        myAlertDialog.setPositiveButton("Gallery",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent pictureActionIntent = null;

                        pictureActionIntent = new Intent(
                                Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(
                                pictureActionIntent,
                                GALLERY_PICTURE);

                    }
                });

        myAlertDialog.setNegativeButton("Camera",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent intent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);


                        startActivityForResult(intent,
                                CAMERA_REQUEST);

                    }
                });
        myAlertDialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_PICTURE||requestCode==CAMERA_REQUEST&&resultCode==RESULT_OK){
            Uri uri = data.getData();
            petImg.setImageURI(uri);
            petImg.setTag(uri);
        }

    }
}
