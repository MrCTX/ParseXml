package com.panda.XmlOperate;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

	private boolean flag = false ;
	@Override
	public void startDocument() throws SAXException {//文档�?始事�?
		System.out.println("文档�?始解析了");
	}

	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {//元素�?始事�?
		if (qName.equals("student")) {//如果元素名字是student，就取属�?
			String attString = attributes.getValue("id");
			if (attString.equals("001")) {
				System.out.println(attString);
				flag = true;
			} else {
				flag = false;
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)//文本事件
			throws SAXException {
		if (flag) {
			String string = new String(ch,start,length);
			String str = string.trim();
			if (str.length() > 0) {
				System.out.println(str);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)//文档结束事件
			throws SAXException {
	}

	
	
	@Override
	public void endDocument() throws SAXException {//文档结束事件
		System.out.println("文档解析结束�?");
	}

	
}
