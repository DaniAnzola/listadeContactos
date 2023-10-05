package com.example.listadecontactos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Button btnAnadir;
    private EditText etNombreC, etNumeroC, etCorreoC;
    private Button btnCrearC;
    private ImageView ivFotoContacto;
    public static final int PICK_IMAGE = 1;
    private Uri selectedImage;
    private ArrayList<lista_Contactos> arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnadir = findViewById(R.id.btnAnadir);

        arr = new ArrayList<lista_Contactos>();
        arr.add(new lista_Contactos("Daniel Anzola", "698285123", R.drawable.daniel, "daniel@gmail.com",0));
        arr.add(new lista_Contactos("Pedro Perez", "656767654", R.drawable.pedro, "pedro@gmail.com",0));
        arr.add(new lista_Contactos("Alejandro Paez", "898986546", R.drawable.alejandro, "alejandro@gmailcom",0));
        arr.add(new lista_Contactos("Alfredo Ditox", "988786876", R.drawable.alfredo, "alfredo@gmail.com",0));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvListaC);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ContactAdapter adapter = new ContactAdapter(arr);
        recyclerView.setHasFixedSize(true);

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
                //Button btnS = popupView.findViewById(R.id.btnSiguiente);

                ivFotoContacto = popupView.findViewById(R.id.ivFotoContacto);
                etNombreC = popupView.findViewById(R.id.etNombreC);
                etNumeroC = popupView.findViewById(R.id.etNumeroC);
                etCorreoC = popupView.findViewById(R.id.etCorreoC);
                btnCrearC = popupView.findViewById(R.id.btnCrearC);
                ivFotoContacto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                        // Configura el titulo.
                        alertDialogBuilder.setTitle("Seguro");

                        // Configura el mensaje.
                        alertDialogBuilder
                                .setMessage("Quieres ir a galeria")
                                .setCancelable(false)
                                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //hasStoragePermission(MainActivity.this)
                                        if (true) {
                                            //TODO SELECCIONAR IMAGEN
                        //Si la respuesta es afirmativa aquí agrega tu función a realizar.
                                            Intent intent = new Intent();
                                            intent.setType("image/*");
                                            intent.setAction(Intent.ACTION_GET_CONTENT);
                                            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
                                        } else {
                                            ActivityCompat.requestPermissions(((AppCompatActivity) MainActivity.this), new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
                                        }


                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                }).create().show();


                    }
                });

                btnCrearC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String tp1 = etNombreC.getText().toString().trim();
                        String tp2 = etNumeroC.getText().toString().trim();
                        String tp3 = etCorreoC.getText().toString().trim();
                       // lista_Contactos c = new lista_Contactos(tp1, tp2, R.drawable.daniel, tp3);
                        lista_Contactos c = new lista_Contactos(tp1, tp2, selectedImage, tp3,1);
                        arr.add(c);
                        popupWindow.dismiss();


                    }
                });


                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

            }
        });


    }

    private boolean hasStoragePermission(Context context) {
        int read = ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE);
        boolean a = read == PackageManager.PERMISSION_GRANTED;
        Toast.makeText(context, String.valueOf(a), Toast.LENGTH_SHORT).show();
        return read == PackageManager.PERMISSION_GRANTED;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            selectedImage = data.getData();
            ivFotoContacto.setImageURI(selectedImage);



        }
    }


};



