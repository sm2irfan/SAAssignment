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
		
		paymentHandlerService.paymentHistory("id1011");
		System.out.println("account balance: " + paymentHandlerService.AccountBalance("id1011"));
		
		
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
		
		for (String str : value) {
			System.out.println(str);
		}
		
		System.out.println(value);
		
		Map <String, historyDele> mapface = new HashMap<String, historyDele>();
		
		mapface.put("id1011", new historyDele("1/5/2020",1500.00));
	
		System.out.println(mapface.get("id1011").getAmount());
	
	}

}





class historyDele{
	
	String date;
	double amount;
	
	public historyDele(String date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
