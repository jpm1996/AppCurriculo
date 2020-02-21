package joao.studio.com.analisecurriculo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonloggout = (Button) findViewById(R.id.buttonloggout);
        buttonloggout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent irTela = new Intent(menu.this, Analise.class);
                startActivity(irTela);
            }
        });

        Button buttoncadastro = (Button) findViewById(R.id.buttoncadastro);
        buttoncadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent irTela = new Intent(menu.this, Cadastro.class);
                startActivity(irTela);
            }
        });

        Button buttonedit = (Button) findViewById(R.id.buttonedit);
        buttonedit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent irTela = new Intent(menu.this, Cadastro.class);
                startActivity(irTela);
            }
        });



        Button buttondelete = (Button) findViewById(R.id.buttondelete);
        buttondelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder msgBox = new AlertDialog.Builder(menu.this);
                msgBox.setTitle("Excluindo...");
                msgBox.setIcon(android.R.drawable.ic_menu_delete);
                msgBox.setMessage("Tem certeza que deseja exlcuir este item?");

                msgBox.setNegativeButton("Não!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(menu.this, "Curriculo não excluído", Toast.LENGTH_SHORT).show();
                    }
                });
                msgBox.setPositiveButton("Sim!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(menu.this, "Excluído com sucesso", Toast.LENGTH_SHORT).show();
                    }
                });

                msgBox.show();

            }
        });


    }
}
