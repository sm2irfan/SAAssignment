package electricalservicedetailshandler;

public class ServiceDetailsHandlerImp implements ServiceDetailsHandler{

	@Override
	public String customerType(int customerID) {
		// TODO Auto-generated method stub
		return "customerType domastic";
	}

	@Override
	public String PhaseDetails(int customerID) {
		// TODO Auto-generated method stub
		return "PhaseDetails three Phase";
	}

	@Override
	public String TransformerRating(int customerID) {
		// TODO Auto-generated method stub
		return "TransformerRating 250kVA";
	}

}
