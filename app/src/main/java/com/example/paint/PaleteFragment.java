package com.example.paint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.GestureDetector;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaleteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaleteFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    //private PaintView canvas;
    //private PaintView canvas;
    private PaintView canvas;

    public PaleteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PaleteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaleteFragment newInstance(String param1, String param2) {
        PaleteFragment fragment = new PaleteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_palete,
                container, false);



        Button erasebutton = (Button) view.findViewById(R.id.erase);
        erasebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                getView().setBackgroundColor(Color.WHITE);
            }
        });




        Button colorbutton = (Button) view.findViewById(R.id.changecolor);
        colorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                getView().setBackgroundColor(Color.WHITE);

               // canvas.changeColor();


                //Fragment canvas = fragmentManager.findFragmentByTag("fragmentContainerView3");



                //PaintView paintView = new PaintView(getContext());
                //paintView.brush.setColor(Color.BLACK);
               // paintView.changeColor();
                //listener.setCanvas(paintView);
                //listener.Change();
                //canvas.changeColor();


            }
        });


       // return inflater.inflate(R.layout.fragment_palete, container, false);
        return view;
    }






}