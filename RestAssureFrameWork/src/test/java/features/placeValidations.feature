Feature: Validate Place API

@addPlace
Scenario Outline: verify if place is being succesfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<place>"
	When User Calls "addPlaceApi" with "Post" http reuest
	Then The API call is success with status code 200
	And "status" in reponse body is "OK"
	But verify place_Id created maps to "<name>" using "getPlaceApi"
	Then "deletePlaceApi" added address
	
Examples:
	|name|language|place|
	|RandomName|English|29, side layout, cohen 09|