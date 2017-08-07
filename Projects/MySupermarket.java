public class MySupermarket implements SupermarketInterface {
	private Queue [] clerks;
	private int [] time;

	public void buildMarket(int numClerks, int lineCapacity) {
		clerks = new Queue[numClerks];
		time = new int[numClerks];

		for (int i=0; i < numClerks; i++) {
			clerks[i] = new Queue(lineCapacity);
			time[i] = 0;
		}
	}


	private int getMinutes() {
		int minutes = -1;

		for (int i = 0; i < time.length; i++) {
			if (!clerks[i].isFull()) {
				minutes = i;
				break;
			}
		}

		if ( minutes == -1)
			return minutes;

		for (int j = minutes+1; j < time.length; j++) {
			if (!clerks[j].isFull() && time[j] < time[minutes])
				minutes = j;
		}

		return minutes;
	}

	public boolean addCustomer(int numItems) {
		if (numItems <= 0)
			return false;

		int minutes = getMinutes();

		if (minutes < 0)
			return false;

		clerks[minutes].insert(numItems);
		time[minutes] += numItems + 1;

		return true;
	}

	public int tick() {
		int count = 0;

		for (int i = 0; i < clerks.length; i++) {
			if (clerks[i].isEmpty()){
				continue;
			}

			if (clerks[i].peekFront() == 0) {
				clerks[i].remove();
				count++;
			}
			else {
				clerks[i].setFront(clerks[i].peekFront() -1);
			}
		}

		return count;
	}
}