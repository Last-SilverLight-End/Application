package com.example.sejongstar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class mains extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private temp fragmentA;
    private temp2 fragmentB;
    private FragmentTransaction transaction;
    private static final String List = "LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frags_main);

        fragmentManager = getSupportFragmentManager();

        fragmentA = new temp();
        fragmentB = new temp2();

        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frameLayout, fragmentA,List);
        transaction.add(R.id.frameLayout,fragmentB,List);
        transaction.commit();
    }

    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        switch(view.getId())
        {
            case R.id.btn_fragmentA:
                transaction.replace(R.id.frameLayout, fragmentA);
                transaction.add(R.id.frameLayout,fragmentB);
                transaction.commit();
                break;
            case R.id.btn_fragmentB:
                transaction.replace(R.id.frameLayout, fragmentB).commitAllowingStateLoss();
                break;
        }
    }
}

