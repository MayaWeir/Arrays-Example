import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The sortingCountries class will read from a file called Countries-Populations.txt
 * and sort the data by countries and population.
 *
 * @author Maya Weir, Maia Mandel, Megan Holmes
 * @version 1 2019.02.02
 */

public class sortingCountries
{
    ArrayList <String> countryName = new ArrayList ();
    ArrayList <String> capital = new ArrayList ();
    ArrayList <String> area = new ArrayList ();
    ArrayList <String> population = new ArrayList();


    public void readInput () throws IOException
    {
        int spaceCount=0;
        int temp = 0;
        BufferedReader input;
        input = new BufferedReader(new FileReader("Countries-Population.txt"));
        String line;
        line = input.readLine ();
        while (line != null) {

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ' && spaceCount == 0) {
                    countryName.add(line.substring(0, i));
                    temp = i;
                    spaceCount++;
                } else if (line.charAt(i) == ' ' && spaceCount == 1) {
                    capital.add(line.substring(temp + 1, i));
                    temp = 1;
                    spaceCount++;
                } else if (line.charAt(i) == ' ' && spaceCount == 2) {
                    area.add(line.substring(temp + 1, i));
                    temp = 1;
                    spaceCount++;
                } else if (line.charAt(i) == ' ' && spaceCount == 3) {
                    population.add(line.substring(temp + 1, i));
                    temp = 1;
                    spaceCount++;
                }
            }
            line = input.readLine ();
        }
    }

    public void sortByCountry ()
    {
        PrintWriter output;
        String fileName = "sortedByCountry.txt";
        try {
            output = new PrintWriter (new FileWriter (fileName));
            output.println (countryName + "\t\t\t" + population);
            output.close ();
        }
        catch (IOException e) {}
    }

    public static void main (String[]args) throws IOException {
sortingCountries s = new sortingCountries();
s.readInput();
s.sortByCountry ();
    }
}
