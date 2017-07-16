/**
*A class for creating student objects.
*@author Paul Armstrong, 3537294
**/

import java.util.*;

public class Student{
	/**
	*The name of the student.
	**/
	private String name;
	/**
	*A companion variable.
	**/
	private static int i = 0;
	/**
	*An arraylist to hold of of the students courses.
	**/
	private ArrayList<Course> classes = new ArrayList<Course>(1);;
	
	/**
	*Creates a student object by taking in a name.
	*@param name The name of the student.
	**/
	public Student(String nameIn){
		name = nameIn;
	}
	
	/**
	*Adds a new course to the list.
	@param x The new course.
	**/
	public void addCourse(Course x){
		classes.add(x);
		i++;
	}
	
	/**
	*Creates a temporary array and fills it from the arraylist.
	*The array is then passed to the Sorting class sorted and returned.
	*It is then transfered back into the arraylist.
	**/
	public void sort(){
		Course[] temp = new Course[classes.size()];
		for(int i = 0; i < temp.length; i++){
			temp[i] = classes.get(i);
		}
		Sorting.selectionSort(temp);
		for(int i = 0; i < temp.length; i++){
			classes.add(i, temp[i]);
		}
	}
	
	/**
	*Searches through the arraylist for the course returning either not found or the stored course information.
	*@param y The name of the course being searched for.
	*@return The stored information regarding the course
	**/
	public String search(String y){
		String message = y + " not found";
		
		for(int x = 0; x < classes.size(); x++){
			if(y.equals(classes.get(x).getTitle())){
				message = classes.get(x).toString();
				break;
			}
		}
		return message;
	}
	
	/**
	*A textual representation of the courses the student has completed.
	*@return The string of courses.
	**/
	public String toString(){
		String message = "" + name + "\nCourses:";
		
		for(int x = 0; x < i; x++){
			message = message + "\n" + classes.get(x).toString();
		}
		
		return message;
	}
}