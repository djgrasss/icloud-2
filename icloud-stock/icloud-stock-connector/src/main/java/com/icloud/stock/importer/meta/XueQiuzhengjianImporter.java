package com.icloud.stock.importer.meta;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.icloud.framework.file.TextFile;
import com.icloud.framework.util.LogFileWriter;
import com.icloud.stock.connector.handler.impl.XueqiuMetaInfoHandler;
import com.icloud.stock.connector.model.XueqiuMetaInfo;
import com.icloud.stock.connector.model.XueqiuMetaInfo.Stock;

public class XueQiuzhengjianImporter {
	private LogFileWriter writer;

	public XueQiuzhengjianImporter(String filePath) {
		writer = new LogFileWriter(filePath);
	}

	public void importHangye() {
		String filePath = "bin/data/证监会行业.txt";
		List<String> list = getAllHangye(filePath);
		for (String hangye : list) {
			System.out.println(hangye);
			String[] params = hangye.split(" ");
			XueqiuMetaInfo fetchData = fetchData(params[0].trim(),
					params[1].trim());
			save(fetchData, hangye);
		}
		close();
	}

	private void save(XueqiuMetaInfo fetchData, String hangye) {
		// TODO Auto-generated method stub
		int count = fetchData.getCount();
		char ch = ' ';
		for (Stock stock : fetchData.getData()) {
			writer.apendln(hangye + ch + stock.getCode() + ch + stock.getName()
					+ ch + stock.getSymbol() + ch + count);
		}
	}

	private void close() {
		this.writer.close();
	}

	private XueqiuMetaInfo fetchData(String typeName, String code) {
		XueqiuMetaInfoHandler handler;
		try {
			handler = new XueqiuMetaInfoHandler(typeName, code);
			XueqiuMetaInfo metaInfo = handler.getHttpData();
			return metaInfo;
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getAllHangye(String filePath) {
		List<String> list = new ArrayList<String>();
		TextFile textFile = new TextFile(filePath);
		for (String text : textFile) {
			list.add(text.trim());
		}
		return list;
	}

	//
	public static void main(String[] args) throws UnsupportedEncodingException {
		XueQiuzhengjianImporter importer = new XueQiuzhengjianImporter(
				"/home/jiangningcui/workspace/mygithub/icloud/icloud-data/xueqiu/zhengjianhuihangye.txt");
		importer.importHangye();
		// XueqiuMetaInfo fetchData = importer.fetchData("A股指数");
		// importer.save(fetchData, "A股指数");
		// importer.close();
		// String a = "A股指数";
		// String string = new String(a.getBytes(), "gb2312");
		// System.out.println(string);
	}
}
