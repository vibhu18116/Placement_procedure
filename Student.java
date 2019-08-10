class Student{

	final int roll_no;
	final float cgpa;
	final String branch;
	private boolean placed = false;
	private String placed_in;

	LinkedList company_marks = new LinkedList();

	Student(int roll_no, float cgpa, String branch){
		this.roll_no = roll_no;
		this.cgpa = cgpa;
		this.branch = branch;
	}

	void addMarks(Node techMarks){
		company_marks.addNode(techMarks);
	}

	boolean getPlacementStatus(){
		return placed;
	}
	
}