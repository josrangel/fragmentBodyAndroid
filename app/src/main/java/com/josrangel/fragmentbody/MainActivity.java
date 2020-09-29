package com.josrangel.fragmentbody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            Fragment fragment1 = new BodyPartFragment();
            ((BodyPartFragment) fragment1).eligeTipo(1);
            Fragment fragment2 = new BodyPartFragment();
            ((BodyPartFragment) fragment2).eligeTipo(2);
            Fragment fragment3 = new BodyPartFragment();
            ((BodyPartFragment) fragment3).eligeTipo(3);

            getSupportFragmentManager().beginTransaction().add(R.id.contenedor1, fragment1).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor2, fragment2).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor3, fragment3).commit();
        }
    }


}