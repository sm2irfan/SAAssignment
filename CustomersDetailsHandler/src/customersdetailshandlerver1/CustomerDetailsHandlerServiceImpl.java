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
	String[] values3 = new String[] {"0771234567", "0772547638", "0772586935","0778957241","0771452689"};
	String[] values4 = new String[] {"951425869V", "961478256V", "920415286V","992587456V","982145687V"};
	 
	
	
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
		
			return address;
		
		
	}

	
	
	
	@Override
	public String phoneNo(String customerID) {
		// TODO Auto-generated method stub
	        Map<String, String> mapphoneNo = new HashMap<String, String>();
		loadIntoHash(keys, values3, mapphoneNo);
		String phoneNo = mapphoneNo.get(customerID);
		
			return phoneNo;
		
	}
	
	

	@Override
	public String NIC(String customerID) {
		// TODO Auto-generated method stub
	        Map<String, String> mapNIC = new HashMap<String, String>();
		loadIntoHash(keys, values4, mapNIC);
		String NIC = mapNIC.get(customerID);
		
			return NIC;
		
	}
	
}	