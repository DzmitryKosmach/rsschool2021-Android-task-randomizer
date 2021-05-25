package com.rsschool.android2021;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FirstFragment.Callbacks, SecondFragment.Callbacks {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFirstFragment(0);
    }

    private void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, firstFragment);
        fragmentManager.popBackStack();
        transaction.commit();
    }

    private void openSecondFragment(int min, int max) {
        final Fragment secondFragment = SecondFragment.newInstance(min, max);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, secondFragment).addToBackStack(null).commit();
    }

    @Override
    public void onClickGenerate(int min, int max) {
        openSecondFragment(min, max);
    }

    @Override
    public void onClickBack(int previousResult) {
        openFirstFragment(previousResult);
    }
}
