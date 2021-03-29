package ru.techpark.hw1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberViewHolder> {

    private List<Integer> data =  NumberSource.getInstance().getData();

    private final OnNumberClickListener numberClickListener;

    public NumberAdapter(OnNumberClickListener _numberClickListener)
    {
        numberClickListener = _numberClickListener;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int ViewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_number,parent,false);
        return new NumberViewHolder(view,numberClickListener);
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position)
    {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public void insert(int value)
    {
        data.add(value);
        notifyItemInserted(data.size() - 1);
    }

}
