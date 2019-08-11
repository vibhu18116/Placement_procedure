import java.util.Scanner;

class Placement_Office{

	static Scanner sc = new Scanner(System.in);
	private static int roll_no = 0;
	static LinkedList all_students;
	static LinkedList companies_arrived;

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
					System.out.println("Enter score for Roll No. " + current.getRollNo());
					int marks = sc.nextInt();
					Node n = new Node(name, marks);
					temp.student.addMarks(n);
					break;
				}
			}
			temp = temp.next;
		}
	}

	void display_company_details(String name){
		Node temp = companies_arrived.getFirst();
		while (temp!=null){
			Company current = temp.company;
			if (current.getName().equals(name)){
				current.displayDetails();
				return;
			}
			temp = temp.next;
		}System.out.println("No such company");
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

	void showStudentDetails(int roll){
		Node temp = all_students.getFirst();
		while (temp!=null){

			Student current = temp.student;

			if (current.getRollNo() == roll){
				current.displayDetails();
				return;
			}
			temp = temp.next;
		}System.out.println("No student with the given roll no has an account.");
	}

	void tech_round_marks(int roll_num){
		Node temp = all_students.getFirst();
		while (temp!=null){

			Student current = temp.student;

			if (current.getRollNo() == roll_num){
				current.show_scores();
				return;
			}

			temp = temp.next;
		}System.out.println("No student with the given roll no has an account.");
	}

	void select_students(String cmp_name){
		Node n = Company.findCompany(cmp_name);
		n.company.select_students();
	}

	void remove_placed_students(){
		Node temp = all_students.getFirst();

		System.out.println("Accounts removed for:");
		while (temp!=null && temp.student.getPlacementStatus()){
			System.out.println(temp.student.getRollNo());
			temp = temp.next;
			all_students.setHead(temp);
		}

		while (temp!=null && temp.next != null){
			if (temp.next.student.getPlacementStatus()){
				System.out.println(temp.next.student.getRollNo());
				temp.next = temp.next.next;
			}else{
				temp = temp.next;
			}
		}
	}

	void remove_companies(){
		Node temp = companies_arrived.getFirst();
		System.out.println("Accounts removed for: ");
		while (temp!=null && !temp.company.getOpenStatus()){
			System.out.println(temp.company.getName());
			temp = temp.next;
			companies_arrived.setHead(temp);
		}

		while (temp!=null && temp.next != null){
			if (!temp.next.company.getOpenStatus()){
				temp.next = temp.next.next;
			}else{
				temp = temp.next;
			}
		}
	}
}