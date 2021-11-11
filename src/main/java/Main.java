import bsh.EvalError;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws EvalError {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int x = 0;
        String s ="";
        String strCal;
        ArrayList<Object> results = new ArrayList<>();
        do {
            System.out.println("1. Посчитать Уравнение");
            System.out.println("2. История расчетов");
            System.out.println("3. Выйти");
            s = scan.nextLine();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
                x = 0;
            }

            switch (x){
                case 1: // вызов метода 1
                    System.out.println("Введите уровнение: ");
                    strCal = scan2.nextLine();
                    MyBSH bsh1 = new MyBSH(strCal);
                    results.add(strCal+" = "+ bsh1.result);
                    System.out.println(bsh1.interpreter.get("result"));
                    break;
                case 2:// вызов метода 2
                    for (int i = 0; i < results.size();i++)
                    {
                        System.out.println(results.get(i));
                    }
                    break;
                case 3: // вызов метода 3
                    System.out.println("До свидания!");
                    System.exit(0);
            }
        }while (true);
    }
}