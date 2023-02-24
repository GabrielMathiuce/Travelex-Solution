package com.travelex.resolucao.imc;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class IMCService {

    public Double calculateIMC(Double weight, String height) {
        DecimalFormat df = new DecimalFormat("#.##");
        Double handledHeight = handleHeightInput(height);
        return Double.parseDouble(df.format(weight / (handledHeight * handledHeight)).replace(",","."));
    }

    public String createResultStringForUser(Double imc) {
        return "Seu IMC é de: " + imc + " e você está na faixa de peso: " + WeightRangeEnum.calculateWeigthRange(imc).getWeightRangeDTO();
    }

    private Double handleHeightInput(String height) {
        if(height.contains(".")) return Double.parseDouble(height);
        else return Double.parseDouble(height) / 100;
    }
}
