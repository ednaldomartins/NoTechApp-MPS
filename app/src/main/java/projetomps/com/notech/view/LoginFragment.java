package projetomps.com.notech.view;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import projetomps.com.notech.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextView login, senha;
    private EditText loginUsuario, senhaUsuario;

    public LoginFragment() {
        // Required empty public constructor
        int i;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        login = (TextView) view.findViewById(R.id.loginLogin);
        senha = (TextView) view.findViewById(R.id.loginSenha);
        loginUsuario = (EditText) view.findViewById(R.id.loginLoginUsuario);
        senhaUsuario = (EditText) view.findViewById(R.id.loginSenhaUsuario);

        return view;
    }

}
