/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tests;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import tn.edu.esprit.entities.Categtra;
import tn.edu.esprit.services.Servicetransaction;
import tn.edu.esprit.entities.Transaction;
import tn.edu.esprit.services.Servicecategtra;
import tn.edu.esprit.services.Servicechatgpt;

/**
 *
 * @author megbl
 */
public class Main {
      public static void main(String[] args) {
        /*Categtra t = new Categtra();
        t.setNom_cat_tra("Payement facture");
        t.setDescrip_cat_tra("Payement facture STEG, SONEDE");
        */        Servicechatgpt Servicechatgpt = new Servicechatgpt();

        //Servicecategtra Servicecategtra = new Servicecategtra();
        System.out.println(Servicechatgpt.chatGPT("who are you?"));
      }
      
}
