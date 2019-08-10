class Node{

	Student student;
	Company company;
	int marks;
	String company_name;

	Node next;

	Node(String name, int marks){
		company_name = name;
		this.marks = marks;
		next = null;
	}

	Node(Student s){
		student = s;
		next = null;
	}

	Node(Company c){
		company = c;
		next = null;
	}
}

class LinkedList{

	private Node first;
	private Node last;

	LinkedList(){
		first = null;
		last = null;
	}

	void addNode(Node n){
		if (first == null){
			first = n;
			last = n;
		}else{
			last.next = n;
			last = last.next;
		}
	}

	Node getFirst(){
		return first;
	}


}