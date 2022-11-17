/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import entidades.Categoria;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author malxg
 */
public class Controlador {
    private DaoUsuario cadUsuario = new DaoUsuario();
    private DaoCategoria cadCategoria = new DaoCategoria();
    private DaoLivro cadLivro = new DaoLivro();
    private DaoEmprestimo cadEmprestimo = new DaoEmprestimo();
    
    public void salvarLivro(Livro livro) {
        cadLivro.salvar(livro);
    }
    
    public void salvarUsuario(Usuario usuario) {
        cadUsuario.salvar(usuario);
    }
    
    public void salvarCategoria(Categoria cat) {
        cadCategoria.salvar(cat);
    }
    
    public void salvarEmprestimo(Emprestimo emprestimo) {
        cadEmprestimo.salvar(emprestimo);
    }
    
    public List getTodosEmprestimos() {
        return cadEmprestimo.consultarTodos();
    }
    
    public List getTodosUsuarios() {
        return cadUsuario.consultarTodos();
    }
    
    public List getTodosCategorias() {
        return cadCategoria.consultarTodos();
    }
    
    public List getTodosLivros() {
        return cadLivro.consultarTodos();
    }
    
    public void atualizarLivro(Livro livro) {
        cadLivro.atualizar(livro);
    }
    
    public void atualizarUsuario(Usuario usuario) {
        cadUsuario.atualizar(usuario);
    }
    
    public void atualizarCategoria(Categoria cat) {
        cadCategoria.atualizar(cat);
    }
    
    public void atualizarEmprestimo(Emprestimo emprestimo) {
        cadEmprestimo.atualizar(emprestimo);
    }
    
    public Usuario validaUsuario(Usuario usuario){
        
        Usuario local = cadUsuario.consultaUsuario(usuario.getLogin(), usuario.getSenha());
        
        if(local != null
                && usuario.getLogin().equals(local.getLogin())
                && usuario.getSenha().equals(local.getSenha())){
            return local;
        }
        
        return null;
    }
    
    public List getTodosEmprestimosId(Usuario usuario){
        return cadEmprestimo.consultaPorUsuario(usuario);
    }
}
