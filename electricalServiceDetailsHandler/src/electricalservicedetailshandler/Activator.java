package electricalservicedetailshandler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Start electrical service details handler");
		ServiceDetailsHandler serviceDetailsHandler = new ServiceDetailsHandlerImp();
		publishServiceRegistration = bundleContext.registerService(
				ServiceDetailsHandler.class.getName(), serviceDetailsHandler, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop electrical service details handler");
		publishServiceRegistration.unregister();
	}

}
