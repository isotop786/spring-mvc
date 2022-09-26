package etc;

import java.util.Map;
import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, String> fruits= new HashMap<>();
		
		fruits.put("red", "apple");
		fruits.put("green", "banana");
		fruits.put("yellow", "banana");
		
		System.out.println(fruits.get("banaa"));
		
		for(Map.Entry str: fruits.entrySet())
		{
			System.out.println(str.getKey()+"\t----"+str.getValue());
		}
		
		fruits.containsKey("red");
		fruits.containsValue("yellow");
		fruits.size();
		fruits.clear();
		
		
	}
}
