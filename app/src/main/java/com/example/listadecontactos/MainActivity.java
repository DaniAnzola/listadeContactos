package com.example.listadecontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {
    public Button btnAnadir;
    private EditText etNombreC, etNumeroC, etCorreoC;
    private Button btnCrearC;
    private ImageView ivFotoContacto;
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnadir = findViewById(R.id.btnAnadir);

        lista_Contactos[] c = new lista_Contactos[]{
                new lista_Contactos("Daniel Anzola", "698285123", R.drawable.daniel, "daniel@gmail.com"),
                new lista_Contactos("Pedro Perez", "656767654", R.drawable.pedro, "pedro@gmail.com"),
                new lista_Contactos("Alejandro Paez", "898986546", R.drawable.alejandro, "alejandro@gmailcom"),
                new lista_Contactos("Alfredo Ditox", "988786876", R.drawable.alfredo, "alfredo@gmail.com")
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvListaC);
        ContactAdapter adapter = new ContactAdapter(c);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        btnAnadir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View popupView = inflater.inflate(R.layout.popup, null);


                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = ViewGroup.LayoutParams.WRAP_CONTENT;
                boolean focusable = true;

                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                Button  btnS = popupView.findViewById(R.id.btnSiguiente);

                etNombreC=popupView.findViewById(R.id.etNombreC);
                etNumeroC=popupView.findViewById(R.id.etNumeroC);
                etNombreC=popupView.findViewById(R.id.etNombreC);



                };

        });
    }
}

