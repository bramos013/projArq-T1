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

		RefGeo refGeo1 = new RefGeo("(A1) Aeroporto Santos Dummont", -22.910000, -43.163056);
		RefGeo refGeo2 = new RefGeo("(A2) Aeroporto de Congonhas", -23.626944, -46.655833);
		RefGeo refGeo3 = new RefGeo("(A3) Aeroporto Internacional Salgado Filho", -29.993889, -51.171667);
		RefGeo refGeo4 = new RefGeo("(A4) Aeroporto Internacional de Confins", -19.633333, -43.968056);
		RefGeo refGeo5 = new RefGeo("(P1) Referência Geográfica intermediária (Curitiba)", -25.528056, -49.175833);

		servicoRefGeo.saveAll(Arrays.asList(refGeo1, refGeo2, refGeo3, refGeo4, refGeo5));

		Aerovia aerovia1 = new Aerovia("Av1", refGeo1, refGeo2, 367);
		Aerovia aerovia2 = new Aerovia("Av2", refGeo2, refGeo1, 367);
		Aerovia aerovia3 = new Aerovia("Av3", refGeo3, refGeo2, 1600);
		Aerovia aerovia4 = new Aerovia("Av4", refGeo1, refGeo5, 700);
		Aerovia aerovia5 = new Aerovia("Av5", refGeo4, refGeo1, 500);
		Aerovia aerovia6 = new Aerovia("Av6", refGeo5, refGeo4, 631);
		Aerovia aerovia7 = new Aerovia("Av7", refGeo5, refGeo3, 1600);
		Aerovia aerovia8 = new Aerovia("Av8", refGeo4, refGeo3, 1800);
		Aerovia aerovia9 = new Aerovia("Av9", refGeo3, refGeo4, 1800);
		Aerovia aerovia10 = new Aerovia("Av10", refGeo2, refGeo5, 450);

		servicoAerovia.saveAll(Arrays.asList(aerovia1, aerovia2, aerovia3, aerovia4, aerovia5, aerovia6, aerovia7, aerovia8, aerovia9, aerovia10));

		Rota rota1 = new Rota("A1->A2");
		Rota rota2 = new Rota("A2->A1");
		Rota rota3 = new Rota("A1->A2");
		Rota rota4 = new Rota("A1->A4");
		Rota rota5 = new Rota("A4->A3");
		Rota rota6 = new Rota("A3->A2");
		Rota rota7 = new Rota("A3->A4");
		Rota rota8 = new Rota("A4->A1");
		Rota rota9 = new Rota("A3->A1");
		Rota rota10 = new Rota("A2->A3");

		servicoRota.saveAll(Arrays.asList(rota1, rota2, rota3, rota4, rota5, rota6, rota7, rota8, rota9, rota10));

		RotaAeroviaPK pk1 = new RotaAeroviaPK(rota1, aerovia1);
		RotaAeroviaPK pk2 = new RotaAeroviaPK(rota2, aerovia2);
		RotaAeroviaPK pk3 = new RotaAeroviaPK(rota3, aerovia4);
		RotaAeroviaPK pk4 = new RotaAeroviaPK(rota3, aerovia7);
		RotaAeroviaPK pk5 = new RotaAeroviaPK(rota3, aerovia3);
		RotaAeroviaPK pk6 = new RotaAeroviaPK(rota4, aerovia4);
		RotaAeroviaPK pk7 = new RotaAeroviaPK(rota4, aerovia5);
		RotaAeroviaPK pk8 = new RotaAeroviaPK(rota5, aerovia4);
		RotaAeroviaPK pk9 = new RotaAeroviaPK(rota5, aerovia7);
		RotaAeroviaPK pk10 = new RotaAeroviaPK(rota6, aerovia3);
		RotaAeroviaPK pk11 = new RotaAeroviaPK(rota7, aerovia9);

		RotaAerovia rotaAerovia1 = new RotaAerovia(pk1);
		RotaAerovia rotaAerovia2 = new RotaAerovia(pk2);
		RotaAerovia rotaAerovia3 = new RotaAerovia(pk3);
		RotaAerovia rotaAerovia4 = new RotaAerovia(pk4);
		RotaAerovia rotaAerovia5 = new RotaAerovia(pk5);
		RotaAerovia rotaAerovia6 = new RotaAerovia(pk6);
		RotaAerovia rotaAerovia7 = new RotaAerovia(pk7);
		RotaAerovia rotaAerovia8 = new RotaAerovia(pk8);
		RotaAerovia rotaAerovia9 = new RotaAerovia(pk9);
		RotaAerovia rotaAerovia10 = new RotaAerovia(pk10);
		RotaAerovia rotaAerovia11 = new RotaAerovia(pk11);

		servicoRotaAerovia.saveAll(Arrays.asList(rotaAerovia1, rotaAerovia2, rotaAerovia3, rotaAerovia4, rotaAerovia5, rotaAerovia6, rotaAerovia7, rotaAerovia8, rotaAerovia9, rotaAerovia10, rotaAerovia11));

		PlanoDeVoo planoVoo1 = new PlanoDeVoo("565", Instant.parse("2019-06-15T12:30:00Z"), 25000, rota1, 950);
		PlanoDeVoo planoVoo2 = new PlanoDeVoo("435", Instant.parse("2019-07-16T15:45:00Z"), 35000, rota2, 950);
		PlanoDeVoo planoVoo3 = new PlanoDeVoo("147", Instant.parse("2019-08-17T17:45:00Z"), 35000, rota3, 950);
		PlanoDeVoo planoVoo4 = new PlanoDeVoo("789", Instant.parse("2020-06-15T12:30:00Z"), 35000, rota4, 950);
		PlanoDeVoo planoVoo5 = new PlanoDeVoo("889", Instant.parse("2020-07-16T15:45:00Z"), 35000, rota5, 950);
		PlanoDeVoo planoVoo6 = new PlanoDeVoo("123", Instant.parse("2020-08-17T17:45:00Z"), 35000, rota6, 950);
		PlanoDeVoo planoVoo7 = new PlanoDeVoo("456", Instant.parse("2021-06-15T12:30:00Z"), 35000, rota7, 950);
		PlanoDeVoo planoVoo8 = new PlanoDeVoo("259", Instant.parse("2021-07-16T15:45:00Z"), 35000, rota8, 950);
		PlanoDeVoo planoVoo9 = new PlanoDeVoo("669", Instant.parse("2021-08-17T17:45:00Z"), 35000, rota9, 950);
		PlanoDeVoo planoVoo10 = new PlanoDeVoo("791", Instant.parse("2022-06-15T12:30:00Z"), 35000, rota10, 950);
		PlanoDeVoo planoVoo11 = new PlanoDeVoo("331", Instant.parse("2022-07-16T15:45:00Z"), 35000, rota1, 950);
		PlanoDeVoo planoVoo12 = new PlanoDeVoo("232", Instant.parse("2022-08-17T17:45:00Z"), 35000, rota2, 950);

		servicoPlanoDeVoo.saveAll(Arrays.asList(planoVoo1, planoVoo2, planoVoo3, planoVoo4, planoVoo5, planoVoo6, planoVoo7, planoVoo8, planoVoo9, planoVoo10, planoVoo11, planoVoo12));

	}
}