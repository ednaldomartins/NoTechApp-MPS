package projetomps.com.notech.view;

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
import projetomps.com.notech.model.Noticia;
import projetomps.com.notech.util.noticias.NoticiaBuilder;
import projetomps.com.notech.util.noticias.NoticiaJobsBuilder;

public class RecyclerViewFragment extends Fragment{

    public interface DataPassListener{
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
        initNoticias();
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

    private void initNoticias() {
        //TODO: retornar noticias no news
        //new NoticiaClient(getResources().getString(R.string.news_api_key)).getNoticias("QUERY", null);

        noticias = new ArrayList<>();
        NoticiaBuilder builder = new NoticiaBuilder(new NoticiaJobsBuilder());
        try {
            JSONObject json = new JSONObject(getResources().getString(R.string.json));
        } catch (JSONException e) {
            Log.d(TAG, e.getMessage());
        }

        builder.build();
        //mock
        noticias.add(builder.getNoticia());
        noticias.add(builder.getNoticia());
        noticias.add(builder.getNoticia());
        noticias.add(builder.getNoticia());
    }
}
