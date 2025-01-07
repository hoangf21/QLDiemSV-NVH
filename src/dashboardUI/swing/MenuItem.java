package dashboardUI.swing;

import PanelAdmin.PCGiangDay;
import dashboardUI.model.Model_Menu;
import java.awt.Color;
import java.util.prefs.Preferences;

public class MenuItem extends javax.swing.JPanel {

    private final Model_Menu data;
    
    Preferences pref;
    boolean prefReme;
    int r, g, b;
    
    public MenuItem(Model_Menu data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        if (data.getType() == Model_Menu.MenuType.MENU) {
            lbIcon.setIcon(data.toIcon());
            lbName.setText(data.getName());
        } else {
            lbName.setText(" ");
        }
        loadcolor();
    }

    public void loadcolor() {
        pref = Preferences.userNodeForPackage(PCGiangDay.class);
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            r = Integer.parseInt(pref.get("r", ""));
            g = Integer.parseInt(pref.get("g", ""));
            b = Integer.parseInt(pref.get("b", ""));
        }

    }

    public void setSelected(boolean selected) {
        if (data.getType() == Model_Menu.MenuType.MENU) {
            if (selected) {
                lbIcon.setIcon(data.toIconSelected());
                lbName.setForeground(new Color(r, g, b));
            } else {
                lbIcon.setIcon(data.toIcon());
                lbName.setForeground(new Color(198, 203, 210));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();

        lbName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(198, 203, 210));
        lbName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addComponent(lbName)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
