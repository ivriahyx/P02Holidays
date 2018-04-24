package com.example.a16023018.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holidays> {

    private ArrayList<Holidays> holidays;
    private Context context;
    private TextView tvName;
    private ImageView ivIcon;
    private TextView tvDate;

    public HolidayAdapter(Context context, int resource, ArrayList<Holidays> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the rowSecond.xmll as the layout for the View object
        View rowView = inflater.inflate(R.layout.rowsecond, parent, false);

        // Get the TextView object
        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivIcon = (ImageView) rowView.findViewById(R.id.imageView);

        // The parameter "position" is the index of the
        //  rowSecond ListView is requesting.
        //  We get back the food at the same index.
        Holidays current = holidays.get(position);
        // Set the TextView to show the food

        tvName.setText(current.getName());
        tvDate.setText(current.getDate());
        // Set the image to star or nostar accordingly

        if(current.getIcon()==0){
            ivIcon.setImageResource(R.drawable.nyd);
        }else if(current.getIcon()==1){
            ivIcon.setImageResource(R.drawable.ld);
        }else if(current.getIcon()==2){
            ivIcon.setImageResource(R.drawable.cny);
        }else if(current.getIcon()==3){
            ivIcon.setImageResource(R.drawable.gf);
        }





        // Return the nicely done up View to the ListView
        return rowView;
    }
}


