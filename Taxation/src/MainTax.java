/**
 * 
 * @author Bigyan Kc
 * @Date 2013/03/24
 * @version 1.1
 * This is the main class
 *
 */
public class MainTax {

	/**
	 * 
	 * @param args
	 * @return void
	 * This method gets required data and displays it
	 */
	public static void main(String []args){
		HandleInput handleinput=new HandleInput();
		Person person;
		String name;
		do{
			name=handleinput.setName();
			String marStatus=handleinput.setMaritalStatus();
			String sex=handleinput.setSex();
			double salary=handleinput.setSalary();
			double allowance=handleinput.setAllowance();
			double annualInsurance=handleinput.setInsurance();
			float pf=handleinput.setPf();
			float cit=handleinput.setCit();
			person=new Person(name,marStatus,sex,salary,allowance,annualInsurance,pf,cit);
			}while(handleinput.checkInput(person)==false);
		
			TaxCalculator taxcalculator=new TaxCalculator(person);
			double pfAmount=taxcalculator.calculatePfAmount();
			double citAmount=taxcalculator.calculateCitAmount();
			double monthlyTax=taxcalculator.calculateTax();
			double monthlyCash=taxcalculator.calculateMonthlyCash();
			
			System.out.println("Name: "+name);
			System.out.println("Your monthly PF amount is: "+pfAmount);
			System.out.println("Your monthly CIT amount is: "+citAmount);
			System.out.println("Your monthly tax amount is: "+monthlyTax);
			System.out.println("Your monthly cash in hand is: "+monthlyCash);
			
	
	}
}
