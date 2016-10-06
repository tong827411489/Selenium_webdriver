package cn.sele;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class testData {
	
	private String filePath;
	private String nextLine[];
	List<String[]> approvaList = new ArrayList<String[]>();
	
	CSVReader reader;
	private String value;
	
	public testData(String filePath){
		this.filePath = filePath;
	}
	
	//行、列
	public String getTestData(String coulumName,String lineName){
		try {
			reader = new CSVReader(new FileReader(filePath));
//			BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
			try {
				while ((nextLine = reader.readNext()) != null) {
					approvaList.add(nextLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			int count = 0;
			int index = 0;
		
			for(String j: approvaList.get(0)){
				count++;
				if (j.equals(coulumName)) {
					index = count - 1;
				}
			}
			
			for (String[] i : approvaList) {
				if (i[0].equals(lineName)) {
					value = i[index].toString();
				}
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args){
		testData t = new testData(System.getProperty("user.dir")+"\\src\\main\\java\\teta\\useinfo.csv");
		System.out.println(t.getTestData("password", "1"));
	}
}
