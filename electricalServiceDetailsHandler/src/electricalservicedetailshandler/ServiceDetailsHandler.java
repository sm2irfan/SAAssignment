package electricalservicedetailshandler;

import java.util.List;



public interface ServiceDetailsHandler {
	
	
	public String PhaseDetails(String customerID);
	public String TransformerRating(String customerID);
	public String customerType(String customerID);
	public int addElectricService(String CustomerId,String CustomerType,String Phase,String TransformerRating);
	public int removeElectricService(String CustomerId);
	public   List<Service> listService();//Returns the Service list

}
