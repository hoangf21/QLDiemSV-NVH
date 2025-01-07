package dashboardUI.chart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

public class ChartLine extends javax.swing.JPanel {

    public List<ModelChartLine> getModel() {
        return model;
    }

    public void setModel(List<ModelChartLine> model) {
        this.model = model;
        initData();
    }

    private List<ModelChartLine> model;

    public ChartLine() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
    }

    private void initData() {
        panelChartLine.removeAllData();
        if (model != null) {
            for (ModelChartLine data : model) {
                panelChartLine.addItem(data);
                panelData.add(new ItemChartLine(data));
            }
        }
    }

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

        panelData = new javax.swing.JPanel();
        panelChartLine = new dashboardUI.chart.PanelChartLine();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 210));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelData.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        panelData.setOpaque(false);
        panelData.setLayout(new javax.swing.BoxLayout(panelData, javax.swing.BoxLayout.Y_AXIS));
        add(panelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 40, 280, 188));

        javax.swing.GroupLayout panelChartLineLayout = new javax.swing.GroupLayout(panelChartLine);
        panelChartLine.setLayout(panelChartLineLayout);
        panelChartLineLayout.setHorizontalGroup(
            panelChartLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        panelChartLineLayout.setVerticalGroup(
            panelChartLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        add(panelChartLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 410, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Lưu lượng truy cập:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 30));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private dashboardUI.chart.PanelChartLine panelChartLine;
    private javax.swing.JPanel panelData;
    // End of variables declaration//GEN-END:variables
}
