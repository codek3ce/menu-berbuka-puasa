package com.example.shohibulamin.menuberbuka.model;

import java.util.List;

public class ResponseMenuHari{
	private List<SemuamenuItem> semuamenu;
	private boolean error;
	private String message;

	public void setSemuamenu(List<SemuamenuItem> semuamenu){
		this.semuamenu = semuamenu;
	}

	public List<SemuamenuItem> getSemuamenu(){
		return semuamenu;
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

	@Override
 	public String toString(){
		return 
			"ResponseMenuHari{" + 
			"semuamenu = '" + semuamenu + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}