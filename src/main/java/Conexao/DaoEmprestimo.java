/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import entidades.Emprestimo;
import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author malxg
 */
public class DaoEmprestimo {
     private EntityManager em;

    public DaoEmprestimo() {
        em = Manager.getInstance().getEm();
    }
    
    public void salvar(Emprestimo emprestimo){
        em.getTransaction().begin();
        em.persist(emprestimo);
        em.getTransaction().commit();
    }
    
    public void atualizar(Emprestimo emprestimo){
        em.getTransaction().begin();
        em.merge(emprestimo);
        em.getTransaction().commit();
    }
    
    public List<Emprestimo> consultarTodos(){        
        Query qry = em.createQuery("from Emprestimo");
        List emprestimos = qry.getResultList();
        return (List<Emprestimo>) emprestimos;
    }
    
    public List<Emprestimo> consultaPorUsuario(Usuario usuario){
        Query qry = em.createQuery("from Emprestimo where usuario.id= :usuario");
        qry.setParameter("usuario", usuario.getIdUsuario());
        
        List emprestimos = qry.getResultList();
        return (List<Emprestimo>) emprestimos;
    }
    
}
