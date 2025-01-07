package dashboardUI.chart;

import PanelAdmin.PCGiangDay;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class PanelChartLine extends javax.swing.JPanel {

    private final List<ModelChartLine> list;

    public PanelChartLine() {
        list = new ArrayList<>();
        initComponents();
        setOpaque(false);
        loadmau();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private double getMax() {
        double max = 0;
        for (ModelChartLine d : list) {
            if (d.getValue() > max) {
                max = d.getValue();
            }
        }
        return max;
    }
    
    Preferences pref;
    boolean prefReme;
    int r,g,b;
    
    public void loadmau() {
        pref = Preferences.userNodeForPackage(PCGiangDay.class);
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            r = Integer.parseInt(pref.get("r", ""));
            g = Integer.parseInt(pref.get("g", ""));
            b = Integer.parseInt(pref.get("b", ""));
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (list.size() > 1) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int margin = 5;
            int width = getWidth() - margin * 2;
            int height = getHeight() - margin * 2;
            double max = getMax();
            double space = width / (list.size() - 1);
            Path2D.Float p = new Path2D.Float();
            p.moveTo(margin, getHeight() - margin);
            int x = margin;
            for (ModelChartLine data : list) {
                double location = data.getValue() * height / max;
                location = getHeight() - location;
                p.lineTo(x, location);
                x += space;
            }
            p.lineTo(x - space, getHeight() - margin);
            GradientPaint gra = new GradientPaint(0, margin, new Color(r, g, b), 0, getHeight(), new Color(255, 255, 255, 0));
            g2.setPaint(gra);
            g2.fill(p);
            drawPoint(g2);
        }
        super.paintComponent(grphcs);
    }

    private void drawPoint(Graphics2D g2) {
        g2.setColor(new Color(r, g, b));
        int size = 4;
        int margin = 5;
        int width = getWidth() - margin * 2;
        int height = getHeight() - margin * 2;
        double max = getMax();
        double space = width / (list.size() - 1);
        int x = margin;
        for (ModelChartLine data : list) {
            double location = data.getValue() * height / max;
            location = getHeight() - location;
            g2.fillOval(x - 2, (int) location - 2, size, size);
            x += space;
        }
    }

    public void addItem(ModelChartLine data) {
        list.add(data);
        repaint();
    }

    public void removeAllData() {
        list.clear();
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
