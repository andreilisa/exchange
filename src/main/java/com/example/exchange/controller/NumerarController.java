package com.example.exchange.controller;

import com.example.exchange.entity.Numerar;
import com.example.exchange.entity.NumerarRequest;
import com.example.exchange.service.NumerarService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@Api
@RestController
@RequestMapping("/numerar")
@RequiredArgsConstructor
public class NumerarController {

    private final NumerarService numerarService;

    @PostMapping("/addNewNumerar")
    public void insertNumerar(@RequestBody NumerarRequest numerarRequest){
        numerarService.addNumerar(numerarRequest);
    }

    @PutMapping("/change/{exchangeValue}")
    public Numerar updateNumerar(@PathVariable(value = "exchangeValue") String exchangeValue,@RequestParam Double newSumOfMoney) throws Exception {
       return numerarService.editNumerar(exchangeValue,newSumOfMoney);
    }
}
