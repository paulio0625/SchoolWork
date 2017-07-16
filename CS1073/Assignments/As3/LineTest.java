public class LineTest{
	public static void main(String[]args){
		LineSegment lineOne = new LineSegment(0.0, 0.0, 0.0, 5.0);
		LineSegment lineTwo = new LineSegment(2.0, 5.0, 2.0, 7.0);
		LineSegment lineThree = new LineSegment(1.0, 5.0, 6.0, 5.0);
		LineSegment lineFour = new LineSegment(2.0, 5.0, 7.3, 10.1);
		LineSegment lineFive = new LineSegment(0.0, -3.0, 10.6, 7.2);
		LineSegment lineSix = new LineSegment(0.0, -3.0, 10.6, 3.0);
		LineSegment lineSeven = new LineSegment(2.0, 5.0, 2.0, 5.0);
		
		if(lineOne.isParallelTo(lineTwo)){
			System.out.println("Line 1 is parallel to line 2.");
		}
		else{
			System.out.println("Line 1 isn't parallel to line 2.");
		}
		
		if(lineOne.isParallelTo(lineThree)){
			System.out.println("Line 1 is parallel to line 3.");
		}
		else{
			System.out.println("Line 1 isn't parallel to line 3.");
		}
		
		if(lineFour.isParallelTo(lineFive)){
			System.out.println("Line 4 is parallel to line 5.");
		}
		else{
			System.out.println("Line 4 isn't parallel to line 5.");
		}
		
		if(lineFour.isParallelTo(lineSix)){
			System.out.println("Line 4 is parallel to line 6.");
		}
		else{
			System.out.println("Line 4 isn't parallel to line 6.");
		}
		
		if(lineFour.isParallelTo(lineFour)){
			System.out.println("Line 4 is parallel to itself.");
		}
		else{
			System.out.println("Line 4 isn't parallel to itself.");
		}
		
		System.out.println("Line 1 has a midpoint at " + lineOne.midpoint() + " and a length of " + lineOne.length());
		System.out.println("Line 3 has a midpoint at " + lineThree.midpoint() + " and a length of " + lineThree.length());
		System.out.println("Line 4 has a midpoint at " + lineFour.midpoint() + " and a length of " + lineFour.length());
		System.out.println("Line 7 has a midpoint at " + lineSeven.midpoint() + " and a length of " + lineSeven.length());
	}
}