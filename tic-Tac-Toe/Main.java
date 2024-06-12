import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        while(true){
            //Запуск игры
            Game game = new Game();
            game.startGame();
            System.out.println("Хотите продолжит? y/n");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if(answer.equals("n") || !answer.equals("y"))
                return;
        }
    }
}
