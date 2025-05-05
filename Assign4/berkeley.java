import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class berkeley {
 public static void berkeleyAlgo(String servertime, String time1, String time2) {
 System.out.println("Server Clock = " + servertime);
 System.out.println("Client Clock 1 = " + time1);
 System.out.println("Client Clock 2 = " + time2);
 SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
 try {
 /* Converting time to Milliseconds */
 long s = sdf.parse(servertime).getTime(); //Server Time
 long t1 = sdf.parse(time1).getTime(); //Client1 Time
 long t2 = sdf.parse(time2).getTime(); //Client2 Time
 /* Calcuating time differences w.r.t server */
 // long s = s – s=0; 
 long st1 = t1 - s; //Client1-Server time in milisecond((1 sec=1000 milisecond so divide by 1000)
 System.out.println("t1 - s = "+st1/1000);
 long st2 = t2 - s; //client2 –server time in millisecond(1 sec=1000 milisecond so divide by 1000)
 System.out.println("t2 - s = "+st2/1000);
 /*Calculate Average of all millisecond times here server time –server time=0 in millisecond therefore take 0 
value i.e. Fault tolerant Average */
 long aveg = (st1 + st2 + 0) / 3;
 System.out.println("(st1 + st2 + 0)/3 = "+aveg/1000); //print average time in milisecond
 /* Adjust clock values by adding or substracting average clock value from client1 time and client1 time 
Adjustment */
 long adjserver = aveg+s;
 long adj_t1 = aveg-st1;
 long adj_t2 = aveg-st2;
 System.out.println("t1 adjustment = "+adj_t1/1000);
 System.out.println("t2 adjustment = "+adj_t2/1000);
/* sync clock values of clients and server */
 System.out.println("Synchronized Server Clock = "+sdf.format(new Date(adjserver)));
 System.out.println("Synchronized Client1 Clock = "+sdf.format(new Date(t1+adj_t1)));
 System.out.println("Synchronized Client2 Clock = "+sdf.format(new Date(t2+adj_t2)));
 } catch (ParseException e) {
 e.printStackTrace();
 }
 }
 
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter server time (mm:ss): ");
 String servertime = input.next();
 System.out.print("Enter client clock 1 (mm:ss): ");
 String time1 = input.next();
 System.out.print("Enter client clock 2 (mm:ss): ");
 String time2 = input.next();
 
 berkeleyAlgo(servertime, time1, time2);
 input.close();
 }
}