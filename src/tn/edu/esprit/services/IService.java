/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;

/**
 *
 * @author abdelazizmezri
 */
<<<<<<< HEAD
import java.util.List;

public interface IService<T> {
    public T create(T t);

    public T getById(int id);

    public List<T> getAll();

    public void update(T t);

    public boolean delete(int id);
=======
public interface IService <T> {
    public void ajouter(T t);
    public void modifier(T t);
    public void supprimer(int id);
    public T getOne(int id);
    public List<T> getAll(T t);
>>>>>>> origin/gestion-terrain
}

