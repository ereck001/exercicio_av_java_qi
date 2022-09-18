package br.edu.qi.projasigno;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText
            nome,
            diaNas,
            mesNas,
            anoNas;
    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.edtNome);
        diaNas = findViewById(R.id.edtDia);
        mesNas = findViewById(R.id.edtMes);
        anoNas = findViewById(R.id.edtAno);
        resposta = findViewById(R.id.txtResposta);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void processar(View v){
        Horoscopo horoscopo = new Horoscopo();
        try {
            horoscopo.setNome(nome.getText().toString());
            horoscopo.setDiaNas(Byte.parseByte(diaNas.getText().toString()));
            horoscopo.setMesNas(Byte.parseByte(mesNas.getText().toString()));
            horoscopo.setAnoNas(Integer.parseInt(anoNas.getText().toString()));
            resposta.setText(horoscopo.toString());
        }catch (java.lang.NumberFormatException erro){
            resposta.setText("Dados inválidos");
        }
    }
}