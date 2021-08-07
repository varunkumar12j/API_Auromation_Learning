Feature: Validate Place API

Scenario: verify if place is being succesfully added using AddPlaceAPI
	Given Add Place Payload
	When User Calls "AddPlaceAPI" with Post http reuest
	Then The API call is success with status code 200
	And "status" in reponse body is "OK"