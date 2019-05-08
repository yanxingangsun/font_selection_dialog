package 字体;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author yanxi
 */
public class 字体对话框 extends JDialog {
    private static 字体对话框 单实例对话框=null;
    
    private Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
            Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };
    private String[] colornames = { "BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY",
            "GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE",
            "YELLOW" };
    private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
    
    private Font font;
    
    private int firstVisibleIndex=0;
    private int lastVisibleIndex=0;
    
    private 字体对话框(JFrame owner, String title, boolean modal) {
        super(owner,title,modal);
        initComponents();
        初始化JList字体(); 
        this.setDefaultCloseOperation(字体对话框.DISPOSE_ON_CLOSE);
    }
    private void 初始化JList字体(){ 
        DefaultListModel model=new DefaultListModel();
        for(int i=0;i<fonts.length;i++){
            model.addElement(fonts[i]); 
        } 
        jList字体.setModel(model); 
        
        jList字体.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) { 
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(index>=firstVisibleIndex&&index<=lastVisibleIndex){
                    Font f=getFont();
                    setFont(new Font(fonts[index],f.getStyle(),f.getSize()));  
                }  
                return this;
            }
        });
        
        jScrollPane字体.getViewport().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) { 
                firstVisibleIndex=jList字体.getFirstVisibleIndex();
                lastVisibleIndex=jList字体.getLastVisibleIndex(); 
                jList字体.updateUI();
            }
        });  
    } 
    
    public static Font 显示(Font f){
        if(单实例对话框==null){
            单实例对话框=new 字体对话框(null,"选择字体",true);
        }
        
        单实例对话框.font=f;
        
        单实例对话框.jLabel预览.setFont(f);
        
        单实例对话框.jTextField字体.setText(f.getName());
        单实例对话框.jTextField样式.setText(""+f.getStyle());
        单实例对话框.jTextField大小.setText(""+f.getSize());
        
        for(int i=0;i<单实例对话框.fonts.length;i++){ 
            if(f.getName().equals(单实例对话框.jList字体.getModel().getElementAt(i))){
                单实例对话框.jList字体.setSelectedIndex(i); 
                单实例对话框.jList字体.ensureIndexIsVisible(i);
                
                int j=单实例对话框.jList字体.getVisibleRowCount();
                if(i-j>0)单实例对话框.firstVisibleIndex=i-j;
                else 单实例对话框.firstVisibleIndex=0;
                if(i+j<单实例对话框.fonts.length)单实例对话框.lastVisibleIndex=i+j;
                else 单实例对话框.lastVisibleIndex=单实例对话框.fonts.length-1;
                
                break;
            }
        } 
        
        单实例对话框.jList样式.setSelectedIndex(f.getStyle());
        单实例对话框.jList样式.ensureIndexIsVisible(f.getStyle());
        
        switch(f.getSize()){
            case 10:单实例对话框.jList大小.setSelectedIndex(0);单实例对话框.jList大小.ensureIndexIsVisible(0);break;
            case 14:单实例对话框.jList大小.setSelectedIndex(1);单实例对话框.jList大小.ensureIndexIsVisible(1);break;
            case 18:单实例对话框.jList大小.setSelectedIndex(2);单实例对话框.jList大小.ensureIndexIsVisible(2);break;
            case 22:单实例对话框.jList大小.setSelectedIndex(3);单实例对话框.jList大小.ensureIndexIsVisible(3);break;
            case 26:单实例对话框.jList大小.setSelectedIndex(4);单实例对话框.jList大小.ensureIndexIsVisible(4);break;
            case 30:单实例对话框.jList大小.setSelectedIndex(5);单实例对话框.jList大小.ensureIndexIsVisible(5);break;
            default:单实例对话框.jList大小.setSelectedIndex(-1);单实例对话框.jTextField大小.setText(""+f.getSize());
        }

        单实例对话框.setSize(650,500);
        单实例对话框.setVisible(true);
        return 单实例对话框.font;
    }
    
    public static Font 显示(){ 
        return 显示(new Font("宋体",Font.BOLD,22));
    }
    
    public static void main(String[] arg){
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(字体对话框.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(字体对话框.显示());  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList大小 = new javax.swing.JList<>();
        jPanel13 = new javax.swing.JPanel();
        jTextField大小 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList样式 = new javax.swing.JList<>();
        jPanel12 = new javax.swing.JPanel();
        jTextField样式 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane字体 = new javax.swing.JScrollPane();
        jList字体 = new javax.swing.JList<>();
        jPanel11 = new javax.swing.JPanel();
        jTextField字体 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel预览 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton确定 = new javax.swing.JButton();
        jButton取消 = new javax.swing.JButton();

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "大小", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18))); // NOI18N
        jPanel7.setLayout(new java.awt.BorderLayout());

        jList大小.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        jList大小.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "10    ", "14    ", "18    ", "22    ", "26    ", "30    " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList大小.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList大小ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList大小);

        jPanel7.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        jTextField大小.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        jTextField大小.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField大小FocusLost(evt);
            }
        });
        jTextField大小.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField大小ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField大小);

        jPanel7.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "样式", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18))); // NOI18N
        jPanel9.setLayout(new java.awt.BorderLayout());

        jList样式.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        jList样式.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "普通  （PLAIN）", "粗体  （BOLD）", "斜体  （ITALIC）", "粗斜体（BOLD ITALIC）" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList样式.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList样式ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jList样式);

        jPanel9.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jTextField样式.setEditable(false);
        jTextField样式.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        jPanel12.add(jTextField样式);

        jPanel9.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel8.add(jPanel9, java.awt.BorderLayout.LINE_END);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "字体", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18))); // NOI18N
        jPanel10.setLayout(new java.awt.BorderLayout());

        jList字体.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        jList字体.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList字体ValueChanged(evt);
            }
        });
        jScrollPane字体.setViewportView(jList字体);

        jPanel10.add(jScrollPane字体, java.awt.BorderLayout.CENTER);

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        jTextField字体.setEditable(false);
        jTextField字体.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        jPanel11.add(jTextField字体);

        jPanel10.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jSplitPane1.setTopComponent(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "预览", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18))); // NOI18N
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel预览.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel预览.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel预览.setText("字体预览 Aa Bb ");
        jPanel4.add(jLabel预览);

        jSplitPane1.setRightComponent(jPanel4);

        jPanel2.add(jSplitPane1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton确定.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        jButton确定.setText("确定");
        jButton确定.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton确定ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton确定);

        jButton取消.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        jButton取消.setText("取消");
        jButton取消.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton取消ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton取消);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jList大小ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList大小ValueChanged
        switch(jList大小.getSelectedIndex()){
            case 0:jTextField大小.setText("10");break;
            case 1:jTextField大小.setText("14");break;
            case 2:jTextField大小.setText("18");break;
            case 3:jTextField大小.setText("22");break;
            case 4:jTextField大小.setText("26");break;
            case 5:jTextField大小.setText("30");break;
            default:;
        }

        int size=Integer.parseInt(jTextField大小.getText()); 
        jLabel预览.setFont(new Font(font.getName(),font.getStyle(),size));
        font = new Font(
                jLabel预览.getFont().getName(),
                jLabel预览.getFont().getStyle(),
                jLabel预览.getFont().getSize());
    }//GEN-LAST:event_jList大小ValueChanged

    private void jList样式ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList样式ValueChanged
        int i=jList样式.getSelectedIndex(); 
        jLabel预览.setFont(new Font(font.getName(),i,font.getSize())); 
        switch(i){
            case 0:jTextField样式.setText("普通  （PLAIN）");break;
            case 1:jTextField样式.setText("粗体  （BOLD）");break;
            case 2:jTextField样式.setText("斜体  （ITALIC）");break;
            case 3:jTextField样式.setText("粗斜体（BOLD ITALIC）");break;
            default:;
        }
        font = new Font(
                jLabel预览.getFont().getName(),
                jLabel预览.getFont().getStyle(),
                jLabel预览.getFont().getSize());
    }//GEN-LAST:event_jList样式ValueChanged

    private void jList字体ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList字体ValueChanged
        jTextField字体.setText(jList字体.getSelectedValue()); 
        jLabel预览.setFont(new Font(jList字体.getSelectedValue(),font.getStyle(),font.getSize()));
        font = new Font(
                jLabel预览.getFont().getName(),
                jLabel预览.getFont().getStyle(),
                jLabel预览.getFont().getSize());
    }//GEN-LAST:event_jList字体ValueChanged

    private void jButton确定ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton确定ActionPerformed
        font = new Font(
            jLabel预览.getFont().getName(),
            jLabel预览.getFont().getStyle(),
            jLabel预览.getFont().getSize());
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_jButton确定ActionPerformed

    private void jButton取消ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton取消ActionPerformed
        font=null;
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_jButton取消ActionPerformed

    private void jTextField大小FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField大小FocusLost
        try{ 
            int size=Integer.parseInt(jTextField大小.getText()); 
            jLabel预览.setFont(new Font(font.getName(),font.getStyle(),size));
            font = new Font(
                jLabel预览.getFont().getName(),
                jLabel预览.getFont().getStyle(),
                jLabel预览.getFont().getSize());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, e);
            jTextField大小.setText(""+font.getSize());
        } 
    }//GEN-LAST:event_jTextField大小FocusLost

    private void jTextField大小ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField大小ActionPerformed
        jTextField大小FocusLost(null);
    }//GEN-LAST:event_jTextField大小ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton取消;
    private javax.swing.JButton jButton确定;
    private javax.swing.JLabel jLabel预览;
    private javax.swing.JList<String> jList大小;
    private javax.swing.JList<String> jList字体;
    private javax.swing.JList<String> jList样式;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane字体;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField大小;
    private javax.swing.JTextField jTextField字体;
    private javax.swing.JTextField jTextField样式;
    // End of variables declaration//GEN-END:variables
}
