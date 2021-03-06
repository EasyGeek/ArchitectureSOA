package com.easygeek.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.ComposantFournisseur;
import com.easygeek.service.ComposantFournisseurService;

import java.util.List;

@RestController
@RequestMapping("/composantfournisseur")
public class ComposantFournisseurController {
    public ComposantFournisseurService composantFournisseurService = new ComposantFournisseurService();

    @RequestMapping(value = "/fournisseur/{idFournisseur}", method = RequestMethod.GET)
    public List<ComposantFournisseur> getComposantsByFournisseur(@PathVariable Integer idFournisseur) {
        List<ComposantFournisseur> details  = composantFournisseurService.getListComposanstByFournisseur(idFournisseur);

        return details;
    }

    @RequestMapping(value = "/composant/{idComposant}", method = RequestMethod.GET)
    public List<ComposantFournisseur> getFournisseursByComposant(@PathVariable String idComposant) {
        List<ComposantFournisseur> details  = composantFournisseurService.getListFournisseursByComposant(idComposant);

        return details;
    }

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
