import java.text.*;
import java.util.*;
import java.io.IOException;

public class BillDetail{
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    int billNum,areaCode,pres, prev,custCharge,ed;
    char grp;
    double unit,unitFare,presAmount,netAmount,totalDue;
    String name,address,prevDate,presDate,city,dueDate;
    public void BillDetail(){
        //Customer detail
        System.out.print("Enter owner's name : ");
        name = sc.nextLine();
        System.out.println();

        System.out.print("City :");
        city = sc.nextLine();

        System.out.print("Enter owner's address : ");
        address = sc.nextLine();

        System.out.print("Enter owner's Area code : ");
        areaCode = sc.nextInt();

        //GRP
        grp = (char) (random.nextInt(26) + 'A');


        //Meter readings
        SimpleDateFormat format = new SimpleDateFormat("MM yyyy");
        //Previous month of reading
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -2);
        //System.out.println(format.format(c.getTime()));
        prevDate = format.format(c.getTime());

        //Present month of reading
        Calendar d = Calendar.getInstance();
        d.add(Calendar.MONTH, 0);
        //System.out.println(format.format(c.getTime()));
        presDate = format.format(d.getTime());

        //input meter readings
        System.out.print("Enter previous months reading : ");
        prev = sc.nextInt();
        System.out.println();
        System.out.print("Enter present month reading : ");
        pres = sc.nextInt();
        System.out.println();

        //Generating bill number
        billNum = random.nextInt(10000);

        //Previous bill amount
        System.out.print("Enter previous bill amount : ");
        presAmount = sc.nextDouble();



        //Cust & ED charge generator
        custCharge = random.nextInt(80);
        ed = random.nextInt(10);

        //calculating charge on units
        System.out.print("Enter meter units :");
        unit = sc.nextDouble();
        unitFare = unit*1.25;

    }


    public void displayDetails(){
        System.out.flush();
        System.out.println("---------------------------------------------------------");
        //Net amount

        netAmount = unitFare+custCharge+ed+presAmount;
        totalDue = netAmount+presAmount;

        //Due date
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        Calendar e = Calendar.getInstance();
        e.add(Calendar.DATE, 15);
        dueDate = format.format(e.getTime());
        //display first section
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        System.out.println("BILL No. :"+billNum+"\t"+"GRP :"+grp);
        System.out.println("NAME\t:"+name);
        System.out.println("ADDR\t:"+address);
        System.out.println(city);
        System.out.println("Area code :"+areaCode);
        System.out.println("---------------------------------------------------------");
        //second section
        System.out.println("IR\tREADING\tMONTH");
        System.out.println("PS\t"+pres+"\t"+presDate);
        System.out.println("PV\t"+prev+"\t"+prevDate);
        System.out.println("Units\t:"+unit);
        System.out.println("---------------------------------------------------------");
        System.out.println("Energy charges\t:"+unitFare);
        System.out.println("Cust charges\t:"+custCharge);
        System.out.println("ED\t:"+ed);
        System.out.println("NET AMOUNT\t:"+netAmount);
        System.out.println("TOTAL DUE\t:"+totalDue);
        System.out.println("DUE DATE\t:"+dueDate);





    }
}
