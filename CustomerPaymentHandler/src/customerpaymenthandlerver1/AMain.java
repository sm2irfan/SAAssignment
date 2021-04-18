package customerpaymenthandlerver1;


import java.util.Collection;
import java.util.HashMap;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

public class AMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentHandlerService paymentHandlerService = new PaymentHandlerServiceImpl();
		
		System.out.println(paymentHandlerService.priceClaculation(1000, "industrial"));
		
		//paymentHandlerService.paymentHistory("id1012");
		System.out.println(paymentHandlerService.totalAmountForUsedUnit("id1015"));
		
		
		String id = null;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter number: ");
		try {
			id = in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while (id != "e") {
				
			System.out.println("account balance: " + paymentHandlerService.totalPayment("id1012"));
		
			
			System.out.println("enter number: ");
			try {
				id = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
			
		
		
		
		
	

}




