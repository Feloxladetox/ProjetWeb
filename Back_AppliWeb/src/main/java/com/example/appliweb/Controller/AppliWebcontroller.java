package com.example.appliweb.Controller;

import com.example.appliweb.Model.Client;
import com.example.appliweb.Model.Imprimante;
import com.example.appliweb.Service.ClientServiceInterface;
import com.example.appliweb.Service.ImprimanteServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin

public class AppliWebcontroller {

    @Autowired
    private final ClientServiceInterface clientServiceInterface;

    @Autowired
    private final ImprimanteServiceInterface imprimanteServiceInterface;


    // ------------------ Client Service --------------- //

    @PostMapping("/create")
    public Client create(@RequestBody Client client){
        return clientServiceInterface.creer(client);
    }

    @GetMapping("/read")
    public List<Client> read(){
        return clientServiceInterface.lire();
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable long id, @RequestBody Client client){
        return clientServiceInterface.modifier(id, client);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable long id){
        return clientServiceInterface.supprimer(id);
    }

    @PostMapping("/existe")
    public boolean existe(@RequestBody Client client){
        return clientServiceInterface.existe(client);
    }


    @PostMapping("/connexion/testco")
    public boolean dansbase(@RequestBody Client client, HttpSession httpSession){
        return clientServiceInterface.dansbase(client);
        /*Client utilisateur = new Client(client);
        httpSession.setAttribute("id",utilisateur.getId());*/
    }

    @PostMapping("/connexion/recup")
    public String[] recup(@RequestBody Client client) {
        String res [] = new String[5];
        if (clientServiceInterface.dansbase(client) == true) {
            long id = clientServiceInterface.recupid(client);
            String modeleun = clientServiceInterface.donnermodimun(id);
            String modeldeux = clientServiceInterface.donnermodimdeux(id);
            res[0] = clientServiceInterface.donnernom(id);
            res[1] = clientServiceInterface.donnermodimun(id);
            res[2] = imprimanteServiceInterface.donnerip(modeleun);
            res[3] = clientServiceInterface.donnermodimdeux(id);
            res[4] = imprimanteServiceInterface.donnerip(modeldeux);
        }
        return res;
    }

    //-------------------------------------- Imprimante Service ----------------------------------------------------//

    @PostMapping("/create/imp")
    public Imprimante create(@RequestBody Imprimante imprimante){
        return imprimanteServiceInterface.creer(imprimante);
    }


}
