package customersdetailshandlerver1;

public interface CustomerDetailsHandlerService {


	public String name(String customerID);
	public String address(String customerID); 
	public String phoneNo(String customerID);
	public String NIC(String customerID); 
}
