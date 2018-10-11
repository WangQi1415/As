/**
 * 
 */
package com.AS3.util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class InfoSave {
	//数据保存在本地的地址

	 public static boolean BuildXMLDoc(String param1,String param2,String param3,String param4
			 ,String param5,String param6,String param7,String param8,String param9) throws IOException, JDOMException {   
	        // 创建根节点 并设置它的属性 ;   
	        Element root = new Element("AS3").setAttribute("count", "1");   
	        // 将根节点添加到文档中；   
	        Document Doc = new Document(root);   	       	       
	       // 创建节点 book;   
	       Element elements1 = new Element("预热温度");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements1.addContent(new Element("值").setText(param1));  
	       root.addContent(elements1);  
	       
	    // 创建节点 book;   
	       Element elements2 = new Element("温度控制范围");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements2.addContent(new Element("值").setText(param2));  
	       root.addContent(elements2);  
	       
	    // 创建节点 book;   
	       Element elements3 = new Element("波峰1浸锡时间");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements3.addContent(new Element("值").setText(param3));  
	       root.addContent(elements3);  
	       
	    // 创建节点 book;   
	       Element elements4 = new Element("波峰2浸锡时间");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements4.addContent(new Element("值").setText(param4));  
	       root.addContent(elements4);  
	       
	    // 创建节点 book;   
	       Element elements5 = new Element("传送速度");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements5.addContent(new Element("值").setText(param5));  
	       root.addContent(elements5);  
	       
	    // 创建节点 book;   
	       Element elements6 = new Element("夹送倾角");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements6.addContent(new Element("值").setText(param6));  
	       root.addContent(elements6);  
	       
	    // 创建节点 book;   
	       Element elements7 = new Element("助焊剂喷雾压力");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements7.addContent(new Element("值").setText(param7));  
	       root.addContent(elements7);  
	       
	    // 创建节点 book;   
	       Element elements8 = new Element("针阀压力");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements8.addContent(new Element("值").setText(param8));  
	       root.addContent(elements8);  
	    // 创建节点 book;   
	       Element elements9 = new Element("位置");     
	       // 给 book 节点添加子节点并赋值；   	     
	       elements9.addContent(new Element("值").setText(param9));  
	       root.addContent(elements9);  
	       // 输出 books.xml 文件；  
	        // 使xml文件 缩进效果
	        Format format = Format.getPrettyFormat();
	        XMLOutputter XMLOut = new XMLOutputter(format);
	        XMLOut.output(Doc, new FileOutputStream("../As3.xml"));
	        System.out.println("保存XML");
	        return true;
	    } 
    
	public static boolean saveFileInfo(String inputStream,String fileExtName) throws IOException {

		// 写入新文件
		FileOutputStream out;
		BufferedOutputStream bos = null; 
		try {
			byte[] bytes = Base64.decode(inputStream);
			// 存储路径
			String path = "../";
			out = new FileOutputStream(new File(path+"MyfileParams3."+fileExtName));
			bos=new BufferedOutputStream(out);
			bos.write(bytes);
			bos.close();
			out.flush();
			out.close();
			return true;
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
			return false;
		}
	}
    
    
    
}
