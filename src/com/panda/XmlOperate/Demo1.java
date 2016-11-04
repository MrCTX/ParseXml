package com.panda.XmlOperate;

import java.io.File;
import java.util.jar.Attributes.Name;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("unused")
public class Demo1 {
	public static void main(String[] args) {
		//1、获得jaxp工厂
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//2、�?�过工厂获得解析器实现类
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			//3、使用解析器加载xml文档
			Document document = documentBuilder.parse(new File("src/students.xml"));
			//4、进行具体解�?
			NodeList nodeList = document.getElementsByTagName("student");
			for(int i = 0 ; i < nodeList.getLength() ; i++) {//取得student元素对象集合
				Element node = (Element) nodeList.item(i);//根据i值取得student对象
				String numberString = node.getAttribute("id");
				System.out.println("当前学生ID是："+ numberString);
				NodeList nodeList2 = node.getChildNodes();//获得student对象下的子对�?(注意包含空白的文本对�?)
				for (int j = 0; j < nodeList2.getLength(); j++) {
					Node elements =  nodeList2.item(j);//获得子对�?
					if (elements.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) elements;
						if (element.getNodeName().equals("name")) {
							String name = element.getTextContent();
							System.out.println("学生姓名�?:" + name );
						}else if (element.getNodeName().equals("age")) {
							String age = element.getTextContent();
							System.out.println("学生年龄�?:" + age );
						}else if (element.getNodeName().equals("sex")) {
							String sex = element.getTextContent();
							System.out.println("学生性别�?:" + sex );
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
