/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.SQLException;
import java.util.List;
import tn.edu.esprit.entities.Transaction;

/**
 *
 * @author abdelazizmezri
 * @param <T>
 */
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
import java.util.List;

public interface IService<T> {
    public T create(T t);

    public T getById(int id);

    public List<T> getAll();

    public void update(T t);

    public boolean delete(int id);
<<<<<<< HEAD


    public void ajouter(T t);
    public void modifier(T t);

    public void supprimer(int id);
    public T getOne(int id);
    public List<T> getAll(T t);


    //public void supprimer(int id_tra);
=======
=======
public interface IService <T> {
    public void ajouter(T t);
    public void modifier(T t);
<<<<<<< HEAD
    public void supprimer(int id);
    public T getOne(int id);
    public List<T> getAll(T t);
>>>>>>> origin/gestion-terrain
=======
    public void supprimer(int id_tra);
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
    public void rechercheType (int id_tra);
    public List remplircombo ();
    /**
     *
     * @param id_tra
     * @return
     */
   
    public T getOne(String categ_tra);
<<<<<<< HEAD
    //public List<T> getAll();
=======
    public List<T> getAll();
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
    public T getPneById(int id) throws SQLException;
    public int caisse ();
    public String chatGPT (String message);
    public int nbligne();
   
<<<<<<< HEAD
=======
>>>>>>> origin/gestion_treso
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
}

