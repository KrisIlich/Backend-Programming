package com.d288.d288backendprogramming.services;

import com.d288.d288backendprogramming.dao.CartItemRepository;
import com.d288.d288backendprogramming.dao.CartRepository;
import com.d288.d288backendprogramming.dao.CustomerRepository;
import com.d288.d288backendprogramming.entities.CartItem;
import com.d288.d288backendprogramming.entities.Cart;
import com.d288.d288backendprogramming.entities.Customer;
import com.d288.d288backendprogramming.entities.StatusType;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutSerivceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;


    public CheckoutSerivceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout(Purchase purchase) {
        try {
            Cart cart = purchase.getCart();
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);
            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> cart.add(item));
            cart.setStatus(StatusType.ordered);
            Customer customer = purchase.getCustomer();
            cartRepository.save(cart);
            customer.add(cart);
            return new PurchaseResponse(orderTrackingNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cart is null or cart items are empty");
        }

        }


    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
