package com.easygeek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ArchitectureSOA {

	/** FICHIER A LANCER POUR DEMARRER L'APPLICATION 
	 PLUS BESOIN DE TOMCAT, SPRING BOOT POSSEDE UN TOMCAT INTEGRE
	CLIQUE DROIT : RUN JAVA APPLICATION **/ 
    public static void main(String[] args) {
        SpringApplication.run(ArchitectureSOA.class, args);
    }
}
