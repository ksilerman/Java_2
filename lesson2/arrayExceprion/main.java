package lesson2.arrayException;

public class main {
    public static void main(String[] args) {

        String[][] weekDays = { {"1","2","3","4"},{"5","6","7","8"}};
        try {
            Arr(weekDays);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    public static void Arr(String a[][]) {
        int[][] pars = new int[a.length][]; // массив для преобразования
        int sum = 0;                        // переменная для суммирования

        for (int i = 0; i < a.length; i++)  {
            pars[i] = new int[a[i].length];

            for (int j = 0; j < a[i].length; j++) {
                try {
                pars[i][j] = Integer.parseInt(a[i][j]) ;

                  } catch (NumberFormatException e) {}
                    System.out.print(pars[i][j] + " ");
                }
            }

        try {

            for (int i = 0; i < pars.length; i++) {
                for (int j = 0; j < pars[i].length; j++) {
                    sum = sum + pars[i][j];
                }
            }
        }catch (ArithmeticException e) {
            System.out.println("");
        }
        System.out.println("\n" + "----------");
        System.out.println("Сумма всех элементов = " + sum);
    }


    }


