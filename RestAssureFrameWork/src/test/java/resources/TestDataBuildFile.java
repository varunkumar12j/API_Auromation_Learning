package resources;

import java.util.ArrayList;

import pojo.Add;
import pojo.Location;

public class TestDataBuildFile {

	public Add addPlacePayload() {
		
		Add addPlace;
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		addPlace = new Add();
		addPlace.setAccuracy(50);
		addPlace.setLanguage("French-IN");
		addPlace.setLocation(location);
		addPlace.setName("Frontline house");
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setTypes(new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 5407144226487773360L;

			{
				add("shoe park");
				add("shop");
			}
		});
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setWebsite("http://google.com");
		return addPlace;
	}
}
