package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.models.PaymentData;
import br.com.casadocodigo.loja.models.ShoppingCart;
import java.math.BigDecimal;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public Callable<String> checkout() {

        return () -> {
            BigDecimal total = shoppingCart.getTotal();
            String uriToPay = "http://book-payment.herokuapp.com/payment";
            //String uriToPay = "http://localhost:9000/payment";
            try {
                String response = restTemplate.postForObject(uriToPay, new PaymentData(total), String.class);
                return "redirect:/payment/sucess";
            } catch (HttpClientErrorException ex) {
                return "redirect:/payment/error";
            }
        };

    }

}
