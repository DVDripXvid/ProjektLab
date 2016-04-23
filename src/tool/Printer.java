package tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Kiírást megvalósító osztály
 */
public abstract class Printer {
    static PrintWriter writer = new PrintWriter(System.out);

    public static void setOutStream(String filename){
        try {
            writer = new PrintWriter(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            writer = new PrintWriter(System.out);
        }
    }

    public static void reset(){
        writer.close();
        writer = new PrintWriter(System.out);
    }

    public static void print(String text) {
        writer.println(text);
        writer.flush();
    }
}