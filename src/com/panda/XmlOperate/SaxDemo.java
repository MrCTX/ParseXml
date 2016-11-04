package com.panda.XmlOperate;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SaxDemo {

	public static void main(String[] args) {
		
		try {
			//1、获得解析工�?
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//2、获得解析器
			SAXParser  saxParser = factory.newSAXParser();
			//3、解析文�?
			saxParser.parse(new File("src/students.xml"), new MyHandler());
		} catch (Exception e) {
			e.printStackTrace();
		
	}
	}

}
