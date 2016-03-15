import java.io.IOException;

import com.lmk.catalogSpider.CatalogSpider;
import com.lmk.catalogSpider.ExcelWriter;
import com.lmk.catalogSpider.MainSpider;
import com.lmk.catalogSpider.data.NodeWithUrl;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class SpiderMain {

	public static void main(String[] args) throws RowsExceededException, WriteException, IOException {
		String title = "数码";
		MainSpider mainSpider = new MainSpider();
		String url = "http://shuma.jd.com/";
		NodeWithUrl root = new NodeWithUrl(title, url);
		mainSpider.crawling(root, 1 ,null);
		
		//特殊情况-- 数码配件
		url = "http://channel.jd.com/652-829.html";
		NodeWithUrl shuMaPeiJianNode = new NodeWithUrl("数码配件", url);
		root.list.add(shuMaPeiJianNode);
		mainSpider.crawling(shuMaPeiJianNode, 2, "div.item ul li a");
		
		ExcelWriter writer = new ExcelWriter(title);
		writer.writeToExcle(root, 1);
		writer.close();
	}

}
