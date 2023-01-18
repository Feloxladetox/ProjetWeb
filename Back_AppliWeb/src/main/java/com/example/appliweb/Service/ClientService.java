package com.example.appliweb.Service;

import com.example.appliweb.Model.Client;
import com.example.appliweb.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    private final ClientRepository clientrepository;

    //private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Client creer(Client client) {
        return clientrepository.save(client);
    }

    @Override
    public List<Client> lire() {
        return (List<Client>) clientrepository.findAll();
    }

    @Override
    public Client modifier(long id, Client client) {
        return clientrepository.findById(id)
                .map(p->{
                    p.setId(client.getId());
                    p.setNom(client.getNom());
                    p.setMdp(client.getMdp());
                    return clientrepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    @Override
    public String supprimer(long id) {
        clientrepository.deleteById(id);
        return "client supprimé";
    }

    @Override
    public Boolean dansbase(Client client) {
        List<Client> listedbo = lire();
        String nom = client.getNom();
        String mdp = client.getMdp();
        int ceclient = 0;
        long idclient = 0;

        for(int i=0;i<listedbo.size();i++){
            if(Objects.equals(listedbo.get(i).getNom(), nom)) {
                if (Objects.equals(listedbo.get(i).getMdp(), mdp)) {
                    ceclient += 1;
                    idclient = listedbo.get(i).getId();
                    System.out.println(listedbo.get(i));
                    System.out.println(ceclient);
                }
            }
        }

        System.out.println("Le id du client est "+idclient);
        if(ceclient>0){ return true; };
        return false;
    }

    @Override
    public long recupid(Client client){
        List<Client> listedbo = lire();
        String nom = client.getNom();
        String mdp = client.getMdp();
        long idclient=0;

        for(int i=0;i<listedbo.size();i++){
            if(listedbo.get(i).toString().contains(nom))
                if(listedbo.get(i).toString().contains(mdp)){
                    idclient = listedbo.get(i).getId();
                }
        }
        System.out.println("Le id du client est "+idclient);
        return idclient;
    }

    @Override
    public String donnernom(long _id){
        List<Client> listedbo = lire();
        for(int i=0;i<listedbo.size();i++){
            if(listedbo.get(i).getId() == _id){
                String nom = listedbo.get(i).getNom();
                return nom;
            }
        }
        return "null";
    }

    @Override
    public String donnermodimun(long id){
        List<Client> listedbo = lire();
        for(int i=0;i<listedbo.size();i++){
            if(listedbo.get(i).getId() == id){
                String modimun = listedbo.get(i).getModimun();
                return modimun;
            }
        }
        return "null";
    }

    @Override
    public String donnermodimdeux(long id){
        List<Client> listedbo = lire();
        for(int i=0;i<listedbo.size();i++){
            if(listedbo.get(i).getId() == id){
                String modimdeux = listedbo.get(i).getModimdeux();
                return modimdeux;
            }
        }
        return "null";
    }

    @Override
    public boolean existe(Client client) {
        List<Client> listedbo = lire();
        String nom = client.getNom();
        for (int i = 0; i < listedbo.size(); i++) {
            if (Objects.equals(listedbo.get(i).getNom(), nom)){
                return true;
            }
        }
        return false;
    }


}

