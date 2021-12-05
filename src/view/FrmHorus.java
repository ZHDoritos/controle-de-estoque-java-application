/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Horus.java
 *
 * Created on Aug 21, 2011, 9:48:51 PM
 */
package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.UIManager;

/**
 *
 * @author Vitor Freitas
 */
public class FrmHorus extends javax.swing.JFrame {

    /** Creates new form Horus */
    public FrmHorus() {
        initComponents();

        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource("/images/ruby.png"));
        } catch (IOException e) {
            
        }
        this.setIconImage(image);        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();
        mainMenu = new javax.swing.JMenuBar();
        mmArquivo = new javax.swing.JMenu();
        mnArquivoBackup = new javax.swing.JMenuItem();
        mmArquivoSair = new javax.swing.JMenuItem();
        mmParametros = new javax.swing.JMenu();
        mmParametrosTipoProduto = new javax.swing.JMenuItem();
        mmAjuda = new javax.swing.JMenu();
        mmAjudaSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("H�rus");

        mainTabbedPane.addTab("Inicial", new javax.swing.ImageIcon(getClass().getResource("/images/house.png")), new view.FrmPanelInicial());
        mainTabbedPane.addTab("Fornecedores", new javax.swing.ImageIcon(getClass().getResource("/images/cart.png")), new view.FrmPanelFornecedor());
        mainTabbedPane.addTab("Produtos", new javax.swing.ImageIcon(getClass().getResource("/images/basket.png")), new view.FrmPanelProduto());
        mainTabbedPane.addTab("Revendedoras", new javax.swing.ImageIcon(getClass().getResource("/images/user_female.png")), new view.FrmPanelRevendedora());
        mainTabbedPane.addTab("Mostru�rios", new javax.swing.ImageIcon(getClass().getResource("/images/briefcase.png")), new view.FrmPanelMostruario());
        mainTabbedPane.addTab("Estoque", new javax.swing.ImageIcon(getClass().getResource("/images/box.png")), new view.FrmPanelEstoque());
        //mainTabbedPane.addTab("Relat�rios", new javax.swing.ImageIcon(getClass().getResource("/images/chart_bar.png")), new view.FrmPanelRelatorios());
        mainTabbedPane.addTab("Financeiro", new javax.swing.ImageIcon(getClass().getResource("/images/money_dollar.png")), new view.FrmPanelFinanceiro());

        mmArquivo.setMnemonic('A');
        mmArquivo.setText("Arquivo");

        mnArquivoBackup.setText("Backup");
        mnArquivoBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnArquivoBackupActionPerformed(evt);
            }
        });
        mmArquivo.add(mnArquivoBackup);

        mmArquivoSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mmArquivoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/door_in.png"))); // NOI18N
        mmArquivoSair.setMnemonic('S');
        mmArquivoSair.setText("Sair");
        mmArquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmArquivoSairActionPerformed(evt);
            }
        });
        mmArquivo.add(mmArquivoSair);

        mainMenu.add(mmArquivo);

        mmParametros.setMnemonic('P');
        mmParametros.setText("Par�metros");

        mmParametrosTipoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cog.png"))); // NOI18N
        mmParametrosTipoProduto.setMnemonic('T');
        mmParametrosTipoProduto.setText("Tipo de Produto");
        mmParametrosTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmParametrosTipoProdutoActionPerformed(evt);
            }
        });
        mmParametros.add(mmParametrosTipoProduto);

        mainMenu.add(mmParametros);

        mmAjuda.setMnemonic('J');
        mmAjuda.setText("Ajuda");

        mmAjudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mmAjudaSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help_2.png"))); // NOI18N
        mmAjudaSobre.setMnemonic('S');
        mmAjudaSobre.setText("Sobre");
        mmAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmAjudaSobreActionPerformed(evt);
            }
        });
        mmAjuda.add(mmAjudaSobre);

        mainMenu.add(mmAjuda);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mmArquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmArquivoSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mmArquivoSairActionPerformed

    private void mmParametrosTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmParametrosTipoProdutoActionPerformed
        new FrmManterTipoProduto(this, true).setVisible(true);
    }//GEN-LAST:event_mmParametrosTipoProdutoActionPerformed

    private void mmAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmAjudaSobreActionPerformed
        new FrmSobre(this, true).setVisible(true);
    }//GEN-LAST:event_mmAjudaSobreActionPerformed

    private void mnArquivoBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnArquivoBackupActionPerformed
        try {
            Process runtimeProcess = Runtime.getRuntime().exec("cmd /c start backup.bat");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_mnArquivoBackupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e){
            
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmHorus().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JMenu mmAjuda;
    private javax.swing.JMenuItem mmAjudaSobre;
    private javax.swing.JMenu mmArquivo;
    private javax.swing.JMenuItem mmArquivoSair;
    private javax.swing.JMenu mmParametros;
    private javax.swing.JMenuItem mmParametrosTipoProduto;
    private javax.swing.JMenuItem mnArquivoBackup;
    // End of variables declaration//GEN-END:variables
}