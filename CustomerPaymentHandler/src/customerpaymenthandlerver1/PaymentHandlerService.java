package customerpaymenthandlerver1;

public interface PaymentHandlerService {

	public double priceClaculation(int unit, String CustomerID);
	public double totalPayment(String customerID);
	public double totalAmountForUsedUnit(String customerID);
	public void paymentHistory(String customerID);
}
