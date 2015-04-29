package com.easygeek.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.ComposantFournisseur;
import com.easygeek.service.ComposantFournisseurService;

@RestController
@RequestMapping("/composantfournisseur")
public class ComposantFournisseurController {
    public ComposantFournisseurService composantFournisseurService = new ComposantFournisseurService();

    /***
     * Affiche la liste de tous les fournisseurs
     * http://localhost:8080/fournisseur
     ***/
    @RequestMapping(method = RequestMethod.GET)
    public List<ComposantFournisseur> composantFournisseurs() {
        List<ComposantFournisseur> composantFournisseurs = composantFournisseurService.getAll();
        System.out.println("getAllComposantFournisseur");
        return composantFournisseurs;
    }

    /***
     * Affiche un fournisseur en passant son id en GET au path variable :
     * http://localhost:8080/fournisseur/id
     ***/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ComposantFournisseur getComposantFournisseur(@PathVariable Integer id) {
        ComposantFournisseur fournisseur = composantFournisseurService.get(id);
        System.out.println("getFournisseur avec l'id : " + id);
        return fournisseur;
    }

    /***
     * Ajoute un fournisseur en passant un json contenant l'objet en POST
     * http://localhost:8080/fournisseur/ajouter
     ***/
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public ResponseEntity<ComposantFournisseur> ajoutComposantFournisseur(@RequestBody ComposantFournisseur composantFournisseur) {
        try {
            composantFournisseurService.save(composantFournisseur);
            System.out.println("Le composantFournisseur avec l'id "
                    + composantFournisseur.getId() + " a été modifié avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du composantFournisseur avec l'id "
                    + composantFournisseur.getId());
        }
        return new ResponseEntity<ComposantFournisseur>(composantFournisseur, HttpStatus.OK);
    }

    /***
     * Modifie un fournisseur en envoyant en post les champs à modifier et en
     * get l'id de l'utilisateur http://localhost:8080/fournisseur/modifier/{id}
     ***/
    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public ResponseEntity<ComposantFournisseur> modifierComposantFournisseur(@RequestBody ComposantFournisseur composantFournisseur) {
        try {
            composantFournisseurService.update(composantFournisseur);
            System.out.println("Le composantFournisseur avec l'id "
                    + composantFournisseur.getId() + " a été modifié avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la modification du composantFournisseur avec l'id"
                    + composantFournisseur.getId());
        }
        return new ResponseEntity<ComposantFournisseur>(composantFournisseur, HttpStatus.OK);
    }

    /***
     * Suppression d'un fournisseur en envoyant en DELETE le champ id
     * http://localhost:8080/fournisseur/supprimer
     ***/
    @RequestMapping(value = "/supprimer/{id}", method = RequestMethod.DELETE)
    public String supprimerComposantFournisseur(@PathVariable Integer id) {
        String message;
        ComposantFournisseur composantFournisseur = composantFournisseurService.get(id);
        try {
            composantFournisseurService.delete(composantFournisseur);
            message = "Le composantFournisseur a été supprimé avec succés.";
            System.out.println("Le composantFournisseur avec l'id : "
                    + composantFournisseur.getId() + "a été supprimé avec succès !");
        } catch (Exception e) {
            message = "Le composantFournisseur n'a pas été supprimé car il possède encore des composants.";
            System.out.println("Problème lors de la suppression du composantFournisseur avec l'id : "
                    + composantFournisseur.getId());
        }
        return message;
    }
}
