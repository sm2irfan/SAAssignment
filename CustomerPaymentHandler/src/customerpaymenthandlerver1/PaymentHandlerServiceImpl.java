package customerpaymenthandlerver1;

public class PaymentHandlerServiceImpl implements PaymentHandlerService {

	@Override
	public double priceClaculation(int unit, String custType) {
		// TODO Auto-generated method stub
		double total;

		switch (custType) {
		case "domastic":
			System.out.println("domastic customer");

			if (unit > 0 && unit <= 10) {

				return unit * 12;

			} else if (unit >= 11 && unit <= 20) {

				return 120 + ((unit - 10) * 18);

			} else if (unit >= 21 && unit <= 30) {

				return 120 + 180 + ((unit - 20) * 31);

			} else if (unit >= 31 && unit <= 40) {

				return 120 + 180 + 310 + ((unit - 30) * 48);

			} else if (unit >= 41 && unit <= 50) {

				return 120 + 180 + 310 + 480 + ((unit - 40) * 70);

			} else if (unit >= 51 && unit <= 60) {

				return 120 + 180 + 310 + 480 + 700 + ((unit - 50) * 95);

			} else if (unit >= 61 && unit <= 500) {

				return 120 + 180 + 310 + 480 + 700 + 950 + ((unit - 60) * 800);

			} else

				break;
		case "industrial":
			System.out.println("industrial customer");

			if (unit > 0 && unit <= 100) {

				return unit * 70;

			} else if (unit >= 110 && unit <= 200) {

				return 7000 + ((unit - 10) * 150);

			} else if (unit >= 210 && unit <= 300) {

				return 7000 + 15000 + ((unit - 20) * 350);

			} else if (unit >= 310 && unit <= 400) {

				return 7000 + 15000 + 35000 + ((unit - 30) * 700);

			} else if (unit >= 410 && unit <= 500) {

				return 7000 + 15000 + 35000 + 70000 + ((unit - 40) * 1200);

			} else if (unit >= 510 && unit <= 600) {

				return 7000 + 15000 + 35000 + 70000 + 120000 + ((unit - 50) * 2100);

			} else if (unit >= 610 && unit <= 5000) {

				return 7000 + 15000 + 35000 + 70000 + 120000 + 210000 + ((unit - 60) * 3500);

			} else

				break;
		default:
			break;
		}

		return (Double) null;

	}

	@Override
	public double AccountBalance(String customerID) {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public void paymentHistory(String customerID) {
		System.out.println("4/14/2020 : 500");

	}

}
