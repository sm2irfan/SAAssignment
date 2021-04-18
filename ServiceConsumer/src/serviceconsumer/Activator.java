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

	// service consumer bundle context -> 4
	// payment handler bundle context -> 2
	
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
		
		// logo
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
		
		// declaring variables for inputing purposes
		String  id = "" ;
		String  number = "" ;
		int i = 1;
		while(i<=1) {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			// prompt to enter customer id
			
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
		System.out.println("          Welcome " + customerDetailsHandlerServiceVer1.name(id) + ", Logged in : " + dateFormat.format(date) );		
		System.out.println("---------------------------------------------------------------------");
		//System.out.println("      (Enter the appropriate number to access the service below)      ");
		System.out.println();
		System.out.println("            +------------------------------------------+");
		System.out.println("            |          Customer Payment Details        |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |         1 - Calculate unit payment       |");
		System.out.println("            |           2 - Check due balance          |");
		System.out.println("            |         3 - Check payment history        |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |              Customer Details            |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |        4 - Check customer's details      |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |         Electrical Service Details       |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |   5 - Check Electricial Service Details  |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |           Miscellaneous Functions        |");
		System.out.println("            +------------------------------------------+");
		System.out.println("            |                 98 - Manual              |");
		System.out.println("            |             99 - Close Console           |");
		System.out.println("            +------------------------------------------+");
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		
		int j = 1;
		while(j<=1) {
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println();
			
			// prompt to access the features
			
			System.out.print("Enter the allocated number to access a specific feature -->  ");
			number = input.readLine();
			System.out.println();
			int option = Integer.parseInt(number);
				
				if( option == 1 ) {
					
					System.out.println("---------------------------------------------------------------------");
					System.out.println("                    Calculating unit payment....");
					System.out.println("---------------------------------------------------------------------");
					System.out.println();
					System.out.print("Enter the number of units to calculate : ");
					
					String unit = input.readLine();
					
					int unitAmount = Integer.parseInt(unit);
					System.out.println("---------------------------------------------------------------------");
					System.out.println("Final unit payment amount : " + paymentHandlerServiceVer1.priceClaculation(unitAmount, serviceDetailsHandler.customerType(id)));
					System.out.println();
					System.out.println("---------------------------------------------------------------------");
										
				}
				if( option == 2 ) {
					
					double totalAmount = paymentHandlerServiceVer1.totalAmountForUsedUnit(id);
					double paidAmount = paymentHandlerServiceVer1.totalPayment(id);
					
					System.out.println("---------------------------------------------------------------------");
					System.out.println("                    Checking due balance....");
					System.out.println("---------------------------------------------------------------------");
					System.out.println();
					System.out.println("Total amount for used units: " + totalAmount);
					System.out.println("Total paid amount by the client: " + paidAmount);
					System.out.println("-----------------------------------------");
					System.out.println("Due balance : " + (totalAmount - paidAmount));
					System.out.println(); 
					System.out.println("---------------------------------------------------------------------");
					
				}
				if( option == 3 ) {
					System.out.println("---------------------------------------------------------------------");
					System.out.println("                   Checking payment history.....");
					System.out.println("---------------------------------------------------------------------");
					paymentHandlerServiceVer1.paymentHistory(id);
					System.out.println();
					System.out.println("---------------------------------------------------------------------");
					
				}
				if( option == 4 ) {
					
					System.out.println("---------------------------------------------------------------------");
					System.out.println("                  Checking customer details.....");
					System.out.println("---------------------------------------------------------------------");
					System.out.println();
					System.out.println("Customer ID : " + id);
					System.out.println("Customer Name : " + customerDetailsHandlerServiceVer1.name(id));
					System.out.println("Customer Address : " + customerDetailsHandlerServiceVer1.address(id));
					System.out.println("Customer NIC : " + customerDetailsHandlerServiceVer1.NIC(id));
					System.out.println("Customer Phone Number : " + customerDetailsHandlerServiceVer1.phoneNo(id));
					System.out.println(); 
					System.out.println("---------------------------------------------------------------------");
					
					
				}
				if( option == 5 ) {
					
					System.out.println("---------------------------------------------------------------------");
					System.out.println("              Checking electrical service details.....");
					System.out.println("---------------------------------------------------------------------");
					System.out.println();
					System.out.println("Customer ID : " + id);
					System.out.println("Customer Type : " + serviceDetailsHandler.customerType(id));
					System.out.println("Customer Phase details : " + serviceDetailsHandler.PhaseDetails(id));
					System.out.println(); 
					System.out.println("---------------------------------------------------------------------");
					
				}
				if (option == 98 ) {

					System.out.println("---------------------------------------------------------------------");
					System.out.println("                 Manual - How to use the console");
					System.out.println("---------------------------------------------------------------------");
					System.out.println();
					System.out.println("Welcome to the electrical service console, which is available for ");
					System.out.println("all clients to access. To access the functions that are available ");
					System.out.println("in the console, enter the appropriate number of the specific function.");
					System.out.println("For example, to access the unit calculator, clients can enter '1' ");
					System.out.println("in the propmt to access the function.");
					System.out.println("To exit the console, simply enter '99'.");
					System.out.println(); 
					System.out.println("---------------------------------------------------------------------");
					
					
				}
				if (number.length() == 0 || number == "") {
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


