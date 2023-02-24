package com.travelex.resolucao;

import com.travelex.resolucao.imc.IMCService;
import com.travelex.resolucao.imc.WeightRangeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResolucaoApplicationTests {

	@Autowired
	private IMCService imcService;

	@Test
	void contextLoads() {
	}

	@Test
	void esperoReceberIMCDe27Ponto04() {
		Assertions.assertEquals(imcService.calculateIMC(80D, 1.72), 27.04D);
	}

	@Test
	void esperoReceberFaixaDePesoSobrepeso() {
		Assertions.assertEquals(WeightRangeEnum.calculateWeigthRange(27.04D), WeightRangeEnum.SOBREPESO);
	}

}
