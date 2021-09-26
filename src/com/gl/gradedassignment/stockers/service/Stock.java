package com.gl.gradedassignment.stockers.service;

public class Stock {

	public void arrange(double[] stocks, int low, int high, boolean flag) {

		sort(stocks, low, high, flag);

		if (flag == true) {
			System.out.println("\nStock prices in ascending order are: \n");
			for (int i = 0; i < stocks.length; i++)
				System.out.print(stocks[i] + " ");
		} else {
			System.out.println("\nStock prices in descending order are: \n");
			for (int i = 0; i < stocks.length; i++)
				System.out.print(stocks[i] + " ");
		}

	}

	public void sort(double[] stocks, int low, int high, boolean flag) {

		if (low < high) {

			int mid = (low + high) / 2;
			sort(stocks, low, mid, flag);
			sort(stocks, mid + 1, high, flag);
			merge(stocks, low, mid, high, flag);
		}
	}

	public void merge(double[] stocks, int low, int mid, int high, boolean flag) {

		int f = mid - low + 1;
		int s = high - mid;

		double[] firsthalf = new double[f];
		double[] secondhalf = new double[s];

		for (int i = 0; i < f; i++) {
			firsthalf[i] = stocks[low + i];
		}
		for (int i = 0; i < s; i++) {
			secondhalf[i] = stocks[mid + 1 + i];
		}

		int i = 0, j = 0, k = low;

		if (flag == true) {

			for (; i < f && j < s; k++) {

				if (firsthalf[i] <= secondhalf[j]) {
					stocks[k] = firsthalf[i];
					i++;
				} else {
					stocks[k] = secondhalf[j];
					j++;
				}

			}
		} else {

			for (; i < f && j < s; k++) {

				if (firsthalf[i] >= secondhalf[j]) {
					stocks[k] = firsthalf[i];
					i++;
				} else {
					stocks[k] = secondhalf[j];
					j++;
				}
			}

		}

		while (i < f) {
			stocks[k] = firsthalf[i];
			k++;
			i++;
		}

		while (i < s) {
			stocks[k] = secondhalf[j];
			k++;
			j++;
		}

	}

	public void countPriceChange(Boolean[] pricechange, boolean rise) {

		int up = 0;
		int fall = 0;

		for (int i = 0; i < pricechange.length; i++) {

			if (pricechange[i] == true)
				up++;
			else
				fall++;

		}

		if (rise == true)
			System.out.println("\nTotal no. of companies whose stock price rose today : " + up);
		else
			System.out.println("\nTotal no. of companies whose stock price declined today : " + fall);

	}

	public double searchStock(double[] stocks, double stock_price) {

		for (int i = 0; i < stocks.length; i++) {
			if (stock_price == stocks[i])
				return stock_price;
		}

		return 0;
	}

}
