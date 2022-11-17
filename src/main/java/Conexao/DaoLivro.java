/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import entidades.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author malxg
 */
public class DaoLivro {
    private EntityManager em;

    public DaoLivro() {
        em = Manager.getInstance().getEm();
    }
    
    public void salvar(Livro livro){
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
    }
    
    public void atualizar(Livro livro){
        em.getTransaction().begin();
        em.merge(livro);
        em.getTransaction().commit();
    }
    
    public List<Livro> consultarTodos(){        
        Query qry = em.createQuery("from Livro");
        List livros = qry.getResultList();
        return (List<Livro>) livros;
    }
    
}
