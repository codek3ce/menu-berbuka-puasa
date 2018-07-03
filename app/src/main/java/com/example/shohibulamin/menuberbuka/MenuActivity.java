package com.example.shohibulamin.menuberbuka;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.shohibulamin.menuberbuka.adapter.MenuAdapter;
import com.example.shohibulamin.menuberbuka.api.BaseApiService;
import com.example.shohibulamin.menuberbuka.api.UtilsApi;
import com.example.shohibulamin.menuberbuka.model.ResponseMenuHari;
import com.example.shohibulamin.menuberbuka.model.SemuamenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.rvMenu)
    RecyclerView rvMenu;
    ProgressDialog loading;

    Context mContext;
    List<SemuamenuItem> semuahariMenuList = new ArrayList<>();
    MenuAdapter menuAdapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle(" Menu Berbuka "+getIntent().getStringExtra("nama_hari"));

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        menuAdapter = new MenuAdapter(this, semuahariMenuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvMenu.setLayoutManager(mLayoutManager);
        rvMenu.setItemAnimator(new DefaultItemAnimator());

        getResultListMenu();
    }

    private void getResultListMenu() {
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);

        String id_hari = getIntent().getStringExtra("id_hari");

        mApiService.getSemuamenu(id_hari).enqueue(new Callback<ResponseMenuHari>() {
            @Override
            public void onResponse(Call<ResponseMenuHari> call, Response<ResponseMenuHari> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<SemuamenuItem> semuaMenuItems = response.body().getSemuamenu();

                    rvMenu.setAdapter(new MenuAdapter(mContext, semuaMenuItems));
                    menuAdapter.notifyDataSetChanged();

                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data menu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMenuHari> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
