import java.util.Comparator;

class Student{

	private final int roll_no;
	final float cgpa;
	final String branch;
	private boolean placed = false;
	private String placed_in;
	int considered_marks;

	LinkedList company_marks = new LinkedList();

	Student(int roll_no, float cgpa, String branch){
		this.roll_no = roll_no;
		this.cgpa = cgpa;
		this.branch = branch;
	}

	void setPlaced(){
		placed = true;
	}

	void setPlacedIn(String c_name){
		placed_in = c_name;
	}

	void addMarks(Node techMarks){
		company_marks.addNode(techMarks);
	}

	String getBranch(){
		return branch;
	}

	boolean getPlacementStatus(){
		return placed;
	}

	int getRollNo(){
		return roll_no;
	}

	float getCGPA(){
		return cgpa;
	}

	void displayDetails(){
		System.out.println(roll_no);
		System.out.println(cgpa);
		System.out.println(branch);
		if (placed){
			System.out.println("Placement Status: Placed");
			System.out.println(placed_in);
		}else{
			System.out.println("Placement Status: Not placed");
		}
	}

	void show_scores(){
		Node temp = company_marks.getFirst();
		while (temp != null){
			System.out.println(temp.company_name + " " + temp.marks);
			temp = temp.next;
		}
	}

	public static final Comparator<Student> tech_round_marks = new Comparator<Student>(){
		@Override
		public int compare(Student s1, Student s2){
			if (s1.considered_marks != s2.considered_marks){
				return s2.considered_marks - s1.considered_marks;
			}else if (s1.cgpa>s2.cgpa){
				return -1;
			}return 1;
		}
	};	
}