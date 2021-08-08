package resources;

import java.util.ArrayList;

import pojo.Add;
import pojo.DeleteBody;
import pojo.Location;

public class TestDataBuildFile {

	public Add addPlacePayload(String name, String language, String address) {

		Add addPlace;
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);

		addPlace = new Add();
		addPlace.setAccuracy(50);
		addPlace.setLanguage(language);
		addPlace.setLocation(location);
		addPlace.setName(name);
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
		addPlace.setAddress(address);
		addPlace.setWebsite("http://google.com");
		return addPlace;
	}
	
	public DeleteBody addToDeletePlaceBody(String place_id){
		DeleteBody deleteBody = new DeleteBody();
		deleteBody.setPlace_id(place_id);
		return deleteBody;
	}
}
