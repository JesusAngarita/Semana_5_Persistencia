package com.JesusAngarita.semana_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import com.JesusAngarita.semana_5.R;
import com.JesusAngarita.semana_5.email.GMailSender;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        Toolbar actionBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button btnEnviarCorreo = (Button) this.findViewById(R.id.btnEnviarCorreo);
        final TextInputEditText etNombre = (TextInputEditText) this.findViewById(R.id.etNombre);
        final TextInputEditText etEmail = (TextInputEditText) this.findViewById(R.id.etEmail);
        final TextInputEditText etComentario = (TextInputEditText) this.findViewById(R.id.etComentario);

        btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    GMailSender sender = new GMailSender("jesus.angarita.ae@gmail.com", "1234567ocho");
                    sender.sendMail(etNombre.getText().toString() + " Enviando un Correo",
                            etComentario.getText().toString(),
                            "jesus.angarita.ae@gmail.com",
                            etEmail.getText().toString());
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }

            }
        });
    }
}