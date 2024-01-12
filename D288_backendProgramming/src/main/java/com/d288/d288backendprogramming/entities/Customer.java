package com.d288.d288backendprogramming.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    public Customer(Division division, String address, String firstName, String lastName, String phone, String postal_code) {
        this.division = division;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.postal_code = postal_code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {

        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;


}
