package com.novemberecho.payment.Service;

import com.novemberecho.payment.Controller.PaymentController;
import com.novemberecho.payment.Entity.Payment;
import com.novemberecho.payment.Repository.paymentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class paymentservice {
    @Autowired
    private paymentrepo prepo;

    public void savepayment(Payment payment) {
        Payment payment1 = new Payment(payment.getDeparture_city(),
                payment.getArrival_city(), payment.getPrice());
        System.out.println(payment1.getArrival_city());
        prepo.save(payment1);
    }

    public Payment getPricesbyCity(String departure, String arrival) {
        List<Payment> allPrices = prepo.findAll();
        Payment responsePrices = new Payment(); // Initialize the list

        for (int i = 0; i < allPrices.size(); i++) {
            if (allPrices.get(i).getArrival_city().equalsIgnoreCase(arrival) && allPrices.get(i).getDeparture_city().equalsIgnoreCase(departure)) {
                responsePrices = allPrices.get(i);
            }
        }
        return responsePrices;
    }


}
