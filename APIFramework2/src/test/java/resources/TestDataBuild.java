package resources;


import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

import pojo.Location;
import pojo.addPlace;


public class TestDataBuild {
	
	public Object addPlacePayload(String name,String language,String address)
	{
		addPlace p = new addPlace();
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress(address);
		p.setWebsite("http://google.com");
		p.setLanguage(language);
		
		Location l = new Location();
		
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);
		
		List<String> myList = new ArrayList<String>();
		
		myList.add("shoe park");
		myList.add("shop");
		
		p.setTypes(myList);
		
		return p;
		
	}

	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

}
