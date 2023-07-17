import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //1.Non-existing spreadsheet
        Spreadsheet spr1 = new Spreadsheet(-3, 0);
        spr1.setValueAt(0,0,"A");
        spr1.setColorAt(4,5,Color.YELLOW);
        spr1.resetAll();
        System.out.println(spr1.getValueAt(0,3));
        System.out.println(spr1.getColumns());
        System.out.println(spr1.getColumnSum(3));

        System.out.println();

        //2 Constructor without parameters
        Spreadsheet spr = new Spreadsheet();
        spr.addColumn();
        //empty spreadsheet
        System.out.println(spr.getValueAt(0,0));
        spr.addRow();
        //null
        System.out.println(spr.getValueAt(0,0));

        System.out.println();

        //3
        Spreadsheet spr2 = new Spreadsheet(3, 3);

        //invalid type
        spr2.setValueAt(1,1,true);

        //empty cell
        System.out.println(spr2.getValueAt(0, 1) + "  ");

        //non - existing cell
        System.out.println(spr2.getValueAt(7, 1));
        spr2.addColumn(3);

        System.out.println();

        int t = 0;
        for (int i = 0; i < spr2.getRows(); i++) {
            for (int j = 0; j < spr2.getColumns(); j++) {
                spr2.setValueAt(i, j, t++);
            }
        }
        spr2.addRow(8);
        spr2.addRow(3);
        for(int i = 0; i < spr2.getRows(); i++){
            spr2.setValueAt(i,0,new Date());
        }
        spr2.resetCellAt(1,1);
        for (int i = 0; i < spr2.getRows(); i++) {
            for (int j = 0; j < spr2.getColumns(); j++) {
                System.out.print(spr2.getValueAt(i, j) + "  ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < spr2.getRows(); i++) {
            for (int j = 0; j < spr2.getColumns(); j++) {
                if(spr2.getValueAt(i, j) == null)
                    spr2.setValueAt(i,j,0);
                System.out.print(spr2.getValueAt(i, j) + "  ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < spr2.getRows(); i++) {
            for (int j = 0; j < spr2.getColumns(); j++) {
                if(spr2.getValueAt(i, j) == (Integer)0)
                    spr2.resetCellAt(i,j);
                System.out.print(spr2.getValueAt(i, j) + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < spr2.getRows(); i++) {
            for (int j = 0; j < spr2.getColumns(); j++) {
                System.out.print(spr2.getValueAt(i, j) + "  ");
            }
            System.out.println();
        }

        System.out.println(spr2.getTypeAt(2,3));
        spr2.setColorAt(5,6,Color.BLUE);
        spr2.setColorAt(1,3,Color.GREEN);
        System.out.println(spr2.getColorAt(1,3));
        spr2.resetAll();
        for (int i = 0; i < spr2.getRows(); i++) {
            for (int j = 0; j < spr2.getColumns(); j++) {
                System.out.println(spr2.getValueAt(i, j) + "  " + spr2.getTypeAt(i, j) + "  " + spr2.getColorAt(i, j));
            }
            System.out.println();
        }

        Spreadsheet spr3 = new Spreadsheet(3, 1);
        for(int i = 0; i < spr3.getRows(); i++) {
            spr3.setValueAt(i, 0,"Hello");
        }
//        Not valid
        System.out.println(spr3.getColumnSum(1));
        System.out.println(spr3.getColumnAverage(1));
        System.out.println(spr3.getRowSum(3));
        System.out.println(spr3.getRowAverage(3));

//        Non-numeric
        System.out.println(spr3.getColumnSum(0));
        System.out.println(spr3.getColumnAverage(0));
        System.out.println(spr3.getRowSum(0));
        System.out.println(spr3.getRowAverage(0));

        System.out.println();

        Spreadsheet spr4 = new Spreadsheet(4, 5);
        for(int i = 0; i < spr4.getRows(); i++) {
            for(int j = 0; j < spr4.getColumns(); j++)
            {
                spr4.setValueAt(i, j,5);
            }
        }
        System.out.println(spr4.getColumnSum(1));
        System.out.println(spr4.getRowSum(1));
        System.out.println(spr4.getColumnAverage(1));
        System.out.println(spr4.getRowAverage(1));

        System.out.println(spr4.getAreaSum(1,7,0,2));
        System.out.println(spr4.getAreaSum(1,3,0,2));

        System.out.println(spr4.getAreaAverage(1,7,0,2));
        System.out.println(spr4.getAreaAverage(1,3,0,2));

        Spreadsheet spr5 = new Spreadsheet(2,2);
        for(int i = 0; i < spr5.getRows(); i++) {
            for(int j = 0; j < spr5.getColumns(); j++)
            {
                spr5.setValueAt(i, j,"Hello");
            }
        }

    }
}