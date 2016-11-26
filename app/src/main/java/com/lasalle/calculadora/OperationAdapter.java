package com.lasalle.calculadora;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by hamza on 20/11/2016.
 */

public class OperationAdapter extends ArrayAdapter<Operation> {

    public OperationAdapter(Context context, int resource, ArrayList<Operation> objects) {
        super(context, resource, objects);
    }

    @Override
    public int getCount() {
        if (super.getCount() < 20) {
        return super.getCount();
        }else{
            return 20;
        }
    }}