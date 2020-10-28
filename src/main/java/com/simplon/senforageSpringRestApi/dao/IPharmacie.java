package com.simplon.senforageSpringRestApi.dao;

import com.simplon.senforageSpringRestApi.model.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPharmacie extends JpaRepository<Pharmacie,Integer> {
}
