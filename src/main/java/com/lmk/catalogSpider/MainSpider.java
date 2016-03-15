package com.lmk.catalogSpider;


import java.io.IOException;
import java.util.List;

import com.lmk.catalogSpider.data.NodeWithUrl;

public class MainSpider {
	String[] CSSSelector = {"div.menu a","div.menu a","ul#brandsArea a"};
	
	public void crawling(NodeWithUrl node,int deepth ,String selector) {
		// TODO Auto-generated method stub
		if (deepth>3){
			return;
		}
		
		if(selector == null){
			selector = CSSSelector[deepth-1];
		}
		
		CatalogSpider spider = new CatalogSpider(node.getUrl(), selector, node.getList());
		try {
			spider.crawling();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<NodeWithUrl> list = node.getList();
		for (int i = 0; i < list.size() ; i++) {
			NodeWithUrl nodeTemp = list.get(i);
			crawling(nodeTemp, deepth+1,null);
		}
	}
	
}
