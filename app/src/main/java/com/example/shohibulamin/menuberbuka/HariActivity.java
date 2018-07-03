package com.example.shohibulamin.menuberbuka;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.shohibulamin.menuberbuka.adapter.HariAdapter;
import com.example.shohibulamin.menuberbuka.api.BaseApiService;
import com.example.shohibulamin.menuberbuka.api.UtilsApi;
import com.example.shohibulamin.menuberbuka.model.ResponseHari;
import com.example.shohibulamin.menuberbuka.model.SemuahariItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HariActivity extends AppCompatActivity {

    @BindView(R.id.rvHari)
    RecyclerView rvHari;
    ProgressDialog loading;

    Context mContext;
    List<SemuahariItem> semuahariItemList = new ArrayList<>();
    HariAdapter hariAdapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hari);

        getSupportActionBar().setTitle("Menu Buka Puasa");

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        hariAdapter = new HariAdapter(this, semuahariItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvHari.setLayoutManager(mLayoutManager);
        rvHari.setItemAnimator(new DefaultItemAnimator());

        getResultListHari();
    }

    private void getResultListHari(){
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);

        mApiService.getSemuaHari().enqueue(new Callback<ResponseHari>() {
            @Override
            public void onResponse(Call<ResponseHari> call, Response<ResponseHari> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<SemuahariItem> semuaHariItems = response.body().getSemuahari();

                    rvHari.setAdapter(new HariAdapter(mContext, semuaHariItems));
                    hariAdapter.notifyDataSetChanged();

                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data hari", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseHari> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
