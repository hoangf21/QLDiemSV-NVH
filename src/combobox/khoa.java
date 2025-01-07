package combobox;

public class khoa {
    String makhoa,tenkhoa;

    public khoa() {
    }

    public khoa(String makhoa, String tenkhoa) {
        this.makhoa = makhoa;
        this.tenkhoa = tenkhoa;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    @Override
    public String toString() {
        return tenkhoa.toString();
    } 
}
