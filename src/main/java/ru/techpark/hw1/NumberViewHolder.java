package ru.techpark.hw1;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NumberViewHolder extends RecyclerView.ViewHolder  {

    private TextView data;

   private int number;

    public NumberViewHolder(View itemView,OnNumberClickListener clickListener)
    {
        super(itemView);

        data = itemView.findViewById(R.id.number);

        data.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                clickListener.onClick(number);
            }

        });

    }



    public void bind(int value)
    {
        number = value;

        if(value % 2 == 0 ) {
            data.setTextColor(Color.RED);
        }
        else{
            data.setTextColor(Color.BLUE);
        }

        data.setText(String.valueOf(value));

    }


}
