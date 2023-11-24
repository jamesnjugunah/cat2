import java.util.Scanner;
// a method that gets the username and registration number.
class getdetails{
    String username;
    String regNo;
    public void getdetails(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username: ");
        username = input.nextLine();
        System.out.println("Enter your registration number: ");
        regNo = input.next();
    }
}
class finances{
    double current_fee=20000;
    double fees;
    double balance;

    public void fees(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount of fees: ");
        fees = input.nextDouble();
        balance = current_fee-fees;
    }
    public void display(){

        System.out.println("The amount of balance is: "+balance);

    }
}
class marks {
    public void getmarks

    {
        String[] arr = {"English", "Mathematics", "Kiswahili", "Science,S/S & CRE"};
        double[][][] subjects = new double[1][5][3];
        double total=0;
        String[] grade={"A","B","C"};
        for (int i = 0; i <= arr.length; i++) {

            for(int j=0; j <= subjects.length; j++) {
                System.out.println("enter marks for" + i);
                subjects[i][j][k] = Scanner.nextDouble;
                for (int k = 0; k <= grade; k++) {
                    if (subjects[i][j][k] >= 70 && subjects[i][j][k] <= 100) {
                        grade = "A";
                    } else if (subjects[i][j] >= 50 && subjects[i][j] < 70) {
                        grade = "B";
                    } else if (subjects[i][j] > 40) {
                        grade = "C";
                    } else {
                        System.out.println("invalid marks!!!");
                    }
                    total = subjects[i][j] + total;
                }
            }

        double average= total/5;
            if(average >=70 ){
                grade="A";
            }

        }
    }
}







public class Main {
    public static void main(String[] args) {

    }
}
