package com.easygeek.service;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.ComposantFournisseur;

public class ComposantFournisseurService extends CoreDao<ComposantFournisseur> {
    public ComposantFournisseurService() {
        super(ComposantFournisseur.class);
    }
}
