package Main;

import PanelUser.*;
import ConnectUI.EventNavigationBar;
import Login.Login;
import java.awt.*;
import javax.swing.*;

public class MainND extends javax.swing.JFrame {

    public String username;
    public String quyen;
    public int chk;
    int xMouse, yMouse;
    
    public MainND() {
        initComponents();
        setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
    }
    
    public MainND(String user, String quyen1) {
        initComponents();
        setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        this.username = user;
        this.quyen = quyen1;
        getContentPane().setBackground(new Color(240, 240, 240));
        if (quyen.equals("SV")) {
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/services.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/usermale.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/Home.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/Start.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/layer.png")));
            navigationBar1.addEvent(new EventNavigationBar() {
                @Override
                public void beforeSelected(int index) {
                    if (index == 4) {
                        panelTransitions1.display(new LichHoc(username), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(false);
                        txtQuyen2.setVisible(false);
                    } else if (index == 2) {
                        panelTransitions1.display(new Home(username, quyen), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(true);
                        txtQuyen2.setVisible(true);
                    } else if (index == 3) {
                        panelTransitions1.display(new BangDiem(username), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(false);
                        txtQuyen2.setVisible(false);
                    } else if (index == 1) {
                        panelTransitions1.display(new ThongTinCaNhan(username, quyen), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(false);
                        txtQuyen2.setVisible(false);
                    } else if (index == 0) {
                        panelTransitions1.display(new DoiMatKhau(username), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(false);
                        txtQuyen2.setVisible(false);
                    }
                }

                @Override
                public void afterSelected(int index) {
                }
            });
        } else if (quyen.equals("GV")) {
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/services.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/usermale.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/Home.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/Start.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/img/stormy.png")));
            navigationBar1.addEvent(new EventNavigationBar() {
                @Override
                public void beforeSelected(int index) {
                    if (index == 4) {
                        panelTransitions1.display(new LichGiangDay(username), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(false);
                        txtQuyen2.setVisible(false);
                    } else if (index == 2) {
                        panelTransitions1.display(new Home(username, quyen), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(true);
                        txtQuyen2.setVisible(true);
                    } else if (index == 3) {
                        panelTransitions1.display(new VaoDiem(username), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(false);
                        txtQuyen2.setVisible(false);
                    } else if (index == 1) {
                        panelTransitions1.display(new ThongTinCaNhan(username, quyen), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(false);
                        txtQuyen2.setVisible(false);
                    } else if (index == 0) {
                        panelTransitions1.display(new DoiMatKhau(username), navigationBar1.getAnimator());
                        txtQuyen1.setVisible(false);
                        txtQuyen2.setVisible(false);
                    }
                }

                @Override
                public void afterSelected(int index) {
                }
            });
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigationBar1 = new ConnectUI.NavigationBar();
        panelTransitions1 = new Transitions.PanelTransitions();
        txtQuyen2 = new javax.swing.JLabel();
        txtQuyen1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1005, 650));
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navigationBar1.setForeground(new java.awt.Color(71, 175, 242));

        javax.swing.GroupLayout navigationBar1Layout = new javax.swing.GroupLayout(navigationBar1);
        navigationBar1.setLayout(navigationBar1Layout);
        navigationBar1Layout.setHorizontalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        navigationBar1Layout.setVerticalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(navigationBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 548, 975, -1));
        getContentPane().add(panelTransitions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 985, 556));

        txtQuyen2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuyen2.setForeground(new java.awt.Color(102, 102, 102));
        txtQuyen2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtQuyen2.setText("Không phải bạn,");
        getContentPane().add(txtQuyen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 100, -1));

        txtQuyen1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtQuyen1.setForeground(new java.awt.Color(102, 153, 255));
        txtQuyen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtQuyen1.setText("Đăng Xuất !");
        txtQuyen1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtQuyen1MouseMoved(evt);
            }
        });
        txtQuyen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtQuyen1MousePressed(evt);
            }
        });
        getContentPane().add(txtQuyen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 180, -1));

        btnClose.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(973, 0, 32, 32));

        bg.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bguser1.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1005, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuyen1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuyen1MouseMoved
        txtQuyen1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_txtQuyen1MouseMoved

    private void txtQuyen1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuyen1MousePressed
        chk = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (chk == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_txtQuyen1MousePressed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        navigationBar1.initSelectedIndex(2);
    }//GEN-LAST:event_formWindowOpened

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

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
            java.util.logging.Logger.getLogger(MainND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainND().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnClose;
    private ConnectUI.NavigationBar navigationBar1;
    private Transitions.PanelTransitions panelTransitions1;
    private javax.swing.JLabel txtQuyen1;
    private javax.swing.JLabel txtQuyen2;
    // End of variables declaration//GEN-END:variables
}
