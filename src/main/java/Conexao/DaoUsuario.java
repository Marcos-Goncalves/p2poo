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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Query;

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
        int i;
       
        try{
            Query qry = em.createQuery("from Usuario where login= :login and senha= :senha");
            qry.setParameter("login", login);
            qry.setParameter("senha", senha);
            if(qry.getSingleResult() != null){
                
                Class<?> theClass = qry.getSingleResult().getClass();
                Field[] fields = theClass.getDeclaredFields();
                    
                fields[0].setAccessible(true);
                usuario.setIdUsuario(Integer.parseInt(fields[0].get(qry.getSingleResult()).toString()));
                    
                fields[1].setAccessible(true);
                usuario.setNome(fields[1].get(qry.getSingleResult()).toString());
                    
                fields[2].setAccessible(true);
                usuario.setLogin(fields[2].get(qry.getSingleResult()).toString());
                    
                fields[3].setAccessible(true);
                usuario.setSenha(fields[3].get(qry.getSingleResult()).toString());
                    
                fields[4].setAccessible(true);

                Object objeto = fields[4].get(qry.getSingleResult());
                Class<?> theClassCat = objeto.getClass();
                Field[] fieldsCat = theClassCat.getDeclaredFields();
                
                fieldsCat[0].setAccessible(true);
                System.out.println(fieldsCat[0].get(objeto));
                usuario.setCategoria((Categoria) fields[0].get(objeto)); // -> aqui ta setando null, mais já tentei converter de todos os jeitos e nada (é FK).
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        System.out.println(usuario.getCategoria());
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
