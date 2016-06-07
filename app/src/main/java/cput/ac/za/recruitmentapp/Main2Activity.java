package cput.ac.za.recruitmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cput.ac.za.recruitmentapp.domain.Administrator.Administrator;

public class Main2Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button preview = (Button) findViewById(R.id.btnSubmit);


        final EditText myStaffNumber = (EditText)findViewById(R.id.edStaff);
        final EditText myBooking = (EditText)findViewById(R.id.edBooking);
        final EditText myTotalWage = (EditText)findViewById(R.id.edTotalWage);



        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String staffNumber =myStaffNumber.getText().toString();

                String booking = myBooking.getText().toString();
                float totalWage = Float.parseFloat(myTotalWage.getText().toString());


                Administrator myAdmin = new Administrator.Builder()
                        .staffNumber(staffNumber)
                        .booking(booking)
                        .totalWage(totalWage)
                        .build();

                Intent myIntent = new Intent(view.getContext(), Main3Activity.class);
                myIntent.putExtra("AdminValue", myAdmin);

                startActivityForResult(myIntent, 0);


            }

        });

    }


}
