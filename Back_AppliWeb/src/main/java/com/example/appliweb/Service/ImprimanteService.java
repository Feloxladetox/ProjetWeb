package com.example.appliweb.Service;


import com.example.appliweb.Model.Client;
import com.example.appliweb.Model.Imprimante;
import com.example.appliweb.Repository.ImprimanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ImprimanteService implements ImprimanteServiceInterface{

    @Autowired
    private final ImprimanteRepository imprimanteRepository;

    @Override
    public Imprimante creer(Imprimante imprimante) {
        return imprimanteRepository.save(imprimante);
    }

    @Override
    public List<Imprimante> lire() {
        return (List<Imprimante>) imprimanteRepository.findAll();
    }

    @Override
    public Imprimante modifier(long id, Imprimante imprimante) {
        return imprimanteRepository.findById(id)
                .map(p->{
                    p.setId(imprimante.getId());
                    p.setModel(imprimante.getModel());
                    p.setAdresse(imprimante.getAdresse());
                    return imprimanteRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    @Override
    public String supprimer(long id) {
        imprimanteRepository.deleteById(id);
        return "client supprimé";
    }

    @Override
    public String donnerip(String model){
        List<Imprimante> listedb = lire();
        for(int i=0;i<listedb.size();i++){
            if(Objects.equals(listedb.get(i).getModel(), model)){
                String ip = listedb.get(i).getAdresse();
                return ip;
            }
        }
        return "null";
    }


}
