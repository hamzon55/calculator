package com.lasalle.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText resultado;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, menos, div, igual, multiple, refresh, masmenos, bhistorico;


    List<Operation> operations = new ArrayList<Operation>();
    boolean bplus, bmenos, bmultiple, bdiv;

    int valueOne, valueTwo, mValue, result;
    String type;
    MathOperations p = new MathOperations();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.lasalle.calculadora.R.layout.activity_main);

        plus = (Button) findViewById(com.lasalle.calculadora.R.id.plus);
        menos = (Button) findViewById(com.lasalle.calculadora.R.id.menos);
        div = (Button) findViewById(com.lasalle.calculadora.R.id.dividir);
        igual = (Button) findViewById(com.lasalle.calculadora.R.id.igual);
        multiple = (Button) findViewById(com.lasalle.calculadora.R.id.multiple);
        refresh = (Button) findViewById(com.lasalle.calculadora.R.id.refresh);
        masmenos = (Button) findViewById(com.lasalle.calculadora.R.id.masmenos);

        bhistorico = (Button) findViewById(com.lasalle.calculadora.R.id.bhistorico);


        resultado = (EditText) findViewById(com.lasalle.calculadora.R.id.result);
        resultado.setFilters(new InputFilter[]{new IntegerFilter()});


        initButtons();


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.length() > 0) {
                    if (resultado == null) {
                        resultado.setText("");
                    } else {

                        valueOne = Integer.parseInt(resultado.getText() + "");
                        bplus = true;
                        resultado.setText(null);
                    }
                }
            }
        });

        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.length() > 0) {
                    valueOne = Integer.parseInt(resultado.getText() + "");
                    bmenos = true;
                    resultado.setText(null);
                    ;
                }
            }
        });

        masmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.length() > 0) {
                    mValue = Integer.parseInt(resultado.getText() + "");
                    resultado.setText("(" + mValue * (-1) + "");


                }
            }
        });


        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.length() > 0) {

                    valueOne = Integer.parseInt(resultado.getText() + "");
                    bmultiple = true;
                    resultado.setText(null);
                }
            }

        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.length() > 0) {
                    valueOne = Integer.parseInt(resultado.getText() + "");
                    bdiv = true;
                    resultado.setText(null);

                }
            }
        });


        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    valueTwo = Integer.parseInt(resultado.getText() + "");

                    if (bplus == true) {
                        type = "+";

                        result = p.sum(valueOne, valueTwo);
                        resultado.setText(result + "");
                        bplus = false;

                    }
                    if (bmenos == true) {
                        type = "-";
                        result = p.restar(valueOne, valueTwo);
                        resultado.setText(result + "");
                        bmenos = false;
                    }
                    if (bmultiple == true) {
                        type = "*";


                        result = p.multiplicar(valueOne, valueTwo);
                        resultado.setText(result + "");
                        bmultiple = false;

                    }
                    if (bdiv == true) {
                        result = valueOne / valueTwo;
                        type = "/";
                        resultado.setText(result + "");
                        bdiv = false;
                    }

                    operations.add(new Operation(type, valueOne, valueTwo, result));

                } catch (MathOperations.MyOverflowException e) {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    e.getMessage(), Toast.LENGTH_SHORT);
                    toast1.show();
                }

            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText("");
            }
        });

        bhistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Historico.class);
                i.putExtra("resultado", (Serializable) operations);
                startActivity(i);
            }
        });

    }

    private void initButtons() {
        b0 = (Button) findViewById(com.lasalle.calculadora.R.id.b0);
        b1 = (Button) findViewById(com.lasalle.calculadora.R.id.b1);
        b2 = (Button) findViewById(com.lasalle.calculadora.R.id.b2);
        b3 = (Button) findViewById(com.lasalle.calculadora.R.id.b3);
        b4 = (Button) findViewById(com.lasalle.calculadora.R.id.b4);
        b5 = (Button) findViewById(com.lasalle.calculadora.R.id.b5);
        b6 = (Button) findViewById(com.lasalle.calculadora.R.id.b6);
        b7 = (Button) findViewById(com.lasalle.calculadora.R.id.b7);
        b8 = (Button) findViewById(com.lasalle.calculadora.R.id.b8);
        b9 = (Button) findViewById(com.lasalle.calculadora.R.id.b9);


        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(resultado.getText() + "9");
            }
        });
    }


}




