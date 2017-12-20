package com.example.aishwarya.monvoix;

/**
 * Created by aishwarya on 19/02/17.
 */

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.speech.RecognizerIntent;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;
import static com.example.aishwarya.monvoix.R.id.editText2;
import static com.example.aishwarya.monvoix.R.id.imageView;


public class tab1ttg extends Fragment{
    ImageButton imageButton;
    EditText edittext;
    ImageView iv;
    private final int REQ_CODE_SPEECH_INPUT = 100;
ImageButton btnSpeak;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1ttg, container, false);
        imageButton = (ImageButton) rootView.findViewById(R.id.imageButton);
        edittext=(EditText) rootView.findViewById(R.id.editText2);
        iv=(ImageView) rootView.findViewById(imageView);
        addListenerOnButton();
        btnSpeak = (ImageButton) rootView.findViewById(R.id.btnSpeak);

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        return rootView;
    }
    public void addListenerOnButton() {



        imageButton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View arg0) {

                Context context=iv.getContext();
                String image_name=edittext.getText().toString();
                // Resources resources = getContext().getResources();
                int resourceId = context.getResources().getIdentifier(image_name,"drawable",context.getPackageName());
                //Drawable drawable=resources.getDrawable(resourceId, getContext().getTheme());
                iv.setImageResource(resourceId);
                //to retrieve image

            }

        });


    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getActivity().getApplicationContext(), getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK&&null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    edittext.setText(result.get(0));
                }
                break;
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }



}




