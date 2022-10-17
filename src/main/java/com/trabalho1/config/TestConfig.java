package com.trabalho1.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.trabalho1.negocio.entidades.Aeronave;
import com.trabalho1.negocio.entidades.Aerovia;
import com.trabalho1.negocio.entidades.PlanoDeVoo;
import com.trabalho1.negocio.entidades.RefGeo;
import com.trabalho1.negocio.entidades.Rota;
import com.trabalho1.negocio.entidades.RotaAerovia;
import com.trabalho1.negocio.entidades.classes_associativas.RotaAeroviaPK;
import com.trabalho1.negocio.services.ServicoAeronave;
import com.trabalho1.negocio.services.ServicoAerovia;
import com.trabalho1.negocio.services.ServicoPlanoDeVoo;
import com.trabalho1.negocio.services.ServicoRefGeo;
import com.trabalho1.negocio.services.ServicoRota;
import com.trabalho1.negocio.services.ServicoRotaAerovia;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ServicoAeronave servicoAeronave;

	@Autowired
	private ServicoRota servicoRota;

	@Autowired
	private ServicoAerovia servicoAerovia;

	@Autowired
	private ServicoPlanoDeVoo servicoPlanoDeVoo;

	@Autowired
	private ServicoRefGeo servicoRefGeo;

	@Autowired
	private ServicoRotaAerovia servicoRotaAerovia;

	@Override
	public void run(String... args) throws Exception {

		Aeronave aeronave1 = new Aeronave("PR-GUO", 300000, 850);
		Aeronave aeronave2 = new Aeronave("PR-MHZ", 6500000, 900);
		Aeronave aeronave3 = new Aeronave("VP-SLR", 100000, 950);
		Aeronave aeronave4 = new Aeronave("PR-XME", 200000, 850);

		servicoAeronave.saveAll(Arrays.asList(aeronave1, aeronave2, aeronave3, aeronave4));


	}
}