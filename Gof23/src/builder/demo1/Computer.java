package builder.demo1;
//产品，电脑
public class Computer {
    private String combine;
    private String installSystem;
    private String installDrivers;
    private String installSoftware;

    public String getCombine() {
        return combine;
    }

    public void setCombine(String combine) {
        this.combine = combine;
    }

    public String getInstallSystem() {
        return installSystem;
    }

    public void setInstallSystem(String installSystem) {
        this.installSystem = installSystem;
    }

    public String getInstallDrivers() {
        return installDrivers;
    }

    public void setInstallDrivers(String installDrivers) {
        this.installDrivers = installDrivers;
    }

    public String getInstallSoftware() {
        return installSoftware;
    }

    public void setInstallSoftware(String installSoftware) {
        this.installSoftware = installSoftware;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "combine='" + combine + '\'' +
                ", installSystem='" + installSystem + '\'' +
                ", installDrivers='" + installDrivers + '\'' +
                ", installSoftware='" + installSoftware + '\'' +
                '}';
    }
}
