### Write a program to find the biggest number among 3 input
```Java
import java.util.Scanner;

public class test{

    public static void main (String[] args){

        Scanner scan=new Scanner(System.in);

        System.out.println("please enter 3 numbers");

        int x=scan.nextInt(),y=scan.nextInt(),z=scan.nextInt();

        if (x>y && x>z) System.out.print(x+" is the biggest number");

        else if (y>x && y>z) System.out.print(y+" is the biggest number");

        else System.out.println(z+" is the biggest number");

    }

}
```
### Write a program to take the number of students and check their grades
```JAVA
// write a program to take a grade from n student and find out their grade

import java.util.Scanner;

  

public class test {

    public static void main (String[] args){

        Scanner input=new Scanner(System.in);

        int n=input.nextInt();

        for (int i=1;i<=n; i++){

            int grade=input.nextInt();

            if (grade>=90) System.out.println("A");

            else if (grade>=70) System.out.println("B");

            else if (grade>=60) System.out.println("C");

            else System.out.println("you failed!");

        }

    }

}
```
