package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        String algorithm = "shift";
        String data = "";
        String inFileName = "";
        String outFileName = "";
        int key = 0;

        List<String> options = Arrays.asList("-mode", "-key", "-data", "-in", "-out", "-alg");

        for (int i = 0; i < args.length; i++) {
            // If option is followed by another option or is final argument, show error and abort
            boolean argValueMissing = i == args.length - 1 || options.contains(args[i + 1]);
            if (options.contains(args[i]) && argValueMissing) {
                System.out.println("Error: missing argument");
                return;
            }

            try {
                switch (args[i]) {
                    case "-mode":
                        mode = args[++i];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[++i]);
                        break;
                    case "-data":
                        data = args[++i];
                        break;
                    case "-in":
                        inFileName = args[++i];
                        break;
                    case "-out":
                        outFileName = args[++i];
                        break;
                    case "-alg":
                        algorithm = args[++i];
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: invalid key");
                return;
            }
        }

        // Process input from file if necessary
        if (!inFileName.isEmpty()) {
            try {
                data = new String(Files.readAllBytes(Paths.get(inFileName)));
            } catch (IOException e) {
                System.out.printf("Error: input file %s not found", inFileName);
                return;
            }
        }

        System.out.println(data);
        // Create encrypter and set its encryption method using selected algorithm
        Encrypter encrypter = new Encrypter();
        encrypter.setMethod(EncryptionMethodFactory.newInstance(algorithm));
        String output = "";
        if ("enc".equals(mode)) {
            output = encrypter.encrypt(data, key);
        } else if ("dec".equals(mode)) {
            output = encrypter.decrypt(data, key);
        }

        // Print output to console or write it to file
        if (outFileName.isEmpty()) {
            System.out.println(output);
        } else {
            try (FileWriter writer = new FileWriter(outFileName)) {
                writer.write(output);
            } catch (IOException e) {
                System.out.printf("Error: invalid output file %s", outFileName);
            }
        }
    }

}
