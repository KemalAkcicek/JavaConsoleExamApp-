package online.exam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class deneme {

	public static void main(String[] args) {

		LinkedHashMap<String, String> test=new LinkedHashMap<String, String>();
		
		test.put("soru1", "cevap1");
		test.put("soru2", "cevap2");
		test.put("soru3", "cevap3");
		test.put("soru4", "cevap4");
		
		for(Map.Entry<String,String> temp:test.entrySet()) {
			System.out.println("Key: "+temp.getKey()+" Anahtar:"+temp.getValue());
		}
		
		List<Map.Entry<String, String>> list=new ArrayList<Map.Entry<String,String>>();
		
		
		
	}

}
