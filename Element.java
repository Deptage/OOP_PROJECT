public class Element{
    private double value;
    Element(double initial)
    {
        this.value=initial;
    }
    Element(){
        this.value=0;
    }
    public Element newValue(double val)
    {
        return new Element(val);
    }
    public double pvalue()
    {
        return value;
    }
}
