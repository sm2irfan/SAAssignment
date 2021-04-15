package electricalservicedetailshandler;

public class ServiceDetailsHandlerImp implements ServiceDetailsHandler{

	@Override
	public String customerType(String customerID) {
		// TODO Auto-generated method stub
		return "customerType domastic";
	}

	@Override
	public String PhaseDetails(String customerID) {
		// TODO Auto-generated method stub
		return "PhaseDetails three Phase";
	}

	@Override
	public String TransformerRating(String customerID) {
		// TODO Auto-generated method stub
		return "TransformerRating 250kVA";
	}

}
