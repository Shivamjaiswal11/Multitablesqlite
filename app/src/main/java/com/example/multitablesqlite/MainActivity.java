package com.example.multitablesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
EditText et_price,et_product,et_qty;
Button bt_add;
ListView list_view1,list_view2,list_view3;
Spinner spinner;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_price=findViewById(R.id.et_price);
        et_product=findViewById(R.id.et_product);
        et_qty=findViewById(R.id.et_qty);
        bt_add=findViewById(R.id.bt_add);
        list_view1=findViewById(R.id.list_view1);
        list_view2=findViewById(R.id.list_view2);
        list_view3=findViewById(R.id.list_view3);
        spinner=findViewById(R.id.spinner);
        databaseHelper =new DatabaseHelper(this);
        databaseHelper.getReadableDatabase();

        String[] spinnerlist = new String[]{"Product","Qty","Price"};
    }
}