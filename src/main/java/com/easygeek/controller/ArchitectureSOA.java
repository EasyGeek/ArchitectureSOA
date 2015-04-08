package com.easygeek.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArchitectureSOA {

	/** FICHIER A LANCER POUR DEMARRER L'APPLICATION 
	 PLUS BESOIN DE TOMCAT, SPRING BOOT POSSEDE UN TOMCAT INTEGRE
	CLIQUE DROIT : RUN JAVA APPLICATION **/ 
    public static void main(String[] args) {
        SpringApplication.run(ArchitectureSOA.class, args);
    }
}
