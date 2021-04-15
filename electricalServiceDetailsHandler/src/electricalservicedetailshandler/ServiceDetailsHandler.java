package electricalservicedetailshandler;

public interface ServiceDetailsHandler {
	
	
	public String PhaseDetails(String customerID);
	public String TransformerRating(String customerID);
	public String customerType(String customerID);
}
