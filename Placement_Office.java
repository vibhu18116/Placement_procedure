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
		Node n = Company.findCompany(name);
		if (n!=null){
			System.out.println("Company already registered.");
			return;
		}
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

	int unplacedStudents(){
		Node temp = all_students.getFirst();
		int count = 0;
		while (temp!=null){
			Student current = temp.student;

			if (!current.getPlacementStatus()){
				count++;
			}
			temp = temp.next;
		}

		// System.out.println(count + " students left. ");
		return count;
	}

	void open_companies_names(){
		Node temp = companies_arrived.getFirst();
		boolean atleastOne = false;
		while (temp!=null){
			Company current = temp.company;
			if (current.getOpenStatus()){
				System.out.println(current.getName());
				atleastOne = true;
			}
			temp = temp.next;
		}
		if (!atleastOne){
			System.out.println("None");
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
		if (n == null){
			System.out.println("Company is not yet in process.");
			return;
		}else if (!n.company.getOpenStatus()){
			System.out.println("Students already placed in the company.");
			return;
		}
		n.company.select_students();
	}

	void remove_placed_students(){
		Node temp = all_students.getFirst();
		Boolean atleastOne = false;

		System.out.println("Accounts removed for:");
		while (temp!=null && temp.student.getPlacementStatus()){
			atleastOne = true;
			System.out.println(temp.student.getRollNo());
			temp = temp.next;
			all_students.setHead(temp);
		}

		while (temp!=null && temp.next != null){
			if (temp.next.student.getPlacementStatus()){
				atleastOne = true;
				System.out.println(temp.next.student.getRollNo());
				temp.next = temp.next.next;
			}else{
				temp = temp.next;
			}
		}

		if (!atleastOne){
			System.out.println("None");
		}
	}

	void remove_companies(){
		Node temp = companies_arrived.getFirst();
		System.out.println("Accounts removed for: ");
		Boolean atleastOne = false;
		while (temp!=null && !temp.company.getOpenStatus()){
			atleastOne = true;
			System.out.println(temp.company.getName());
			temp = temp.next;
			companies_arrived.setHead(temp);
		}

		while (temp!=null && temp.next != null){
			if (!temp.next.company.getOpenStatus()){
				atleastOne = true;
				System.out.println(temp.next.company.getName());
				temp.next = temp.next.next;
			}else{
				temp = temp.next;
			}
		}

		if (!atleastOne){
			System.out.println("None");
		}
	}
}