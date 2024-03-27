package com.novemberecho.payment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payment_id;

    public Payment(String departure_city, String arrival_city, String price) {
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.price = price;
    }

    private String departure_city;
    private String arrival_city;
    private String price;
}
