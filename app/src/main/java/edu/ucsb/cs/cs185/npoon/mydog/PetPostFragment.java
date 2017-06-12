package edu.ucsb.cs.cs185.npoon.mydog;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * Created by wpollek on 6/11/17.
 */

public class PetPostFragment extends Fragment {
    ImageView petImg;
    EditText petName;
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
        petName = (EditText) root.findViewById(R.id.editText);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (petImg.getTag()!=null && petName.getText()!=null) {
                    PetSwipeActivity.mData.add(petName.getText().toString());
                    PetSwipeActivity.mImgs.add((Uri)petImg.getTag());
                }
                else{
                    Toast.makeText(getContext(),"Must have name and picture",Toast.LENGTH_SHORT);
                }
                getActivity().getFragmentManager().popBackStack();
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
