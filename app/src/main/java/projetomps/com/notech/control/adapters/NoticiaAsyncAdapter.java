package projetomps.com.notech.control.adapters;

import android.support.v7.util.AsyncListUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import projetomps.com.notech.model.Noticia;

public class NoticiaAsyncAdapter extends AsyncListUtil<Noticia> {

    private static final int pedacoTamanho = 5;
    private static final long delay = 500;//ms

    public NoticiaAsyncAdapter(final List<Noticia> noticias, final RecyclerView recyclerView) {
        super(Noticia.class, pedacoTamanho,
                new AsyncListUtil.DataCallback<Noticia>(){

                    @Override
                    public int refreshData() {
                        return noticias.size();
                    }

                    @Override
                    public void fillData(Noticia[] data, int startPosition, int itemCount) {
                        dorme();//delay
                        for(int i = 0; i < itemCount; i++) {
                            data[i] = noticias.get(startPosition + i);
                        }
                    }

                    public void dorme() {
                        try{
                            Thread.sleep(delay);
                        } catch (InterruptedException e) {
                            //TODO: tratar interrupção
                            e.printStackTrace();
                        }
                    }
                }, new AsyncListUtil.ViewCallback(){

                    @Override
                    public void getItemRangeInto(int[] outRange) {
                        //nao acho que seja uma boa pratica dar esse casting mas to com preguiça
                        outRange[0] = ((LinearLayoutManager)recyclerView.getLayoutManager())
                                .findFirstVisibleItemPosition();
                        outRange[1] = ((LinearLayoutManager)recyclerView.getLayoutManager())
                                .findLastVisibleItemPosition();
                    }

                    @Override
                    public void onDataRefresh() {
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onItemLoaded(int position) {
                        recyclerView.getAdapter().notifyItemChanged(position);
                    }
                });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                onRangeChanged();
            }
        });
    }
}
