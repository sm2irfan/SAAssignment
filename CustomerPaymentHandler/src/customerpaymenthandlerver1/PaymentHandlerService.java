package customerpaymenthandlerver1;

public interface PaymentHandlerService {

	public double priceClaculation(int unit, int custType);
	public double AccountBalance(int customerID);
	public void paymentHistory(int customerID);
}
