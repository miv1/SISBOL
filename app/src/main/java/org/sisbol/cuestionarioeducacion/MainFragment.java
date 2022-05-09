package org.sisbol.cuestionarioeducacion;

import android.content.Intent;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


public class MainFragment extends Fragment {

    //Variables de la GUI
    EditText correoEditText;
    EditText contrasennaEditText;
    TextView correoTextView;
    TextView contrasennaTextView;
    TextView recuperarContrasennaTextView;
    Button iniciarButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        super.onCreateView(inflater, container , savedInstanceState);
        View vista = inflater.inflate(R.layout.inicio_sesion_fragment, container,false);

        setHasOptionsMenu(true);

        correoEditText = vista.findViewById(R.id.correoEditText);
        contrasennaEditText= vista.findViewById(R.id.contrasennaEditText);
        correoTextView = vista.findViewById(R.id.correoTextView);
        contrasennaTextView= vista.findViewById(R.id.contrasennaTextView);
        recuperarContrasennaTextView=vista.findViewById(R.id.recuperarContrasennaTextView);
        iniciarButton=vista.findViewById(R.id.iniciarButton);

        //Oyentes de eventos para los botones y edit text
        iniciarButton.setOnClickListener(oyenteIniciarButton);
        recuperarContrasennaTextView.setOnClickListener(oyenteRecuperarContrasennaTextView);
        correoEditText.addTextChangedListener(oyenteCorreoEditText);
        contrasennaEditText.addTextChangedListener(oyenteContrasennaEditText);

        return vista;

    }//OnCreateView()

    private final View.OnClickListener oyenteIniciarButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //logica para validar los datos y compararlos con la base de datos,mostrar mensaje de error si los datos no coinciden se debe usar intents para ir al fragmento de docente o el de estudiante
        }//onClick()
    };//oyenteIniciarButton


    private final TextWatcher oyenteCorreoEditText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }//beforeTextChanged()

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            correoTextView.setText(correoEditText.getText().toString());
        }//onTextChanged()

        @Override
        public void afterTextChanged(Editable s) {

        }//afterTextChanged()
    };//oyenteCorreoEditText


    private final TextWatcher oyenteContrasennaEditText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }//beforeTextChanged()

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            contrasennaTextView.setText(contrasennaEditText.getText().toString());
        }//onTextChanged()

        @Override
        public void afterTextChanged(Editable s) {

        }//afterTextChanged()
    };//oyenteContrasennaEditText

    private final View.OnClickListener oyenteRecuperarContrasennaTextView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gotoUrl("https://wa.me/59165148248?text=Quiero%20reestablecer%20mi%20contraseña");
        }
    };

    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }//gotoUrl()

}//MainFragment