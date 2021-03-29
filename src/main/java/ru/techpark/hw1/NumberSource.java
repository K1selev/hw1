package ru.techpark.hw1;

import java.util.ArrayList;
import java.util.List;

public class NumberSource {

    private final List<Integer> data ;

    private static final int SIZE = 100;

    private static NumberSource pInstance;

    public List<Integer> getData()
    {
        return data;
    }

    private NumberSource()
    {
        data = new ArrayList<Integer>(SIZE);

        for ( int i = 0 ; i < SIZE; )
        {
            data.add(++i);
        }
    }

    public static NumberSource getInstance()
    {
        if(pInstance == null)
        {
            pInstance = new NumberSource();
        }

        return pInstance;
    }


}
