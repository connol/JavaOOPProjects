/**
 *Simple driver to test Money, Date, and Bill classes
 *@author Rob Nash, borrowed from cfolsen 
 *Substanital additions by Connor Lauerman
 */
public class BillMoneyDateDriver 
{

    /**
    main driver function
    pre:  none
    post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args)
    {
        System.out.println("New tests");
        Date a = new Date(1,2,2019);
        Date b = a.clone();
        Date c = new Date(3,3,2020);
        Date d = new Date(3,3,2018);
        System.out.print("Checks if clonable creates deep copy");
        System.out.println(" if so it will print false then true");
        System.out.println((a == b) + " " + a.equals(b));
        System.out.println("prints -1\n"+a.compareTo(c));
        System.out.println("prints 1\n"+c.compareTo(a));
        
        Money z = new Money(100,0);
        Money y = z.clone();
        Money x = new Money(300,0);
        System.out.print("Checks if clonable creates deep copy");
        System.out.println(" if so it will print false then true");
        System.out.println((z==y) + " " + z.equals(y));
        System.out.println("prints -1\n"+z.compareTo(x));
        System.out.println("prints 1\n"+x.compareTo(z));
        
        Bill j = new Bill(z,a,"lona");
        Bill k = j.clone();
        Bill just = new Bill(x,a,"Smough");
        System.out.print("Checks if clonable creates deep copy");
        System.out.println(" if so it will print false then true");
        System.out.println((k==j) + " " + k.equals(j));
        System.out.println("prints -7\n"+j.compareTo(just));
        System.out.println("prints 7\n"+just.compareTo(j));
        
        
        ExpenseAccount ex = new ExpenseAccount();
        System.out.println("Adds 3 bills to expense accounts");
        ex.debited(j);
        ex.debited(k);
        ex.debited(just);
        System.out.println("Prints the orginator to check if the for each works");
        System.out.println("First two bills are same last is different");
        for(Bill zzz: ex)
        {
            System.out.println(zzz.getOriginator());
        }
        System.out.println("Checks if get Balance method works");
        System.out.println(ex.getBalance());
        ex.credited(j,a);
        System.out.println(ex.getBalance());
        System.out.println("Checks next due Bill");
        ex.nextDue();
        System.out.println("Printing the bills then closing the account");
        System.out.println(ex);
        ex.close(a);
        System.out.println("Nothing will print becasue expense account empty");
        System.out.println(ex);
        
        
        System.out.println("\n\nEnd of New Tests Start of Old tests\n\n");
        //Money tests
        Money money1 = new Money(10);
        Money money2 = money1.clone();
        money1.setMoney(30,50);
        //Will throw runtimeexception
        //money2.setDollars(-5); Will throw runtimeexception
        money2.setDollars(100);
        System.out.println("Dollars: " + money2.getDollars());
        System.out.println();
        
        //Will throw runtume exception
        //money2.setCents(-5);//Will throw runtimeexcetpion for invariants
        //money2.setCents(105);//Will throw runtimeexceptio for invariants
        System.out.println("Sets cents to 50: ");
        money2.setCents(50);
        System.out.println(money2);
        System.out.println();
        
        System.out.println("Returns dollar for money will be 100: ");
        System.out.println("Dollars: " + money2.getDollars());
        System.out.println();
        
        System.out.println("Returns cents for money will be 50: ");
        System.out.println("Cents: " + money2.getCents());
        System.out.println();
        
        System.out.println("Returns total amount of money, will be 100.50: ");
        System.out.println("Total: " + money2.getMoney());
        System.out.println();
        
        money2.setMoney(10,2);
        System.out.println("Sets total amount of money, will be 10.02: ");
        System.out.println("Total: " + money2.getMoney());
        System.out.println();
        
        //Will throw runtimeexception
        //money2.add(-50);
        money2.add(10);
        System.out.println("Adds 10 to dollars, will be 20.02");
        System.out.println("Total: " + money2.getMoney());
        System.out.println();
        
       /* Throws runtimeException 
        money2.add(50 , -50);
        money2.add(-50, 50);
        System.out.println();*/
        
        //Will throw runtimeexception;
        //money2.add(-100,0);
        System.out.println("Will convert dollars to cents and add corectly");
        money2.add(-5,-52);
        System.out.println("Total will be 14.5: ");
        System.out.println("Total: " + money2.getMoney());
        System.out.println();
        
        money2.add(0,-350);
        System.out.println("Will convert dollars to cents and add corectly");
        System.out.println("Total will be 11: ");
        System.out.println("Total: " + money2.getMoney());
        System.out.println();
        
        money2.add(10,900);
        System.out.println("Will convert cents to dollars and add corectly");
        System.out.println("Total will be 30: ");
        System.out.println("Total: " + money2.getMoney());
        System.out.println();
        
        money2.add(0,50);
        System.out.println("Will add cents");
        System.out.println("Total will be 30.5: ");
        System.out.println("Total: " + money2.getMoney());
        System.out.println();
        
        Money adder = new Money(10,20);
        money2.add(adder);
        System.out.println("Will add amount of both objects, store in calling");
        System.out.println("Total will be 40.7: ");
        System.out.println("Total: " + money2.getMoney());
        System.out.println();
        
        System.out.println("Will test if two money are equal");
        System.out.println("Will be true then false");
        Money test = money2.clone();
        System.out.println(money2.equals(test));
        System.out.println(money2.equals(adder));
        System.out.println(money2.toString());
        System.out.println();
        
        //Date tests
        //Will give error msg and exit program");
        //Date dd = new Date(-1,-1,-1);//throw runtume exception
        Date d1 = new Date(2,2,2020);
        Date d2 = d1.clone();
        Date d3 = new Date(6,25,2020);
        System.out.println(d3);
        System.out.println();
        
        d3.setDay(2);
        d3.setMonth(7);
        d3.setYear(2019);
        System.out.println("Will change values of day, month and year");
        System.out.println("Month: 7 Day: 2 Year: 2019");
        System.out.println(d3);
        System.out.println();
        
        System.out.println("Will get values of day, month and year");
        System.out.println(" Day: 2 Month: 7 Year: 2019");
        System.out.println(d3.getDay()+" "+d3.getMonth()+" "+d3.getYear());
        System.out.println(d3.toString());
        System.out.println();
        
        System.out.println("Equals methods will print true then false");
        System.out.println(d2.equals(d1) + " " + d3.equals(d1));
        
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
        System.out.println();

        //Bills test
        Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2007);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
        System.out.print("Testing getter methods prints \" 30.4.2007");
        System.out.println("The phone company \n 20\"");
        System.out.println(bill1.getDueDate()+ " " + bill1.getOriginator());
        System.out.println(bill1.getAmount());
        
        
       
        System.out.println("Creates new bill using bill1 then calling setters");
        Bill bill2 =bill1.clone();
        bill2.setDueDate(new Date(5, 30, 2007));
        Money m = new Money(31, 99);
        bill2.setAmount(m);
        dueDate.setDay(29);
        bill2.setOriginator("Loan Shark");
        Bill bill3 = new Bill(amount, dueDate, "The record company");

        System.out.println("Bill objects output:");
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);
        Date paid = new Date(2,30,2007);
        
        System.out.println("Using set Paid 2 will set 1 wont");
        bill1.setPaid(paid);
        bill2.setPaid(paid);
        //bill3.setPaid(paid); ThrowsRuntimeException
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);
        System.out.println("Test if bill is paid prints true then false");
        System.out.println(bill2.isPaid() + " " + bill3.isPaid());
        System.out.println("Makes bill2 unpaid then prints");
        bill2.unPaid();
        System.out.println(bill2);
        
        
        
        
        
    }
}
