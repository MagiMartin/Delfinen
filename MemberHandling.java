import java.util.*;
import java.io.*;

public class MemberHandling{

   String kontigentType[] = {"junior","senior","passiv"};
   int kontigentPris[] = {1000,1600,500};
   ArrayList<Member> memberlist = new ArrayList<Member>();
   int kontigent;
   String membertype;
   Scanner input = new Scanner(System.in);

   
   
   public void registerMembers()throws FileNotFoundException{   
      Scanner inputmotion = new Scanner(new File("motionmember.txt"));
      Scanner inputkonkurrence = new Scanner(new File("konkurrencemember.txt"));   
      while (inputkonkurrence.hasNext()) {
         String name = inputkonkurrence.next();
         int age = inputkonkurrence.nextInt();
         String part = inputkonkurrence.next();
         String status = inputkonkurrence.next();
         String type = inputkonkurrence.next();
         int kontigent = inputkonkurrence.nextInt();
         String trainer = inputkonkurrence.next();
         String disciplin = inputkonkurrence.next();
         memberlist.add(new Konkurrence(name,trainer,age,status,part,membertype,kontigent,disciplin));
      }
      while (inputkonkurrence.hasNext()) {
         String name = inputkonkurrence.next();
         int age = inputkonkurrence.nextInt();
         String part = inputkonkurrence.next();
         String status = inputkonkurrence.next();
         String type = inputkonkurrence.next();
         int kontigent = inputkonkurrence.nextInt();
         memberlist.add(new Motionist(name,age,status,part,membertype,kontigent));
      }  
   }

   
   
   public void newMember(){  
      System.out.println("navn");
      String name = input.next();
      System.out.println("alder");
      int age = input.nextInt();   
      System.out.println("aktiv/passiv");
      String status = input.next();   
      System.out.println("motionist/konkurrence");
      String part = input.next();  
      if(status.equals("passiv")){
         kontigent = 500;
      }else if (age <= 18 && status.equals("aktiv")){
         kontigent = kontigentPris[0];
         membertype = kontigentType[0];
      }else if ((age >= 18 & age <= 59) && status.equals("aktiv")){
         kontigent = kontigentPris[1];
         membertype =  kontigentType[1];
      }else if (age >= 60 && status.equals("aktiv")){
         kontigent = kontigentPris[1]-400;
         membertype = kontigentType[1];
      } 
      if(part.equals("motionist")){
         memberlist.add(new Motionist(name,age,status,part,membertype,kontigent));
      }else if(part.equals("konkurrence")){
         
         String trainer;
         
         if(age < 18 ){
            trainer = "johnjohn";}
         else{trainer = "basse";}         
         System.out.println("hvor mange svømme discipliner vi har : [crawl,butterfly]");
         System.out.println("Skriv discipliner kunb adskilt af komma");
         String antal_disciplin = input.next();
         memberlist.add(new Konkurrence(name,trainer,age,status,part,membertype,kontigent,antal_disciplin));
      }
   }
   
   
   
   public void saveMembers()throws FileNotFoundException{   
      PrintStream output = new PrintStream("motionmember.txt");
      PrintStream output1 = new PrintStream("konkurrencemember.txt");
      for(Member m : memberlist){
         if (m instanceof Motionist){
            output.println(m.getName() + " " + m.getAge() + " " + m.getMemberType() + " " + m.getMemberStatus() + " " + m.getMemberPart() + " " + m.getKontigent());
         }else if (m instanceof Konkurrence){
            output1.println(m.getName() + " " + m.getAge() + " " + m.getMemberType() + " " + m.getMemberStatus() + " " + m.getMemberPart() + " " + m.getKontigent() + " " + ((Konkurrence) m).getTrainer() + " " + ((Konkurrence) m).getDisciplin());
         }   
      }
   }
}