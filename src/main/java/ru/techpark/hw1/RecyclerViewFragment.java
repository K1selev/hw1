package ru.techpark.hw1;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RecyclerViewFragment extends Fragment {

    private OnNumberClickListener onClickListener;


    public RecyclerViewFragment() { }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onClickListener = (OnNumberClickListener)  context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        RecyclerView recyclerView =view.findViewById(R.id.recycler_view);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 4));
        }
        else
        {
            recyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 3));
        }

        recyclerView.setAdapter(new NumberAdapter(onClickListener));
       // recyclerView.setAdapter(new NumberAdapter());

        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NumberAdapter numberAdapter = (NumberAdapter) recyclerView.getAdapter();

                numberAdapter.insert(numberAdapter.getItemCount() + 1);

            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onClickListener = null;
    }

}