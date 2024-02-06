import java.util.Scanner;
import java.io.File;
import java.io.IOException; 
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
class Expense
{
   static  double amount;
   static String category;
   static String date;
    public Expense(double amount,String category,String date)
    {
        this.amount=amount;
        this.category=category;
        this.date=date;
    }
    static void add(File f1) throws IOException
            {   
                f1.createNewFile();

                Scanner sc=new Scanner(System.in);
                System.out.print("Enter Expense : ");
                amount=sc.nextDouble();

                System.out.print("Enter category : ");
                category=sc.next();

                System.out.print("Enter date(YYYY-MM-DD) : ");
                date=sc.next();

                Expense latestExpense=new Expense(amount,category,date);
                System.out.println("Added Successfully");

                //Writing into the file
                FileOutputStream fos=new FileOutputStream("D:/java programs/ExpenseTracker.txt",true);
                String s=" \nAmount : "+Expense.amount+" Category : "+Expense.category+" Date : "+Expense.date;
                char ch[]=s.toCharArray();
                for(int i=0;i<s.length();i++)
                {
                    fos.write(ch[i]);
                }
                fos.close();
            }
            static void viewLatest(File f1)
            {  
                if(amount!=0&& category!=null&& date!=null)
                {
                    System.out.println("Latest Expense : ");
                    System.out.println("Amount : "+Expense.amount+" Category : "+Expense.category+" Date : "+Expense.date);
                         
                }
                else if(amount==0&& category==null&& date==null)
                {
                    System.out.println("\nNo latest Expenses Recorded yet");
                }
            }

            static void viewHistoty(File f1) throws IOException
            {   
                if(f1.exists())
                {
                   int i;
                   FileInputStream fis=new FileInputStream("D:/java programs/ExpenseTracker.txt");
                   System.out.print("\nHistory : ");
                   while((i=fis.read())!=-1)
                   {
                     System.out.print((char)i);
                     if((char)i=='\n')
                     {
                        System.out.println();//prints newline after each line 
                     }
                   }
                   
                }
                else
                {
                    System.out.println("No History Recorded yet");
                }
           
            }

            static void clearHistory(File f1)
            {
               if(f1.exists())
               { 
                 f1.delete(); 
                 System.out.println("Cleared Successfully");
                 
               }
               else
               {
                 System.out.println("No History Recorded yet");
               }

            }   

}
class ExpenseTracker
{
    public static void main(String[] a) throws IOException
    {   //create file
        File f1=new File("D:/java programs/ExpenseTracker.txt");
        
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("\n1.Add Expense");
            System.out.println("2.View LatestExpense");
            System.out.println("3.View History");
            System.out.println("4.Clear History");
            System.out.println("5.Exit");
            System.out.println("Choose an option");
            int choice=sc.nextInt();

            switch(choice)
            {   
                case 1:
                    Expense.add(f1);
                    break;
                case 2:
                    Expense.viewLatest(f1);
                    break;
                case 3:
                    Expense.viewHistoty(f1);
                    break;
                case 4:
                    Expense.clearHistory(f1);
                    break;
                case 5:
                    System.out.println("Exited successfully");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid option");   
            }         
        }
    }     
}