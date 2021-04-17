package customerpaymenthandlerver1;


import java.util.Collection;
import java.util.HashMap;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Map;

public class AMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentHandlerService paymentHandlerService = new PaymentHandlerServiceImpl();
		
		System.out.println(paymentHandlerService.priceClaculation(1000, "industrial"));
		
		
		Map<String, ArrayList<String>> multivalueMap = new HashMap<String, ArrayList<String>>();
		
		multivalueMap.put("ford", new ArrayList<String>());
		multivalueMap.get("ford"). add("git");
		multivalueMap.get("ford"). add("Mustang Match-E");
		multivalueMap.get("ford"). add("Pantera");

		System.out.println(multivalueMap.get("ford"));
		
		
		Multimap<String,String>	map = ArrayListMultimap.create();
		
		map.put("ford", "musta");
		map.put("ford", "Pantera");
		map.put("roas", "daddd");
		
		Collection<String> value = map.get("ford");
		
		System.out.println(value);
		
	
	
	}

}
