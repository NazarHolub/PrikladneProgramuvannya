import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Phone arr[] = {
                new Phone(1, "Nazar", "Igorovich", 123, 12, 2),
                new Phone(2, "Ostap", "Igorovich", 113, 0, 0),
                new Phone(3, "Nastya", "Igorovna", 114, 0, 5),
                new Phone(3, "Valetin", "Olegovich", 126, 1, 3),

        };
        Show(arr);

        System.out.println("1) відомості про абонентів, у яких час міських розмов перевищує заданий;\n" +
                "2) відомості про абонентів, які користувались міжміським зв'язком;\n" +
                "3) відомості про абонентів чий номер рахунку знаходиться у вказаному діапазоні.");

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        switch (a) {
            case 1:
                cityCallsCheck(arr, 0);
                break;
            case 2:
                intercityCallsCheck(arr);
                break;
            case 3:
                numberInDiapazon(arr, 100, 115);
                break;
            default:
                System.out.println("wrong");
        }

    }

    static void Show(Phone[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Id: " + arr[i].GetId() + "\t");
            System.out.print("Name: " + arr[i].GetName() + "\t");
            System.out.print("Middle Name: " + arr[i].GetMiddleName() + "\t");
            System.out.print("Number: " + arr[i].GetNumber() + "\t");
            System.out.println("In and out city calling time: " + arr[i].GetinTime() + " "+ arr[i].GetOutTime());

        }
    }

    static void cityCallsCheck(Phone[] arr, double limit) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].GetinTime() > limit) {
                System.out.print("Name: " + arr[i].GetName() + "\t");
            }
        }
    }

    static void intercityCallsCheck(Phone[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].GetOutTime() > 0) {
                System.out.print("Name: " + arr[i].GetName() + "\t");
                System.out.print("Intercity calling time: " + arr[i].GetOutTime() + "\n");
            }
        }
    }

    static void numberInDiapazon(Phone[] arr, int d1, int d2) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].GetNumber() >= d1 && arr[i].GetNumber() <= d2) {
                System.out.print("Name: " + arr[i].GetName() + "\t");
                System.out.print("Number: " + arr[i].GetNumber() + "\n");
            }
        }
    }
}
