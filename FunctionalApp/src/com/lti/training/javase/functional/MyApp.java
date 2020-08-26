package com.lti.training.javase.functional;

class GreetingBase{
	
	// tightly coupled
	
	// console
	/*public void conveyMessage(String message) {
	 * how
		System.out.println(message);
	}*/
	
	// email : sms
	// single method 
	// loosly coupled
	
	public void conveyMessage(String message, Greeting greeting) {
		// what
		greeting.sendGreeting(message);
	}
}

public class MyApp {
	
	public static void fun(String str) {
		System.out.println("Static method of class : " + str);
	}

	
	public  void funInstance(String str) {
		System.out.println("Non Static mehtod of class : " + str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Classical OOPs
		GreetingBase greeting  = new GreetingBase();
		// greeting.conveyMessage("Hello All");
		EmailGreeting email = new EmailGreeting();
		greeting.conveyMessage("Hello All", email);
		
		
		SmsGreeting sms = new SmsGreeting();
		greeting.conveyMessage("Hello All", sms);
		
		// functional 
		// greeting.conveyMessage("Hello All", <functionality>);
		
		// <instance> = <Object>
		// <instance> = <functionality>
		// demands for a new type : whose instance is capable of holding a function
		// backward compatibility : existing feature to be compatible
		/*<Interface> <instance> = public void sendGreeting(String message) {
			// TODO Auto-generated method stub
			System.out.println("Sending Email : " + message);
		}*/
		
		// lambdas : removing the boiler plate req
		/*Greeting twitter = (message) -> {
			// TODO Auto-generated method stub
			System.out.println("Sending Twitter : " + message);
		};*/
		Greeting twitter = message -> System.out.println("Sending Twitter : " + message);
		
		greeting.conveyMessage("Hello All", twitter);
		
		greeting.conveyMessage("Hello All", message -> System.out.println("Sending Network : " + message));
		
		// method reference
		// Greeting random = MyApp :: fun;
		MyApp obj = new MyApp();
		Greeting random = obj :: funInstance;
		greeting.conveyMessage("Hello All", random);
		greeting.conveyMessage("Hello All", MyApp :: fun);
	}
}
