package com.hfad.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  IFragments{
    private FragmentManager  fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, ThirdFragment.newInstance("f", ""));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFirstFragment() {

        transaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        transaction.hide(fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onSecondFragment() {

        transaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        transaction.show(fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void sendMessage(String s){
        transaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        ((TextView) fragment.getView().findViewById(R.id.txtSecond)).setText(s);
        transaction.show(fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}