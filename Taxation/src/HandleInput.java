
import java.util.Scanner;

/**
 * 
 * @author Bigyan K.c
 * @Date 2013/03/24
 * @version 1.1
 * Takes the input from user and checks it's validity
 *
 */
public class HandleInput {
	
	private String name_;
	private String maritalStatus_;
	private String sex_;
	private double salary_;
	private double allowance_;
	private double annualInsurance_;
	private float pfPerCent_;
	private float citPerCent_;
	Scanner sc=new Scanner(System.in);
	
	/**
	 * 
	 * @return
	 */
	public String setName(){
	System.out.println("Your Name:");
	name_=sc.nextLine();
	return name_;
	}

	/**
	 * 
	 * @return
	 */
	public String setMaritalStatus(){
		System.out.println("Married or NOt(Y/N):");
		maritalStatus_=sc.next();
		return maritalStatus_;
		}
	/**
	 * 
	 * @return
	 */
	
	public String setSex(){
		System.out.println("SEX(M/F):");
		sex_=sc.next();
		return sex_;
		}
	
	/**
	 * 
	 * @return
	 */
	public double setSalary(){
		System.out.println("Your Salary:");
		 salary_=sc.nextDouble();
		return salary_;
		}
	
	/**
	 * 
	 * @return
	 */
	public double setAllowance(){
		System.out.println("Allowance Amount:");
		allowance_=sc.nextDouble();
		return allowance_;
		}
	/**
	 * 
	 * @return
	 */
	
	public double setInsurance(){
		System.out.println("Annual Insurance Amount:");
		annualInsurance_=sc.nextDouble();
		return annualInsurance_;
		}
	
	/**
	 * 
	 * @return
	 */
	public float setPf(){
		System.out.println("Provident fund saving%(Not more than 10%)");
		float pfPerCent_=sc.nextFloat();
		return pfPerCent_;
		}
	/**
	 * 
	 * @return
	 */
	
	public float setCit(){
		System.out.println("CIT saving(In%)");
		float citPerCent_=sc.nextFloat();
		sc.nextLine();
		return citPerCent_;
		}
	/**
	 * 
	 * @param person
	 * @return void
	 * Takes person object as its input and returns true if user enters valid data 
	 * and false for invalid input
	 */
	
	public boolean checkInput(Person person){
		boolean check=true;
		float pf=person.getPf();
		float cit=person.getCit();
		if(pf>10)
			check=false;
		
		else if(cit+2*pf>33)
			check=false;
		
		return check;
		
	}

}

