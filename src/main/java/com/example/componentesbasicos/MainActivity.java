

package com.example.componentesbasicos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private EditText campoNome;
        private TextInputEditText textoEmail;
        private TextView textoResultado;
        private CheckBox checkBranco, checkVerde, checkVermelho;
        private RadioButton rdMasculino, rdFeminino;
        private RadioGroup opcaoSexo;
        private ToggleButton toggleSenha;
        private Switch switchSenha;
        private TextView resultado2;
        private ProgressBar progressBarHorizontal;
        private ProgressBar progressBarCircular;
        private int progresso = 0;
        private SeekBar seekBarEscala;
        private TextView textResultado3;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                campoNome = findViewById(R.id.editNome);
                textoResultado = findViewById(R.id.resultado);
                textoEmail = findViewById(R.id.email);
                checkBranco = findViewById(R.id.checkBranco);
                checkVerde = findViewById(R.id.checkVerde);
                checkVermelho = findViewById(R.id.checkVermelho);
                rdMasculino = findViewById(R.id.rdMasculino);
                rdFeminino = findViewById(R.id.rdFeminino);
                opcaoSexo = findViewById(R.id.radioGroupSexo);
                radiobutton();
                toggleSenha = findViewById(R.id.toggleSenha);
                switchSenha = findViewById(R.id.switchSenha);
                resultado2 = findViewById(R.id.textResultado2);
                adicionarListner2();
                progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
                progressBarCircular = findViewById(R.id.progressBarCircular);
                progressBarCircular.setVisibility(View.GONE);//esconde apenas na view e não no activity_main
                seekBarEscala = findViewById(R.id.seekBar);
                textResultado3 = findViewById(R.id.textViewSeek);
                seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                textResultado3.setText("Progresso " + progress + " / " + seekBar.getMax());//qdo p progresso muda
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                                //textResultado3.setText("OnStartTrackingTouch");//qdo clica no cursor do progresso

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                                //textResultado3.setText("OnStpTrackingTouch"); // quando solta o cursor
                        }
                });


        }

        public void recuperarProgresso(View view) {

                textResultado3.setText("Escolhido: " + seekBarEscala.getProgress());
        }

        public void carregarProgessBar(View view) {

                this.progresso += 2;
                progressBarHorizontal.setProgress(this.progresso);

                progressBarCircular.setVisibility(View.VISIBLE);

                if (this.progresso == 10) {
                        progressBarCircular.setVisibility(View.GONE);
                }
        }

        public void abrirDialog(View view) {
                //Instanciar Dialog

                AlertDialog.Builder dialog = new AlertDialog.Builder(this);

                //configurar titulo e mensagem

                dialog.setTitle("Título da Dialog");
                dialog.setMessage("Menssagem da Dialog");

                //Configurar cancelamento

                dialog.setCancelable(false); // o usuario precisa escolher sim ou não

                // configurar icone

                dialog.setIcon(R.drawable.ic_launcher_background);

                // configurar ações se sim ou se não

                dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                //ação a ser executada
                                Toast.makeText(getApplicationContext(), "Executar a ação SIM", Toast.LENGTH_LONG).show();
                        }
                });
                dialog.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                //ação a ser executada
                                Toast.makeText(getApplicationContext(), "Executar a ação NÃO", Toast.LENGTH_LONG).show();
                        }
                });

                //Criar e exibir o Dialog

                dialog.create();
                dialog.show();


        }

        public void abrirToast(View view) {

                ImageView imageView = new ImageView(getApplicationContext());
                //imageView.setImageResource(android.R.drawable.star_big_off);
                imageView.setImageResource(R.drawable.logo);

                TextView textView = new TextView(getApplicationContext());
                //textView.setBackgroundResource(R.color.colorAccent); falta criar a cor
                //textView.setText("Olá você conseguiu!!");

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(imageView);
                //toast.setView(textView);
                toast.show();

                //Toast.makeText(getApplicationContext(), "Ação realizada com sucesso",Toast.LENGTH_LONG).show();
        }

        public void enviar2(View view) {

                // if(switchSenha.isChecked()){
                // resultado2.setText("switch ligado");
                //}else resultado2.setText("switch desligado");

                if (toggleSenha.isChecked()) {
                        resultado2.setText("toggleSenha  ligado");
                } else resultado2.setText("ToggleSenha desligado");

        }

        public void adicionarListner2() {

                switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {
                                        resultado2.setText("switch ligado");
                                } else resultado2.setText("switch desligado");
                        }
                });
        }

        public void checkbox() {

                String corSelecionada = "";

                if (checkVerde.isChecked()) {
                        corSelecionada += checkVerde.getText().toString();
                        corSelecionada += " ";
                }
                if (checkVermelho.isChecked()) {
                        corSelecionada += checkVermelho.getText().toString();
                        corSelecionada += " ";
                }
                if (checkBranco.isChecked()) {
                        corSelecionada += checkBranco.getText().toString();
                }

                textoResultado.setText(corSelecionada);

        }

        public void radiobutton() {
        /*
        if(rdFeminino.isChecked()){
            textoResultado.setText(rdFeminino.getText().toString());
        } else if (rdMasculino.isChecked()) {
            textoResultado.setText(rdMasculino.getText().toString());
        }
         */

                opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                                if (checkedId == R.id.rdFeminino) {
                                        textoResultado.setText(rdFeminino.getText().toString());
                                } else if (checkedId == R.id.rdMasculino) {
                                        textoResultado.setText(rdMasculino.getText().toString());
                                }

                        }
                });


        }

        public void enviar(View view) {
                radiobutton();

                // checkbox();

       /* String textoParaEmail = textoEmail.getText().toString();
        String nome = campoNome.getText().toString();
        textoResultado.setText(nome + " " + textoParaEmail);,

        */

        }

        public void limpar(View view) {

                campoNome.setText("");
                textoEmail.setText("");
                textoResultado.setText("Resultado");

        }
}



