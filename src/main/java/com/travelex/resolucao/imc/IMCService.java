package com.travelex.resolucao.imc;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class IMCService {

    public Double calculateIMC(Double weight, Double height) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(weight / (height * height)));
    }

    public String createResultStringForUser(Double imc) {
        return "Seu IMC é de: " + imc + " e você está na faixa de peso: " + WeightRangeEnum.calculateWeigthRange(imc).getWeightRangeDTO();
    }
}
