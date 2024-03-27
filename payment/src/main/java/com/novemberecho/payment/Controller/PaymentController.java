package com.novemberecho.payment.Controller;

import com.novemberecho.payment.Entity.Payment;
import com.novemberecho.payment.Service.paymentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    //    @Autowired
//    RestTemplate restTemplate;
    @Autowired
    paymentservice paymentservice;

    @RequestMapping("/m1")
    public String m1() {
        return "hello";
    }


    @PostMapping("/data/{departure}/{arrival}/{price}")
    public ResponseEntity<Payment> receive(@PathVariable("departure") String dep, @PathVariable("arrival") String arr,
                                           @PathVariable("price") String price) {
        Payment payment = new Payment(dep, arr, price);
        paymentservice.savepayment(payment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetch/{departure}/{arrival}")
    public ResponseEntity<Payment> fetchPrice(@PathVariable("departure") String dep, @PathVariable("arrival") String arr) {
        Payment prices = paymentservice.getPricesbyCity(dep, arr);
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }


}
