package com.trabalho1.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trabalho1.negocio.entidades.Aeronave;
import com.trabalho1.negocio.repositorios.IAeronaveRepository;


public class AeronaveRepository implements IAeronaveRepository {
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public AeronaveRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcTemplate.execute("DROP TABLE aeronaves IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE aeronaves("
                + "prefixo VARCHAR(100), autonomia int, velocidadedeCruzeiro int, PRIMARY KEY(prefixo))");

        cadastra(new Aeronave("PT-ABC", 10000, 850));
        cadastra(new Aeronave("PR-GUO", 300000, 850));
        cadastra(new Aeronave("PR-MHZ", 6500000, 900));
        cadastra(new Aeronave("VP-SLR", 100000, 950));
        cadastra(new Aeronave("PR-XME", 200000, 850));
    }

    public boolean cadastra(Aeronave aeronave){
        this.jdbcTemplate.update("INSERT INTO aeronaves VALUES(?, ?, ?)",
                aeronave.getPrefixo(), aeronave.getAutonomia(), aeronave.getVelocidadeCruzeiro());
        return true;
    }

    public boolean remove(String nome){
        if(this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM aeronaves WHERE prefixo = ?", Integer.class, nome) == 0){
            return false;
        }else{
            this.jdbcTemplate.update("DELETE FROM aeronaves WHERE prefixo = ?", nome);
            return true;
        }
    }

    public boolean removeTodas(){
        this.jdbcTemplate.update("DELETE * FROM aeronaves");
        return true;
    }

    public Aeronave listarAeronave(String prefixo){
        return this.jdbcTemplate.queryForObject("SELECT * FROM aeronaves WHERE prefixo = ?",
                (rs, rowNum) -> new Aeronave(rs.getString("prefixo"), rs.getInt("autonomia"), rs.getInt("velocidadeCruzeiro")), prefixo);
    }

    // public List<Aeronave> listarTodas(){
    //     return this.jdbcTemplate.query("SELECT * FROM aeronaves",
    //             (rs, rowNum) -> new Aeronave(rs.getString("prefixo"), rs.getInt("autonomia"), rs.getInt("velocidadeCruzeiro")));
    // 
    // }
    
}
