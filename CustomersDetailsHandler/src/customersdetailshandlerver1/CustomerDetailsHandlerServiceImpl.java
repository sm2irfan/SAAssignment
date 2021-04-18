package customersdetailshandlerver1;

import java.util.HashMap;
import java.util.Map;

public class CustomerDetailsHandlerServiceImpl implements CustomerDetailsHandlerService{
	
	

	public void loadIntoHash(String[] keys, String[] values, Map<String, String> map) {
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
	}
	
	
	
	
	
	
	String[] keys = new String[] {"id1011", "id1012", "id1013","id1014","id1015"};
	String[] values1 = new String[] {"Kamal", "Ravi", "Nimal","Kumar","Raj"};
	String[] values2 = new String[] {"Jaffna", "Mannaar", "Colombo","Kandy","Colombo"};
	
	
	@Override
	public String name(String customerID) {
		// TODO Auto-generated method stub
		Map<String, String> mapName = new HashMap<String, String>();
		loadIntoHash(keys, values1, mapName);
		String name = mapName.get(customerID);
		
			return name;
		
	}
	
	
	
	
	
	

	@Override
	public String address(String customerID) {
		// TODO Auto-generated method stub
		Map<String, String> mapaddress = new HashMap<String, String>();
		loadIntoHash(keys,values2,mapaddress);
		String address = mapaddress.get(customerID);
		if(address==null) {
			return "please enter correct customer ID";
		}else {
			return address;
		}
		
	}
}
