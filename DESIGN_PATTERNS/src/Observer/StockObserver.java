package Observer;

public class StockObserver implements Observer {
	private double ibmPrice;
	private double applePrice;
	private double googlePrice;

	private StockGrabber stockGrabber;

	private int observerID;

	private int observerIDTracker = 0;

	public StockObserver(StockGrabber stockGrabber) {
		this.stockGrabber = stockGrabber;
		this.observerID = ++observerIDTracker;

		System.out.println("New observer : " + observerID);

		stockGrabber.register(this);
	}

	@Override
	public void update(double ibmPrice, double applePrice, double googlePrice) {
		this.ibmPrice = ibmPrice;
		this.applePrice = applePrice;
		this.googlePrice = googlePrice;

		printThePrices();
	}

	private void printThePrices() {
		System.out.println(observerID + "\nIBM Price: " + ibmPrice + "\nAPPLE Price: " + applePrice + "\nGOOGLE Price: "
				+ googlePrice + "\n");
	}

}
