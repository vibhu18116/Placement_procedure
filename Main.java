import java.util.Scanner;

public class Main{
	static Placement_Office p_cell = new Placement_Office();
	static Scanner sc = new Scanner(System.in);

	static void decode(int instruction){
		switch (instruction){
			case 1:
				add_company();
				return;
			case 2:
				remove_placed_students();
				return;
			case 3:
				remove_closed_companies();
				return;
			case 4:
				num_unplaced_students();
				return;
			case 5:
				open_companies_names();
				return;
			case 6:
				select_students();
				return;
			case 7:
				company_details();
				return;
			case 8:
				student_details();
				return;
			case 9:
				companies_applied_for_and_marks();
				return;
			default:
				System.out.println("Invalid query");
				return;
		}
	}

	static void remove_closed_companies(){
		p_cell.remove_companies();
	}

	static void remove_placed_students(){
		p_cell.remove_placed_students();
	}

	static void select_students(){
		String comp_name = sc.next();
		p_cell.select_students(comp_name);
	}

	static void student_details(){
		int roll_num = sc.nextInt();
		p_cell.showStudentDetails(roll_num);
	}

	static void add_company(){
		String c_name = sc.next();
		System.out.print("Number of Eligible Courses: ");
		int num_eligible_courses = sc.nextInt();
		String [] courses = new String[num_eligible_courses];
		for (int i = 0; i<num_eligible_courses; i++){
			courses[i] = sc.next();
		}
		System.out.print("Number of Required Students: ");
		int num_required_students = sc.nextInt();
		p_cell.addCompany(c_name, courses, num_required_students);
		
	}

	static void companies_applied_for_and_marks(){
		int roll_num = sc.nextInt();
		p_cell.tech_round_marks(roll_num);
	}

	static void num_unplaced_students(){
		p_cell.unplacedStudents();
	}

	static void open_companies_names(){
		p_cell.open_companies_names();
	}

	static void company_details(){
		String company_name = sc.next();
		p_cell.display_company_details(company_name);
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		for (int i = 0; i<n; i++){
			float cgpa = sc.nextFloat();
			String course = sc.next();
			p_cell.addStudent(cgpa, course);
		}

		while (num_unplaced_students()!=0){
			decode(sc.nextInt());
		}
	}
}