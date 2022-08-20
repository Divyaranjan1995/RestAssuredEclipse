package resources;


import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

import pojo.Location;
import pojo.addPlace;


public class TestDataBuild {
	
	public Object addPlacePayload()
	{
		addPlace p = new addPlace();
		p.setAccuracy(50);
		p.setName("Divyaranjan Padhiary");
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress("29, side layout, cohen 09");
		p.setWebsite("http://google.com");
		p.setLanguage("French-IN");
		
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

}
