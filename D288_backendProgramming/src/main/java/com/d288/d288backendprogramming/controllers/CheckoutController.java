package com.d288.d288backendprogramming.controllers;
import com.d288.d288backendprogramming.services.CheckoutService;
import com.d288.d288backendprogramming.services.Purchase;
import com.d288.d288backendprogramming.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }
    @PostMapping("/purchase")
    public PurchaseResponse checkout(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.checkout(purchase);
        return purchaseResponse;
    }
}
