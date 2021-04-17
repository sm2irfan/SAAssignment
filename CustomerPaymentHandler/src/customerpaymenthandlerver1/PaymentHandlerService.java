package customerpaymenthandlerver1;

public interface PaymentHandlerService {

	public double priceClaculation(int unit, String CustomerID);
	public double AccountBalance(String customerID);
	public void paymentHistory(String customerID);
}
