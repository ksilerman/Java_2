package lesson_5.threads;

public class main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
// 1 массив -----------------------------------
        float[] arr1 = new float[size];

        long a1 = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1;
        }
        System.out.print("Время затраченное на заполнение массива 1: ");
        System.out.println(System.currentTimeMillis() - a1 + "msec");
        long b1 = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.print("Время затраченное на вычисление массива 1: ");
        System.out.println(System.currentTimeMillis() - b1 + "msec");

//---------------------------------------------------
        System.out.println("------------------");
// 2 массив ------------------------------------------

        float[] arr2 = new float[size];
        float[] arr21 = new float[h];
        float[] arr22 = new float[h];

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 1;
        }
        System.out.print("Время затраченное на заполнение массива 2: ");
        System.out.println(System.currentTimeMillis() - a + "msec");

        long b = System.currentTimeMillis();
        System.arraycopy(arr2, 0, arr21, 0, h); //(источник, откуда начинаем брать, назначение, куда начинаем записывать, сколько)
        System.arraycopy(arr2, h, arr22, 0, h);
        System.out.print("Время затраченное на разбивку: ");
        System.out.println(System.currentTimeMillis() - b + "msec");

        Thread potok1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long c = System.currentTimeMillis();
                for (int i = 0; i < arr21.length; i++) {
                    arr21[i] = (float)(arr21[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.print("Время затраченное на вычисление 1 части: ");
                System.out.println(System.currentTimeMillis() - c + "msec");
            }
        });
        potok1.start();

        Thread potok2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long d = System.currentTimeMillis();
                for (int i = 0; i < arr22.length; i++) {
                    arr22[i] = (float)(arr22[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.print("Время затраченное на вычисление 2 части: ");
                System.out.println(System.currentTimeMillis() - d + "msec");
            }
        });
        potok2.start();

        long e = System.currentTimeMillis();
        System.arraycopy(arr21, 0, arr2, 0, h);
        System.arraycopy(arr22, 0, arr2, h, h);
        System.out.print("Время затраченное на склейку: ");
        System.out.println(System.currentTimeMillis() - e + "msec");

    }
}

