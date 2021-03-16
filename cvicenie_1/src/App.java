
/**
 * @author lacal
 */
public class App {
    public static final String[] units = { "", "jeden", "dva", "tri", "štyri", "päť", "šesť", "sedem", "osem", "deväť",
            "desať", "jedenásť", "dvanásť", "trinásť", "štrnásť", "päťnásť", "šesťnásť", "sedemnásť", "osemnásť",
            "deväťnásť" };

    public static final String[] tens = { "", // 0
            "", // 1
            "dvadsať", // 2
            "tridsať", // 3
            "štyridsať", // 4
            "päťdesiať", // 5
            "šesťdesiať", // 6
            "sedemdesiať", // 7
            "osemdesiať", // 8
            "deväťdesiat" // 9
    };

    public static String convert(final int n) {
        if (n < 0) {
            return "mínus " + convert(-n);
        }

        if (n == 0)
            return "nula";

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + units[n % 10];
        }

        if (n < 1000) {
            return units[n / 100] + "sto" + convert(n % 100);
        }

        if (n < 1000000) {
            return convert(n / 1000) + "tisíc" + convert(n % 1000);
        }

        if (n < 1000000000) {
            return convert(n / 1000000) + "milión" + convert(n % 1000000);
        }

        return convert(n / 1000000000) + "miliárd" + convert(n % 1000000000);
    }

    public static void main(String[] args) {

        int min = 0;
        int max = 999999;

        int n;
        for (int i = 0; i < 20; i++) {
            n = (int) ((Math.random() * (max - min)) + min);

            System.out.printf("%10d = '%s'%n", n, convert(n));
        }

        n = 23181;
        System.out.printf("%10d = '%s'%n", n, convert(n));
    }
}