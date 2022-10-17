package com.trabalho1.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trabalho1.negocio.entidades.RefGeo;
import com.trabalho1.negocio.repositorios.IRefGeoRepository;


public class RefGeoRepository implements IRefGeoRepository {
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public RefGeoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcTemplate.execute("DROP TABLE refGeos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE refGeos("
                + "nome VARCHAR(100), latitude float, longitude float, PRIMARY KEY(nome))");

       cadastra(new RefGeo("(A1) Aeroporto Santos Dummont", -22.91000, -43.163056));
       cadastra(new RefGeo("(A2) Aeroporto de Congonhas", -23.62694, -46.655833));
       cadastra(new RefGeo("(A3) Aeroporto Internacional Salgado Filho", -29.993889, -51.171667));
       cadastra(new RefGeo("(A4) Aeroporto Internacional de Confins", -19.633333, -43.968056));
       cadastra(new RefGeo("(P1) Referência Geográfica intermediária (Curitiba)", -25.528056, -49.175833));
    }

    public boolean cadastra(RefGeo refGeo){
        this.jdbcTemplate.update("INSERT INTO refGeos VALUES(?, ?, ?)", refGeo.getNome(), refGeo.getLatitude(), refGeo.getLongitude()); 
        return true;
    }

    public boolean remove(String nome){
        if(this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM refGeos WHERE nome = ?", Integer.class, nome) == 0){
            return false;
        }else{
            this.jdbcTemplate.update("DELETE FROM refGeos WHERE nome = ?", nome);
            return true;
        }
    }

    public boolean removeTodas(){
        this.jdbcTemplate.update("DELETE * FROM refGeos");
        return true;
    }

    public RefGeo listarRefGeo(String nome){
        return this.jdbcTemplate.queryForObject("SELECT * FROM refGeos WHERE nome = ?",
                (rs, rowNum) -> new RefGeo(rs.getString("nome"), rs.getFloat("latitude"), rs.getFloat("longitude")), nome);
    }

    // public List<RefGeo> listarTodas(){
    //     return this.jdbcTemplate.query("SELECT * FROM refGeos",
    //             (rs, rowNum) -> new RefGeo(rs.getString("prefixo"), rs.getInt("autonomia"), rs.getInt("velocidadeCruzeiro")));
    // 
    // }
    
}
