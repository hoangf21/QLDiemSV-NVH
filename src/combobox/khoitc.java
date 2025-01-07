package combobox;

public class khoitc {
    String makhoi,tenkhoi;

    public khoitc() {
    }

    public khoitc(String makhoi, String tenkhoi) {
        this.makhoi = makhoi;
        this.tenkhoi = tenkhoi;
    }

    public String getMakhoi() {
        return makhoi;
    }

    public void setMakhoi(String makhoi) {
        this.makhoi = makhoi;
    }

    public String getTenkhoi() {
        return tenkhoi;
    }

    public void setTenkhoi(String tenkhoi) {
        this.tenkhoi = tenkhoi;
    }

    @Override
    public String toString() {
        return tenkhoi.toString();
    } 
}
