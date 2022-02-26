package com.example.ecommercesoap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProductService {

    DB db = new DB();
    Connection connection = connectionClass.getConnection();

    // function to add discount
    public String addDiscount(int id, int discount) {
        String sql = "SELECT id FROM shop WHERE id ='" + id + "'";

        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            if (result.next()) {
                return "Product doesn't exist!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (discount == 0) {
            return "Invalid input!";
        }

        String sql1 = "UPDATE shop SET discount = '" + discount + "' WHERE id = '" + id + "'";

        try {
            PreparedStatement s = connection.prepareStatement(sql1);
            s.setInt(1, discount);
            s.setInt(2, id);
            s.executeUpdate();

            return "Discount added!";
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "Error!";
    }
    // get product discount
    public int getProductDiscount(int id) {
        String sql = "SELECT discount FROM shop WHERE id ='" + id + "'";

        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            if (result.next()) {
                return result.getInt("discount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // function to list all products with discount
    public List<Product> productsWithDiscount() {
        String sql = "SELECT * FROM shop WHERE discount > 0";

        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            if (result.next()) {
                return db.getProducts(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // function to list products with discount bigger than 50%
    public List<Product> productsWithDiscountBiggerThan50( int discount) {

        String sql = "SELECT * FROM shop WHERE discount > 50";


        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            if (result.next()) {
                return db.getProducts(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // function to list discounts by category
    public List<Product> productsWithDiscountByCategory(String category) {

        String sql = "SELECT * FROM shop WHERE category = '" + category + "' AND discount > 0";

        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            if (result.next()) {
                return db.getProducts(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // delete product discount
    public String deleteDiscount(int id) {
        String sql = "SELECT id FROM shop WHERE id ='" + id + "'";

        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            if (result.next()) {
                return "Product doesn't exist!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql1 = "UPDATE shop SET discount = '0' WHERE id = '" + id + "'";

        try {
            PreparedStatement s = connection.prepareStatement(sql1);
            s.setInt(1, id);
            s.executeUpdate();

            return "Discount deleted!";
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "Error!";
    }

    // delete discount from all products
    public String deleteDiscountFromAllProducts() {
        String sql = "UPDATE shop SET discount = '0'";

        try {
            PreparedStatement s = connection.prepareStatement(sql);
            s.executeUpdate();

            return "Discount deleted from all products!";
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "Error!";
    }

    // list products with discount that expires in less than three days
    public List<Product> productsWithDiscountExpiresInLessThanThreeDays() {
        String sql = "SELECT * FROM shop WHERE discount > 0 AND date_expire < CURRENT_DATE + 3";

        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            if (result.next()) {
                return db.getProducts(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // prolong discount data expire date
    public String prolongDiscount(int id, int days) {
        String sql = "SELECT id FROM shop WHERE id ='" + id + "'";

        try {
            ResultSet result = connection.createStatement().executeQuery(sql);
            if (result.next()) {
                return "Product doesn't exist!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql1 = "UPDATE shop SET date_expire = date_expire + '"+days+"' WHERE id = '" + id + "'";

        try {
            PreparedStatement s = connection.prepareStatement(sql1);
            s.setInt(1, id);
            s.executeUpdate();

            return "Discount prolonged for "+days+" days!";
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "Error!";
    }

}


}
