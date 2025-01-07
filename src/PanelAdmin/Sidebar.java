package PanelAdmin;

import dashboardUI.event.*;
import dashboardUI.model.Model_Menu;
import dashboardUI.shadow.ShadowBorder;
import dashboardUI.swing.PanelShadow;
import java.awt.*;
import java.awt.image.BufferedImage;
import org.jdesktop.animation.timing.*;

public class Sidebar extends PanelShadow {

    private int selectedIndex = -1;
    private double menuTarget;
    private double menuLastTarget;
    private double currentLocation;
    private BufferedImage selectedImage;
    private Animator animator;
    private EventMenuCallBack callBack;
    private EventMenu event;
    
    public Sidebar() {
        initComponents();
        init();
    }
    
    public void init(){
        setRadius(20);
        initData();
        listMenu.addEventSelectedMenu(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if (!animator.isRunning()) {
                    if (index != selectedIndex) {
                        Sidebar.this.callBack = callBack;
                        selectedIndex = index;
                        menuTarget = selectedIndex * 50 + listMenu.getY();
                        animator.start();
                    }
                }
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                currentLocation = (menuTarget - menuLastTarget) * fraction;
                currentLocation += menuLastTarget;
                repaint();
            }

            @Override
            public void end() {
                menuLastTarget = menuTarget;
                callBack.call(selectedIndex);
                if (event != null) {
                    event.menuIndexChange(selectedIndex);
                }
            }
        };
        animator = new Animator(300, target);
        animator.setResolution(1);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }
    
    public void setSelectedIndex(int index) {
        selectedIndex = index;
        menuTarget = selectedIndex * 50 + listMenu.getY();
        menuLastTarget = menuTarget;
        currentLocation = menuLastTarget;
        listMenu.selectedIndex(index);
        repaint();
    }
    
    private void initData() {
        listMenu.addItem(new Model_Menu("1", "Trang Chủ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("2", "Môn Tín Chỉ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("3", "Khối Tín Chỉ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("4", "QL Sinh Viên", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("5", "QL Giảng Viên", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("6", "PC Giảng Dạy", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("7", "Quản Lý Điểm ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("8", "Đăng Xuất", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }
    
    private void createImage() {
        int width = getWidth() - 30;
        selectedImage = ShadowBorder.getInstance().createShadowOut(width, 50, 8, 8, new Color(242, 246, 253));
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createImage();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        if (selectedIndex >= 0) {
            grphcs.drawImage(selectedImage, 15, (int) currentLocation, null);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile1 = new PanelAdmin.Profile();
        listMenu = new dashboardUI.swing.ListMenu<>();

        setPreferredSize(new java.awt.Dimension(250, 609));

        profile1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        listMenu.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        listMenu.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 506, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 83, Short.MAX_VALUE)
                    .addComponent(listMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addEvent(EventMenu event) {
        this.event = event;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private dashboardUI.swing.ListMenu<String> listMenu;
    private PanelAdmin.Profile profile1;
    // End of variables declaration//GEN-END:variables
}
