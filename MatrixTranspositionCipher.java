public class MatrixTranspositionCipher {
    public static String encryption(String plaintext, int[] key) {

        int keyLength = key.length;

        char[][] encryptionMatrix = new char[keyLength][keyLength];

        String charPlaceholder = "%";
        int index = 0;
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (index < plaintext.length()) {
                    if (plaintext.charAt(index) == ' ') {
                        encryptionMatrix[i][j] = charPlaceholder.charAt(0);
                    } else encryptionMatrix[i][j] = plaintext.charAt(index);
                } else encryptionMatrix[i][j] = charPlaceholder.charAt(0);
                index++;
            }
        }

        String ciphertext = " ";
        for(int i = 0; i<key.length; i++) {
            for(int j = 0; j< encryptionMatrix.length; j++) {
                int pos = key[i]-1;
                ciphertext += (encryptionMatrix[j][pos]);
            }
        }

        return ("Cipher text:"  +  ciphertext);
    }


    public static String decryption(String ciphertext, int[] key) {
        int charLength =  ciphertext.length();
        int cols = key.length;
        int rows =  charLength/cols;

        String[] splitText = ciphertext.split("(?<=\\G.{"+rows+"})");

        char[][] decryptMatrix = new char[rows][cols];

        int index = 0;
        for(int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int pos = key[c]-1;
                decryptMatrix[r][pos] = splitText[index].charAt(r);
            }
            index++;
        }

        String charPlaceholder = "%";
        String plaintext=" ";
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j< cols; j++) {
                if  (decryptMatrix[i][j] == charPlaceholder.charAt(0)) {
                    plaintext+= "";
                }
                else
                    plaintext += (decryptMatrix[i][j]);
            }
        }
        return ("Plaintext:" + plaintext);
    }}
