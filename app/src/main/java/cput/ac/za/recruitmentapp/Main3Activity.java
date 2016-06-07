package cput.ac.za.recruitmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cput.ac.za.recruitmentapp.domain.Administrator.Administrator;
import cput.ac.za.recruitmentapp.repository.administrator.AdministratorRepository;
import cput.ac.za.recruitmentapp.repository.administrator.impl.AdministratorRepositoryImpl;

public class Main3Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button submit = (Button) findViewById(R.id.btnSubmit);

        Intent i = getIntent();
        final Administrator myAdminCatch =(Administrator)i.getSerializableExtra("AdminValue");

        Toast.makeText(Main3Activity.this,myAdminCatch.toString(),Toast.LENGTH_LONG).show();

        EditText myEdit = (EditText ) findViewById(R.id.displayAlltxt);
        myEdit.setText(myAdminCatch.toString());





        submit.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                AdministratorRepository repo = new AdministratorRepositoryImpl(getApplicationContext()) {

                };
                // CREATE
                //Administrator createEntity = AdministratorFactory.CreateAdministrator(myAdminCatch.getName(),myAdminCatch.getSurname(),myAdminCatch.getPersalNumber());
                Administrator insertedEntity = repo.save(myAdminCatch);

                //Call the fourth sctivity
                Intent myIntent = new Intent(view.getContext(), Main4Activity.class);
                startActivityForResult(myIntent, 0);

            }
        });

    }


}
