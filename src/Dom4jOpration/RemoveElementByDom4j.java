package Dom4jOpration;

import java.io.File;
import java.io.FileOutputStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class RemoveElementByDom4j {

	//移除id�?001的学�?
	public static void main(String[] args) {
		try {
			//1、读取xml并获得Document对象
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("src/copy.xml"));
			//2、获得根元素
			Element students = document.getRootElement();
			//3、根据xpath路径名获得要删除的student对象
			String xpath = "//student[@id='001']";
			Element student = (Element) students.selectSingleNode(xpath);
			//4、删除获得student对象
			students.remove(student);
			//5、重新写入xml文档�?
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(new FileOutputStream
					(new File("src/copy2.xml")),format);
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
