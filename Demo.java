import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    public static void main (String args[]) throws FileNotFoundException {

        Scanner kbd = new Scanner(System.in);
        System.out.println("Encryption or Decryption? ");
        String preference = kbd.nextLine();

        if (preference.toLowerCase().equals("decryption")) {

            String decryptFile = "./cipher_input.txt";

            Scanner inputFile = new Scanner(new File(decryptFile));
            while (inputFile.hasNext()) {
                String[]  details = inputFile.nextLine().split("\t");
                String ciphertext = details[0];
                String key = details[1];

                String[] keyArray = key.split(",");
                int[] secretKey = new int[keyArray.length];
                for (int i = 0; i < keyArray.length; i++) {
                    secretKey[i] = Integer.parseInt(keyArray[i]);
                }

                String decryptTest = MatrixTranspositionCipher.decryption(ciphertext, secretKey);
                System.out.print("Ciphertext: "+ciphertext+ " with key "+ key);

                System.out.print("\n"+ decryptTest);
                System.out.println();
            }

            inputFile.close();
        }
        else if (preference.toLowerCase().equals("encryption"))  {

            String encryptFile = "./plaintext_input.txt";
            Scanner inputFile = new Scanner(new File(encryptFile));
            while (inputFile.hasNext()) {
                String plaintext = inputFile.nextLine();
                String key = inputFile.nextLine();

                String[] keyArray = key.split(",");
                int[] secretKey = new int[keyArray.length];
                for (int i = 0; i < keyArray.length; i++) {
                    secretKey[i] = Integer.parseInt(keyArray[i]);
                }

                String encryptTest = MatrixTranspositionCipher.encryption(plaintext, secretKey);
                System.out.print("Plaintext: "+plaintext+ " with key "+ key);

                System.out.print("\n"+encryptTest);
                System.out.println();

            }
        }
        else System.out.println("Invalid Input");
    }
}
