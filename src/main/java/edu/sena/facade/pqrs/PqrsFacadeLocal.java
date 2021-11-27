/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.pqrs;

import edu.sena.entity.pqrs.Pqrs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josar
 */
@Local
public interface PqrsFacadeLocal {

    void create(Pqrs pqrs);

    void edit(Pqrs pqrs);

    void remove(Pqrs pqrs);

    Pqrs find(Object id);

    List<Pqrs> findAll();

    List<Pqrs> findRange(int[] range);

    int count();
    
}
