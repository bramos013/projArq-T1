INSERT INTO aeronaves (prefixo,autonomia,velocidade_Cruzeiro) VALUES ('PR-GUO', 300000, 850);
INSERT INTO aeronaves (prefixo,autonomia,velocidade_Cruzeiro) VALUES ('PR-MHZ', 6500000, 900);
INSERT INTO aeronaves (prefixo,autonomia,velocidade_Cruzeiro) VALUES ('VP-SLR',100000, 950);
INSERT INTO aeronaves (prefixo,autonomia,velocidade_Cruzeiro) VALUES ('PR-XME',100000, 950);

insert into ocupacoes_aerovias ( data , horario , nivel_alti ) values ('2004-12-19', 21, 1);
insert into ocupacoes_aerovias ( data , horario , nivel_alti ) values ('2004-10-19', 20, 2);
insert into ocupacoes_aerovias ( data , horario , nivel_alti ) values ('2004-11-10', 18, 3);
insert into ocupacoes_aerovias ( data , horario , nivel_alti ) values ('2004-11-19', 17, 4);
insert into ocupacoes_aerovias ( data , horario , nivel_alti ) values ('2004-09-19', 12, 5);

INSERT INTO refs_geos (nome, latitude, longitude) VALUES ('(A2) Aeroporto de Congonhas', -23.626944, -46.655833)
INSERT INTO refs_geos (nome, latitude, longitude) VALUES ('(A3) Aeroporto Internacional Salgado Filho', -29.993889, -51.171667)
INSERT INTO refs_geos (nome, latitude, longitude) VALUES ('(A4) Aeroporto Internacional de Confins', -19.633333, -43.968056)
INSERT INTO refs_geos (nome, latitude, longitude) VALUES ('(P1) Referência Geográfica intermediária (Curitiba)', -25.528056, -49.175833)


insert into aerovias ( nome , distancia , origem_id , destino_id , ocupacao_id) values ('av1', 2000, 1, 2, 1);
insert into aerovias ( nome , distancia , origem_id , destino_id , ocupacao_id) values ('av2', 4000, 2, 1, 2);
insert into aerovias ( nome , distancia , origem_id , destino_id , ocupacao_id) values ('av3', 8000, 2, 3, 3);
insert into aerovias ( nome , distancia , origem_id , destino_id , ocupacao_id) values ('av4', 2000, 3, 2, 4);
insert into aerovias ( nome , distancia , origem_id , destino_id , ocupacao_id) values ('av5', 8000, 3, 1, 5);

insert into rotas (nome, aerovia_id) values ('A', 1);
insert into rotas (nome, aerovia_id) values ('B', 2);
insert into rotas (nome, aerovia_id) values ('C', 3);
insert into rotas (nome, aerovia_id) values ('D', 4);
insert into rotas (nome, aerovia_id) values ('E', 5);

--INSERT INTO plano_de_voo (id_voo, altitude, data, vel_cruzeiro, aeronave_id) VALUES ('565', 28000, '2022-12-31', 900, 'PR-GUO');
--INSERT INTO plano_de_voo (id_voo, altitude, data, vel_cruzeiro, aeronave_id) VALUES ('435', 28000, '2019-06-15', 900, 'PR-MHZ');
--INSERT INTO plano_de_voo (id_voo, altitude, data, vel_cruzeiro, aeronave_id) VALUES ('147', 25000, '2020-06-23', 900, 'VP-SLR');
--INSERT INTO plano_de_voo (id_voo, altitude, data, vel_cruzeiro, aeronave_id) VALUES ('789', 28000, '2022-01-04', 900, 'PR-GUO');
--INSERT INTO plano_de_voo (id_voo, altitude, data, vel_cruzeiro, aeronave_id) VALUES ('889', 25000, '2022-09-09', 900, 'PR-GUO');
--INSERT INTO plano_de_voo (id_voo, altitude, data, vel_cruzeiro, aeronave_id) VALUES ('333', 28000, '2022-10-08', 900, 'PR-XME');
--INSERT INTO plano_de_voo (id_voo, altitude, data, vel_cruzeiro, aeronave_id) VALUES ('456', 35000, '2022-11-07', 900, 'PR-GUO');
--
--
--INSERT INTO rotas_planos_de_voo (rota_nome, planos_de_voo_id_voo) VALUES ('A1->A2', 'Av1');
--
--//		RotaAeroviaPK pk1 = new RotaAeroviaPK(rota1, aerovia1);
--//		RotaAeroviaPK pk2 = new RotaAeroviaPK(rota2, aerovia2);
--//		RotaAeroviaPK pk3 = new RotaAeroviaPK(rota3, aerovia4);
--//		RotaAeroviaPK pk4 = new RotaAeroviaPK(rota3, aerovia7);
--//		RotaAeroviaPK pk5 = new RotaAeroviaPK(rota3, aerovia3);
--//		RotaAeroviaPK pk6 = new RotaAeroviaPK(rota4, aerovia4);
--//		RotaAeroviaPK pk7 = new RotaAeroviaPK(rota4, aerovia5);
--//		RotaAeroviaPK pk8 = new RotaAeroviaPK(rota5, aerovia4);
--//		RotaAeroviaPK pk9 = new RotaAeroviaPK(rota5, aerovia7);
--//		RotaAeroviaPK pk10 = new RotaAeroviaPK(rota6, aerovia3);
--//		RotaAeroviaPK pk11 = new RotaAeroviaPK(rota7, aerovia9);
--
--//		RotaAerovia rotaAerovia1 = new RotaAerovia(pk1);
--//		RotaAerovia rotaAerovia2 = new RotaAerovia(pk2);
--//		RotaAerovia rotaAerovia3 = new RotaAerovia(pk3);
--//		RotaAerovia rotaAerovia4 = new RotaAerovia(pk4);
--//		RotaAerovia rotaAerovia5 = new RotaAerovia(pk5);
--//		RotaAerovia rotaAerovia6 = new RotaAerovia(pk6);
--//		RotaAerovia rotaAerovia7 = new RotaAerovia(pk7);
--//		RotaAerovia rotaAerovia8 = new RotaAerovia(pk8);
--//		RotaAerovia rotaAerovia9 = new RotaAerovia(pk9);
--//		RotaAerovia rotaAerovia10 = new RotaAerovia(pk10);
--//		RotaAerovia rotaAerovia11 = new RotaAerovia(pk11);
--//
--//		servicoRotaAerovia.saveAll(Arrays.asList(rotaAerovia1, rotaAerovia2, rotaAerovia3, rotaAerovia4, rotaAerovia5, rotaAerovia6, rotaAerovia7, rotaAerovia8, rotaAerovia9, rotaAerovia10, rotaAerovia11));
--
