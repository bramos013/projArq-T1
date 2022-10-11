package com.trabalho1.negocio.services;

public class ServicoRefGeo {
    
    public IRefGeoRepository refGeoRep;
    

    List<RefGeo> listarTodas();
    RefGeo listarRefGeo(String nome);
    void removeRefGeo(String nome);
    void acrescentaRefGeo(RefGeo refGeo);
}
