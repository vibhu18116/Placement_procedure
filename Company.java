import java.util.ArrayList;
import java.util.Collections;

class Company{

	private final String company_name;
	private final String[] courses;
	private final int required;
	private boolean status = true;
	Company(String name, String[] courses, int required){
		this.company_name = name;
		this.courses = courses;
		this.required = required;
	}

	void displayDetails(){
		System.out.println(company_name);
		System.out.println("Course Criteria: ");
		for (int i = 0; i<courses.length; i++){
			System.out.println(courses[i]);
		}
		System.out.println("Number of Required Students = " + required);
		String status_str;
		if (status) status_str = "OPEN";
		else status_str = "CLOSED";
		System.out.println("Application Status: " + status_str);
	}

	boolean getOpenStatus(){
		return status;
	}

	String getName(){
		return company_name;
	}

	void select_students(){
		ArrayList <Student> eligible = new ArrayList<Student>();

		Node temp = Placement_Office.all_students.getFirst();

		while (temp!=null){
			Student current = temp.student;

			if (!current.getPlacementStatus()){
				Node temp_marks = current.company_marks.getFirst();

				while (temp_marks!=null){

					if (temp_marks.company_name.equals(company_name)){
						current.considered_marks = temp_marks.marks;
						eligible.add(current);
						break;
					}temp_marks = temp_marks.next;
				}
			}temp = temp.next;
		}

		selection(eligible);
	}

	void selection(ArrayList<Student> eligible){
		Collections.sort(eligible, Student.tech_round_marks);
		int count = 0;
		System.out.println("Roll Numbers of selected students: ");
		for (int i=0; i<eligible.size(); i++){
			eligible.get(i).setPlaced();
			eligible.get(i).setPlacedIn(company_name);
			System.out.println(eligible.get(i).getRollNo());
			count++;
			if (count == required){
				status = false;
				break;
			}
		}
	}

	static Node findCompany(String cmp_name){
		LinkedList l = Placement_Office.companies_arrived;
		Node temp = l.getFirst();

		while (temp != null){
			if (temp.company.company_name.equals(cmp_name)){
				return temp;
			}temp = temp.next;
		}

		return null;
	}


}