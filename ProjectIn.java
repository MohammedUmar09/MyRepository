//RentalVehicalSystem 
import java.util.Scanner;
class Vehicle
{
    private String brand;//manufacturer
    private String modalName;//specific modal name
    private double rentalPrice;
    boolean available;

    public Vehicle(String brand,String modalName,double rentalPrice)
    {
       this.brand=brand;
       this.modalName=modalName;
       this.rentalPrice=rentalPrice;
       this.available=true;
    }
    public String getBrand()
    {
        return brand;
    }
    public String getModalName()
    {
        return modalName;
    }
    public double getRentalPrice()
    {
        return rentalPrice;
    }
    public String isAvailable()
    {
        if(available==true)
        {
            return "Available";
        }
        else 
        {
            return "Not available";
        }
    }
    public void rentVehicle()
    {
        if(available)
        {
            System.out.println("Rented Successfully");
            available=false;
        }
        else
        {
            System.out.println("Vehicle is Not Available");
        }
    }
    public void returnVehicle()
    {
        if(!available)
        {
            System.out.println("Vehicle has been Returned Successfully");
            available=true;
        }
        else
        {
            System.out.println("Vehicle is already available");
        }
    }
    public void vehicleInfo()
    {
        System.out.println("Brand : "+brand);
        System.out.println("ModalName : "+modalName);
        System.out.println("RentalPrice$: "+rentalPrice+" per day");
        System.out.println("Status : "+(available? "Available": "Not Availble"));//instead of if-else using ternary operator
    }
} 
class Car extends Vehicle
{   int numberOfDoors;
    String engineType;
    String colour;
    public Car(String brand,String modalName,double rentalPrice,int numberOfDoors,String engineType,String colour)
    {
        super(brand,modalName,rentalPrice);//Here subclass constructor is calling superclass constructor to initialize private variables indirectly
        this.numberOfDoors=numberOfDoors;
        this.engineType=engineType;
        this.colour=colour;
    }
    @Override
    public void vehicleInfo()
    {
        super.vehicleInfo();
        System.out.println("Number Of Doors : "+numberOfDoors);
        System.out.println("Colour : "+colour);
        System.out.println("Engine Type : "+engineType);
    }
}
class Bike extends Vehicle
{   String engineType;
    String colour;
    public Bike(String brand,String modalName,double rentalPrice,String engineType,String colour)
    {
        super(brand,modalName,rentalPrice);
        this.engineType=engineType;
        this.colour=colour;
    }
    public void vehicleInfo()
    {
        super.vehicleInfo();
        System.out.println("Colour : "+colour);
        System.out.println("Engine Type : "+engineType);
    }
}
class VehicleRentalSystem
{
    static int c;
    public static void main(String[] a)
    {
        Car obj1=new Car("Toyota","Camry",50.0,4,"Petrol","Super White");

        Bike obj2=new Bike("TVS","Apache RTR 160",20.0,"Petrol","Red" );

        Scanner sc=new Scanner(System.in);

        while(true)
        {
            System.out.println("\n1.Vehicle Type");
            System.out.println("2.Vehicle Info");
            System.out.println("3.Check Availability");
            System.out.println("4.Rent");
            System.out.println("5.Return");
            System.out.println("6.Exit");
            System.out.print("Choose an option : ");
            int choice=sc.nextInt();
            System.out.println();
            switch(choice)
            { 
                case 1:
                    System.out.println("What type of vehicle you want : \n1.Car\n2.Bike");
                    System.out.print("Choose an option : ");
                    c=sc.nextInt();
                    System.out.println("Noted!");
                    break;
                case 2:
                    if(c==1) 
                    {   System.out.println("Car Info : ");
                        obj1.vehicleInfo();
                    }
                    else if(c==2)
                    {
                        System.out.println("Bike Info : ");
                        obj2.vehicleInfo();
                    }   
                    else
                    {
                        System.out.println("Mention the Vehicle type for the Info");
                    }
                    break;
                case 3:
                    if(c==1)
                    {
                        System.out.println("Car Availability : "+obj1.isAvailable());
                    }
                    else if(c==2)
                    {
                        System.out.println("Bike Availability : "+obj1.isAvailable());
                    }
                    else
                    {
                        System.out.println("Mention the Vehicle type to check its availability");
                    }
                    break;
                case 4:
                    if(c==1||c==2)
                    {
                        obj1.rentVehicle();
                    }
                    else
                    {
                        System.out.println("Pls Select a Vehicle First");
                    }
                    break;
                case 5:
                    if(c==1||c==2)
                    {
                        obj1.returnVehicle();
                    }
                    else
                    {
                        System.out.println("Pls Select a Vehicle First");
                    }
                    break;
                case 6:
                    System.out.println("Exited Successfully");
                    System.exit(0); 
                default:
                    System.out.println("Enter a valid option");  
            }
        }
    }
}