import java.util.*;

interface Observer {
    void update(String stockName, double price);
}

class MobileApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Mobile App: " + stockName + " price updated to " + price);
    }
}

class WebApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Web App: " + stockName + " price updated to " + price);
    }
}

interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket("TCS", 3500);

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stock.registerObserver(mobile);
        stock.registerObserver(web);

        stock.setPrice(3600);
    }
}