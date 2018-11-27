import java.util.*;
import java.io.*;

public class MemberHandling{

   private String kontigentType[] = {"junior","senior"};
   private int kontigentPris[] = {1000,1600,500};
   private ArrayList<Member> memberlist = new ArrayList<Member>();
   private int kontigent;
   private String membertype;
   private Scanner input = new Scanner(System.in);
 
   public void registerMembers()throws FileNotFoundException{   
      Scanner inputmotion = new Scanner(new File("motionmember.txt"));
      Scanner inputkonkurrence = new Scanner(new File("konkurrencemember.txt"));   
      while (inputkonkurrence.hasNext()) {
         String name = inputkonkurrence.next();
         int age = inputkonkurrence.nextInt();
         String type = inputkonkurrence.next();  
         String status = inputkonkurrence.next();
         String part = inputkonkurrence.next();
         int kontigent = inputkonkurrence.nextInt();
         String trainer = inputkonkurrence.next();
         String disciplin = inputkonkurrence.next();
         memberlist.add(new Konkurrence(name,trainer,age,status,part,type,kontigent,disciplin));
      }
      while (inputmotion.hasNext()) {
         String name = inputmotion.next();
         int age = inputmotion.nextInt();
         String type = inputmotion.next();
         String status = inputmotion.next();
         String part = inputmotion.next();
         int kontigent = inputmotion.nextInt();
         memberlist.add(new Motionist(name,age,status,part,type,kontigent));
      }  
   }

   public void restance(){
   
      int rand = (int)(Math.random()*4);
      int rand1 = (int)(Math.random()*4);
   
      System.out.println("");
      System.out.println("Disse personer skylder kontigent: ");
      memberlist.get(rand).setBetalt(false);
      memberlist.get(rand1).setBetalt(false);
      System.out.println("");

   
      for(Member m : memberlist){
         if (m.getBetalt() == false){
            System.out.println("Navn: "+ m.getName() + " " + "Alder: " + m.getAge() + " " + "Type: " + m.getMemberType() + " " + "Status: "+m.getMemberStatus() + " " +"Aktivitet: "+ m.getMemberPart() + " " +"Belob: "+ m.getKontigent());

         }
      } 
      for(Member m : memberlist){
         m.setBetalt(true);         
      }
   
   }
    
   public void newMember(){ 
      try{ 
         System.out.println("");
         System.out.print("navn: ");
         String name = input.next();
         System.out.print("alder: ");
         int age = input.nextInt();   
         System.out.print("aktiv/passiv: ");
         String status = input.next();   
         System.out.print("motionist/konkurrence: ");
         String part = input.next();  
         if(status.equals("passiv")){
            kontigent = kontigentPris[2];
            if(age <= 18){ 
               membertype = kontigentType[0];
            }else{
               membertype = kontigentType[1];
            }
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
            System.out.println("Navn: " + name + " " + "Alder: " + age + " " + "Status: " + status + " " + "Aktivitet: "+ part + " " +"Type: "+ membertype + " " +"Belob: "+ kontigent);
            System.out.print("Er det de rigtge informationer?: ");
            String answer;
            answer = input.next();
               if(answer.equals("ja")){
                  memberlist.add(new Motionist(name,age,status,part,membertype,kontigent));
               }else{
                  newMember();
               }
         }else if(part.equals("konkurrence")){
         
            String trainer;
         
            if(age < 18 ){
               trainer = "Bear_G.";}
            else{trainer = "Arnold_S.";}         
            System.out.println("hvor mange svomme discipliner vi har: (eks. Crawl,Butterfly,Rygsvomning)");
            System.out.print("Skriv discipliner kun adskilt af komma: ");
            String antal_disciplin = input.next();
            memberlist.add(new Konkurrence(name,trainer,age,status,part,membertype,kontigent,antal_disciplin));
         }
      }catch(Exception i){
         System.out.println("Forkert input");
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