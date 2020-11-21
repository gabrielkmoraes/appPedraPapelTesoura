package com.example.apppedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

    public void opcaoSelecionada(String opcaoSelecionada) {                 //recebe o parametro de uma das opções selecionadas pelo usuario

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);
        ImageView imageWin = findViewById(R.id.imageWin);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};                    //Criando uma array de strings
        int numero = new Random().nextInt(3);                       //Criando a variavel número e atribuindo a ela um número aleatório entre 0 e 3
        String opcaoApp = opcoes[numero];                                   //opçãoApp recebe o valor dentro da array de string
        switch (opcaoApp) {                                                 //se a opção aleatória for:
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);          //Pedra, configura a imagem como a da pedra
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);          //papel, configura a imagem como a do papel
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);        //tesoura, configura a imagem como a da tesoura
                break;
        }

        imageWin.setVisibility(View.VISIBLE);
        if  ((opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
            (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") ||
            (opcaoApp == "Papel" && opcaoSelecionada == "Pedra")) {             //Se algumas dessas opções foi verdadeira, o aplicativo é o ganhador

            textResultado.setText("Você perdeu :( ");
            imageWin.setImageResource(R.drawable.lose);


        } else if ((opcaoApp == "Tesoura" && opcaoSelecionada == "Pedra") ||
                    (opcaoApp == "Papel" && opcaoSelecionada == "Tesoura") ||
                    (opcaoApp == "Pedra" && opcaoSelecionada == "Papel")) {             ////Se algumas dessas opções foi verdadeira, o usuário é o ganhador

            textResultado.setText("Você ganhou :D");
            imageWin.setImageResource(R.drawable.win);

        } else {                                                                    //Caso contrário, é empate
            textResultado.setText("EMPATE!!!!");
            imageWin.setImageResource(R.drawable.draw);

        }


    }

}