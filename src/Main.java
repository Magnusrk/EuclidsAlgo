import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstNum = 0;
        int secondNum = 0;
        int[] arr = new int[100];
        int[] s = new int [100];
        int[] t = new int [100];
        int[] q = new int [100];
        Arrays.fill(arr, -1000);

        Scanner input = new Scanner(System.in);
        System.out.println("Input first integer");
        firstNum = input.nextInt();
        System.out.println("Input second integer");
        secondNum = input.nextInt();

        q[0] = 0;
        q[1] = 0;
        s[0]=1;
        s[1]=0;
        t[0]=0;
        t[1]=1;

        sfd(firstNum, secondNum, -1, arr);
        for (int i = 0; i < 15; i++){
            try {
                q[i+2] = -(-arr[i]+arr[i+2])/arr[i+1];
                s[i + 2] = s[i] - q[i + 2] * s[i + 1];
                t[i + 2] = t[i] - q[i + 2] * t[i + 1];

            } catch (Exception e){

            }
            if (arr[i+1] == -1000){
                break;
            }else {
                System.out.println("r" + (i - 1) + " " + arr[i] + "\t | " + q[i] + "\t | s" + (i - 1) + " " + s[i] + "\t | t" + (i - 1) + " " + t[i]);
            }

        }
    }

    public static int sfd(int a, int b, int i, int[] arr){
        if (i == -1){
            arr[0]=a;
        }
        if (a== 0){
            return b;
        }
        int r = b % a;
        i = i+1;
        arr[i+1] = r;
        return sfd(r, a, i, arr);
    }
}

