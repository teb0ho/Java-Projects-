/**
* @TODO visual interface.
*
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Teb0ho on 2016-11-24 - 2017-07-07.
 */

public class Lottery {

    public static void main (String[] args) {

        String textLotto, textPwrBall, sixNumbers, sixNumbers1;
        String[] uNumbers = new String[6];
        File file = new File("res/results.txt").getAbsoluteFile();
        File file1 = new File("res/combos.txt");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        BufferedReader br = null;
        FileReader fr = null;

        System.out.println("Would you like to generate some numbers ? 1 = yes, 2 = no, 3 = check results");

        try {
            for (;;) {

                Scanner scan = new Scanner(System.in);

                int prompt = scan.nextInt();
                String sCurrentLine, sCurrentLine1 = "";

                if (prompt == 1) {

                    System.out.println("What type of lotto numbers would you like to generate ? 1 = Standard Lotto 2 = Powerball");
                    int lottoOpts = scan.nextInt();

                    if (lottoOpts == 1) {
                        textLotto = Num.lotto();
                        referenceNum.getNum();
                        referenceNum.genNums();

                        if(!file.exists())
                            file.createNewFile();

                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        fr = new FileReader(file1);
                        br = new BufferedReader(fr);
                        br = new BufferedReader(new FileReader(file1));

                        while ((sCurrentLine = br.readLine()) != null) {
                            sCurrentLine1 = sCurrentLine;
                        }

                        bufferedWriter.write(textLotto + "\tLotto\t\t" + dateFormat.format(date) + "\t" + sCurrentLine1 + "\n");
                        bufferedWriter.close();
                        fileWriter.close();

                        System.out.println(textLotto);
                    }

                    else if (lottoOpts == 2) {
                        textPwrBall = Num.powerBall();
                        referenceNum.getNum();
                        referenceNum.genNums();

                        if(!file.exists())
                            file.createNewFile();


                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        fr = new FileReader(file1);
                        br = new BufferedReader(fr);
                        br = new BufferedReader(new FileReader(file1));

                        while ((sCurrentLine = br.readLine()) != null) {
                            sCurrentLine1 = sCurrentLine;
                        }
                        bufferedWriter.write(textPwrBall + "\tPowerball\t" + dateFormat.format(date) + "\t" + sCurrentLine1 + "\n");
                        bufferedWriter.close();
                        fileWriter.close();

                        System.out.println(textPwrBall);
                    }


                    System.out.println("\nPress 2 to quit, 1 to generate new numbers\n");

                }

                else if (prompt == 2) {

                    System.out.println("Thanks for running this program");
                    System.exit(0);

                }

                else if (prompt == 3) {
                    String refNumber;
                    refNumber = scan.nextLine();

                    System.out.println("Enter your reference number (e.g. A0A0) the reference numbers for different number combinations can be found in the directory \"res/results.txt\": ");

                    refNumber = scan.nextLine();

                    for (int i = 0; i < 6; i++) {
                        int k = i;
                        k++;

                        System.out.println("Enter your " + k + " number: ");
                        sixNumbers = scan.nextLine();

                        if (sixNumbers.length() == 1)
                            sixNumbers1 = "0" + sixNumbers;
                        else
                            sixNumbers1 = sixNumbers;

                        uNumbers[i] = sixNumbers1;
                    }

                    referenceNum.checkNums(uNumbers, refNumber);

                    System.out.println();
                    System.out.println("Would you like to generate some numbers ? 1 = yes, 2 = no, 3 = check results");
                }

                else {

                    System.out.println("Incorrect option please try again.");

                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error - incorrect answer please enter the number 1 or 2 ");
        }
        finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
