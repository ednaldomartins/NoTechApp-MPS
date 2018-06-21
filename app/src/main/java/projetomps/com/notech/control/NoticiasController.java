package projetomps.com.notech.control;

import android.app.SearchManager;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import projetomps.com.notech.R;
import projetomps.com.notech.model.Noticia;
import projetomps.com.notech.view.NoticiaDetalhesFragment;
import projetomps.com.notech.view.RecyclerViewFragment;

public class NoticiasController extends AppCompatActivity implements RecyclerViewFragment.DataPassListener{

    public static final String TAG = "NoticiasController";

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private static RecyclerViewFragment recyclerViewFragment;
    private static NoticiaDetalhesFragment noticiaDetalhesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_view);

        if (savedInstanceState == null) {
            recyclerViewFragment = new RecyclerViewFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.listaNoticias, recyclerViewFragment);

            transaction.commit();
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

        //TODO: separar listeners
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //TODO: BUSCA
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    private void setupDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void passData(Noticia noticia) {
        noticiaDetalhesFragment = new NoticiaDetalhesFragment();
        Bundle arg = new Bundle();
        arg.putParcelable("noticia", noticia);
        noticiaDetalhesFragment.setArguments(arg);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.listaNoticias, noticiaDetalhesFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
