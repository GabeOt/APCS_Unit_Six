import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SpellChecker {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("files/alice.txt"));
        FileWriter fw = new FileWriter("files/corrected.txt");
        Scanner scanInput = new Scanner(System.in);
        String[] dictionary = getDictionary();
        int count = 0;
        while (scan.hasNext()) {
            String word = scan.next();
            if (wordInDictionary(word, dictionary)) {
                fw.write(word);
            }
            else {
                System.out.println("Is the spelling of " + "\"" + word + "\"" + " correct? If yes, type " + "\"" + "y" + "\"" + " or " + "\"" + "n" + "\"" + " if incorrect:");
                if (scanInput.nextLine().equals("y")) {
                    fw.write(word);
                }
                else {
                    System.out.println("Please type the correct spelling of the word:");
                    String word1 = scanInput.nextLine();
                    fw.write(word1);
                }

            }
            count ++;
        }




    }

    public static String[] getDictionary() throws IOException {
        String[] dictionary = new String[61336];
        Scanner scan = new Scanner(new File("files/words.txt"));
        int count=0;
        while(scan.hasNext()) {
            dictionary[count] = scan.next();
            count ++;
        }
        return dictionary;

    }

    public static boolean wordInDictionary(String word, String[] dictionary) {
        int mid = dictionary.length/2;
        int min = 0;
        int max = dictionary.length-1;
        while (min<=max) {
            if (word.compareTo(dictionary[mid])==0) {
                return true;
            }
            if (word.compareTo(dictionary[mid]) < 0) {
                max = mid-1;
                mid = ((min+max)/2);
            }
            if (word.compareTo(dictionary[mid]) > 0) {
                min = mid+1;
                mid = ((min+max)/2);
            }
        }
        return false;
    }




}
