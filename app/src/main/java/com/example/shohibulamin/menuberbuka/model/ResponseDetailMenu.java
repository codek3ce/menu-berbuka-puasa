package com.example.shohibulamin.menuberbuka.model;

public class ResponseDetailMenu{
	private String nama_menu;
	private String descripsi_menu;
	private String id_hari;
	private String id;

	private boolean error;
	private String message;
	private String gambar_menu;

	public void setNamaMenu(String nama_menu){
		this.nama_menu = nama_menu;
	}

	public String getNamaMenu(){
		return nama_menu;
	}

	public void setDescripsiMenu(String descripsi_menu){
		this.descripsi_menu = descripsi_menu;
	}

	public String getDescripsiMenu(){
		return descripsi_menu;
	}

	public void setIdHari(String id_hari){
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

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
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
		"ResponseDetailMenu{" +
		"nama_menu = '" + nama_menu + '\'' +
		",descripsi_menu = '" + descripsi_menu + '\'' +
		",id_hari = '" + id_hari + '\'' +
		",id = '" + id + '\'' +
		",error = '" + error + '\'' +
		",message = '" + message + '\'' +
		",gambar_menu = '" + gambar_menu + '\'' +
		"}";
	}
}
