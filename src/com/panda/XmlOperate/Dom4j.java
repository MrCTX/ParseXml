package com.panda.XmlOperate;
import java.io.File;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4j {   

	public static void main(String[] args) {
		try {
			//获得sax解析�?
			SAXReader reader = new SAXReader();
			//传入解析对象,获得Document对象
			Document document = reader.read(new File("src/students.xml"));
			//获得文档跟元素对�?
			Element students = document.getRootElement();
			for (int i = 0; i < students.elements().size(); i++) {
				Element student = (Element) students.elements().get(i);
				String id = student.attributeValue("id");
				System.out.println("学生Id�?:"+id);
				String name = student.elementText("name");
				System.out.println("学生姓名�?:"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
