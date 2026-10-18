
    public class Drink {

        private double price;

        public void setPrice(double price) {
            if (price < 0) {
                throw new IllegalArgumentException("Prisen må ikke være negativ");
            }

            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }


