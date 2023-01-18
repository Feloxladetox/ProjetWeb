package com.example.appliweb.Repository;

import com.example.appliweb.Model.Imprimante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImprimanteRepository extends JpaRepository<Imprimante, Long> {
}
