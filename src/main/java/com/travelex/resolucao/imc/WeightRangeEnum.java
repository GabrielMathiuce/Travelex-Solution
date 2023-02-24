package com.travelex.resolucao.imc;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum WeightRangeEnum {
    ABAIXO_DO_PESO(18.5D, "Abaixo do peso"),
    PESO_NORMAL(24.99D, "Peso Normal"),
    SOBREPESO(29.99D, "Sobrepeso"),
    OBESIDADE_GRAU_UM(34.99D, "Obesidade grau um"),
    OBESIDADE_GRAU_DOIS(39.99D, "Obesidade grau dois"),
    OBESIDADE_GRAU_TRES(40D, "Obesidade grau tres");

    private final Double imc;
    private final String weightRangeDTO;

    public Double getImc() {
        return imc;
    }

    public String getWeightRangeDTO() {
        return weightRangeDTO;
    }
    WeightRangeEnum(Double imc, String weightRangeDTO) {
        this.imc = imc;
        this.weightRangeDTO = weightRangeDTO;
    }

    public static WeightRangeEnum calculateWeigthRange(Double imc) {
        WeightRangeEnum result = null;
            for(WeightRangeEnum weightRangeEnum : Arrays.stream(WeightRangeEnum.values()).sorted((o1, o2) -> o2.getImc().compareTo(o1.getImc())).collect(Collectors.toList())) {
                if (imc < weightRangeEnum.getImc()) {
                    result = weightRangeEnum;
                }
        }
        return result;
    }
}
