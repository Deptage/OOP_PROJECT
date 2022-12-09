public class Element implements Operations{
    private double value;
    Element(double initial)
    {
        this.value=initial;
    }
    Element(){
        this.value=0;
    }
    public Element addition(double add)
    {
        return new Element(this.value+add);
    }
    public Element substraction(double sub)
    {
        return new Element(this.value-sub);
    }
    public Element multiplication(double mul)
    {
        return new Element(this.value*mul);
    }
    public Element division(double div)
    {
        return new Element(this.value/div);
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
