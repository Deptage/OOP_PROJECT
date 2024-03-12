package pl.poznan.put.matrix;
public class Element {
    private double value;

    Element(double initial) {
        //constructor to create an element with initial value
        this.value = initial;
    }

    Element() {
        //constructor to create an element with default initial value
        this.value = 0;
    }

    public Element newValue(double val) {
        return new Element(val);
    }

    public double printValue() {
        return value;
    }
}
