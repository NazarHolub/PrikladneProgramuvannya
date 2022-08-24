import java.util.Scanner;

class lukeNumbers {
    int n;
    double fi;
    double mfi;
    lukeNumbers(int _n){
        this.n = _n;
        fi = (1+Math.sqrt(5))/2;
        mfi = (1-Math.sqrt(5))/2;
    }

    public void ShowSimple(){
        int number;
        boolean flag;
        for(int i =1; i <= n; i++){
            flag = true;
            number = (int)(Math.pow(fi,i) + Math.pow(mfi,i));
            for (int j = 2; j < number; j++){
                if(number % j == 0){
                    flag = false;
                }

            }
            if(flag == true){
                System.out.println(" " + number + " \n");
            }

            flag = true;
        }
    }
}

public class main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number- ");

        int num= sc.nextInt();

        lukeNumbers numbers = new lukeNumbers(num);

        numbers.ShowSimple();

    }
}
