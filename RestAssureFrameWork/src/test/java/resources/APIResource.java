package resources;

public enum APIResource {
	addPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");
	private String apiCall;
	
	
	APIResource(String api) {
		this.apiCall = api;
	}
	
	public String getApi() {
		return apiCall;
	}
}
