import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    // Qs: Stock data coming in during the day, we need to notify users if the price drops more than 5 %
    public static class Stock {
        String name;
        int price;
        public Stock(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    public interface Observable {
        void add(Observer observer);
        void remove(Observer observer);
        void notifyObservers();
        void setData(int p);
    }

    public interface Observer {
        void update();
    }

    public static class ItcStockObserver1 implements Observer {
        @Override
        public void update() {
            System.out.println("Price has fallen below 5 %");
        }
    }

    public static class StockITCObserverable implements Observable {
        List<Observer> observerList;
        Stock itcStock;

        StockITCObserverable(Stock stock) {
            itcStock = stock;
            observerList = new ArrayList<>();
        }
        @Override
        public void add(Observer observer) {
            observerList.add(observer);
        }
        @Override
        public void remove(Observer observer) {
            observerList.remove(observer);
        }
        @Override
        public void notifyObservers() {
            for (Observer observer: observerList)
                observer.update();
        }
        @Override
        public void setData(int price) {
            double percentage = ((double) (itcStock.price - price) / itcStock.price) * 100;
            // System.out.println(percentage);
            if (percentage >= 5) {
                notifyObservers();
            }
        }
    }

    public static class Driver {

        public static void main(String[] args) {
            // streaming stock price data
            int[] itcStockPrice = {440, 416, 450, 431, 441, 435, 400};
            Stock itcStock = new Stock("itc", 440);
            ItcStockObserver1 observer1 = new ItcStockObserver1();
            StockITCObserverable observerable = new StockITCObserverable(itcStock);
            observerable.add(observer1);

            for (int i: itcStockPrice) {
                observerable.setData(i);
            }
        }
    }

}
