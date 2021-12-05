/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmManterProduto.java
 *
 * Created on Sep 25, 2011, 4:51:31 PM
 */
package view;

import controller.ManterFornecedorController;
import controller.ManterProdutoController;
import controller.ManterTipoProdutoController;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Fornecedor;
import model.Produto;
import model.TipoProduto;
import util.Horus;
import util.ImageUploader;

/**
 *
 * @author Vitor
 */
public class FrmManterProduto extends javax.swing.JDialog {
    private String id;
    final JFileChooser fc = new JFileChooser();
    private ImageUploader iu = new ImageUploader();
    private Produto produtoOriginal = null;

    /** Creates new form FrmManterProduto */
    public FrmManterProduto(java.awt.Frame parent, boolean modal, Produto produto) {
        super(parent, modal);
        initComponents();
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource("/images/basket.png"));
        } catch (IOException e) {
            
        }
        this.setIconImage(image);
        
        if (produto==null){
            this.setTitle("Incluir Produto");
            this.id = ManterProdutoController.getInstance().getNextId().toString();
            lbCodigo.setText(this.id);
        }
        else if ((produto.getId()==null||produto.getId()==0)&&produto.getCodItemForn()!=null){
            this.setTitle("Incluir Produto");
            this.id = ManterProdutoController.getInstance().getNextId().toString();
            lbCodigo.setText(this.id);
            txtCodigoReferencia.setText(produto.getCodItemForn());
        }
        else {
            produtoOriginal = produto;
            this.setTitle("Alterar Produto");
            this.id = produto.getId().toString();
            lbCodigo.setText(produto.getCodigo());
            txtNome.setText(produto.getNome());
            txtPreco.setText(produto.getValorSaida().toString());
            taDescricao.setText(produto.getDescricao());
            txtPrecoCompra.setText(produto.getValorEntrada().toString());
            txtCodigoReferencia.setText(produto.getCodItemForn());
            
            for (int i=1;i<cbTipoProduto.getItemCount();i++)
                if (((TipoProduto)cbTipoProduto.getItemAt(i)).getCodigo().equals(produto.getTipoProduto().getCodigo())){
                    cbTipoProduto.setSelectedIndex(i);
                    break;
                }
            
            for (int i=1;i<cbFornecedor.getItemCount();i++){
                if (((Fornecedor)(cbFornecedor.getItemAt(i))).getId().equals(produto.getFornecedor().getId())){
                    cbFornecedor.setSelectedIndex(i);
                    break;
                }
            }
            
            ckDesativarProduto.setSelected(produto.getIcAtivo()==0?true:false);
            
            try {
                BufferedImage img = ImageIO.read(new File("media/" + produto.getCodigo() + ".jpg"));
                img = iu.resizeImage(img, 100, 100);
                if (img != null) {
                    ImageIcon icon = new ImageIcon(img);
                    lbImagem.setText("");
                    lbImagem.setIcon(icon);
                }
            } catch (Exception e) {
                
            }
                    
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnProduto = new javax.swing.JPanel();
        lbTitleProduto = new javax.swing.JLabel();
        pnDadosProduto = new javax.swing.JPanel();
        cbTipoProduto = new javax.swing.JComboBox();
        lbTipoProduto = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        spDescricao = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        txtPreco = new javax.swing.JFormattedTextField();
        lbPreco = new javax.swing.JLabel();
        btnAtualizarImagem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbImagem = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        pnDadosFornecedor = new javax.swing.JPanel();
        cbFornecedor = new javax.swing.JComboBox();
        lbFornecedor = new javax.swing.JLabel();
        txtPrecoCompra = new javax.swing.JFormattedTextField();
        lbPrecoCompra = new javax.swing.JLabel();
        txtCodigoReferencia = new javax.swing.JTextField();
        lbCodigoReferencia = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        ckDesativarProduto = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTitleProduto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTitleProduto.setForeground(new java.awt.Color(51, 51, 51));
        lbTitleProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/promotion.png"))); // NOI18N
        lbTitleProduto.setText("Produto");

        pnDadosProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        try {
            Horus.atualizarComboBox(cbTipoProduto, ManterTipoProdutoController.getInstance().getTipoProdutos());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao carregar Tipos de Produtos!");
        }
        cbTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoProdutoActionPerformed(evt);
            }
        });

        lbTipoProduto.setText("Tipo de Produto:");

        lbNome.setText("Nome:");

        lbDescricao.setText("Descri��o:");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        spDescricao.setViewportView(taDescricao);

        lbPreco.setText("Pre�o:");

        btnAtualizarImagem.setText("Atualizar Imagem");
        btnAtualizarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarImagemActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbImagem.setText("Produto Sem Imagem");
        lbImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImagemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnDadosProdutoLayout = new javax.swing.GroupLayout(pnDadosProduto);
        pnDadosProduto.setLayout(pnDadosProdutoLayout);
        pnDadosProdutoLayout.setHorizontalGroup(
            pnDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(pnDadosProdutoLayout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTipoProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                    .addGroup(pnDadosProdutoLayout.createSequentialGroup()
                        .addGroup(pnDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescricao)
                            .addGroup(pnDadosProdutoLayout.createSequentialGroup()
                                .addComponent(btnAtualizarImagem)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDadosProdutoLayout.setVerticalGroup(
            pnDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosProdutoLayout.createSequentialGroup()
                .addGroup(pnDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTipoProduto)
                    .addComponent(cbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtualizarImagem)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(51, 51, 51));

        pnDadosFornecedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        try {
            Horus.atualizarComboBox(cbFornecedor, ManterFornecedorController.getInstance().getFornecedoresAtivos());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao carregar Fornecedores!");
        }
        cbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFornecedorActionPerformed(evt);
            }
        });

        lbFornecedor.setText("Fornecedor:");

        lbPrecoCompra.setText("Pre�o de compra:");

        lbCodigoReferencia.setText("C�digo refer�ncia:");

        javax.swing.GroupLayout pnDadosFornecedorLayout = new javax.swing.GroupLayout(pnDadosFornecedor);
        pnDadosFornecedor.setLayout(pnDadosFornecedorLayout);
        pnDadosFornecedorLayout.setHorizontalGroup(
            pnDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosFornecedorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPrecoCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbFornecedor, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbCodigoReferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDadosFornecedorLayout.setVerticalGroup(
            pnDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFornecedor)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPrecoCompra)
                    .addComponent(lbCodigoReferencia)
                    .addComponent(txtCodigoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disk.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        ckDesativarProduto.setText("Desativar Produto");

        javax.swing.GroupLayout pnProdutoLayout = new javax.swing.GroupLayout(pnProduto);
        pnProduto.setLayout(pnProdutoLayout);
        pnProdutoLayout.setHorizontalGroup(
            pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDadosProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProdutoLayout.createSequentialGroup()
                        .addComponent(lbTitleProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                        .addComponent(lbCodigo))
                    .addComponent(pnDadosFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProdutoLayout.createSequentialGroup()
                        .addComponent(ckDesativarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        pnProdutoLayout.setVerticalGroup(
            pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTitleProduto)
                    .addComponent(lbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDadosProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDadosFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(ckDesativarProduto)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarCodigo(){
        TipoProduto tipoProduto = new TipoProduto();
        //Fornecedor fornecedor = new Fornecedor();
        String codigo = this.id;
        
        /*if (cbFornecedor.getSelectedIndex()!=-1){
            fornecedor = (Fornecedor) cbFornecedor.getSelectedItem();
            codigo = Horus.zeroFill(fornecedor.getId().toString(), 2) + codigo;
        }*/
        
        if (cbTipoProduto.getSelectedIndex()!=-1){
            tipoProduto = (TipoProduto) cbTipoProduto.getSelectedItem();
            codigo = tipoProduto.getCodigo() + codigo;
        }
        lbCodigo.setText(codigo);
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoProdutoActionPerformed
        atualizarCodigo();
    }//GEN-LAST:event_cbTipoProdutoActionPerformed

    private void cbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFornecedorActionPerformed
        atualizarCodigo();
    }//GEN-LAST:event_cbFornecedorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Produto produto = new Produto();
        
        try {
            produto.setId(Integer.parseInt(this.id));
            produto.setFornecedor((Fornecedor) cbFornecedor.getSelectedItem());
            produto.setTipoProduto((TipoProduto) cbTipoProduto.getSelectedItem());
            produto.setNome(txtNome.getText());
            produto.setDescricao(taDescricao.getText());
            produto.setValorEntrada(txtPrecoCompra.getText().isEmpty()?0:Float.parseFloat(txtPrecoCompra.getText().replaceAll(",", ".")));
            produto.setValorSaida(txtPreco.getText().isEmpty()?0:Float.parseFloat(txtPreco.getText().replaceAll(",", ".")));
            produto.setCodItemForn(txtCodigoReferencia.getText());
            produto.setIcAtivo(ckDesativarProduto.isSelected()?0:1);
            ManterProdutoController.getInstance().save(produto);
            if (iu.getImage() != null) {
                iu.save(produto.getTipoProduto().getCodigo() + produto.getId());
            }
            this.dispose();
            JOptionPane.showMessageDialog(this, "O produto foi salvo com sucesso!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarImagemActionPerformed
        int returnVal = fc.showOpenDialog(this);
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            iu = new ImageUploader();
            iu.upload(file);
            ImageIcon icon = new ImageIcon(iu.resizeImage(100, 100));
            lbImagem.setText("");
            lbImagem.setIcon(icon);
        }
    }//GEN-LAST:event_btnAtualizarImagemActionPerformed

    private void lbImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImagemMouseClicked
        if (produtoOriginal != null) {
            ImagemDialog imagemDialog = new ImagemDialog(null, true, produtoOriginal.getCodigo());
            imagemDialog.setVisible(true);
        }
    }//GEN-LAST:event_lbImagemMouseClicked
    
    public String getCodigo(){
        return lbCodigo.getText();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FrmManterProduto dialog = new FrmManterProduto(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarImagem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JComboBox cbTipoProduto;
    private javax.swing.JCheckBox ckDesativarProduto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCodigoReferencia;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbFornecedor;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbPrecoCompra;
    private javax.swing.JLabel lbTipoProduto;
    private javax.swing.JLabel lbTitleProduto;
    private javax.swing.JPanel pnDadosFornecedor;
    private javax.swing.JPanel pnDadosProduto;
    private javax.swing.JPanel pnProduto;
    private javax.swing.JScrollPane spDescricao;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField txtCodigoReferencia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JFormattedTextField txtPrecoCompra;
    // End of variables declaration//GEN-END:variables
}