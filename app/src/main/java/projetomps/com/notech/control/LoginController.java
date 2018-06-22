package projetomps.com.notech.control;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import projetomps.com.notech.R;
import projetomps.com.notech.view.CadastroFragment;
import projetomps.com.notech.view.LoginFragment;

public class LoginController extends Activity {

    private TextView textoFragmento, sair;
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
        FragmentManager loginFragment = getFragmentManager();
        FragmentTransaction fragmentTransaction = loginFragment.beginTransaction();

        switch (fragmentoAtivo){
            case "telaDeCadastro":
                //LoginFragment loginFragment = new LoginFragment();
                fragmentTransaction.replace(R.id.loginLayoutFragmento, new LoginFragment());
                fragmentTransaction.commit();
                fragmentoAtivo = "telaDeLogin";
                textoFragmento.setText("Deseja se cadastrar? então click aqui!");
                break;

            case "telaDeLogin":
                fragmentTransaction.replace(R.id.loginLayoutFragmento, new CadastroFragment());
                fragmentTransaction.commit();
                fragmentoAtivo = "telaDeCadastro";
                textoFragmento.setText("Deseja fazer login? então click aqui!");
                break;

        }
    }
}
