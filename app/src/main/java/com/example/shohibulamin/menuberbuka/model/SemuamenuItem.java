package com.example.shohibulamin.menuberbuka.model;

public class SemuamenuItem{
	private String nama_menu;
	private String descripsi_menu;
	private String id_hari;
	private String id;
	private String gambar_menu;

	public void setNamaMenu(String namaMenu){
		this.nama_menu = nama_menu;
	}

	public String getNamaMenu(){
		return nama_menu;
	}

	public void setDescripsiMenu(String descripsiMenu){
		this.descripsi_menu = descripsi_menu;
	}

	public String getDescripsiMenu(){
		return descripsi_menu;
	}

	public void setIdHari(String idHari){
		this.id_hari = id_hari;
	}

	public String getIdHari(){
		return id_hari;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setGambarMenu(String gambarMenu){
		this.gambar_menu = gambar_menu;
	}

	public String getGambarMenu(){
		return gambar_menu;
	}

	@Override
 	public String toString(){
		return 
			"SemuamenuItem{" + 
			"nama_menu = '" + nama_menu + '\'' +
			",descripsi_menu = '" + descripsi_menu + '\'' +
			",id_hari = '" + id_hari + '\'' +
			",id = '" + id + '\'' + 
			",gambar_menu = '" + gambar_menu + '\'' +
			"}";
		}
}
