import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DiscountCuponTest {

    /*
   We first check whether the user has a coupon or not.

        1. If he has a coupon, our " yesCupon" method works.
    - The coupon should logically be between 0 and 100 and greater than zero and less than 100 should be equal.
    - If the coupon is greater than 0 and less than 20, the user can use the coupon "All products".
    - If the coupon is equal to greater than 20 and less than 35, the redeemer can use the coupon on "Shirts && Pants"
    - If the coupon is equal to or greater than 35 and less than 50, the user can redeem the coupon for "Glasses"
    - If the coupon is equal to greater than 50 and less than 100, the user can redeem the coupon on "Red Labeled Products"

      Test Data;
         this algorithm is tested with (-1)-0-1- 19-20-21-34-35-36-49-50-51-99-100-101 data
         We check whether it works properly or not. Here we do a boundary value analysis test.
      2. If there are no coupons, our "noCupon" method works.
        A. If the user is a new member;
             we give a coupon of 0.15 valid for the first purchase.
        B. if the user is not a new member and has not shopped for more than a year;
             we give a 0.10 coupon valid for the first purchase.
 */



    public static void main(String[] args) {

        LocalDate lastShoppingDate = LocalDate.of(2022, 10, 15);
        LocalDate currentDate = LocalDate.of(2023, 10, 15);
        boolean newCustomer = true;
        boolean haveCupon = true;
        double cupon = 30;

        if (haveCupon) {
            System.out.println(yesCupon(cupon));
        } else {
            System.out.println("You have a " + noCupon(newCustomer, lastShoppingDate, currentDate) + " cupon for first shopping");
            ;
        }

    }


    public static double noCupon(boolean newCustomer, LocalDate lastShoppingDate, LocalDate currentDate) {

        long day = ChronoUnit.DAYS.between(lastShoppingDate, currentDate);
        double cupon = 0;
        if (newCustomer) {
            cupon = 0.15;
        } else if (!newCustomer && day > 365) {
            cupon = 0.10;
        }
        return cupon;
    }

    public static String yesCupon(double cupon) {
        String products = "";
        if (cupon > 0 && cupon <= 100) {
            if (cupon > 0 && cupon < 20) {
                products += "All products";
            } else if (cupon >= 20 && cupon < 35) {
                products += "Shirt && Pants";
            } else if (cupon >= 35 && cupon < 50) {
                products += "Glasess";
            } else if (cupon >= 50 && cupon <= 100) {
                products += "Red Labeled Products";
            }
        } else {
            System.out.println("Wrong cupon");
        }

        return products;
    }


}
