import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Application();
    }

    private static void Application()
    {
        System.out.println("\n"+"\n"+"\n"+"Welcome to my basic apps, please chose and application"+"\n"+"Calculator:1"
        +"\n"+"and that is all I have for now");
        Scanner input = new Scanner(System.in);
        char option = input.next().charAt(0);

        switch (option)
        {
            case '1':Calculator();
            break;
            default: System.out.println("Please chose a valid application");
            Application();
        }
    }

    private static void Calculator()
    {
        System.out.print("\n"+"\n"+"\n"+"Welcome to calculator enter your first value:");

        Scanner nums = new Scanner(System.in);

        double firstNum = nums.nextDouble();

        System.out.print("Enter your second value: ");

        double secondNum = nums.nextDouble();

        System.out.print("What would you like to do with these values");

        char operation = nums.next().charAt(0);
            Operations(firstNum, secondNum, operation);
            System.out.println("\n"+"\n"+"\n"+"To exit press x"+"\n"+" To repeat press r"+"\n"+" To go home press a");
            System.out.print("Enter your value:");

            char repeat = nums.next().charAt(0);

            if (repeat == 'x')
            {
                System.exit(0);
            } else if (repeat == 'r')
            {
                Calculator();
            } else if (repeat == 'a')
            {
                Application();
            } else
            {
                System.out.println("Wrong value");
            }
    }
    private static void Operations(double firstNum, double secondNum, char operation)
    {
        switch (operation)
        {
            case '+':
                System.out.print("Your answer is:");
                System.out.print(firstNum + secondNum);
                break;
            case '-':
                System.out.print("Your answer is:");
                System.out.print(firstNum - secondNum);
                break;
            case '*':
                System.out.print("Your answer is:");
                System.out.print(firstNum * secondNum);
                break;
            case '/':
                System.out.print("Your answer is:");
                System.out.print(firstNum / secondNum);
                break;
            default:
                System.out.println("Incorrect operation");
        }
    }

}