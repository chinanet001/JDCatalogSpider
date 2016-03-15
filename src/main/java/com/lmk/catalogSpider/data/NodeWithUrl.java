package com.lmk.catalogSpider.data;

import java.util.ArrayList;
import java.util.List;

public class NodeWithUrl{
	
	private String catalogueName;
	private String url;
	
	public String getUrl(){
		return this.url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}

	public String getCatalogueName() {
		return catalogueName;
	}

	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	public List<NodeWithUrl> getList() {
		return list;
	}

	public void setList(List<NodeWithUrl> list) {
		this.list = list;
	}

	public List<NodeWithUrl> list = new ArrayList<NodeWithUrl>();
	
	public NodeWithUrl(String name,String url) {
		this.catalogueName = name;
		this.url = url;
	}

}
