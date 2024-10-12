package com.example.xmen;

import com.example.xmen.services.AdnServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XmenApplicationTests {

	@Autowired
	public AdnServiceImpl service;

	//test propuestos por el profe
	@Test
	public void arrayVacio() {
		String[] adn = {};
		Assumptions.assumeFalse(service.isMutant(adn));

	}

	@Test
	public void arrayNxM() {
		String[] adn = {
				"BBBBB",
				"BBBBB",
				"BBBBB",
				"BBBBB"
		};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.isMutant(adn);
		});
	}

	@Test
	public void arrayNumeros() {
		String[] adn = {
				"5555",
				"5555",
				"5555",
				"5555"
		};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.isMutant(adn);
		});
	}
	@Test
	public void recibirNull(){
		Assertions.assertThrows(NullPointerException.class, ()->{service.isMutant(null);});
	}

	@Test
	public void arrayOtrasLetras() {
		String[] adn = {
				"BBBB",
				"HHHH",
				"BBBB",
				"HHHH"
		};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.isMutant(adn);
		});
	}

	@Test
	public void prueba1() {
		String[] adn = {
				"AAAA",
				"CCCC",
				"TCAG",
				"GGTC"
		};
		Assumptions.assumeTrue(service.isMutant(adn));
	}

	@Test
	public void prueba2() {
		String[] adn = {
				"AAAT",
				"AACC",
				"AAAC",
				"CGGG"
		};
		Assumptions.assumeFalse(service.isMutant(adn));
	}

	@Test
	public void prueba3() {
		String[] adn = {
				"TGAC",
				"AGCC",
				"TGAC",
				"GGTC"
		};
		Assumptions.assumeTrue(service.isMutant(adn));
	}

	@Test
	public void prueba4() {
		String[] adn = {
				"AAAA",
				"AAAA",
				"AAAA",
				"AAAA"
		};
		Assumptions.assumeTrue(service.isMutant(adn));
	}

	@Test
	public void prueba5() {
		String[] adn = {
				"TGAC",
				"ATCC",
				"TAAG",
				"GGTC"
		};
		Assumptions.assumeFalse(service.isMutant(adn));
	}
	@Test
	public void prueba6() {
		String[] adn = {
				"TCGGGTGAT",
				"TGATCCTTT",
				"TACGAGTGA",
				"AAATGTACG",
				"ACGAGTGCT",
				"AGACACATG",
				"GAATTCCAA",
				"ACTACGACC",
				"TGAGTATCC"
		};
		Assumptions.assumeTrue(service.isMutant(adn));
	}
	@Test
	public void prueba7() {
		String[] adn = {
				"TTTTTTTTT",
				"TTTTTTTTT",
				"TTTTTTTTT",
				"TTTTTTTTT",
				"CCGACCAGT",
				"GGCACTCCA",
				"AGGACACTA",
				"CAAAGGCAT",
				"GCACTCCCC"
		};
		Assumptions.assumeTrue(service.isMutant(adn));
	}
}