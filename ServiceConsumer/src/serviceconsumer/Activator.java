package serviceconsumer;

import customerpaymenthandlerver1.PaymentHandlerService;
import customersdetailshandlerver1.CustomerDetailsHandlerService;
import electricalservicedetailshandler.ServiceDetailsHandler;
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
		
		
		
		
		
		
		
		// using payment handler service
		paymentHandlerServiceVer1.paymentHistory("id1011");
		System.out.println(paymentHandlerServiceVer1.AccountBalance("id1011"));
		
	
		
		
		
		// using electrical service details
		System.out.println("electrical service details: " + serviceDetailsHandler.customerType("id1011"));
		
		
		
		
		//using customer details handler
		System.out.println("customer details: " + customerDetailsHandlerServiceVer1.name("id1011"));
	}

	
	
	
	
	
	
	
	
	
	// service stop
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("good bye ...");
		bundleContext.ungetService(paymentHandlerVer1ServiceReference);
		bundleContext.ungetService(electricalServiceDetailsServiceReference);
		bundleContext.ungetService(customerDetailsServiceVer1Reference);
	}

}
