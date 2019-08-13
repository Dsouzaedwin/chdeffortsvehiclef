package com.edwin.chdeffortsvehicle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtvehicleno,txtstartread , txtendread, txtamount;
    Button btnaddvehicle;
    DatabaseReference databasevehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databasevehicle = FirebaseDatabase.getInstance().getReference();
        txtvehicleno =(EditText) findViewById(R.id.etvehicleno);
        txtstartread= (EditText) findViewById(R.id.etstartreading);
        txtendread=(EditText) findViewById(R.id.etendreding);
        txtamount= (EditText) findViewById(R.id.etamount);
        btnaddvehicle =(Button) findViewById(R.id.btnsubmitvehicle);

        btnaddvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addvehicle();
            }
        });

    }
    public void addvehicle(){
        String vehicleno = txtvehicleno.getText().toString().trim();
        String startread = txtstartread.getText().toString().trim();
        String endread= txtendread.getText().toString().trim();
        String amount = txtamount.getText().toString().trim();

        if(!TextUtils.isEmpty(vehicleno)){
           String id =  databasevehicle.push().getKey();
           Vehicle vehicle = new Vehicle(id,vehicleno,startread,endread,amount);
           databasevehicle.child(id).setValue(vehicle);
            Toast.makeText(this, "Vehicle Data Added", Toast.LENGTH_LONG).show();
        }else{
            txtvehicleno.setError("Please Enter Vehicle Number");

        }
        if(!TextUtils.isEmpty(startread)){

        }else{
            txtvehicleno.setError("Please Enter Start Reading");

        }
        if(!TextUtils.isEmpty(endread)){

        }else{
            txtvehicleno.setError("Please Enter End Reading");

        }
        if(!TextUtils.isEmpty(amount)){

        }else{
            txtvehicleno.setError("Please Enter amount");

        }



    }
}
