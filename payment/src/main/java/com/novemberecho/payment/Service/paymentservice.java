package com.novemberecho.payment.Service;

import com.novemberecho.payment.Entity.Payment;
import com.novemberecho.payment.Repository.paymentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class paymentservice {
    @Autowired
    private paymentrepo prepo;

    public void savepayment(Payment payment){
        Payment payment1=new Payment(payment.getDeparture_city(),
                payment.getArrival_city(), payment.getPrice());
        System.out.println(payment1.getArrival_city());
        prepo.save(payment1);
    }
}
