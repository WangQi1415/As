package com.AS3.dynamicParamImpl;

import java.io.IOException;

import javax.jws.WebService;

import org.jdom.JDOMException;

import com.AS3.dynamicParam.DynamicParam;
import com.AS3.dynamicParamModel.MyDynamicParams;
import com.AS3.util.InfoSave;


@WebService
public class DynamicParamImpl implements DynamicParam{

		//预热温度
		public String param1;
		//温度控制范围
		public String param2;
		//波峰1浸锡时间
		public String param3;
		//波峰2浸锡时间
		public String param4;
		//夹角速度
		public String param5;
		//夹角倾度
		public String param6;
		//助锡剂喷雾压力
		public String param7;
		//针阀压力
		public String param8;
	
		public String param9;
	
	public boolean dynamicParamModel(MyDynamicParams params) {
		boolean saveParameters=false;
		try {
			saveParameters=InfoSave.BuildXMLDoc(params.getParam1(), params.getParam2(), params.getParam3(), 
					params.getParam4(), params.getParam5(), params.getParam6(),
					params.getParam7(), params.getParam8(),params.getParam9());
		
		} catch (IOException e) {		
			e.printStackTrace();
		} catch (JDOMException e) {			
			e.printStackTrace();
		}
		return saveParameters;
		
	
	}

	
	
	public boolean dynamicParamFileModel(String inputStream, String fileExtName) {
		boolean result = false;
		try {
			result = InfoSave.saveFileInfo(inputStream,fileExtName);
			System.out.println("保存文件的状态"+result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;	
	}


	
	public String dynamicParamHandle() {
		//上传参数处理
		return "WebService处理了参数";
	}


	
	public String dynamicParamdistribute() {
		
		return "下发操作";
	}

}
