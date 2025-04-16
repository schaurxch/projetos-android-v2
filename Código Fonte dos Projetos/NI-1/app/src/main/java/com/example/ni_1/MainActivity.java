package com.example.ni_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbCoca;
    Button btnCalcular;
    TextView txtResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbArroz = findViewById(R.id.Arroz);
        cbLeite = findViewById(R.id.Leite);
        cbCarne = findViewById(R.id.Carne);
        cbFeijao = findViewById(R.id.Feijao);
        cbCoca = findViewById(R.id.Coca);

        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0;

                if (cbArroz.isChecked()) {
                    total += 2.69;
                }
                if (cbLeite.isChecked()) {
                    total += 2.70;
                }
                if (cbCarne.isChecked()) {
                    total += 16.70;
                }
                if (cbFeijao.isChecked()) {
                    total += 3.38;
                }
                if (cbCoca.isChecked()) {
                    total += 3.00;
                }

                txtResultado.setText(String.format("Total: R$ %.2f", total));
            }
        });
    }
}