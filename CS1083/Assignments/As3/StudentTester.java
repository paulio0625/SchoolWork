import java.util.Scanner;

public class StudentTester{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		Student stu1 = new Student(name);
		
		String title = sc.next();;
		String grade;
		int credit;
		int cat;
		Course temp;
		while(!(title.equals("end"))){
			credit = sc.nextInt();
			grade = sc.next();
			cat = sc.nextInt();
			
			switch(cat){
				case 1: temp = new CICourse(title, grade, credit);
				break;
				case 2: temp = new TECourse(title, grade, credit);
				break;
				case 3: temp = new MSCourse(title, grade, credit);
				break;
				case 4: temp = new BrCourse(title, grade, credit);
				break;
				default: temp = new FECourse(title, grade, credit);
				break;
			}
			
			stu1.addCourse(temp);
			sc.nextLine();
			title = sc.next();
		}
		
		title = sc.next();
		String searched = "";
		while(!(title.equals("end"))){
			searched += stu1.search(title) + "\n";
			
			title = sc.next();
		}
		
		System.out.println("Orignal data:");
		System.out.println();
		System.out.println(stu1.toString());
		System.out.println();
		
		stu1.sort();
		
		System.out.println("Sorted data:");
		System.out.println(stu1.toString());
		System.out.println();
		System.out.println("Search for courses:");
		System.out.println();
		System.out.println(searched);
	}
}