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
		
		paymentHandlerService.paymentHistory("id1012");
		//System.out.println("account balance: " + paymentHandlerService.AccountBalance("id1012"));
		
		
		
	}

}




