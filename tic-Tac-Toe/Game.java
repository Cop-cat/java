import java.util.Scanner;
public class Game {
    public Game(){
        //Инициализация xo
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
                xo[i][j] = "_";
        }
    }
    
    private static String[][] xo = new String[3][3];
    
    public void startGame(){
        main(new String[] {});
    }
    private static void printField(){
        System.out.println("  1 2 3");
        System.out.println("  _ _ _");
        System.out.println("A|" + xo[0][0] + "|" + xo[0][1] + "|" + xo[0][2] + "|");
        System.out.println("B|" + xo[1][0] + "|" + xo[1][1] + "|" + xo[1][2] + "|");
        System.out.println("C|" + xo[2][0] + "|" + xo[2][1] + "|" + xo[2][2] + "|");
    }
    private static void makeMove(String cellNum, int i){
        String symbol;
        symbol = i%2 == 0 ? "X" : "O";
        int i1 = Character.getNumericValue(cellNum.charAt(0) - 17);
        int i2 = Character.getNumericValue(cellNum.charAt(1)) - 1;
        xo[i1][i2] = symbol;
    }
    private static boolean isWin(){
        //Проверка по горизонтали
        if((xo[0][0].equals(xo[0][1]) && xo[0][1].equals(xo[0][2]) && !xo[0][0].equals("_")) || 
            (xo[1][0].equals(xo[1][1]) && xo[1][1].equals(xo[1][2]) && !xo[1][0].equals("_")) ||
            (xo[2][0].equals(xo[2][1]) && xo[2][1].equals(xo[2][2]) && !xo[2][0].equals("_")))
            return true;
        //Проверка по вертикали
        if((xo[0][0].equals(xo[1][0]) && xo[1][0].equals(xo[2][0]) && !xo[0][0].equals("_")) ||
            (xo[0][1].equals(xo[1][1]) && xo[1][1].equals(xo[2][1]) && !xo[0][1].equals("_")) || 
            (xo[0][2].equals(xo[1][2]) && xo[1][2].equals(xo[2][2]) && !xo[0][2].equals("_")))
            return true;
        //Проверка по диагонали
        if((!xo[1][1].equals("_")) && ((xo[0][0].equals(xo[1][1]) && xo[1][1].equals(xo[2][2])) || 
                    (xo[2][0].equals(xo[1][1]) && xo[1][1].equals(xo[0][2]))))
            return true;
        return false;
    }
    

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            printField();
            boolean isInputCorrect1, isInputCorrect2;
            String cellNum;
            do{
                if(i%2 == 0)
                    System.out.println("Крестики ходят: ");
                else
                    System.out.println("Нолики ходят: ");
                //Ввод клетки
                cellNum = input.nextLine();
                //Проверка корректности ввода(первой должна быть буква А, В или С, а затем цифра от 1 до 3)
                isInputCorrect1 = cellNum.length() == 2 &&
                    (Character.getNumericValue('A') <= Character.getNumericValue(cellNum.charAt(0)) &&
                    Character.getNumericValue(cellNum.charAt(0)) <= Character.getNumericValue('C')) &&
                    (1 <= Character.getNumericValue(cellNum.charAt(1)) &&
                    Character.getNumericValue(cellNum.charAt(1)) <= 3);
                //Проверка что клетка пустая
                int i1 = Character.getNumericValue(cellNum.charAt(0) - 17);
                int i2 = Character.getNumericValue(cellNum.charAt(1)) - 1;
                isInputCorrect2 = xo[i1][i2].equals("_");
            }while(!isInputCorrect1 || !isInputCorrect2);
            makeMove(cellNum, i);
            //Проверка на победу
            if(i >= 4 && isWin()){
                if(i%2 == 0)
                    System.out.print("Крестики ");
                else
                    System.out.print("Нолики ");
                System.out.println("победили!");
                return;
            }
        }
    }
}
