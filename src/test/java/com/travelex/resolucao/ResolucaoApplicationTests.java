package com.travelex.resolucao;

import com.travelex.resolucao.classes.Cliente;
import com.travelex.resolucao.classes.ExchangeEntity;
import com.travelex.resolucao.exceptions.BlankNameException;
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

	@Test
	void esperoReceberIMCDe21Ponto72EFaixaDePesoNormal() {
		Assertions.assertEquals(imcService.calculateIMC(57D, 1.62D), 21.72D);
		Assertions.assertEquals(WeightRangeEnum.calculateWeigthRange(21.72D), WeightRangeEnum.PESO_NORMAL);
	}

	@Test
	void esperoReceberONomeSemWhiteSpaces() {
		Cliente cliente = new Cliente("   Gabriel   ");
		Assertions.assertEquals(cliente.getName(), "Gabriel");
	}

	@Test
	void esperoReceberOPrimeiroNome() {
		Cliente cliente = new Cliente("Gabriel Mathiuce da Silva");
		Assertions.assertEquals(cliente.getFirstName(), "Gabriel");
	}

	@Test
	void esperoReceberOSobrenome() {
		Cliente cliente = new Cliente("Gabriel Mathiuce da Silva");
		Assertions.assertEquals(cliente.getSurname(), "Mathiuce da Silva");
	}

	@Test
	void esperoReceberONomeEmCaixaAlta() {
		Cliente cliente = new Cliente("Gabriel Mathiuce da Silva");
		Assertions.assertEquals(cliente.getFullNameToUpperCase(), "GABRIEL MATHIUCE DA SILVA");
	}

	@Test
	void esperoReceberNomeAbreviado() {
		Cliente cliente = new Cliente("Gabriel Mathiuce da Silva");
		Assertions.assertEquals(cliente.getAbbreviatedName(), "Gabriel M. da Silva");
	}
}
