package com.lmk.catalogSpider;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.lmk.catalogSpider.data.NodeWithUrl;

public class CatalogSpiderTest {

	@Test
	public void testCrawling() throws IOException {
		String url = "http://channel.jd.com/652-829.html";
//		String CSSSelector = "div.menu a"; //二级目录
//		String CSSSelector = "div.menu a"; //三级目录
//		String CSSSelector = "ul#brandsArea a";//品牌目录
		String CSSSelector = "div.item ul li a";//特殊情况 数码配件
		NodeWithUrl root = new NodeWithUrl("智能手环", url);
		CatalogSpider spider = new CatalogSpider(url, CSSSelector, root.list);
		spider.crawling();
		System.out.println(root.list.toString());
	}

}
