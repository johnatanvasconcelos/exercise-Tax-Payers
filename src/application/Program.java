package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.*;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.println("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.println("Individual or company (i/c)?");
			char a = sc.next().charAt(0);
			System.out.println("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(a == 'i') {
				System.out.println("Health expenditures:");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}else {
				System.out.println("Number of employees:");
				int numberEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberEmployees));
			}
		}
		
		double sum = 0.0;
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		for (TaxPayer tp : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $" + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));
		
		sc.close();
	}

}
