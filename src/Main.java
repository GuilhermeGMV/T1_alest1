import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 para ListArrayOfIntegers e 2 para LinkedListOfIntegers");
        int a = in.nextInt();
        switch (a) {
            case 1:
                ListArrayOfIntegers la = new ListArrayOfIntegers();
                break;
            case 2:
                LinkedListOfIntegers ll = new LinkedListOfIntegers(5000);
                for(int i =0;i<5000;i++){
                    ll.add(i);
                }
                break;
        }
    }
}