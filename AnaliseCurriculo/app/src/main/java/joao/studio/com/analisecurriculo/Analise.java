package joao.studio.com.analisecurriculo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Analise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise);

        Button buttonlog = (Button) findViewById(R.id.buttonlog);
        buttonlog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String nome = ((EditText) findViewById(R.id.logintext)).getText().toString();
                String senha = ((EditText) findViewById(R.id.pastext)).getText().toString();

                if((nome.equals("leucotron") && (senha.equals("123")))){
                    Toast.makeText(Analise.this, "Bem Vindo!!", Toast.LENGTH_SHORT).show();
                    Intent irTela = new Intent(Analise.this, menu.class);
                    startActivity(irTela);
                }

                else{
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Analise.this);
                    dlg.setTitle("Aviso");
                    dlg.setMessage("Usuario ou senha invalidos!");
                    dlg.setNeutralButton("OK", null);
                    dlg.show();

                }


            }
        });

        Button buttonexit = (Button) findViewById(R.id.buttonexit);
        buttonexit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existeapp();
            }
        });
    }

    private void existeapp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Analise.this);
        builder.setMessage("Deseja sair do aplicativo?");
        builder.setCancelable(true);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                System.exit(0);

            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }


}