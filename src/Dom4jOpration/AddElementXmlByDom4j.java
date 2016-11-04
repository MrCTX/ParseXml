package Dom4jOpration;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//增加�?个id�?3的学�?
public class AddElementXmlByDom4j {

	public static void main(String[] args) {
		try {
			//1、解析xml
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("src/students.xml"));
			//2、获得根元素
			Element students = document.getRootElement();
			//3、增加student元素对象
			Element studentElement = students.addElement("student")
					.addAttribute("id", "003");
			studentElement.addElement("name").addText("张三");
			studentElement.addElement("age").addText("24");
			studentElement.addElement("sex").addText("�?");
			//重新写入xml文档�?
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(new FileOutputStream
					(new File("src/copy.xml")),format);
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//2�?
	}

}
