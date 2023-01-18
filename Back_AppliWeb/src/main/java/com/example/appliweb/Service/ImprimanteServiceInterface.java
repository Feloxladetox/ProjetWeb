package com.example.appliweb.Service;

import com.example.appliweb.Model.Client;
import com.example.appliweb.Model.Imprimante;

import java.util.List;

public interface ImprimanteServiceInterface {

    Imprimante creer(Imprimante imprimante);

    List<Imprimante> lire();

    Imprimante modifier(long id, Imprimante imprimante);

    String supprimer(long id);

    String donnerip(String model);

}
