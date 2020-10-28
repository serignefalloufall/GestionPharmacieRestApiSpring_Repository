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
    public String ajouterPharmacie(@RequestBody Pharmacie pharmacie) {
        /* @RequestBody Cette annotation demande à Spring que le JSON contenu dans
        // la partie body de la requête HTTP soit converti en objet Java.*/
        try {
            pharmaciedao.save(pharmacie);
            return "Ajout reuisit!!!!!";


        }catch (Exception e){

            return "Erreur d'insertion!!!!!";

        }
    }

    // update pharmacie
    @PutMapping("/Pharmacie/edit/{id}")
    public String updatePharmacie(@RequestBody Pharmacie pharmacie, @PathVariable("id") int id) {

        try {
            Pharmacie existingPharmacie = pharmaciedao.getOne(id);

            existingPharmacie.setEtat(pharmacie.getEtat());
            existingPharmacie.setNom(pharmacie.getNom());
            existingPharmacie.setQuartier(pharmacie.getQuartier());

            pharmaciedao.save(existingPharmacie);

            return "Modification reuisit!!!!!";

        } catch (Exception e) {

            return "Modification erreur !!!!!";        }

    }

    //delete pharmacie by id
    @DeleteMapping(value = "/Pharmacie/delete/{id}")
    public void deletePharmacie(@PathVariable("id") int id) {
        pharmaciedao.deleteById(id);
    }

}
