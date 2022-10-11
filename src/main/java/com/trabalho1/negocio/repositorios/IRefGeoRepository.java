package com.trabalho1.negocio.repositorios;

import com.trabalho1.negocio.entidades.RefGeo;

import java.util.List;
import org.springframework.stereotype.Component;

public class IRefGeoRepository {
    @Component
    public class ServicoRefGeo {
        public IRefGeoRepository refGeoRep;
    
        public ServicoRefGeo(IRefGeoRepository refGeoRep){
            this.refGeoRep = refGeoRep;
        }
    
        public void cadastraAeronave(RefGeo refGeo){
            refGeoRep.removeTodas();
            refGeoRep.cadastra(aerovia);
        }
    
        public List<Aerovia> listarTodas(){
            return refGeoRep.listarTodas();
        }
    
        public void removeTodas(){
            refGeoRep.removeTodas();
        }
    
    }




    List<RefGeo> listarTodas();
    RefGeo listarRefGeo(String nome);
    void removeRefGeo(String nome);
    void acrescentaRefGeo(RefGeo refGeo);

}


