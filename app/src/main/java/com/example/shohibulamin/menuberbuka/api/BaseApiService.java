package com.example.shohibulamin.menuberbuka.api;

import com.example.shohibulamin.menuberbuka.model.ResponseDetailMenu;
import com.example.shohibulamin.menuberbuka.model.ResponseHari;
import com.example.shohibulamin.menuberbuka.model.ResponseMenuHari;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BaseApiService {
    @GET("semuahari")
    Call<ResponseHari> getSemuaHari();

    @GET("menuhari/{id_hari}")
    Call<ResponseMenuHari> getSemuamenu(@Path("id_hari") String id_hari);

    @GET("menu/{id}")
    Call<ResponseDetailMenu> getDetailMenu(@Path("id") String id);
}
