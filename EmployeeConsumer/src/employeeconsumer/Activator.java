package employeeconsumer;

import electricalservicedetailshandler.Service;
import electricalservicedetailshandler.ServiceDetailsHandler;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(ServiceDetailsHandler.class.getName());
		ServiceDetailsHandler servicedetails = (ServiceDetailsHandler)context.getService(serviceReference);
		
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		
		do {
		int action;
		
		
		
		System.out.println("Starting Employee Consumer");
		System.out.println("Select options by entering 1 to 3");
		
		System.out.println("1.Add a new Service ");
		
		System.out.println("2.List Service Details");
		System.out.println("3.Remove Service details");
		
		System.out.println("Enter your selection...");
		 action = input.nextInt();
		 
		 input.nextLine();
		 
	        if(action==6) {
	        	exit = true;
	        }

	        
		
		String Home = null;
		
		 if (action == 1) {
			 
			 do {
			 System.out.println("Customer id");
			 String cusid = input.nextLine();
			 
			 System.out.println("Customer type");
			 String custype = input.nextLine();
			 
			 if (custype=="domestic") {
				 
			 }
			 
			 System.out.println("Phase");
			 String phase = input.nextLine();
			 
			 System.out.println("Transformerrate");
			 String rate = input.nextLine();
			 
			 int result = servicedetails.addElectricService(cusid, custype, phase, rate);
			 String msg = (result ==1) ? "Successfully added the item!" :"please enter a valid name";
			   System.out.println(msg);
			   
			   System.out.println("to go to home please enter 0");
				
				Home=input.nextLine();

			 
			 }
			 while(!(Home.equals("0")));
			 
			 
			 
		 }
		 
		 else if(action == 2) {
			 
		do {
			 List<Service> servicelist = servicedetails.listService();
			 
			 
			 for(Service tempService: servicelist) {
				 System.out.println(tempService.getCustomerId() + "\t" + tempService.getCustomerType()+"\t"+ tempService.getPhase()+"\t"+tempService.getTransformerRating());
			 }
			 System.out.println("-----------------------------------------------------------------------------------------");
	            System.out.println("to go to home please enter 0");
				
				Home=input.nextLine();
		}
		while(!(Home.equals("0")));
		
		 }
		 
		 else if(action ==3) {
			 System.out.println("Enter Customer Id");
			 String cusid = input.nextLine();
			 int result = servicedetails.removeElectricService(cusid);
			 System.out.println("Service Detail removed successfully");
			 
			 System.out.println("to go to home please enter 0");
			 Home = input.nextLine();
		 }
		 
		 else if(action == 6) {//Exits form the Manager consumer program
				return;
			}
		}while(!exit);
		}
	
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("Employee consumer stopped");
		context.ungetService(serviceReference);
	}

}
