package automation.RestAssureAPI;

public class DataProviderClass {

	public static String getPayload() {
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Varun First Try\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}";
	}
	
	public static String getPutPayload() {
		return "{\r\n" + 
				"\"place_id\":\"%s\",\r\n" + 
				"\"address\":\"70 winter walk, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}";
	}
	
	public static String addBook(String name,String isbn,String aisle,String author) {
		return String.format("{\r\n" + 
				"\r\n" + 
				"\"name\":\"%s\",\r\n" + 
				"\"isbn\":\"%s\",\r\n" + 
				"\"aisle\":\"%s\",\r\n" + 
				"\"author\":\"%s\"\r\n" + 
				"}\r\n" + 
				"", name, isbn, aisle, author);
	}
}
