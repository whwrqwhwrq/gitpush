package builder.demo2;

public class Worker extends Builder{
    private Combo combo;

    public Worker() {
        combo = new Combo();
    }

    @Override
    Builder hamburger(String msg) {
        combo.setHamburger(msg);
        return this;
    }

    @Override
    Builder french_fries(String msg) {
        combo.setFrench_fries(msg);
        return this;
    }

    @Override
    Builder cola(String msg) {
        combo.setCola(msg);
        return this;
    }

    @Override
    Combo getCombo() {
        return combo;
    }
}
