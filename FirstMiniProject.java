//BodyTypeFinder
import java.util.Scanner;
class BodyTypeFinder
{
     static int num;
     static int i;
    public static void main(String[] args)
    {   
        Scanner sc=new Scanner(System.in);

        //Inputs
        System.out.println("Find Your BodyType");
        
        //do-while loop
        do
        {
           System.out.print("Enter Your Height (in cm): ");
           double height=sc.nextDouble();
           System.out.print("Enter Your Weight (in kg): ");
           double weight=sc.nextDouble();
           System.out.println("what's your current body shape :");
           System.out.println("1.Slim-lean");
           System.out.println("2.Rounder-softer");
           System.out.println("3.Muscular-well defined");
           num=sc.nextInt();
           if(num!=1&&num!=2&&num!=3)
           {
           System.out.println("Enter a valid number :");
           return;
           }
            String st=bodyMassIndex(height,weight); 

            //final Result
            System.out.println("Your BodyType is :"+st);

            //to start again
            System.out.println("Enter 1 to start again and 0 to End");
            i=sc.nextInt();
        }while(i==1);
    } 

     //Calculating Body Mass Index
    private static String bodyMassIndex(double height,double weight)
       {
        double bmi=(weight/((height/100)*(height/100)));

        if(num==1 && bmi<18.5)
           return "ECTOMORPH";

        else if(num==3 && bmi>=18.5 && bmi<24.9)
           return "MESOMORPH";

        else
            return "ENDOMORPH";
       }              
}