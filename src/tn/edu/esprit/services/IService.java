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
import java.util.List;

public interface IService<T> {
    public T create(T t);

    public T getById(int id);

    public List<T> getAll();

    public void update(T t);

    public boolean delete(int id);
}

