class Student{

	final int roll_no;
	final float cgpa;
	final String branch;

	private boolean placed = false;

	class Company_Score{

		final String company_name;
		final int score_in_test;

		Company_Score(String company_name, int score_in_test){
			this.company_name = company_name;
			this.score_in_test = score_in_test;
		}
	}

	class Companies_Applied_To{

		private Company_Score first;

		Companies_Applied_To(){
			
		}
	}
}