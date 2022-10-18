package com.trabalho1.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trabalho1.negocio.entidades.Aeronave;
import com.trabalho1.negocio.repositorios.IAeronaveRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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

    @Override
    public List<Aeronave> findAll() {
        return null;
    }

    @Override
    public List<Aeronave> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Aeronave> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Aeronave> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Aeronave entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Aeronave> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Aeronave> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Aeronave> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Aeronave> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Aeronave> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Aeronave> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Aeronave> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Aeronave getOne(String s) {
        return null;
    }

    @Override
    public Aeronave getById(String s) {
        return null;
    }

    @Override
    public Aeronave getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Aeronave> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Aeronave> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Aeronave> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Aeronave> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Aeronave> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Aeronave> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Aeronave, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    // public List<Aeronave> listarTodas(){
    //     return this.jdbcTemplate.query("SELECT * FROM aeronaves",
    //             (rs, rowNum) -> new Aeronave(rs.getString("prefixo"), rs.getInt("autonomia"), rs.getInt("velocidadeCruzeiro")));
    // 
    // }
    
}