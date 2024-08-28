import java.util.HashMap;
public class Task05 
{

	public static void main(String[] args) 
	{
		
		// Create a HashMap to store String keys and Integer values
		HashMap<String, Integer> hashingmap=new HashMap<>();
		
		// Add key-value pairs to the HashMap
		hashingmap.put("ALI",30);
		hashingmap.put("HAMZA",40);
		hashingmap.put("AMMAD",50);
		
		//Access and print values based on keys
		System.out.println("Age of AMMAD :"+hashingmap.get("AMMAD"));
		System.out.println("Age of ALI :"+hashingmap.get("ALI"));
		// Remove a key-value pair from the HashMap
		hashingmap.remove("AMMAD");
		
		// FOR PRACTICE
		// Check if a key exists in the HashMap
		System.out.println("Is HAMZA present?"+hashingmap.containsKey("HAMZA"));

		// Update the value associated with a key
		hashingmap.put("ALI",80);
		
		// Print all key-value pairs in the HashMap
		System.out.println("Key-Value pairs in the HashMap:");
		for (String key : hashingmap.keySet())
		{
		System.out.println(key+":"+hashingmap.get(key));
		}
		
		// Check the size of the HashMap
		 System.out.println("Size of the HashMap:"+hashingmap.size());
	}
	

	

}
