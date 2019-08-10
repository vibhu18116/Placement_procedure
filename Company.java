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

}