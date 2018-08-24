package com.valpez.javabrains;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

public class SoapCalculatorClient {

	public static void main(String[] args) {
		// We will call the web service exposed here:
		// http://www.dneonline.com/calculator.asmx?WSDL
		boolean expectedInput = false;
		Integer firstArg = null;
		Integer secondArg = null;
		if (args.length == 2) {
			boolean firstArgNumeric = args[0].chars().allMatch(Character::isDigit);
			boolean secondArgNumeric = args[1].chars().allMatch(Character::isDigit);
			if (firstArgNumeric && secondArgNumeric) {
				expectedInput = true;
				firstArg = Integer.parseInt(args[0]);
				secondArg = Integer.parseInt(args[1]);
			}
		}

		if (!expectedInput) {
			System.out.println("You need to pass in 2 integer values.");
		} else {
			// In the wsdl, we need to look at the name of the service, and that is
			// located in correspondence of the tag <wsdl:service name="<service name>">.
			// This will provide the name of the class we need to instantiate.
			Calculator calculator = new Calculator();
			// The class CalculatorSoap is what we find in correspondence of the tag
			// <wsdl:port name="<port name>" binding="<binding>">
			CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();
			// We get a stub and invoke a method on the stub; this call will
			// be translated to a SOAP message to send to the remote service
			int result = calculatorSoap.add(firstArg, secondArg);
			System.out.println("Sum: " + result);
		}
	}
}
