package com.lmk.catalogSpider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.lmk.catalogSpider.data.NodeWithUrl;

public class CatalogSpider {
	String url;
	String CSSSelector;
	Elements resultLinks;
	List<NodeWithUrl> list = new ArrayList<NodeWithUrl>();
	public CatalogSpider() {
		// TODO Auto-generated constructor stub
	}
	public CatalogSpider(String url, String cSSSelector, List<NodeWithUrl> list) {
		super();
		this.url = url;
		CSSSelector = cSSSelector;
		this.list = list;
	}
	
	public void crawling() throws IOException{
		Document doc = Jsoup.connect(url).get();
		resultLinks = doc.select(CSSSelector);
		extractFromResult();
	}
	private void extractFromResult() {
		// TODO Auto-generated method stub
		for (int i = 0; i < resultLinks.size(); i++) {
			Element el = resultLinks.get(i);
			String name = el.text();
			String url = el.attr("href");
			
			list.add( new NodeWithUrl(name, url));
		}
	}
}
