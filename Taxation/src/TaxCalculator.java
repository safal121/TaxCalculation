import java.util.Scanner;

/**
 * 
 * @author Bigyan Kc
 * @Date 2013/03/24
 * @version 1.1
 * This class contains the calculation parts
 *
 */
public class TaxCalculator {
	
	private String name_;
	private char maritalStatus_;
	private char sex_;
	private double salary_;
	private double allowance_;
	private double annualInsurance_;
	private double taxableAmount_;
	private double annualSalary_;
	private double annualAllowance_;
	private float pfPerCent_;
	private float citPerCent_;
	private double annualPfAmount_;
	private double annualCitAmount_;
	private final double PERCENT=0.01;
	private final double FIRSTBRACKET_MAR=200000;
	private final double SECONDBRACKET_MAR=300000;
	private final double FIRSTBRACKET_UNMAR=160000;
	private final double SECONDBRACKET_UNMAR=260000;
	private final double FEMALETAX_DISCOUNT=10;
	
	
	
	Scanner sc=new Scanner(System.in);
	public TaxCalculator(Person person){
		
		name_=person.getName();
		maritalStatus_=person.getMaritalStatus().toLowerCase().charAt(0);
		sex_=person.getSex().toLowerCase().charAt(0);
		salary_=person.getSalary();
		allowance_=person.getAllowance();
		annualInsurance_=person.getInsurance();
		pfPerCent_=person.getPf();
		citPerCent_=person.getCit();
		annualSalary_=salary_*12;
		annualAllowance_=allowance_*12;
	}

	/**
	 * 
	 * @return double
	 * @param void
	 * Calculates the monthly PF amount
	 */
	public double calculatePfAmount(){
		annualPfAmount_=annualSalary_*2*pfPerCent_*PERCENT;
		return(annualPfAmount_/12);
	}
	/**
	 * @param void
	 * @return void
	 * Calculates the monthly CIT amount
	 */
	public double calculateCitAmount(){
		if((annualSalary_+annualAllowance_)*citPerCent_*PERCENT>300000){
			annualCitAmount_=300000;
			return(annualCitAmount_/12);
		}
		else{
			annualCitAmount_=(annualSalary_+annualAllowance_)*citPerCent_*PERCENT;
			return(annualCitAmount_/12);
	}

	}
		/**
		 * @param void
		 * @return double
		 * calculates the monthly Tax amount
		 */
		public double calculateTax(){
		double pfAnnual=calculatePfAmount()*12;
		double citAnnual=calculateCitAmount()*12;
		double taxableInsurance;
		double annualTax=0;
		//Finds taxable insurance if annual insurance premium>20000
		if(annualInsurance_<=20000){
			taxableInsurance=0;
		}
		else{
			taxableInsurance=annualInsurance_-20000;
		}
		//annual taxable amount
		double taxable=annualSalary_+taxableInsurance+annualAllowance_-annualInsurance_-pfAnnual/2-citAnnual;
		//return taxable;
		
		if(maritalStatus_=='y')
		{
			if(sex_=='m'){
				if(taxable<=FIRSTBRACKET_MAR){
					annualTax=taxable*1*PERCENT;
						}
				else if(taxable>FIRSTBRACKET_MAR&&taxable<=SECONDBRACKET_MAR){
					double temp=taxable-FIRSTBRACKET_MAR;
					annualTax=FIRSTBRACKET_MAR*1*PERCENT+temp*15*PERCENT;
					}
				else{
					double temp=taxable-SECONDBRACKET_MAR;
					annualTax=FIRSTBRACKET_MAR*1*PERCENT+(SECONDBRACKET_MAR-FIRSTBRACKET_MAR)*15*PERCENT+temp*25*PERCENT;
					}
			}
				else{
					if(taxable<=FIRSTBRACKET_MAR){
						annualTax=taxable*1*PERCENT*(100-FEMALETAX_DISCOUNT)*PERCENT;
					}
					else if(taxable>FIRSTBRACKET_MAR&&taxable<=SECONDBRACKET_MAR){
						double temp=taxable-FIRSTBRACKET_MAR;
						annualTax=(FIRSTBRACKET_MAR*1*PERCENT+temp*15*PERCENT)*(100-FEMALETAX_DISCOUNT)*PERCENT;
					}
					else{
						double temp=taxable-SECONDBRACKET_MAR;
						annualTax=(FIRSTBRACKET_MAR*1*PERCENT+(SECONDBRACKET_MAR-FIRSTBRACKET_MAR)*15*PERCENT+temp*25*PERCENT)*(100-FEMALETAX_DISCOUNT)*PERCENT;
						}
			
				}
				}
				else{
					if(sex_=='m'){
						if(taxable<=FIRSTBRACKET_UNMAR){
							annualTax=taxable*1*PERCENT;
						}
						else if(taxable>FIRSTBRACKET_UNMAR&&taxable<=SECONDBRACKET_UNMAR){
							double temp=taxable-FIRSTBRACKET_UNMAR;
							annualTax=FIRSTBRACKET_UNMAR*1*PERCENT+temp*15*PERCENT;
						}
						else{
							double temp=taxable-SECONDBRACKET_UNMAR;
							annualTax=FIRSTBRACKET_UNMAR*1*PERCENT+(SECONDBRACKET_UNMAR-FIRSTBRACKET_UNMAR)*15*PERCENT+temp*25*PERCENT;
						}
					}
					else{
						if(taxable<=FIRSTBRACKET_UNMAR){
						annualTax=taxable*1*PERCENT*(100-FEMALETAX_DISCOUNT)*PERCENT;
						}
						else if(taxable>FIRSTBRACKET_UNMAR&&taxable<=SECONDBRACKET_UNMAR){
							double temp=taxable-FIRSTBRACKET_UNMAR;
							annualTax=(FIRSTBRACKET_UNMAR*1*PERCENT+temp*15*PERCENT)*(100-FEMALETAX_DISCOUNT)*PERCENT;
					}
						else{
							double temp=taxable-SECONDBRACKET_UNMAR;
							annualTax=(FIRSTBRACKET_UNMAR*1*PERCENT+(SECONDBRACKET_UNMAR-FIRSTBRACKET_UNMAR)*15*PERCENT+temp*25*PERCENT)*(100-FEMALETAX_DISCOUNT)*PERCENT;
							}
						}
				}
		

		return annualTax/12;
		}
		/**
		 * 
		 * @return double
		 * @param void
		 * calculates monthly cash received by the person
		 */
		
		public double calculateMonthlyCash(){
			double monthlyPf=calculatePfAmount();
			double monthlyCit=calculateCitAmount();
			double monthlyTax=calculateTax();
			double monthlyCash=salary_+allowance_-monthlyPf/2-monthlyCit-annualInsurance_/12-monthlyTax;
			return monthlyCash;
		}
}
