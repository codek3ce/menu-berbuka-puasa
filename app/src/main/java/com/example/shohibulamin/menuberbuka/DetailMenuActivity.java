package com.example.shohibulamin.menuberbuka;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shohibulamin.menuberbuka.adapter.MenuAdapter;
import com.example.shohibulamin.menuberbuka.api.BaseApiService;
import com.example.shohibulamin.menuberbuka.api.UtilsApi;
import com.example.shohibulamin.menuberbuka.model.ResponseDetailMenu;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMenuActivity extends AppCompatActivity {

    private Menu menu;

    TextView FullNamaMenu;
    TextView FullDeskripsiMenu;
    ImageView ivFullGambarMenu;

    Context mContext;
    ProgressDialog loading;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle(getIntent().getStringExtra("nama_menu"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    showOption(R.id.action_info);
                } else if (isShow) {
                    isShow = false;
                    hideOption(R.id.action_info);
                }
            }
        });

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        getResultDetailMenu();

    }

    private void getResultDetailMenu(){
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);

        String id_menu = getIntent().getStringExtra("id");
        mApiService.getDetailMenu(id_menu).enqueue(new Callback<ResponseDetailMenu>(){

            @Override
            public void onResponse(Call<ResponseDetailMenu> call, Response<ResponseDetailMenu> response) {
                loading.dismiss();
                ResponseDetailMenu detailMenu = response.body();

                FullDeskripsiMenu = (TextView)findViewById(R.id.tvFullDeskripsiMenu);
                ivFullGambarMenu = (ImageView)findViewById(R.id.ivFullGambarMenu);

                FullDeskripsiMenu.setText(detailMenu.getDescripsiMenu());
                Picasso.get().load(detailMenu.getGambarMenu().toString()).into(ivFullGambarMenu);
                //Log.d("AAA", "Method OnDestroy Bekerja "+detailMenu.getDescripsiMenu());
            }

            @Override
            public void onFailure(Call<ResponseDetailMenu> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_detail_menu, menu);
        hideOption(R.id.action_info);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }

    private void hideOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(false);
    }

    private void showOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(true);
    }
}
