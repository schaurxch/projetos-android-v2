package com.example.ni_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etSalario;
    RadioGroup rgPercentuais;
    RadioButton rb40, rb45, rb50;
    Button btnCalcular;
    TextView txtResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSalario = findViewById(R.id.Salario);
        rgPercentuais = findViewById(R.id.rgPercentuais);
        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String salarioStr = etSalario.getText().toString();

                if (salarioStr.isEmpty()) {
                    txtResultado.setText("Por favor, digite um salário válido.");
                    return;
                }

                double salario = Double.parseDouble(salarioStr);
                double percentual = 0;

                if (rb40.isChecked()) {
                    percentual = 0.40;
                } else if (rb45.isChecked()) {
                    percentual = 0.45;
                } else if (rb50.isChecked()) {
                    percentual = 0.50;
                } else {
                    txtResultado.setText("Selecione um percentual de aumento.");
                    return;
                }

                double novoSalario = salario + (salario * percentual);
                txtResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
            }
        });
    }
}