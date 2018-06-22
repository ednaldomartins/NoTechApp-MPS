package projetomps.com.notech.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import projetomps.com.notech.R;
import projetomps.com.notech.control.adapters.NoticiaAdapter;
import projetomps.com.notech.data.BancoFacade;
import projetomps.com.notech.model.Noticia;
import projetomps.com.notech.util.command.GetNoticiasHeadlines;
import projetomps.com.notech.util.noticias.NoticiaBuilder;
import projetomps.com.notech.util.noticias.NoticiaJobsBuilder;

public class RecyclerViewFragment extends Fragment{

    public interface DataPassListener {
        void passData(Noticia noticia);
    }

    protected DataPassListener callack;

    private static final String TAG = "RecyclerViewFragment";

    protected RecyclerView mRecyclerView;
    protected NoticiaAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Noticia> noticias;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        noticias = new ArrayList<>();

        BancoFacade.getInstancia().addComando(
                new GetNoticiasHeadlines("google-news", getResources().getString(R.string.news_api_key)));
        BancoFacade.getInstancia().executaComando();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_frag, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvNoticias);

        mLayoutManager = new LinearLayoutManager(getActivity());

        int scrollPosition = 0;
        if (mRecyclerView.getLayoutManager() != null)
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);

        mAdapter = new NoticiaAdapter(noticias, new NoticiaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Noticia item) {
                callack.passData(item);
            }
        });

        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        callack = (DataPassListener) context;
    }

    public void updateAdapterData(List<Noticia> noticias) {
        mAdapter.swapList(noticias);
    }

}
