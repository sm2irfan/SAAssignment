package customersdetailshandlerver1;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello");
		
		CustomerDetailsHandlerServiceImpl customerDetailsHandlerServiceImpl = new CustomerDetailsHandlerServiceImpl();
		
		System.out.println(customerDetailsHandlerServiceImpl.name("id1011"));

	}

}
