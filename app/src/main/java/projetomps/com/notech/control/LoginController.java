package projetomps.com.notech.control;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import projetomps.com.notech.R;
import projetomps.com.notech.data.local.Cache;
import projetomps.com.notech.model.Usuario;
import projetomps.com.notech.view.CadastroFragment;
import projetomps.com.notech.view.LoginFragment;

public class LoginController extends FragmentActivity {

    private TextView textoFragmento, loginLogin, senhaLogin, cadastroNome, cadastroLogin, cadastroSenha;
    private String fragmentoAtivo = "telaDeLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_controller_view);
    }

    public void onClickSair(View v) {
        startActivity(new Intent(LoginController.this, NoticiasController.class));
    }

    public void onClickSwitch(View v) {
        textoFragmento = findViewById(R.id.loginTextoFragmento);
        FragmentManager loginFragment = getFragmentManager();
        FragmentTransaction fragmentTransaction = loginFragment.beginTransaction();

        switch (fragmentoAtivo){
            case "telaDeCadastro":
                fragmentTransaction.replace(R.id.fragmentContainer, new LoginFragment());
                fragmentTransaction.commit();
                fragmentoAtivo = "telaDeLogin";
                textoFragmento.setText("Deseja se cadastrar? então click aqui!");
                break;

            case "telaDeLogin":
                fragmentTransaction.replace(R.id.fragmentContainer, new CadastroFragment());
                fragmentTransaction.commit();
                fragmentoAtivo = "telaDeCadastro";
                textoFragmento.setText("Deseja fazer login? então click aqui!");
                break;

        }
    }

    public void onClickCadastro(View v) {
        cadastroNome = findViewById(R.id.cadastroLoginUsuario);
        cadastroLogin = findViewById(R.id.cadastroNomeUsuario);
        cadastroSenha = findViewById(R.id.cadastroSenhaUsuario);
        Usuario usuario = new Usuario(
                cadastroNome.getText().toString(),
                cadastroLogin.getText().toString(),
                cadastroSenha.getText().toString());
        Context context = getApplicationContext();
        Cache cache = Room.databaseBuilder(context, Cache.class, "cache.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        if(cache.getUsuarioDao().getUsuarioLogin(usuario.getLogin()) != null) {
            CharSequence text = "Este login já está cadastrado";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
            return;
        }
        cache.getUsuarioDao().insert(usuario);
        CharSequence text = "Usuario cadastrado";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    public void onClickLogin(View v) {
        loginLogin = findViewById(R.id.loginLoginUsuario);
        senhaLogin = findViewById(R.id.loginSenhaUsuario);
        Usuario usuario = new Usuario(null,
                loginLogin.getText().toString(),
                senhaLogin.getText().toString());

        Context context = getApplicationContext();
        Cache cache = Room.databaseBuilder(context, Cache.class, "cache.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        if(cache.getUsuarioDao().getUsuarioLogin(usuario.getLogin()) != null) {
            startActivity(new Intent(LoginController.this, NoticiasController.class));
            return;
        }
        CharSequence text = "Usuario nao cadastrado";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }
}
