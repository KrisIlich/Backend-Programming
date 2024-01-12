package com.d288.d288backendprogramming.entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "excursions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartitems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name = "excursion_price", nullable = false)
    private BigDecimal excursion_price;

    @Column(name = "excursion_title", nullable = false)
    private String excursion_title;

    @Column(name = "image_url", nullable = false)
    private String image_URL;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private Date last_update;

}
