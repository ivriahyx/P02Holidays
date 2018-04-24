package com.example.a16023018.p02_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lvM;
    TextView tvYear;

    ArrayAdapter aa;
    ArrayList<Holidays> holidays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvM = (ListView) this.findViewById(R.id.lvHolidays);
        tvYear = (TextView) findViewById(R.id.tvSelected);

        // Create a few objects in array
        holidays = new ArrayList<Holidays>();

        Intent i = getIntent();
        String year = i.getStringExtra("selection");
        tvYear.setText(year);

        if(tvYear.getText().equals("Secular")) {
            holidays.add(new Holidays( "New Year's Day", "1 January 2018",0));
            holidays.add(new Holidays( "Labour Day", "1 May 2018",1));
        }else if(tvYear.getText().equals("Ethnic & Religion")) {
            holidays.add(new Holidays( "Chinese New Year", "28-29 January 2018",2));
            holidays.add(new Holidays( "Good Friday", "14 April 2018",3));
        }
        aa = new HolidayAdapter(this, R.layout.rowsecond, holidays);
        lvM.setAdapter(aa);

        lvM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selectedHoliday = holidays.get(position);

                Toast.makeText(SecondActivity.this, selectedHoliday.getName()
                                + " Date: " + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });


    }

}
