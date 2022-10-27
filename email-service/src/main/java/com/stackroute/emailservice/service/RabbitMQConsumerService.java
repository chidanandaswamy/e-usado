package com.stackroute.emailservice.service;


import com.stackroute.emailservice.dto.MailRequest;
import com.stackroute.emailservice.model.SlotBooking;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

;

@Component
public class RabbitMQConsumerService {

    @Autowired
    private EmailService service;


    //product added conformation mail
    @RabbitListener(queues = "productMailQueue")
    public void ProductAddedConforming(MailRequest request1) {

        Map<String, Object> model = new HashMap<>();
        model.put("name", "E-usado");
        model.put("productName", request1.getProductName());
        model.put("location", "Banglore, India");
        model.put("productPrice", request1.getProductPrice());
        model.put("productDescription", request1.getProductDescription());
        model.put("productBrand", request1.getProductBrand());
        model.put("productDiscount", request1.getProductDiscount());
        model.put("productManufacturedYear", request1.getProductManufacturedYear());
        model.put("DamageLevel", request1.getProductDamageLevel());
       model.put("productSpecs", request1.getProductSpecs());



         service.sendEmailProductAdded(request1, model);
    }
            //for registration conformation mail
//    @RabbitListener(queues = "User_queue")
//    public void sendEmailThank(MailRequest request2) {
//
//        Map<String, Object> model = new HashMap<>();
//        model.put("Username", request2.getUserName());
//        model.put("UserEmail", request2.getUserEmail());
//
//
//
//         service.sendEmailThankyou(request2, model);
//    }


//
//
//    //slot booked conformation mail
//    @RabbitListener(queues = "User-booking_queue")
//    public void OrderConformation(MailRequest request1) {
//        Map<String, Object> model = new HashMap<>();
//        model.put("name", request1.getProductName());
//        model.put("location", "Banglore, India");
//        model.put("productPrice", request1.getProductPrice());
//        model.put("productName", request1.getProductDescription());
//        model.put("userEmail", request1.getProductBrand());
//        service.sendEmailSlotBooking(request1, model);
//    }
//
    @RabbitListener(queues = "Slot_queue")
    public void sendEmailSlot(SlotBooking request1) {
        Map<String, Object> model = new HashMap<>();
        model.put("slotId", request1.getSlotId());
        model.put("buyerName", request1.getBuyerName());
        model.put("BuyerEmailId", request1.getBuyerEmailId());
        model.put("slotDate", request1.getDate());
        model.put("SlotTime", request1.getDateTimeSlots());
        model.put("sellerName", request1.getSellerName());
        model.put("sellerEmail", request1.getSellerEmailId());
        model.put("SlotDescription", request1.getDescription());
        System.out.println(request1);
        service.sendEmailSlotBooking(request1, model);
    }
}