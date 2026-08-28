import java.util.Scanner;

public class JavaLangTutorial
{
	static void main(String[] args)
	{
       LanternaDisplay disp =  new LanternaDisplay();

	}

    private static void variable() {
        Scanner sc = new Scanner(System.in);
        int age;
        String name;
        Double long_integer;
        Long money;
        boolean grade = true;
        char letter = 'A';

        System.out.print("Enter your age: ");
        age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your name: ");
        name = sc.next();
        sc.nextLine();

        long_integer = 6.5;

        System.out.printf("My name  is %s and my age is %d", name,age);
    }

    private static void operators(){

    }
}
