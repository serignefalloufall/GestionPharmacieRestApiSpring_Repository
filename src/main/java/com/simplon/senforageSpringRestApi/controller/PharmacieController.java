package com.simplon.senforageSpringRestApi.controller;

import com.simplon.senforageSpringRestApi.dao.IPharmacie;
import com.simplon.senforageSpringRestApi.model.Pharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PharmacieController {
    @Autowired
    private IPharmacie pharmaciedao;

    @RequestMapping(value="/Pharmacie/liste", method= RequestMethod.GET)
    public List<Pharmacie> listePharmacies() {
        List<Pharmacie> pharmacies = pharmaciedao.findAll();
        return pharmacies;
    }

    //ajout pharmacie
    @PostMapping(value = "/Pharmacie/add")
    public void ajouterPharmacie(@RequestBody Pharmacie pharmacie) {
        /* @RequestBody Cette annotation demande à Spring que le JSON contenu dans
        // la partie body de la requête HTTP soit converti en objet Java.*/
        pharmaciedao.save(pharmacie);
    }

    //update pharmacie
    @PostMapping(value = "/Pharmacie/edit")
    public void editPharmacie(@RequestBody Pharmacie pharmacie) {
        pharmaciedao.save(pharmacie);
    }

    //delete pharmacie
    @GetMapping(value = "/Pharmacie/delete/{id}")
    public void deletePharmacie(@PathVariable("id") int id) {
        Pharmacie pharmacie = new Pharmacie();
        pharmacie = pharmaciedao.getOne(id);
        pharmaciedao.delete(pharmacie);
    }

}
