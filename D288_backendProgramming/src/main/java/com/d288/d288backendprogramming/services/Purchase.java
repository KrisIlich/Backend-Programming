package com.d288.d288backendprogramming.services;


import com.d288.d288backendprogramming.entities.CartItem;
import com.d288.d288backendprogramming.entities.Cart;
import com.d288.d288backendprogramming.entities.Customer;
import com.d288.d288backendprogramming.entities.StatusType;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
    private StatusType status;

}
