package dashboardUI.chart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

public class ChartPie extends javax.swing.JPanel {

    public List<ModelChartPie> getModel() {
        return model;
    }

    public void setModel(List<ModelChartPie> model) {
        this.model = model;
//        initData();
    }

    private List<ModelChartPie> model;

    public ChartPie() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
    }

//    private void initData() {
//        panelChartPie1.removeAllData();
//        if (model != null) {
//            for (ModelChartPie data : model) {
//                panelChartPie1.addItem(data);
//                panelData.add(new ItemChartPie(data));
//            }
//        }
//    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
