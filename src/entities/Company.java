package entities;

public class Company extends TaxPayer{
	
	protected Integer numberEmployees;
	
	public Company() {
		
	}
	public Company(String name, Double anualIncome, Integer numberEmployees) {
		super(name, anualIncome);
		this.numberEmployees = numberEmployees;
	}

	private Integer getNumberEmployees() {
		return numberEmployees;
	}

	private void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}
	
	@Override
	public Double tax() {
		if(numberEmployees > 10) {
			return getAnualIncome() * 0.14;
		} else {
			return getAnualIncome() * 0.16;
		}
	}
}
