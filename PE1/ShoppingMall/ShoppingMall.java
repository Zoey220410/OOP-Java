public class ShoppingMall {
    public static void main(String[] args){
        /* Name: Congyan Li
           Fun Fact: I've seen hundreds of episodes of the Korean variety show Running man.
         */
        int cash = 100;
        double taxRate = 1.13;
        double subtotal = 58.62;
        String name = "Congyan Li";

        double change = cash - subtotal * taxRate;
        // First shift the decimal point two places to the left to get the integer, then shift the decimal point two places to the right.
        double changeTrunc = (int) (change * 100) / 100.0;

        System.out.println(name + " has $" + changeTrunc + " dollars remaining!\n" + name + " started with $" + cash + " dollars!");
    }
}
