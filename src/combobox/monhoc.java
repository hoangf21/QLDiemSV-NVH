package combobox;

public class monhoc {
    String mamh,tenmh;
    int sotin;

    public monhoc() {
    }

    public monhoc(String mamh, String tenmh, int sotin) {
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.sotin = sotin;
    }

    public int getSotin() {
        return sotin;
    }

    public void setSotin(int sotin) {
        this.sotin = sotin;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    @Override
    public String toString() {
        return tenmh.toString();
    } 
}
