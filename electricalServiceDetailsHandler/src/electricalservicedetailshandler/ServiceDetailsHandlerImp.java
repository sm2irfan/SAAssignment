package electricalservicedetailshandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ServiceDetailsHandlerImp implements ServiceDetailsHandler{
	
	
	public void HashType(String[] keys, String[] values, Map<String, String> map) {
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
	}
	
	static String[] id = new String[] {"id1011","id1012","id1013","id1014","id1015"};
	static String[] type = new String[] {"industrial","domastic", "domastic","industrial","industrial"};
	static String[] phasevalues = new String[] {"singlephase","three phase", "three phase","singlephase","singlephase"};


	@Override
	public String customerType(String customerID) {
		// TODO Auto-generated method stub
		final Map<String,String> mapCusType = new HashMap<String,String>();
		HashType(id,type,mapCusType);
		String customerType =mapCusType.get(customerID);
		if(customerType == null) {
			return "customerID you entered is wrong. Please enter correct id";
			
		}
		else
		{
			return customerType;
		}
		
		
	}

	@Override
	public String PhaseDetails(String customerID) {
		final Map<String,String> mapPhase = new HashMap<String,String>();
		HashType(id,phasevalues,mapPhase);
		String custype = mapPhase.get(customerID);
		if(custype =="Industrial") {
			return "should be domestic";
		}
		else if(custype == null) {
			return "customerID you entered is wrong. Please enter correct id";
		}
		else
		{
			return custype;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public String TransformerRating(String customerID) {
		// TODO Auto-generated method stub
		return "TransformerRating 250kVA";
	}

	@Override
	public synchronized int addElectricService(String CustomerId, String CustomerType, String Phase, String TransformerRating) {
		// TODO Auto-generated method stub
		Service service = new Service(CustomerId,CustomerType,Phase,TransformerRating);
		ServiceList.Servicelist.add(service);
		return 1;
	}

	@Override
	public List<Service> listService() {
		// TODO Auto-generated method stub
		return ServiceList.Servicelist;
	}
	
	@Override
	public  synchronized int removeElectricService(String CustomerId) {

		boolean invalid = true;
		int count = -1;
		for (Service tempService :ServiceList.Servicelist) {
			count++;
			if (tempService.getCustomerId().equalsIgnoreCase(CustomerId)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			ServiceList.Servicelist.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

}
