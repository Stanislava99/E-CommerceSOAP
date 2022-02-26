package com.example.ecommercesoap;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebService(serviceName = "DiscountService")
public class DiscountService {

    ProductSe   rvice productService = new ProductService();

    @WebMethod(action = "addDiscount")
    public String addDiscount(int id, int discount) {
        return productService.addDiscount(id, discount);
    }

    @WebMethod(action = "removeDiscount")
    public String removeDiscount(int id) {
        return productService.deleteDiscount(id);
    }

    @WebMethod(action = "removeDiscountAll")
    public String deleteDiscountFromAllProducts() {
        return productService.deleteDiscountFromAllProducts();
    }

    @WebMethod(action = "getProductDiscount")
    @WebResult(name = "Product")
    public int getDiscount(int id) {
        return productService.getProductDiscount(id);
    }

    @WebMethod(action ="productsWithDiscount")
    @WebResult(name = "Product")
    public List<Product> productsWithDiscount() {
        return productService.productsWithDiscount();
    }

    @WebMethod(action ="productsWithDiscountBiggerThan50")
    @WebResult(name = "Product")
    public List<Product> productsWithDiscountBiggerThan50() {
        return productService.productsWithDiscountBiggerThan50();
    }

    @WebMethod(action ="productsWithDiscountByCategory")
    @WebResult(name = "Product")
    public List<Product> productsWithDiscountByCategory(String category) {
        return productService.productsWithDiscountByCategory(category);
    }

    @WebMethod(action ="productsDiscountLessThanThreeDays")
    @WebResult(name = "Product")
    public List<Product> productsWithDiscountExpiresInLessThanThreeDays() {
        return productService.productsWithDiscountExpiresInLessThanThreeDays();
    }

    @WebMethod(action ="prolongDiscountDays")
    public String prolongDiscountDays(int id, int days) {
        return productService.prolongDiscount(id,days);
    }


}
