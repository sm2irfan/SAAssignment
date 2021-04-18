package electricalservicedetailshandler;

public class Service {
	private String CustomerId;
	private String CustomerType;
	private String Phase;
	private String TransformerRating;
	
	public Service(String CustomerId,String CustomerType,String Phase,String TransformerRating) {
		super();
		this.CustomerId = CustomerId;
		this.CustomerType = CustomerType;
		this.Phase = Phase;
		this.TransformerRating = TransformerRating;
		
	}
	

	public String getCustomerType() {
		return CustomerType;
	}


	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}


	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getPhase() {
		return Phase;
	}

	public void setPhase(String phase) {
		Phase = phase;
	}

	public String getTransformerRating() {
		return TransformerRating;
	}

	public void setTransformerRating(String transformerRating) {
		TransformerRating = transformerRating;
	}
	
}
