package examples_ebook.Unit_2;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class DOMDemo02 {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//创建一个新文档
		Document doc = builder.newDocument();

		//建立各个元素
		Element addressList = doc.createElement("AddressList");
		Element person = doc.createElement("Person");
		Element name = doc.createElement("Name");
		Element contact = doc.createElement("Contact");
		//设置元素的文本内容，即为每一个元素添加文本节点
		name.setTextContent("索拉尔");
		contact.setTextContent("白标蜡记石");
		//设置节点关系
		person.appendChild(name);
		person.appendChild(contact);
		addressList.appendChild(person);
		doc.appendChild(addressList);

		//输出到文件中
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		//设置编码（单条Property）
		transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
		//建立DOM资源
		DOMSource source = new DOMSource(doc);
		//指定输出的位置
		StreamResult result = new StreamResult(new File("DOMDemo02Doc.xml"));
		//进行输出，不处理错误
		transformer.transform(source,result);
	}
}
