package serviceconsumer;

import customerpaymenthandlerver1.PaymentHandlerService;
import customersdetailshandlerver1.CustomerDetailsHandlerService;
import electricalservicedetailshandler.ServiceDetailsHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;



public class Activator implements BundleActivator {

	ServiceReference paymentHandlerVer1ServiceReference, electricalServiceDetailsServiceReference, customerDetailsServiceVer1Reference;

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("consumer service Start");
		
		//connecting with service provider 
		paymentHandlerVer1ServiceReference = bundleContext.getServiceReference(
				PaymentHandlerService.class.getName());
		electricalServiceDetailsServiceReference = bundleContext.getServiceReference(
				ServiceDetailsHandler.class.getName());
		customerDetailsServiceVer1Reference = bundleContext.getServiceReference(
				CustomerDetailsHandlerService.class.getName());
		
		// service provider object creating
		PaymentHandlerService paymentHandlerServiceVer1 = (PaymentHandlerService) bundleContext.getService(paymentHandlerVer1ServiceReference);
		ServiceDetailsHandler serviceDetailsHandler = (ServiceDetailsHandler) bundleContext.getService(electricalServiceDetailsServiceReference);
		CustomerDetailsHandlerService customerDetailsHandlerServiceVer1 = (CustomerDetailsHandlerService) bundleContext.getService(customerDetailsServiceVer1Reference);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
		System.out.println("     _______  ___      _______  ______   _______  _______  _______ tm");
		System.out.println("    /  ____/ /  /     /  ____/ /  ___/  /__  __/ / ___  / / ___  /");
		System.out.println("   /  /___  /  /     /  /___  /  /        / /   / /__/ / / /  / /");
		System.out.println("  /  ____/ /  /     /  ____/ /  /        / /   / _____/ / /  / /");
		System.out.println(" /  /___  /  /___  /  /___  /  /___     / /   /  \\     / /__/ / ");
		System.out.println("/______/ /______/ /______/ /______/    /_/   /_/\\_\\   /______/");
		System.out.println("");
		System.out.println("              -------------------------------------------");
		System.out.println("              // Welcome To Electrical Service Console //");
		System.out.println("              -------------------------------------------");
		System.out.println();
		
		String  id = "" ;
		String  number = "" ;
		int i = 1;
		while(i<=1) {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			if (customerDetailsHandlerServiceVer1.name(id) == null) {
			System.out.print("                 Enter your customer ID -->  ");
			id = in.readLine();
			}
			else {
				i++;
			}

		}
		//Welcome Text
		System.out.println("---------------------------------------------------------------------");
		System.out.println("             Welcome " + customerDetailsHandlerServiceVer1.name(id) + ", Logged in : " + dateFormat.format(date) );		
		System.out.println("---------------------------------------------------------------------");
		//System.out.println("      (Enter the appropriate number to access the service below)      ");
		System.out.println();
		System.out.println("            +------------------------------------------+");
		System.out.println("            |          Customer Payment Details        |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |         1 - Calculate unit payment       |");
		System.out.println("            |         2 - Check account balance        |");
		System.out.println("            |         3 - Check payment history        |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |              Customer Details            |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |        4 - Check customer's details      |");
		System.out.println("            |        5 - Edit customer's address       |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |         Electrical Service Details       |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |           6 - Price Calculation          |");
		System.out.println("            |           7 - Price Calculation          |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |             99 - Close Console           |");
		System.out.println("            +------------------------------------------+");
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		
		int j = 1;
		while(j<=1) {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println();
			
			System.out.print("Enter the allocated number to access a specific feature -->  ");
			number = in.readLine();
			System.out.println();
			int option = Integer.parseInt(number);
				
				if( option == 1 ) {
					
				}
				if( option == 2 ) {
					
				}
				if( option == 3 ) {
					System.out.print("Payment History =>  ");
					paymentHandlerServiceVer1.paymentHistory("id1011");
				}
				if( option == 4 ) {
					
				}
				if( option == 5 ) {
					
				}
				if( option == 6 ) {
					
				}
				if( option == 7 ) {
					
				}
				if( option == 8 ) {
					
				}
				if( option == 9 ) {
					
				}
				if (number.length() == 0 || number == " ") {
					break;
				}
	
				if (option == 99 ) {
					break;
				}
			}	
			
			
				j++;
				
				
			
		}
	
	// service stop
	public void stop(BundleContext bundleContext) throws Exception {
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date1 = new Date();
		System.out.println("Thank you for using the service console.");
		System.out.println("Logged out : " + dateFormat1.format(date1) );	
		bundleContext.ungetService(paymentHandlerVer1ServiceReference);
		bundleContext.ungetService(electricalServiceDetailsServiceReference);
		bundleContext.ungetService(customerDetailsServiceVer1Reference);
	}

}
