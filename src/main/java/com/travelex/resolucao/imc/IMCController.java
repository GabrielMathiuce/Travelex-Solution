package com.travelex.resolucao.imc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/imc")
public class IMCController {

    @Autowired
    private IMCService imcService;

    /**
     * Uma alternativa para a anotacao @Autowired seria a seguinte abordagem:
     * private IMCService imcService = new IMCService();
     */

    @GetMapping(value = "/calculator")
    private ResponseEntity<String> calculateIMC(@RequestParam Double weight, @RequestParam String height) {
        return new ResponseEntity<>(imcService.createResultStringForUser(imcService.calculateIMC(weight, height)), HttpStatus.OK);
    }
}
