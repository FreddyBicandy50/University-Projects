``` JAVA
 // write a program taht take from the user 2 number and swaps them and display them

import java.util.Scanner;

  

public class test {

    public static void main (String [] args){

        Scanner scan=new Scanner(System.in);

  

        System.out.print("please enter 2 numbers:");

        int x=scan.nextInt(),y=scan.nextInt();

        System.out.print("before swap\n"+"x="+x+"\ty="+y);

        int temp=x;

        x=y;

        y=temp;

        System.out.println("\nafter swap\n"+"x="+x+"\ty="+y);

    }

}
```