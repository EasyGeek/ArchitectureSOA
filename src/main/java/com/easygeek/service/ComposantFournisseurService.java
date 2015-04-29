package com.easygeek.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.ComposantFournisseur;

public class ComposantFournisseurService extends CoreDao<ComposantFournisseur> {

    public ComposantFournisseurService() {
        super(ComposantFournisseur.class);
    }

    @SuppressWarnings("unchecked")
    public List<ComposantFournisseur> getDetails(Integer idFournisseur){
        return (List<ComposantFournisseur>) session.createCriteria(ComposantFournisseur.class).add(Restrictions.eq("fournisseur.fournisseurId", idFournisseur)).list();
    }
}
