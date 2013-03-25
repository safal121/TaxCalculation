/**
 * 
 * @author Bigyan Kc
 * @Date 2013/03/24
 * @Version 1.1
 * This class holds the information of taxpayer like name, salary
 * ,allowance,cit%,pf% etc
 */

public class Person {
	
	private String name_;
	private String maritalStatus_;
	private String sex_;
	private double salary_;
	private double allowance_;
	private double annualInsurance_;
	private float pfPerCent_;
	private float citPerCent_;
	/**
	 * 
	 * @param name
	 * @param status
	 * @param sex
	 * @param salary
	 * @param allowance
	 * @param insurance
	 * @param pf
	 * @param cit
	 * For the initialization of personal info
	 */
	public Person(String name,String status,String sex,double salary,double allowance,
					double insurance,float pf,float cit){
		name_=name;
		maritalStatus_=status;
		sex_=sex;
		salary_=salary;
		allowance_=allowance;
		annualInsurance_=insurance;
		pfPerCent_=pf;
		citPerCent_=cit;
		
	}
		
	public String getName(){
		return name_;
		}
	
	public String getMaritalStatus(){
		return maritalStatus_;
		}
	
	public String getSex(){
		return sex_;
		}

	public double getSalary(){
		return salary_;
		}
	
	public double getAllowance(){
		return allowance_;
	}
	
	public double getInsurance(){
		return annualInsurance_;
		}
	
	public float getPf(){
		return pfPerCent_;
		}
	
	public float getCit(){
		return citPerCent_;
		}

}


