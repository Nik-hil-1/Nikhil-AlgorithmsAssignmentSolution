package com.gl.gradedassignment.stockers.main;

import java.util.Scanner;

import com.gl.gradedassignment.stockers.service.Stock;

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;
		int no_of_company;

		System.out.println("Enter the number of companies --");
		no_of_company = sc.nextInt();

		double stocks[] = new double[no_of_company];
		Boolean[] price_change = new Boolean[no_of_company];

		Stock stock = new Stock();

		while (no_of_company > 0) {

			int company_count = no_of_company;

			for (int i = 0; i < company_count; i++) {

				System.out.println("Enter the stock price of the company " + (i + 1));
				stocks[i] = sc.nextDouble();
				System.out.println("Whether company's stockprice rose today compare to yesterday?");
				price_change[i] = sc.nextBoolean();

				no_of_company--;
			}
		}

		do {
			System.out.println("\n\nUser can perform the following operations in the application:\n\n");
			System.out.println("1. Display the companies stock prices in ascending order.");
			System.out.println("2. Display the companies stock prices in descending order.");
			System.out.println("3. Display the total number of the companies for which stock prices roses today.");
			System.out.println("4. Display the total number of the companies for which stock prices declined today.");
			System.out.println("5. Search a specific stock price.");
			System.out.println("6. press 0 to exit.");

			choice = sc.nextInt();

			switch (choice) {

			case 0:
				System.out.println("Exited Successfully!");
				System.exit(0);

			case 1:
				stock.arrange(stocks, 0, stocks.length - 1, true);
				break;

			case 2:
				stock.arrange(stocks, 0, stocks.length - 1, false);
				break;

			case 3:
				stock.countPriceChange(price_change, true);
				break;

			case 4:
				stock.countPriceChange(price_change, false);
				break;

			case 5:

				System.out.println("Enter the stock price!");
				double stock_price = sc.nextDouble();
				double result = stock.searchStock(stocks, stock_price);

				if (result != 0)
					System.out.println("\nStock of value " + result + " is present.");
				else
					System.out.println("\nStock of value " + stock_price + " is not present.");

				break;

			case 6:
				System.out.println("Exited Successfully!");
				System.exit(0);

			default:
				System.out.println("Please enter valid option");
				break;

			}

		} while (choice > 0);

		sc.close();
	}
}
