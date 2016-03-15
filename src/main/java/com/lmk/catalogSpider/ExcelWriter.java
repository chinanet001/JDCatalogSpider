package com.lmk.catalogSpider;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.lmk.catalogSpider.data.NodeWithUrl;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelWriter implements Closeable{
	WritableWorkbook wwb ;
	WritableSheet ws;
	int bottom = 1;
	public ExcelWriter() {
		// TODO Auto-generated constructor stub
		try {
			this.wwb = Workbook.createWorkbook(new File("数码.xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ws = wwb.createSheet("Test Sheet 1",0);
	}
	
	
	
	public ExcelWriter(String title) {
		// TODO Auto-generated constructor stub
		try {
			this.wwb = Workbook.createWorkbook(new File(title+".xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ws = wwb.createSheet("Test Sheet 1",0);
	}



	public void writeToExcle(NodeWithUrl node,int deepth){
//		if (deepth>3){
//			return;
//		}
		Label cell = new Label(deepth, bottom, node.getCatalogueName());
		try {
			ws.addCell(cell);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<NodeWithUrl> list = node.getList();
		for (int i = 0; i < list.size() ; i++) {
			writeToExcle(list.get(i), deepth+1);
			if(deepth == 3){
				bottom++;
			}
		}
	}



	public void close() throws IOException {
		wwb.write();
		try {
			wwb.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static void write(List<NodeWithUrl> result) throws IOException, RowsExceededException, WriteException{
//
//		WritableWorkbook wwb = Workbook.createWorkbook(new File("数码.xls"));
//		
//		WritableSheet ws = wwb.createSheet("Test Sheet 1",0);
//		
//		int i = 0,j = 0;
//		
//		for(Iterator<NodeWithUrl> iter1 = result.iterator();iter1.hasNext();){
//			String word = "";
//			i = 0;
//			NodeWithUrl x = iter1.next();
//			word = x.getCatalogueName();
//			jxl.write.Label s11=new jxl.write.Label(i, j, word);
//			ws.addCell(s11);
//			for(Iterator<NodeWithUrl> iter2 = x.list.iterator();iter2.hasNext();){
//				i = 1;
//				NodeWithUrl y = iter2.next();
//				word = y.getCatalogueName();
//				jxl.write.Label s21=new jxl.write.Label(i, j, word);
//				ws.addCell(s21);
//				for(Iterator<NodeWithUrl> iter3 = y.list.iterator();iter3.hasNext();){
//					i = 2;
//					NodeWithUrl z = iter3.next();
//					System.out.println(z.list.size());
//					word = z.getCatalogueName();
//					jxl.write.Label s31=new jxl.write.Label(i, j, word);
//					ws.addCell(s31);
//					j++;
//				}
//			}
//		}
//		wwb.write();
//		wwb.close();
//	}
	
}
