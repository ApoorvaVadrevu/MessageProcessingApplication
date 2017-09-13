package messages;

import messages.Message2;

public class Main {
	public static void main(String args[]){
		Message1 message1 = new Message1();
		Message2 message2 = new Message2();
		System.out.println("Details of each sale:");
		message1.process();
		System.out.println("Number of occurances of each product type:");
		message2.process2();
	}
}
