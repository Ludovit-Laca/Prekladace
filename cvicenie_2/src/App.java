import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lacal
 */
public class App {

    public static void main(String[] args) throws Exception {

        // arrayList of words
        ArrayList<String> allowedStrings = new ArrayList<String>(Arrays.asList("milión", "tisíc", "sto", "deväťdesiat",
                "osemdesiat", "sedemdesiat", "šesťdesiat", "päťdesiat", "štyridsať", "tridsať", "dvadsať", "devätnásť",
                "osemnásť", "sedemnásť", "šesťnásť", "pätnásť", "štrnásť", "trinásť", "dvanásť", "jedenásť", "desať",
                "deväť", "osem", "sedem", "šesť", "päť", "štyri", "tri", "dva", "jeden", "nula"));

        // input string
        String input = "dva-dsať-tri-tisíc-jeden-sto-štr-násť";
        // String input = "dvadsaťtritisícjedenstoštrnásť";
        // String input = "tri-dsať-tisíc-jede-násť";
        // String input = "deväťstodeväťdesiatdeväťtisícdeväťstodeväťdesiatdeväť";
        // String input = "nula";

        // regex to remove any non-letter characters
        String line = input.replaceAll("[^\\s\\p{L}\\p{N}]+", "");

        // intermediate result
        int result = 0;

        // final result
        int finalResult = 0;
        while (!line.equals("")) {
            for (int j = 0; j < allowedStrings.size(); j++) {

                // get word from array of words
                String word = allowedStrings.get(j);

                // get first index of the word
                int index = line.indexOf(word);

                // if word index is first in the sentence
                if (index == 0) {

                    // multiply correct value
                    if (word.equalsIgnoreCase("nula")) {
                        result += 0;
                    } else if (word.equalsIgnoreCase("jeden")) {
                        result += 1;
                    } else if (word.equalsIgnoreCase("dva")) {
                        result += 2;
                    } else if (word.equalsIgnoreCase("tri")) {
                        result += 3;
                    } else if (word.equalsIgnoreCase("štyri")) {
                        result += 4;
                    } else if (word.equalsIgnoreCase("päť")) {
                        result += 5;
                    } else if (word.equalsIgnoreCase("šesť")) {
                        result += 6;
                    } else if (word.equalsIgnoreCase("sedem")) {
                        result += 7;
                    } else if (word.equalsIgnoreCase("osem")) {
                        result += 8;
                    } else if (word.equalsIgnoreCase("deväť")) {
                        result += 9;
                    } else if (word.equalsIgnoreCase("desať")) {
                        result += 10;
                    } else if (word.equalsIgnoreCase("jedenásť")) {
                        result += 11;
                    } else if (word.equalsIgnoreCase("dvanásť")) {
                        result += 12;
                    } else if (word.equalsIgnoreCase("trinásť")) {
                        result += 13;
                    } else if (word.equalsIgnoreCase("štrnásť")) {
                        result += 14;
                    } else if (word.equalsIgnoreCase("päťnásť")) {
                        result += 15;
                    } else if (word.equalsIgnoreCase("šesťnásť")) {
                        result += 16;
                    } else if (word.equalsIgnoreCase("sedemnásť")) {
                        result += 17;
                    } else if (word.equalsIgnoreCase("osemnásť")) {
                        result += 18;
                    } else if (word.equalsIgnoreCase("deväťnásť")) {
                        result += 19;
                    } else if (word.equalsIgnoreCase("dvadsať")) {
                        result += 20;
                    } else if (word.equalsIgnoreCase("tridsať")) {
                        result += 30;
                    } else if (word.equalsIgnoreCase("štyridsať")) {
                        result += 40;
                    } else if (word.equalsIgnoreCase("päťdesiat")) {
                        result += 50;
                    } else if (word.equalsIgnoreCase("šesťdesiat")) {
                        result += 60;
                    } else if (word.equalsIgnoreCase("sedemdesiat")) {
                        result += 70;
                    } else if (word.equalsIgnoreCase("osemdesiat")) {
                        result += 80;
                    } else if (word.equalsIgnoreCase("deväťdesiat")) {
                        result += 90;
                    } else if (word.equalsIgnoreCase("sto")) {
                        result *= 100;
                    } else if (word.equalsIgnoreCase("tisíc")) {
                        result *= 1000;
                        finalResult += result;
                        result = 0;
                    } else if (word.equalsIgnoreCase("milión")) {
                        result *= 1000000;
                        finalResult += result;
                        result = 0;
                    }

                    // shrink the string
                    line = line.substring(word.length(), line.length());
                    break;
                }
            }
        }

        // sum final value and print it
        finalResult += result;
        result = 0;
        System.out.println(finalResult);
    }
}