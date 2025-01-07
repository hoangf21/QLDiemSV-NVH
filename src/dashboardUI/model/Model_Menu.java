package dashboardUI.model;

import PanelAdmin.*;
import java.util.prefs.Preferences;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        loadmau();
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
       
    }

    private String icon;
    private String name;
    private MenuType type;

    Preferences pref;
    boolean prefReme;
    String i = "";
    
    public void loadmau(){
        pref = Preferences.userNodeForPackage(PCGiangDay.class);
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            i = pref.get("i", "");
        }
    }
    
    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/dashboardUI/icon/" + icon + ".png"));
    }

    public Icon toIconSelected() {
        return new ImageIcon(getClass().getResource("/dashboardUI/icon/" + icon + i + "_selected.png"));
    }

    public static enum MenuType {
        MENU, EMPTY
    }
}
