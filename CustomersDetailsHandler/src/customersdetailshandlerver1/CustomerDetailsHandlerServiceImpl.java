package customersdetailshandlerver1;

import java.util.HashMap;
import java.util.Map;

public class CustomerDetailsHandlerServiceImpl implements CustomerDetailsHandlerService{
	
	

	public void loadIntoHash(String[] keys, String[] values, Map<String, String> map) {
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
	}
	
	
	
	
	
	
	String[] keys = new String[] {"id1011", "id1012", "id1013"};
	String[] values = new String[] {"aaa", "bbbb", "cccc"};
	
	
	
	@Override
	public String name(String customerID) {
		// TODO Auto-generated method stub
		Map<String, String> mapName = new HashMap<String, String>();
		loadIntoHash(keys, values, mapName);
		String name = mapName.get(customerID);
		
			return name;
		
	}
	
	
	
	
	
	

	@Override
	public String address(String customerID) {
		// TODO Auto-generated method stub
		return "kalmunai";
	}

}
