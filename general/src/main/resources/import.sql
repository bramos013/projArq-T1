INSERT INTO aeronaves (prefixo,autonomia,velocidade_Cruzeiro) VALUES ('PR-GUO', 300000, 850);
INSERT INTO aeronaves (prefixo,autonomia,velocidade_Cruzeiro) VALUES ('PR-MHZ', 6500000, 900);
INSERT INTO aeronaves (prefixo,autonomia,velocidade_Cruzeiro) VALUES ('VP-SLR',100000, 950);
INSERT INTO aeronaves (prefixo,autonomia,velocidade_Cruzeiro) VALUES ('PR-XME',100000, 950);

insert into ocupacoes_aerovias ( data , slot_horario , nivel_alti ) values ('2004-12-19', 21, 1);
insert into ocupacoes_aerovias ( data , slot_horario , nivel_alti ) values ('2004-10-13', 20, 2);
insert into ocupacoes_aerovias ( data , slot_horario , nivel_alti ) values ('2004-11-10', 18, 3);
insert into ocupacoes_aerovias ( data , slot_horario , nivel_alti ) values ('2004-11-19', 17, 4);
insert into ocupacoes_aerovias ( data , slot_horario , nivel_alti ) values ('2004-09-19', 12, 5);

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

insert into planos_de_voo ( id_voo , vel_cruzeiro , altitude , data , aeronave_id , rota_id , horario_partida, liberar_rota ) values ('fligthSecurity', 800, 30000, '2004-12-19', 1,2, 12,true);	
insert into planos_de_voo ( id_voo , vel_cruzeiro , altitude , data , aeronave_id , rota_id , horario_partida, liberar_rota ) values ('fligth', 700, 19000, '2004-10-13', 2,1, 04,true)	;
insert into planos_de_voo ( id_voo , vel_cruzeiro , altitude , data , aeronave_id , rota_id , horario_partida, liberar_rota ) values ('fligthGO', 1000, 31000, '2004-11-10', 3,2, 06,true);
insert into planos_de_voo ( id_voo , vel_cruzeiro , altitude , data , aeronave_id , rota_id , horario_partida, liberar_rota ) values ('fligthGOAL', 600, 32000, '2004-09-19', 3,1, 19,true);