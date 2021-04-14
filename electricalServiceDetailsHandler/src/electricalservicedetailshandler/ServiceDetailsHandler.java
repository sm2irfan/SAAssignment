package electricalservicedetailshandler;

public interface ServiceDetailsHandler {
	
	public String customerType(int customerID);
	public String PhaseDetails(int customerID);
	public String TransformerRating(int customerID);
}
