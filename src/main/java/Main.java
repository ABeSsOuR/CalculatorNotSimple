import LexemeClass.Lexeme;
import LexemeClass.LexemeBuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static CalculateTheEquation.Calculate.expr;
import static LexemeClass.LexAnalyze.LexAnalyze;

public class Main {

    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buffReader = new BufferedReader(inputStreamReader);
        int x = 0;
        String strCal="";
        ArrayList<Object> results = new ArrayList<>();
        do {
            System.out.println("1. Посчитать Уравнение");
            System.out.println("2. История расчетов");
            System.out.println("3. Выйти");
            try {
                x = Integer.parseInt(buffReader.readLine());
            }  catch (IOException e) {
                e.printStackTrace();
            }  catch (NumberFormatException e){
                System.out.println("Неверный ввод, вводить только цифры из списка");
                x = 0;
            }

            switch (x){
                case 1:
                    System.out.println("Введите уровнение: ");
                    try {
                        strCal = buffReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // при использовании библиотеки -------------------------------------
                    //MyBSH bsh1 = new MyBSH(strCal);
                    //results.add(strCal+" = "+ bsh1.result);
                    //System.out.println(bsh1.interpreter.get("result"));
                    //-------------------------------------------------------------------
                    List<Lexeme> lexemes = LexAnalyze(strCal);
                    LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
                    System.out.println(expr(lexemeBuffer));
                    break;
                case 2:
                    for (int i = 0; i < results.size();i++)
                    {
                        System.out.println(results.get(i));
                    }
                    break;
                case 3:
                    System.out.println("До свидания!");
                    System.exit(0);
            }
        }while (true);
    }
}
