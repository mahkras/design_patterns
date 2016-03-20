package Observer;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable {

	private String stock;
	private int startTime;
	private double price;

	private Subject stockGrabber;

	public GetTheStock(StockGrabber stockGrabber, int newStartTime, String newStock, double newPrice) {
		this.stockGrabber = stockGrabber;
		this.startTime = newStartTime;
		this.stock = newStock;
		this.price = newPrice;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(1000 * startTime);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			double randomNum = (Math.random() * (.06)) - .03;
			DecimalFormat df = new DecimalFormat("#,##");
			price = Double.valueOf(df.format(price + randomNum));

			if (stock == "IBM") {
				((StockGrabber) stockGrabber).setIbmPrice(price);
			}
			if (stock == "APPLE") {
				((StockGrabber) stockGrabber).setApplePrice(price);
			}
			if (stock == "GOOGLE") {
				((StockGrabber) stockGrabber).setGooglePrice(price);
			}
			System.out.println(stock + ": " + df.format((price + randomNum)) + " " + df.format(randomNum));

			System.out.println();

		}
	}

}
