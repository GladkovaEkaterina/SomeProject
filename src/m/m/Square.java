package m;

import java.util.ArrayList;

class Square {
    ArrayList<Cell> Squares = new ArrayList<>();

    public ArrayList<boolean[]> getDesk() {
        return desk;
    } //сделать ссылку для работы fileWork

    private ArrayList<boolean[]> desk = new ArrayList<>();//представление само матрицы
    int max = 0;
    int mi1 = -1;
    int mi2 = -1;
    int mj1 = -1;
    int mj2 = -1;

    private boolean find(int i1, int j1, int i2, int j2) {
        for (int i = i1; i <= i2; i++)
            for (int j = j1; j <= j2; j++)
                if (desk.get(i)[j])
                    return false; //если закр клетки есть
        return true; //если закр клеток нет
    }

    void work() {
        for (int i1 = 0; i1 < desk.size(); i1++)
            for (int j1 = 0; j1 < desk.get(0).length; j1++)
                for (int i2 = i1; i2 < desk.size(); i2++)
                    for (int j2 = j1; j2 < desk.get(0).length; j2++) {
                        int s = (i2 - i1 + 1) * (j2 - j1 + 1);
                        if (find(i1, j1, i2, j2))
                            if (max < s) {
                                Squares = new ArrayList<Cell>(); //пересоздаем массив, чтобы очистить его
                                max = s;
                                mi1 = i1;
                                mi2 = i2;
                                mj1 = j1;
                                mj2 = j2;
                                Squares.add(new Cell(i1, j1, i2, j2));
                            } else if (max == s)
                                Squares.add(new Cell(i1, j1, i2, j2));
                    }
    }

    class Cell { //для хранения в АrrаyList
        int i1, j1, i2, j2;

        private Cell(int i1, int j1, int i2, int j2) {
            this.i1 = i1;
            this.j1 = j1;
            this.i2 = i2;
            this.j2 = j2;
        }
    }
}




    /*private void scnByKty(String fileNme) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(fileNme));
        int i = 0, j = 0;
        Pattern p = Pattern.compile("[^01]");
        {

        }
    }

    private List<int[]>  red(String nme) throws IOException {
        List<int[]> content = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nme))){
            String str = bufferedReader.readLine();
            while(str!=null){
                String[] strList = str.split(" ");
                int[] res= new int[strList.length];
                for (int i = 0; i< strList.length; i++){
                    res[i]= Integer.parseInt(strList[i]);
                }
                content.add(res);
                str = bufferedReader.readLine();
            }

        }
        return content;
    }
    */