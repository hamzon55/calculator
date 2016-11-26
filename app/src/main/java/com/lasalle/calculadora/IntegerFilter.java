package com.lasalle.calculadora;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by hamza on 20/11/2016.
 */

public class IntegerFilter implements InputFilter {

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        if (source.length() > 0) {
            try {
                Integer.parseInt(dest.toString() + source.toString());
                return source;
            } catch (NumberFormatException nfe) {

                return source.subSequence(0, source.length() - 1);
            }
        }


        return source;
    }
}

