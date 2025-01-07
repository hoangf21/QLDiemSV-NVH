package combobox;

public class giangvien {
    String magv,tengv;

    public giangvien() {
    }

    public giangvien(String magv, String tengv) {
        this.magv = magv;
        this.tengv = tengv;
    }

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getTengv() {
        return tengv;
    }

    public void setTengv(String tengv) {
        this.tengv = tengv;
    }

    @Override
    public String toString() {
        return tengv.toString();
    } 
}
