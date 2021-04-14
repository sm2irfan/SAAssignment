package customersdetailshandlerver1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;



	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Start Customer Details handler");
		CustomerDetailsHandlerService customerDetailsHandlerServiceVer1 = new CustomerDetailsHandlerServiceImpl();
		publishServiceRegistration = bundleContext.registerService(CustomerDetailsHandlerService.class.getName(), customerDetailsHandlerServiceVer1, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Customer Details handler");
		publishServiceRegistration.unregister();
	}

}
