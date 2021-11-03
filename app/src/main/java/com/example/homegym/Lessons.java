package com.example.homegym;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Lessons extends Fragment {

    TextView buttonHands;
    TextView buttonSpine;
    TextView buttonTorso;
    TextView buttonLegs;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;

    public Lessons() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lessons, container, false);
        Init(v);

        ImageView[] masImage = {image1, image2, image3, image4};
        TextView[] masTextView = {buttonHands, buttonSpine, buttonTorso, buttonLegs};

        buttonHands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change(buttonHands, masTextView, masImage);
            }
        });

        buttonSpine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change(buttonSpine, masTextView, masImage);
            }
        });


        buttonTorso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change(buttonTorso, masTextView, masImage);
            }
        });


        buttonLegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change(buttonLegs, masTextView, masImage);
            }
        });

        return v;
    }

    private void Change(TextView textView, TextView[] mas, ImageView[] imas) {
        String drawable_name = "null";
        String value = textView.getText().toString();

        switch (value) {
            case "Hands":
                drawable_name = "bcps";
                break;
            case "Spine":
                drawable_name = "fback";
                break;
            case "Torso":
                drawable_name = "ftors";
                break;
            case "Legs":
                drawable_name = "flegs";
        }

        int resID = getResources().getIdentifier(drawable_name, "drawable", getContext().getPackageName());

        for (TextView text : mas) {
            if (text.getText().equals(value)) {
                text.setTextColor(getResources().getColor(R.color.white));
                text.setBackgroundResource(R.color.blue_bg);
            }
            else {
                text.setTextColor(getResources().getColor(R.color.blue_bg));
                text.setBackgroundResource(R.drawable.stroke);
            }
        }

        for (ImageView image: imas) {
            image.setImageResource(resID);
        }
    }

    private void Init(View v){
        buttonHands = v.findViewById(R.id.textView13);
        buttonSpine = v.findViewById(R.id.textView19);
        buttonTorso = v.findViewById(R.id.textView20);
        buttonLegs = v.findViewById(R.id.textView21);

        image1 = v.findViewById(R.id.imageView16);
        image2 = v.findViewById(R.id.imageView17);
        image3 = v.findViewById(R.id.imageView18);
        image4 = v.findViewById(R.id.imageView19);

    }
}