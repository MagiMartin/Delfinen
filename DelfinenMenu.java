import java.util.*;
import java.io.*;

public class DelfinenMenu{

   private Scanner input = new Scanner(System.in);
   private boolean stop = false;
   private String answer = ""; 
   MemberHandling member = new MemberHandling();
   KonkurrenceUdtagelse udtagelse = new KonkurrenceUdtagelse();
   
   public void startMenu()throws InterruptedException, FileNotFoundException{
      
      member.registerMembers();
      
      while(stop != true){
      
         System.out.println();
         System.out.println("~ Welkommen til klub Delfinen ~");
         System.out.println();
         System.out.print("Login: ");
         
         answer = input.next();
         
         
         System.out.println(".");
         Thread.sleep(500);
         System.out.println(".");
         Thread.sleep(500);
                
         if(answer.equals("123")){
            formand();     
         }
         else if(answer.equals("456")){
            kassere();
         }
         else if(answer.equals("789")){
            coach();
         }
         else if(answer.equals("+")){
            System.out.println("'System lukker ned'");
            stop = true;
         }else{
            System.out.println("'Forkert login'");
            System.out.println("");
         }
      }
   }

   public void formand()throws InterruptedException,FileNotFoundException{
      System.out.println("Velkommen 'Formand'");
      System.out.println("[1] Opret nyt medlem");
      System.out.println("[2] Exit");
      
      try{
         System.out.print("Input: ");
         answer = input.next();
      
         if(answer.equals("1")){
            member.newMember();
            member.saveMembers();
         }
         else if(answer.equals("2")){
            System.out.println("");
            System.out.println("'logger af Formand'");
            System.out.println("");
            Thread.sleep(500);
            stop = false;
         }else{
            System.out.println("");
            System.out.println("'Input ikke kendt'");
            System.out.println("");
            Thread.sleep(500);
            formand();
              
         }
         
      }catch(InputMismatchException i){
         System.out.println("'Forkert input'");
         System.out.println("");  
      }   
   }

   public void kassere()throws InterruptedException, FileNotFoundException{
      System.out.println("Velkommen 'Kassere'");
      System.out.println("[1] Ubetalt Kontingent");
      System.out.println("[2] Exit");
     
      try{   
         System.out.print("Input: ");
         answer = input.next();
         
         if(answer.equals("1")){
            member.restance();
            System.out.println("");
            kassere();      
         }
         else if(answer.equals("2")){
            System.out.println("");
            System.out.println("'Logger af Kasser'");
            System.out.println("");
            Thread.sleep(500);
            stop = false;
         }else{
            System.out.println("");
            System.out.println("'Input ikke kendt'");
            System.out.println("");
            Thread.sleep(500);
            kassere();
              
         }
            
      }catch(InputMismatchException i){
         System.out.println("'Forkert input'");
         System.out.println("");      
      } 
   }
   
   public void coach()throws InterruptedException,FileNotFoundException{
      System.out.println("Velkommen 'Traner'");
      System.out.println("[1] Se tranings statistik");      
      System.out.println("[2] Se konkurrence statistik");
      System.out.println("[3] Set ny tid");
      System.out.println("[4] Exit");   
      
      try{   
         System.out.print("Input: ");
         answer = input.next();
         
         if(answer.equals("1")){
            System.out.print("Hvilken disiplin?: ");
            String swimtype = input.next();       
            udtagelse.trackTimeTraining(swimtype);
            coach();
         }
         else if(answer.equals("2")){
            System.out.print("Hvilken disiplin?: ");
            String swimtype = input.next();
            udtagelse.trackTimeCompetition(swimtype);
            coach();
         }
         else if(answer.equals("3")){
            udtagelse.setNewTime();
            coach();
         }         
         else if(answer.equals("4")){
            System.out.println("");
            System.out.println("'Logger af Traner'");
            System.out.println("");
            Thread.sleep(500);
            stop = false;
         }else{
            System.out.println("");
            System.out.println("'Input ikke kendt'");
            System.out.println("");
            Thread.sleep(500);
            coach();
             
         }
         
      }catch(InputMismatchException i){
         System.out.println("'Forkert input'");
         System.out.println("");     
      } 
   }   
}