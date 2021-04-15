package customerpaymenthandlerver1;

public interface PaymentHandlerService {

	public double priceClaculation(int unit, String custType);
	public double AccountBalance(String customerID);
	public void paymentHistory(String customerID);
}
