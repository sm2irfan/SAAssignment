package customerpaymenthandlerver1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Start Customer Payment Handler");
		PaymentHandlerService paymentHandlerServiceVer1 = new PaymentHandlerServiceImpl();
		publishServiceRegistration = bundleContext.registerService(
				PaymentHandlerService.class.getName(), paymentHandlerServiceVer1, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Customer Payment handler");
		publishServiceRegistration.unregister();
	}

}
