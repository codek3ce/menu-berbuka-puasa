package com.example.shohibulamin.menuberbuka.model;

public class SemuahariItem{
	private String slug_hari;
	private String tgl_hari;
	private String nama_hari;
	private String id;

	public void setSlugHari(String slugHari){
		this.slug_hari = slug_hari;
	}

	public String getSlugHari(){
		return slug_hari;
	}

	public void setTglHari(String tglHari){
		this.tgl_hari = tgl_hari;
	}

	public String getTglHari(){
		return tgl_hari;
	}

	public void setNamaHari(String namaHari){
		this.nama_hari = nama_hari;
	}

	public String getNamaHari(){
		return nama_hari;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"SemuahariItem{" + 
			"slug_hari = '" + slug_hari + '\'' +
			",tgl_hari = '" + tgl_hari + '\'' +
			",nama_hari = '" + nama_hari + '\'' +
			",id = '" + id + '\'' + 
			"}";
		}
}
