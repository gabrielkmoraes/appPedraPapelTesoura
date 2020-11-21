package com.example.apppedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");

    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");

    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");

    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);
        ImageView imageWin = findViewById(R.id.imageWin);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];
        switch (opcaoApp) {
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        imageWin.setVisibility(View.VISIBLE);
        if ((opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura") || (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") || (opcaoApp == "Papel" && opcaoSelecionada == "Pedra")) {             //App ganhador

            textResultado.setText("Você perdeu :( ");
            imageWin.setImageResource(R.drawable.lose);


        } else if ((opcaoApp == "Tesoura" && opcaoSelecionada == "Pedra") || (opcaoApp == "Papel" && opcaoSelecionada == "Tesoura") || (opcaoApp == "Pedra" && opcaoSelecionada == "Papel")) {             //Usuario Ganhador

            textResultado.setText("Você ganhou :D");
            imageWin.setImageResource(R.drawable.win);

        } else {                                                                    //empate
            textResultado.setText("EMPATE!!!!");
            imageWin.setImageResource(R.drawable.draw);

        }


    }

}