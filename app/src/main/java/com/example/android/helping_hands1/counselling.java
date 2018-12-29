package com.example.android.helping_hands1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class counselling extends AppCompatActivity {
    Spinner sp;
    Button bt;
    int[] seats = {70,70,70,70};
    List l;
    ArrayAdapter aa;
    TextView tv2,tv3,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counselling);
        tv1= (TextView)findViewById(R.id.t1);
        Intent i=new Intent();
        i.putExtra("name", "16BCA0022");
        Bundle b = i.getExtras();

        bt = (Button)findViewById(R.id.b1);

        tv1.setText("Welcome"+b.getString("name"));

        String[] c = new String[]{"BCA","BCom","BSc","MBA"};
        l = new ArrayList(Arrays.asList(c));
        aa = new ArrayAdapter<String>(this,R.layout.counselling,l);

        final String[] f = new String[]{"Bachelor of Computer Applications","Bachelor of Commerce","Bachelor of Science","Master of Business Administration"};
        sp = (Spinner)findViewById(R.id.s1);
        sp.setAdapter(aa);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = sp.getSelectedItemPosition();
                tv2 = (TextView)findViewById(R.id.t2);
                tv3 = (TextView)findViewById(R.id.t3);

                tv2.setText(f[pos]);
                tv3.setText("Seats Available:"+seats[pos]);

                if(seats[pos] == 0)
                {
                    Toast.makeText(getApplicationContext(),"No Seats Available. Try another course",Toast.LENGTH_LONG).show();
                }
                else
                {
                    seats[pos]--;
                    Toast.makeText(getApplicationContext(),"Seat Booked"+seats[pos],Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
