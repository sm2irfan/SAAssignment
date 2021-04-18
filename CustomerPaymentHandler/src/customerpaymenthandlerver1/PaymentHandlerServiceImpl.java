package customerpaymenthandlerver1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class PaymentHandlerServiceImpl implements PaymentHandlerService {

	@Override
	public double priceClaculation(int unit, String custType) {
		// TODO Auto-generated method stub
		double total;

		switch (custType) {
		case "domastic":

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
	public double totalAmountForUsedUnit(String customerID) {
		
		
		String[] customerId = new String[] {"id1011", "id1012", "id1013","id1014","id1015"};
		Double[] amount = new Double[] {10000.00, 11000.00, 17000.00,25000.00,12000.00};
		
		Map<String, Double> customerAcc = new HashMap<String, Double>();
		
		for (int i = 0; i < customerId.length; i++) {
			customerAcc.put(customerId[i], amount[i]);
		}
		
		Double amountValue = customerAcc.get(customerID);
		
		return amountValue;
	}

	@Override
	public double totalPayment(String customerID) {
		// TODO Auto-generated method stub
		double total = 0;
		
		collectData();
		String[] filterPayIdArray = filterPaymentID(customerID);
		Double[] filteramountArray = filterPaymentAmount(customerID, filterPayIdArray);
		
		for (int i = 0; i < filteramountArray.length; i++) {
			total +=  filteramountArray[i];
		}
		
		return total;
	}

	
	
	@Override
	public void paymentHistory(String customerID) {

		collectData();

		// Filter id
		String[] fildCustomeridArray = filtercustomerID(customerID);

		// filter Payment id
		String[] filterPayIdArray = filterPaymentID(customerID);

		// filter date
		String[] filterdateArray = filterPaymentDate(customerID, filterPayIdArray);

		// filter Amount
		Double[] filteramountArray = filterPaymentAmount(customerID, filterPayIdArray);


		System.out.println("+---------------+-----------------------+---------------+---------------+");
		System.out.println("|Customer ID    |        Date           |  Payment ID   |   Amount      |");
		System.out.println("+---------------+-----------------------+---------------+---------------+");
		
		
		for (int i = 0; i < fildCustomeridArray.length; i++) {
			//System.out.println("Customer Id :" + fildCustomeridArray[i] +"\tDate:"+ filterdateArray[i] +  "\t Payment Id : " + filterPayIdArray[i]
					//+ "\t Amount : " + filteramountArray[i] + "\n");
			
			System.out.println("|\t"+fildCustomeridArray[i]+"\t|\t" + filterdateArray[i]+"\t|\t"+filterPayIdArray[i]+"\t|\t"  +filteramountArray[i]+"\t|");
			System.out.println("+\t\t+\t\t\t+\t\t+\t\t+");
			

		}

		System.out.println("+---------------+-----------------------+---------------+---------------+");
	}
	
	
	
	// data for inserting
	String[] customerid = new String[] { "id1011", "id1012", "id1012", "id1013", "id1014", "id1011" };
	String[] paymentid = new String[] { "py901", "py902", "py903", "py904", "py905", "pay906" };
	String[] paymentdate = new String[] { "1/5/2020", "1/8/2020", "1/9/2020", "9/9/2020", "8/8/2020", "31/8/2020" };
	double[] paymentamount = new double[] { 1500.00, 1200.00, 500.00, 800.00, 650.00, 780.00 };

	Multimap<String, String> map = ArrayListMultimap.create();
	Map<String, history> mapface = new HashMap<String, history>();

	public void collectData() {

		for (int i = 0; i < paymentid.length; i++) {
			map.put(customerid[i], paymentid[i]);
		}

		// add date and amount to hasMap
		for (int i = 0; i < paymentid.length; i++) {
			mapface.put(paymentid[i], new history(paymentdate[i], paymentamount[i]));
		}
	}

	
	// filtering how many time exist particular customer id
	public String[] filtercustomerID(String customerID) {

		ArrayList<String> filderdArrayList = new ArrayList<>();
		for (int i = 0; i < customerid.length; i++) {
			if (customerid[i].matches(customerID)) {
				filderdArrayList.add(customerID);
			}
		}
		String[] fildCustomeridArray = new String[filderdArrayList.size()];
		filderdArrayList.toArray(fildCustomeridArray);

		return fildCustomeridArray;

	}

	//filtering payment id according to customer id 
	public String[] filterPaymentID(String customerID) {

		Collection<String> value = map.get(customerID);
		ArrayList<String> filderdPaymentId = new ArrayList<>();
		for (String str : value) {
			filderdPaymentId.add(str);
		}
		String[] filterPayIdArray = new String[filderdPaymentId.size()];
		filderdPaymentId.toArray(filterPayIdArray);
		return filterPayIdArray;

	}

	
	//filtering payment date for given customer ID
	public String[] filterPaymentDate(String customerID, String[] filterPayIdArray) {

		ArrayList<String> paydate = new ArrayList<>();
		for (int i = 0; i < filterPayIdArray.length; i++) {
			paydate.add(mapface.get(filterPayIdArray[i]).getDate());
		}
		String[] filterdateArray = new String[paydate.size()];
		paydate.toArray(filterdateArray);
		return filterdateArray;

	}

	public Double[] filterPaymentAmount(String customerID, String[] filterPayIdArray) {

		ArrayList<Double> payAmount = new ArrayList<>();
		for (int i = 0; i < filterPayIdArray.length; i++) {
			payAmount.add(mapface.get(filterPayIdArray[i]).getAmount());
		}
		Double[] filteramountArray = new Double[payAmount.size()];
		payAmount.toArray(filteramountArray);
		return filteramountArray;

	}

	

	

}







// for serving payment history date and amount

class history {

	String date;
	double amount;

	public history(String date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

}
