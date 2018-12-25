package m;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class FileWork {
    static int scan(String string, ArrayList<boolean[]> desk) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(string));
        } catch (FileNotFoundException e) {
            return 2;  //if file not found
        }
        int i = 0, j = 0;
        int size = -1;
        Pattern p = Pattern.compile("[^01]"); //compile regex
        while (scanner.hasNextLine()) {
            String line = p.matcher(scanner.nextLine()).replaceAll("");
            if (size == -1) size = line.length();
            else if (size != line.length())
                return 1;
            desk.add(new boolean[line.length()]); //добавляем новую строку в матрицу
            for (int c = 0; c < line.length(); c++)
                desk.get(i)[j++] = line.charAt(c) == '1';
            i++; //переходим к следующеи строке
            j = 0;
        }
        scanner.close();
        return 0;
    }

    static int print(String pathname, m.Square t) {
        FileWriter fw;
        try {
            fw = new FileWriter(new File(pathname));
            fw.write("max S = " + String.valueOf(t.max) + System.lineSeparator());
            fw.flush();
            for (m.Square.Cell c : t.Squares) {
                fw.write("A(" + (c.j1 + 1) + "," + (c.i1 + 1) + ") B(" + (c.j2 + 1) + "," + (c.i2 + 1) + ")" + System.lineSeparator());
                fw.flush();
            }
        } catch (IOException e) {
            return 1; //невозможно записать в выходно file
        }
        return 0;
    }
}
