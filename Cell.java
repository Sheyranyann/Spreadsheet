import java.util.Date;
public class Cell {
    private Type type;
    private Color color;
    private Object value;

    public Cell()
    {
        this.type = null;
        this.color = Color.WHITE;
        this.value = null;
    }

    public Color getColor()
    {
        return color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }

    public Type getType()
    {
        return type;
    }
    public void setValue(Object value)
    {
        if (value instanceof String) {
            this.type = Type.STRING;
        }
        else if (value instanceof  Number){
            this.type = Type.NUMBER;
        }
        else if (value instanceof  Date){
            this.type = Type.DATE;
        }
        else {
            System.out.println("Invalid type for setting value");
            return;
        }
        this.value = value;
    }
    public Object getValue()
    {
        return value;
    }
    public void reset()
    {
        this.type = null;
        this.color = Color.WHITE;
        this.value = null;
    }

}













