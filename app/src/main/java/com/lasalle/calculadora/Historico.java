package com.lasalle.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Historico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.lasalle.calculadora.R.layout.activity_historico);

        ArrayAdapter<Operation> arrayAdapter;

        ArrayList<Operation> operations = (ArrayList<Operation>) getIntent().getSerializableExtra("resultado");


        arrayAdapter = new OperationAdapter(
                this,
                android.R.layout.simple_list_item_1,
                operations
        );


        ListView operationlist = (ListView) findViewById(com.lasalle.calculadora.R.id.operations);

        operationlist.setAdapter(arrayAdapter);





    }


}
