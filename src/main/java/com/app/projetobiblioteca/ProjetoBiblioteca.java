/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.app.projetobiblioteca;

import entidades.Categoria;
import entidades.Usuario;
import janelas.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author malxg
 */
public class ProjetoBiblioteca {

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
