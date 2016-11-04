package Dom4jOpration;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXmlByDom4j {

	public static void main(String[] args) {
		
		try {
			//1、读取xml
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("src/students.xml"));
			//2、获得Document对象的根元素
			Element rootElement = document.getRootElement();
			//3、获得根元素下的�?有student元素对象
			for (@SuppressWarnings("unchecked")
			Iterator<Element> iterator = 
					rootElement.elementIterator("student");iterator.hasNext();) {
				Element student = iterator.next();
				//根据获得的student对象取属性�?�或者子对象内容
				String attribute = student.attributeValue("id");
				String name = student.elementText("name");
				String age = student.elementText("age");
				String sex = student.elementText("sex");
				System.out.println("学生学号�?"+attribute+",姓名�?:"+name+
						",年龄�?"+age+",性别�?"+sex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
