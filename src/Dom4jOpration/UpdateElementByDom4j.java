package Dom4jOpration;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class UpdateElementByDom4j {

	//修改id�?002信息
	public static void main(String[] args) {
		try {
			//1、解析xml
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("src/copy2.xml"));
			//2、获得根元素
			Element students = document.getRootElement();
			//3、根据xpath路径得到id�?002的student对象
			String xpath = "//student[@id='002']";
			Element student = (Element) students.selectSingleNode(xpath);
			//4、获得studnet对象下的子对象并修改文本内容
			student.element("name").setText("王八");
			student.element("age").setText("31");
			student.element("sex").setText("�?");
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(new FileOutputStream
					(new File("src/update.xml")),format);
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
