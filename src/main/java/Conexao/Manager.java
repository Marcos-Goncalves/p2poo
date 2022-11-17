/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author malxg
 */
public class Manager {
    private EntityManager em;
    
    private static Manager instance = null;
    
    public static Manager getInstance(){
        if(instance == null){
            instance = new Manager();
        }
        return instance;
    }
    
    private Manager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhopoo");
        em = emf.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
    
}
