package m;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FWTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    String pth;

    @Before
    public void setUp() throws Exception {
        File file = temporaryFolder.newFile();
        pth = file.getAbsolutePath();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("10101010\n" +
                "10001001\n" +
                "10001111\n" +
                "00110000\n" +
                "11100010\n" +
                "10100001");
        fileWriter.flush();
    }

    private boolean compArr(boolean[] v1, boolean[] v2){
        if (v1.length != v2.length) return false;
        for (int i = 0; i < v2.length; i++) {
            if (v1[i] != v2[i]) return false;
        }
        return true;
    }

    @Test
    public void scan() {
        ArrayList<boolean[]> desk = new ArrayList<>();
        desk.add(new boolean[]{true, false, true, false, true, false, true, false});
        desk.add(new boolean[]{true, false, false, false, true, false, false, true});
        desk.add(new boolean[]{true, false, false, false, true, true, true, true});
        desk.add(new boolean[]{false, false, true, true, false, false, false, false});
        desk.add(new boolean[]{true, true, true, false, false, false, true, false});
        desk.add(new boolean[]{true, false, true, false, false, false, false, true});
        Square square = new Square();
        Assert.assertEquals(0, FileWork.scan(pth, square.getDesk()));
        for (int i =0 ;i < desk.size();i++)
            assertTrue(compArr(desk.get(i),square.getDesk().get(i)));
    }
    @Test
    public void print() throws IOException {
        String dir = temporaryFolder.newFolder().getAbsolutePath();
        Square square = new Square();
        Assert.assertEquals(0, FileWork.scan(pth, square.getDesk()));
        square.work();
        Assert.assertEquals(0, FileWork.print(dir+"/res", square));
        Scanner sc = new Scanner(new File(dir+"/res"));
        StringBuilder result = new StringBuilder();
        while (sc.hasNextLine())
            result.append(sc.nextLine()).append(System.lineSeparator());
        assertEquals(result.toString(),"max S = 6" + System.lineSeparator() +
                "A(2,2) B(4,3)" + System.lineSeparator() +
                "A(5,4) B(6,6)" + System.lineSeparator() +
                "A(4,5) B(6,6)" + System.lineSeparator());
    }
}