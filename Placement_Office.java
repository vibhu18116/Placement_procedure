import java.util.Scanner;

class Placement_Office{

	static Scanner sc = new Scanner(System.in);
	private static int roll_no = 0;
	private LinkedList all_students;
	private LinkedList companies_arrived;

	Placement_Office(){
		all_students = new LinkedList();
		companies_arrived = new LinkedList();
	}

	void addStudent(float cg, String course){
		roll_no++;
		Student new_student = new Student(roll_no, cg, course);
		all_students.addNode(new Node(new_student));
	}

	void addCompany(String name, String[] courses, int required){
		Company new_company = new Company(name, courses, required);
		companies_arrived.addNode(new Node(new_company));
		new_company.displayDetails();
		student_marks(courses, name);
	}

	private void student_marks(String [] courses, String name){
		Node temp = all_students.getFirst();
		System.out.println("Enter scores for technical round ");
		while (temp!=null){
			Student current = temp.student;
			for (int i = 0; i<courses.length; i++){
				if (current.branch.equals(courses[i]) && !current.getPlacementStatus()){
					System.out.println("Enter score for Roll No. " + current.roll_no);
					int marks = sc.nextInt();
					Node n = new Node(name, marks);
					temp.student.addMarks(n);
					break;
				}
			}
			temp = temp.next;
		}
	}

	void display_company_details(){
		
	}

	void unplacedStudents(){
		Node temp = all_students.getFirst();
		int count = 0;
		while (temp!=null){
			Student current = temp.student;

			if (!current.getPlacementStatus()){
				count++;
			}
			temp = temp.next;
		}

		System.out.println(count + " students left. ");
	}

	void open_companies_names(){
		Node temp = companies_arrived.getFirst();
		while (temp!=null){
			Company current = temp.company;
			if (current.getOpenStatus()){
				System.out.println(current.getName());
			}
			temp = temp.next;
		}
	}
}