import java.util.Date;
import java.util.ArrayList;
public class Spreadsheet {

    private int rows;
    private int columns;
    private ArrayList<ArrayList<Cell>> cells;
    public Spreadsheet()
    {
        cells = new ArrayList<>();
    }
    public Spreadsheet(int rows, int columns)
    {
        try {
            spreadSheetCheck(rows, columns);
            cells = new ArrayList<>();
            this.rows = rows;
            this.columns = columns;
            for (int i = 0; i < rows; i++) {
                cells.add(new ArrayList<Cell>(columns));
            }
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    cells.get(r).add(c, new Cell());
                }
            }
        } catch(InvalidParametersForSpreadsheetException e) {
            System.out.println(e.getMessage());
        }
    }
    private void spreadSheetCheck(int row, int column){
        if (row < 0 || column < 0) {
            throw new InvalidParametersForSpreadsheetException("Can't create a spreadsheet with this parameters  ");
        }
    }
    private void isSpreadSheet(){
        if (cells == null){
            throw new InvalidParametersForSpreadsheetException("That spreadsheet doesn't exist  ");
        }
    }
    public int getRows() {
        try {
            isSpreadSheet();
        } catch(InvalidParametersForSpreadsheetException e) {
            System.out.print(e.getMessage());
        }
        return rows;
    }
    public int getColumns() {
        try {
            isSpreadSheet();
        } catch(InvalidParametersForSpreadsheetException e) {
            System.out.print(e.getMessage());
        }
        return columns;
    }
    public void addColumn(){
        try {
            for (int i = 0; i < rows; i++) {
                cells.get(i).add(new Cell());
            }
            columns++;
        } catch (InvalidParametersForSpreadsheetException e){
            System.out.println(e.getMessage());
        }
    }
    public void addColumn(int pos){
        try {
            isSpreadSheet();
            for (int i = 0; i < rows; i++) {
                cells.get(i).add(pos, new Cell());
            }
            columns++;
        } catch (InvalidParametersForSpreadsheetException e){
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(pos + " is invalid position for adding a column");
        }
    }
    public void addRow(){
        try{
            cells.add(new ArrayList<Cell>());
            for(int j = 0; j < columns; j++){
                cells.get(rows).add(new Cell());
            }
            rows++;
        } catch(InvalidParametersForSpreadsheetException e){
            System.out.println(e.getMessage());
        }
    }
    public void addRow(int pos) {
        try{
            isSpreadSheet();
            cells.add(pos, new ArrayList<Cell>(columns));
            for (int j = 0; j < columns; j++) {
                cells.get(pos).add(j, new Cell());
            }
            rows++;
        } catch (InvalidParametersForSpreadsheetException e){
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(pos + " is invalid position for adding a row");
        }
    }
    public void setValueAt(int i, int j, Object val) {
        try {
            isSpreadSheet();
            cells.get(i).get(j).setValue(val);
        } catch(InvalidParametersForSpreadsheetException e){
            System.out.println(e.getMessage());
        } catch(IndexOutOfBoundsException e){
            System.out.println("[" + i + ", " + j + "] is Invalid position for setting value");
        }
    }
    public Object getValueAt(int i, int j)
    {
        try {
            isSpreadSheet();
            return cells.get(i).get(j).getValue();
        } catch(InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.print("[" + i + ", " + j + "] is Invalid position for getting value  ");
        }
        return null;
    }
    public Type getTypeAt(int i, int j)
    {
        try {
            isSpreadSheet();
            return cells.get(i).get(j).getType();
        } catch(InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.print("[" + i + ", " + j + "] is Invalid position for getting type  ");
        }
        return null;
    }
    public void setColorAt(int i, int j, Color color)
    {
        try {
            isSpreadSheet();
            cells.get(i).get(j).setColor(color);
        } catch(InvalidParametersForSpreadsheetException e){
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[" + i + ", " + j + "] is Invalid position for setting color");
        }
    }
    public Color getColorAt(int i, int j)
    {
        try {
            isSpreadSheet();
            return cells.get(i).get(j).getColor();
        } catch(InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.print("[" + i + ", " + j + "] is Invalid position for setting color  ");
        }
        return null;
    }
    public void resetAll()
    {
        try{
            isSpreadSheet();
            for(int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    cells.get(i).get(j).reset();
                }
            }
        } catch (InvalidParametersForSpreadsheetException e) {
            System.out.println(e.getMessage());
        }
    }
    public void resetCellAt(int i, int j)
    {
        try{
            isSpreadSheet();
            cells.get(i).get(j).reset();
        } catch (InvalidParametersForSpreadsheetException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getColumnSum(int j)
    {
        try {
            isSpreadSheet();
            double Sum = 0;
            for (ArrayList<Cell> r : cells) {
                if (r.get(j).getType() == Type.NUMBER) {
                    Sum += Double.parseDouble(r.get(j).getValue().toString());;
                } else {
                    System.out.print("There is cell containing non-numeric value in " + j + "'th column  ");
                    return 0;
                }
            }
            return Sum;
        }  catch (InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        }  catch (IndexOutOfBoundsException e){
            System.out.print(j + " is not valid column for computing sum  ");
        }
        return 0;
    }
    public double getRowSum(int i)
    {
        try {
            isSpreadSheet();
            double Sum = 0;
            for (Cell c : cells.get(i)) {
                if (c.getType() == Type.NUMBER) {
                    Sum += Double.parseDouble(c.getValue().toString());
                } else {
                    System.out.print("There is cell containing non-numeric value in " + i + "'th row  ");
                    return 0;
                }
            }
            return Sum;
        }  catch (InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        }  catch (IndexOutOfBoundsException e){
            System.out.print(i + " is not valid row for computing sum  ");
        }
        return 0;
    }

    public double getColumnAverage(int j)
    {
        try {
            isSpreadSheet();
            double Sum = 0;
            for (ArrayList<Cell> r : cells) {
                if (r.get(j).getType() == Type.NUMBER) {
                    Sum += Double.parseDouble(r.get(j).getValue().toString());;
                } else {
                    System.out.print("There is cell containing non-numeric value in " + j + "'th column  ");
                    return 0;
                }
            }
            return Sum / rows;
        }  catch (InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        }  catch (IndexOutOfBoundsException e){
            System.out.print(j + " is not valid column for computing average of column  ");
        }
        return 0;
    }
    public double getRowAverage(int i)
    {
        try {
            isSpreadSheet();
            double Sum = 0;
            for (Cell c : cells.get(i)) {
                if (c.getType() == Type.NUMBER) {
                    Sum += Double.parseDouble(c.getValue().toString());
                } else {
                    System.out.print("There is cell containing non-numeric value in " + i + "'th row  ");
                    return 0;
                }
            }
            return Sum / columns;
        }  catch (InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        }  catch (IndexOutOfBoundsException e){
            System.out.print(i + " is not valid row for computing average of row  ");
        }
        return 0;
    }


    public double getAreaSum(int a, int b, int c, int d)
    {
        try {
            double Sum = 0;
            for (int i = a; i <= b; i++) {
                for (int j = c; j <= d; j++) {
                    if (cells.get(i).get(j).getType() == Type.NUMBER) {
                        Sum += Double.parseDouble(cells.get(i).get(j).getValue().toString());
                    } else {
                        System.out.print("This area contains non-numeric value. ");
                        return 0;
                    }
                }
            }
            return Sum;
        } catch (InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        }  catch (IndexOutOfBoundsException e){
            System.out.print("not valid parameters for computing average of area  ");
        }
        return 0;
    }

    public double getAreaAverage(int a, int b, int c, int d)
    {
        try {
            double Sum = 0;
            for (int i = a; i <= b; i++) {
                for (int j = c; j <= d; j++) {
                    if (cells.get(i).get(j).getType() == Type.NUMBER) {
                        Sum += Double.parseDouble(cells.get(i).get(j).getValue().toString());
                    } else {
                        System.out.print("This area contains non-numeric value. ");
                        return 0;
                    }
                }
            }
            return Sum / ((b - a + 1) * (d - c + 1));
        } catch (InvalidParametersForSpreadsheetException e){
            System.out.print(e.getMessage());
        }  catch (IndexOutOfBoundsException e){
            System.out.print("not valid parameters for computing average of area  ");
        }
        return 0;
    }

}

