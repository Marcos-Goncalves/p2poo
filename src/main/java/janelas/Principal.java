/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package janelas;

import Conexao.Controlador;
import entidades.Categoria;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author malxg
 */
public class Principal extends javax.swing.JFrame {
    private Controlador con = new Controlador();
    private LinkedList<Usuario> listaUsuario = new LinkedList<>();
    private LinkedList<Categoria> listaCategoria = new LinkedList<>();
    private LinkedList<Livro> listaLivro = new LinkedList<>();
    private LinkedList<Emprestimo> listaEmprestimo = new LinkedList<>();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private Usuario user;

    /**
     * Creates new form Principal
     */
    public Principal(Usuario user) {
        initComponents();
        this.user = user;
        
        listaUsuario.addAll(con.getTodosUsuarios());
        comboUsuario.setModel(new DefaultComboBoxModel(listaUsuario.toArray()));

        comboEmprestimo.setEnabled(false);
        
        //Listar os empréstimos
        try {
            List<Emprestimo> emps = con.getTodosEmprestimos();
            Object[] listEmps = new Object[5];
            DefaultTableModel model = (DefaultTableModel) tabelaEmprestimo.getModel();
            
            for (int i = 0; i < emps.size(); i++) {
                listEmps[0] = emps.get(i).getIdEmprestimo();
                listEmps[1] = emps.get(i).getLivro();
                listEmps[2] = emps.get(i).getUsuario();
                listEmps[3] = format.format(emps.get(i).getEmprestimo());
                listEmps[4] = format.format(emps.get(i).getDevolucao());
                model.addRow(listEmps);
            }
        } catch (Exception ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboEmprestimo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dataEmprestimo = new javax.swing.JFormattedTextField();
        dataDevolucao = new javax.swing.JFormattedTextField();
        comboUsuario = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmprestimo = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu = new javax.swing.JMenu();
        menuCadastroUsuario = new javax.swing.JMenuItem();
        menuCadastroLivro = new javax.swing.JMenuItem();
        menuCadastroEmprestimo = new javax.swing.JMenuItem();
        menuCadastroCategoria = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Usuario"));

        jLabel1.setText("Matrícula:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Status do Livro"));

        comboEmprestimo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEmprestimoItemStateChanged(evt);
            }
        });

        jLabel4.setText("Empréstimo:");

        jLabel5.setText("Devolução:");

        try {
            dataEmprestimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            dataDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEmprestimo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dataEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(dataDevolucao))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        comboUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboUsuarioItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de empréstimo"));

        tabelaEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emprestimo", "Livro", "Usuario", "Data Emp.", "Data Dev."
            }
        ));
        jScrollPane1.setViewportView(tabelaEmprestimo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("Sair");
        jMenuBar1.add(jMenu1);

        menu.setText("Cadastro");
        menu.setToolTipText("");
        menu.setDisplayedMnemonicIndex(0);

        menuCadastroUsuario.setText("Cadastro de usuário");
        menuCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroUsuarioActionPerformed(evt);
            }
        });
        menu.add(menuCadastroUsuario);

        menuCadastroLivro.setText("Cadastro de livro");
        menuCadastroLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroLivroActionPerformed(evt);
            }
        });
        menu.add(menuCadastroLivro);

        menuCadastroEmprestimo.setText("Empréstimo");
        menuCadastroEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroEmprestimoActionPerformed(evt);
            }
        });
        menu.add(menuCadastroEmprestimo);

        menuCadastroCategoria.setText("Categoria");
        menuCadastroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroCategoriaActionPerformed(evt);
            }
        });
        menu.add(menuCadastroCategoria);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioActionPerformed
        new CadastroUsuario(listaUsuario,listaCategoria, user).setVisible(true);
    }//GEN-LAST:event_menuCadastroUsuarioActionPerformed

    private void menuCadastroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroCategoriaActionPerformed
        new CadastroCategoria(listaCategoria).setVisible(true);
    }//GEN-LAST:event_menuCadastroCategoriaActionPerformed

    private void menuCadastroLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroLivroActionPerformed
        new CadastroLivro(listaLivro).setVisible(true);
    }//GEN-LAST:event_menuCadastroLivroActionPerformed

    private void menuCadastroEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroEmprestimoActionPerformed
        new CadastroEmprestimo(listaEmprestimo, listaUsuario, listaLivro).setVisible(true);
    }//GEN-LAST:event_menuCadastroEmprestimoActionPerformed

    private void comboUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboUsuarioItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            comboEmprestimo.setEnabled(true);
            
            Usuario usuario = (Usuario) comboUsuario.getSelectedItem();
            
            listaEmprestimo.clear();
            listaEmprestimo.addAll(con.getTodosEmprestimosId(usuario));
            comboEmprestimo.setModel(new DefaultComboBoxModel(listaEmprestimo.toArray()));
            
            //Set os atributos na troca de usuario
            Emprestimo emprestimo = (Emprestimo) comboEmprestimo.getSelectedItem();
            
            String emprestimoFormat = format.format(emprestimo.getEmprestimo());
            String devolucaoFormat = format.format(emprestimo.getDevolucao());
            
            dataEmprestimo.setText(emprestimoFormat);
            dataDevolucao.setText(devolucaoFormat);
        }
    }//GEN-LAST:event_comboUsuarioItemStateChanged

    private void comboEmprestimoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEmprestimoItemStateChanged
        //Set atributos na troca do emprestimo
        if(evt.getStateChange() == ItemEvent.SELECTED){
            Emprestimo emprestimo = (Emprestimo) comboEmprestimo.getSelectedItem();
            
            String emprestimoFormat = format.format(emprestimo.getEmprestimo());
            String devolucaoFormat = format.format(emprestimo.getDevolucao());
            
            dataEmprestimo.setText(emprestimoFormat);
            dataDevolucao.setText(devolucaoFormat);
        }
    }//GEN-LAST:event_comboEmprestimoItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEmprestimo;
    private javax.swing.JComboBox<String> comboUsuario;
    private javax.swing.JFormattedTextField dataDevolucao;
    private javax.swing.JFormattedTextField dataEmprestimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem menuCadastroCategoria;
    private javax.swing.JMenuItem menuCadastroEmprestimo;
    private javax.swing.JMenuItem menuCadastroLivro;
    private javax.swing.JMenuItem menuCadastroUsuario;
    private javax.swing.JTable tabelaEmprestimo;
    // End of variables declaration//GEN-END:variables
}
