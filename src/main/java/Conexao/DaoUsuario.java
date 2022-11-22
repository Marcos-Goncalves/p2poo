/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import entidades.Categoria;
import entidades.Usuario;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.criteria.Expression;
import org.hibernate.query.criteria.internal.expression.ExpressionImpl;

/**
 *
 * @author malxg
 */
public class DaoUsuario {
    private EntityManager em;

    public DaoUsuario() {
        em = Manager.getInstance().getEm();
    }
    
    public Usuario consultaUsuario(String login, String senha){
        Usuario usuario = new Usuario();
        Categoria cat = new Categoria();
       
        try{
            Query qry = em.createQuery("from Usuario where login= :login and senha= :senha");
            qry.setParameter("login", login);
            qry.setParameter("senha", senha);
            
            usuario = (Usuario) qry.getSingleResult();
            
        }catch(Exception e){
            System.out.println(e);
        }
       
        return usuario;
    }
    
    public void salvar(Usuario usuario){
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
    
    public void atualizar(Usuario usuario){
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }
    
    public List<Usuario> consultarTodos(){        
        Query qry = em.createQuery("from Usuario");
        List usuarios = qry.getResultList();
        return (List<Usuario>) usuarios;
    }
    
}
