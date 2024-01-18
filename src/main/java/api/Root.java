package api;

import com.google.gson.annotations.SerializedName;

public class Root{

	@SerializedName("data")
	private Data data;

	@SerializedName("support")
	private Support support;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setSupport(Support support){
		this.support = support;
	}

	public Support getSupport(){
		return support;
	}
}