package ru.techpark.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements  OnNumberClickListener{

    public final static String  RECYCLERVIEW_TAG="RECYCLERVIEW_TAG";
    public final static String NUMBER_TAG="NUMBER_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecyclerViewFragment();
    }

    @Override
    public void onClick(int value)
    {
        setNumberFragment(value);
    }


    private void setRecyclerViewFragment()
    {
        if(getSupportFragmentManager().findFragmentByTag(RECYCLERVIEW_TAG) == null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new RecyclerViewFragment(),RECYCLERVIEW_TAG)
                    .commit();
        }
    }

    private  void setNumberFragment(int value)
    {
        if(getSupportFragmentManager().findFragmentByTag(NUMBER_TAG) == null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,new NumberFragment(value),NUMBER_TAG)
                    .addToBackStack(NUMBER_TAG)
                    .commit();
        }

    }

}