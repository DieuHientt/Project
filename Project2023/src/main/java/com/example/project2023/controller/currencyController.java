package com.example.project2023.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.example.project2023.model.currency;
import com.example.project2023.repository.currencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/currency")
public class currencyController {
//
//    @Autowired
//    private com.example.project2023.repository.currencyRepository currencyRepository;
//
//    @GetMapping("/get-all-currency")
//    public List<currency> getAllCurrency(){
//        List<currency> allCurrencyList = (List<currency>) currencyRepository.findAll();
//        return allCurrencyList;
//    }
//
//    @GetMapping ("/get-currency/{id}")
//    public currency getCurrencyId(@PathVariable( value = "id") Integer currency_id)
//    {
//        currency currency = currencyRepository.findById(currency_id).get();
//        return currency;
//    }
//
//    @PostMapping ("/create-currency")
//    public currency createCurrency (@RequestBody currency currency){
//        currency savedCurrency = currencyRepository.save(currency);
//        return savedCurrency;
//    }
//
//    @PutMapping("/update-currency/{id}")
//    public ResponseEntity<currency> updateCurrency(@PathVariable(value = "id") Integer currency_id,
//                                                         @RequestBody currency currencyDetails) {
//        currency currency = currencyRepository.findById(currency_id).get();
//
//        currency.setCurrency_id(currencyDetails.getCurrency_id());
//        currency.setName_currency(currencyDetails.getName_currency());
//
//        final currency  updatedCurrency =  currencyRepository.save(currency);
//        return ResponseEntity.ok(updatedCurrency);
//    }
//
//    @DeleteMapping("/delete-currency/{id}")
//    public Map<String, Boolean> deletecurrency(@PathVariable(value = "id") Integer currency_id)
//    {
//        currency currency = currencyRepository.findById(currency_id).get();
//
//        currencyRepository.delete(currency);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
//

}
