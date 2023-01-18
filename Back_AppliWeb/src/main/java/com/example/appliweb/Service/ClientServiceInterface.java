package com.example.appliweb.Service;

import com.example.appliweb.Model.Client;

import java.util.List;

public interface ClientServiceInterface {

    Client creer(Client client);

    List<Client> lire();

    Client modifier(long id, Client client);

    String supprimer(long id);

    Boolean dansbase(Client client);

    long recupid(Client client);

    String donnernom(long _id);

    String donnermodimun(long id);

    String donnermodimdeux(long id);


    boolean existe(Client client);

}
