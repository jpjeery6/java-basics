package wayfair;

import java.util.List;

public class CouponCategory {

    public static void main(String[] args) {
        List<String[]> coupons = List.of(
                new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2022-01-01"},
                new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2018-01-01"},
                new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01"},
                new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2022-01-01"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01"}
        );


        List<String[]> categories = List.of(
                new String[]{"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
                new String[]{"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Bed & Bath", "CategoryParentName:None"},
                new String[]{"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
                new String[]{"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
                new String[]{"CategoryName:Baby And Kids", "CategoryParentName:Null"}
        );
    }

}
