package m;

public class Main {
    public static void main(String[] args) { //входные аргументы команднои строки
        m.Square t = new m.Square();
        switch (FileWork.scan(args[0], t.getDesk())) { //запускаем FileWork и проверяем коды ошибок
            case 2:
                System.out.println("Input file not found");
                break;
            case 1:
                System.out.println("Illegal input file format");
                break;
            default:
                t.work();
                switch (FileWork.print(args[1], t)) {
                    case 1:
                        System.out.println("Cant write to output file");
                        break;
                    default:
                        System.out.println("Calculate completed!");
                }
        }
    }
}
