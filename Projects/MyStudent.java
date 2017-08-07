
public class MyStudent implements Student {
	private String name;
	private double gpa; 
	
	@Override
	public void init(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	@Override
	public double getGPA() {
		// TODO Auto-generated method stub
		return this.gpa = gpa;
	}

	@Override
	public void setGPA(double gpa) {
		// TODO Auto-generated method stub
		this.gpa = gpa;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name = name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}
	
	//@return String "(name:gpa)" sans quotes
	@Override 
	public String toString(){
		name = getName();
		gpa = getGPA();
		return "(" + name + ":" + gpa + ")";
		
	}

}
