package customerpaymenthandlerver1;

public class PaymentHandlerServiceImpl implements PaymentHandlerService{

	@Override
	public double priceClaculation(int unit, int custType) {
		// TODO Auto-generated method stub
		return 350;
	}

	@Override
	public double AccountBalance(int customerID) {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public void paymentHistory(int customerID) {
		System.out.println("4/14/2020 : 500");
		
	}

}
