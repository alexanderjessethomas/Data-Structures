
class MySupermarketApp {

	public static void main (String [] agrs) {
		MySupermarket market = new MySupermarket();
		market.buildMarket(2, 3);

		int [] customers = { 3, 0, 6, 9, 7, 1, 8, 3, 4, 5, 2, 9};

		for (int i = 0; i < customers.length; i++) {
			if (!market.addCustomer(customers[i]))
				System.out.println ("Customer with items " + customers[i] + " could not be added.");
		}

		for (int i = 1; i <= 20; i++)
			System.out.println (market.tick() + " customers were removed at " + i + " second.");
	}
}
