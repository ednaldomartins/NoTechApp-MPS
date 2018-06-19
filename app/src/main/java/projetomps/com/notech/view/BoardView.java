package projetomps.com.notech.view;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import projetomps.com.notech.R;
import projetomps.com.notech.control.adapters.NoticiaAdapter;
import projetomps.com.notech.model.Noticia;

public class BoardView extends Fragment {

    private static BoardView bv;
    private List<Noticia> noticias;
    private NoticiaAdapter adapter;
    private static RecyclerView rv;
    private LinearLayoutManager layoutManager;
    private View view;
    private ImageView imagem;
    private TextView titulo, data, texto, autor;

    public BoardView() {
        super();
    }

    public static BoardView newInstance(List<Noticia> noticias){
        BoardView bv = new BoardView();
        Bundle args = new Bundle();
        args.putParcelable("noticias", (Parcelable) noticias);
        bv.setArguments(args);
        return bv;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null)
            noticias = getArguments().getParcelableArrayList("noticias");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_noticia, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rvNoticias);
        layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        adapter = new NoticiaAdapter(noticias, getContext(), rv);
        rv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
