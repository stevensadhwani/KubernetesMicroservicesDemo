package com.sadhwani.kubernetes.TransactionService.Payment;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentRepository repository;

    public PaymentController(PaymentRepository repository){
        this.repository= repository;
    }

    @CrossOrigin
    @RequestMapping("/makePayment")
    public String makePayment(@RequestParam(value="amount",defaultValue="0") String amount,
                              @RequestParam(value="payee",defaultValue="Jeff Jefferson") String payee,
                              @RequestParam(value="tranType",defaultValue="pay")String tranType){


        if(Double.parseDouble(amount) <=0 || payee.isEmpty()||
                (!tranType.equalsIgnoreCase("pay") && !tranType.equalsIgnoreCase("collect"))){
            return "error";
        }

        else {

            Payment payment = new Payment();
            payment.setAmount(Double.parseDouble(amount));
            payment.setName(payee);
            payment.setTranType(tranType.equals("pay")? Payment.TranType.PAY : Payment.TranType.COLLECT);
            return repository.save(payment).toString();
        }



    }


}
