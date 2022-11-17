/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import entidades.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author malxg
 */
public class DaoCategoria {
    private EntityManager em;

    public DaoCategoria() {
        em = Manager.getInstance().getEm();
    }
    
    public void salvar(Categoria categoria){
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
    }
    
    public void atualizar(Categoria categoria){
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
    }
    
    public List<Categoria> consultarTodos(){        
        Query qry = em.createQuery("from Categoria");
        List categorias = qry.getResultList();
        return (List<Categoria>) categorias;
    }
}
