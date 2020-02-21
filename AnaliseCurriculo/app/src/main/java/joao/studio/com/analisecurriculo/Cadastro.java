package joao.studio.com.analisecurriculo;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtNasc;
    private EditText edtTel;
    private EditText edtEmail;
    private EditText edtArea;
    private EditText edtHab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        edtNome = (EditText) findViewById(R.id.editText6);
        edtNasc = (EditText) findViewById(R.id.editText);
        edtTel = (EditText) findViewById(R.id.editText7);
        edtEmail = (EditText) findViewById(R.id.editText8);
        edtArea = (EditText) findViewById(R.id.editText2);
        edtHab = (EditText) findViewById(R.id.editText9);

        Button buttonaccept = (Button) findViewById(R.id.buttonaccept);
        buttonaccept.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                validaCampos();

                Intent irTela = new Intent(Cadastro.this, menu.class);
                startActivity(irTela);

            }

        });

        Button buttoncancel = (Button) findViewById(R.id.buttoncancel);
        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaCampos();

                Intent irTela = new Intent(Cadastro.this, menu.class);
                startActivity(irTela);
            }
        });

    }


    private void validaCampos() {

        String nome = edtNome.getText().toString();
        String nasc = edtNasc.getText().toString();
        String tel = edtTel.getText().toString();
        String email = edtEmail.getText().toString();
        String area = edtArea.getText().toString();
        String hab = edtHab.getText().toString();
        boolean res = false;


        if (isCampoVazio(nome)) {
            edtNome.requestFocus();
            res = true;

        } else if (isCampoVazio(nasc)) {
            edtNasc.requestFocus();
            res = true;

        } else if (isCampoVazio(tel)) {
            edtTel.requestFocus();
            res = true;

        } else if (!isEmailValido(email)) {
            edtEmail.requestFocus();
            res = true;

        } else if (isCampoVazio(area)) {
            edtArea.requestFocus();
            res = true;

        } else if (isCampoVazio(hab)) {
            edtHab.requestFocus();
            res = true;

        }
        if (res) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(Cadastro.this);
            dlg.setTitle("Aviso");
            dlg.setMessage("Há campos inválidos ou em branco!");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

    }




        private boolean isCampoVazio(String valor){

            boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
            return resultado;

        }

        private boolean isEmailValido(String email){

            boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
            return resultado;
        }






}
