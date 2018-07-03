package com.example.shohibulamin.menuberbuka.model;

import java.util.List;

public class ResponseHari{
	private boolean error;
	private String message;
	private List<SemuahariItem> semuahari;

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

	public void setSemuahari(List<SemuahariItem> semuahari){
		this.semuahari = semuahari;
	}

	public List<SemuahariItem> getSemuahari(){
		return semuahari;
	}

	@Override
 	public String toString(){
		return 
			"ResponseHari{" + 
			"error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			",semuahari = '" + semuahari + '\'' + 
			"}";
		}
}