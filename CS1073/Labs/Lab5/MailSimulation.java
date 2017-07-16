import java.text.NumberFormat;

/**
 * Testing driver class for addresses, envelopes and trackable envelopes
 * 
 * @author Panos
 */
public class MailSimulation {

	public static void main(String[] args) {
		
		/*Number format object*/
		NumberFormat curFormat = NumberFormat.getCurrencyInstance();
		
		/*Create and test an Address object*/
		Address csAddress = new Address(510, "Winsdor", "E3B 5A3");
		
		/*Perform test*/
		System.out.println(csAddress);
		System.out.print("Testing creation and initial display of an Address object: ");
		if(csAddress.toString().equals("510 Winsdor, E3B 5A3")){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
		System.out.println();
		
		
		/*Create and test a simple envelope object*/
		Envelope simpleEnvelope = new Envelope(
				csAddress,
				new Address(810, "Montogomery", "E3B 2Y1"),
				10
		);
		
		/*Perform test*/
		String msg = simpleEnvelope + "Cost: " + curFormat.format(simpleEnvelope.calculateCost());
		System.out.println(msg);
		System.out.print("Testing creation and initial display of a Envelope object: ");
		if(msg.equals("From: 510 Winsdor, E3B 5A3\nTo: 810 Montogomery, E3B 2Y1\nCost: $1.00")){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
		System.out.println();
		
		/*Create and test a trackable envelope object*/
		TrackableEnvelope trackableEnvelope = new TrackableEnvelope(
				new Address(3800, "Finnerty", "V8P 5C2"),
				new Address(676, "Winsdor", "E3B 4G4"),
				2,
				"X104884AH1232"
		);
		
		
		/*Perform tests*/
		System.out.print("Testing is-a relation: ");
		if(trackableEnvelope instanceof Envelope){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
		System.out.println();
		
		msg = trackableEnvelope + "Cost: " + curFormat.format(trackableEnvelope.calculateCost());
		System.out.println(msg);
		System.out.print("Testing creation and initial display of a TrackableEnvelope object: ");
		if(msg.equals("X104884AH1232\nFrom: 3800 Finnerty, V8P 5C2\nTo: 676 Winsdor, E3B 4G4\nNot sent yet\nCost: $10.20")){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
		System.out.println();
		
		trackableEnvelope.swapAddresses();
		System.out.println(trackableEnvelope);
		System.out.print("Testing address swap: ");
		if(trackableEnvelope.toString().equals("X104884AH1232\nFrom: 676 Winsdor, E3B 4G4\nTo: 3800 Finnerty, V8P 5C2\nNot sent yet\n")){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
		System.out.println();
		
		System.out.print("Testing invalid status changes of a TrackableEnvelope object: ");
		if(!(trackableEnvelope.arriveAtHub() || trackableEnvelope.deliver())){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
		System.out.println();
		
		trackableEnvelope.send();
		System.out.println(trackableEnvelope);
		System.out.print("Testing sending, isSent and invalid delivery: ");
		if(trackableEnvelope.isSent() && !trackableEnvelope.deliver() && trackableEnvelope.toString().equals("X104884AH1232\nFrom: 676 Winsdor, E3B 4G4\nTo: 3800 Finnerty, V8P 5C2\nDispatched\n")){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
		
		trackableEnvelope.arriveAtHub();
		System.out.println(trackableEnvelope);
		System.out.print("Testing arriveAtHub and hasArrivedAtHub: ");
		if(trackableEnvelope.hasArrivedAtHub() && trackableEnvelope.toString().equals("X104884AH1232\nFrom: 676 Winsdor, E3B 4G4\nTo: 3800 Finnerty, V8P 5C2\nAt mailing hub\n")){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
		
		trackableEnvelope.deliver();
		System.out.println(trackableEnvelope);
		System.out.print("Testing deliver and isDelivered: ");
		if(trackableEnvelope.isDelivered() && trackableEnvelope.toString().equals("X104884AH1232\nFrom: 676 Winsdor, E3B 4G4\nTo: 3800 Finnerty, V8P 5C2\nDelivered\n")){
			System.out.println("PASS!");
		} else {
			System.out.println("Fail");
		}
	}

}
