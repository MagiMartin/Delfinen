import java.util.*;
import java.io.*;

public class KonkurrenceUdtagelse{

   ArrayList<Konkurrence> map2 = new ArrayList<Konkurrence>();   
   
   public void setNewTime()throws FileNotFoundException{
      try{
         File file = new File("trainingtider.txt");
         File file1 = new File("konkurrencetider");
         PrintStream output = new PrintStream(new FileOutputStream(file,true));
         PrintStream output1 = new PrintStream(new FileOutputStream(file1,true));
         Scanner input1 = new Scanner(System.in); 
      
         System.out.println("1:Træning    2:konkurrecne");
         int answer = input1.nextInt();
         if(answer == 1){
            System.out.println("Disciplin");
            String disciplin = input1.next();   
            System.out.println("navn");
            String name = input1.next();
            System.out.println("tid i sekunder");
            int tid = input1.nextInt();  
            System.out.println("dato [dd/mm-yr]");
            String date = input1.next();
            output.println(disciplin + " " + name + " " + tid + " " + date); 
         }else if (answer == 2){
            System.out.println("Disciplin");
            String disciplin = input1.next();   
            System.out.println("navn");
            String name = input1.next();
            System.out.println("tid i sekunder");
            int tid = input1.nextInt();  
            System.out.println("dato [dd/mm-yr]");
            String date = input1.next();
            System.out.println("Stævne");
            String cup = input1.next();
            System.out.println("placering");
            int placering = input1.nextInt();
            output1.println(disciplin + " " + name + " " + tid + " " + date + " " + cup + " " + placering);       
         }
      
      }catch(Exception i){
         System.out.println("Wrong input");
      }
   }
 
 
   public void trackTimeTraining(String swimType)throws FileNotFoundException{   
      Scanner input = new Scanner(new File("trainingtider.txt"));
      while (input.hasNext()) {
         String word = input.next();
         if (word.equals(swimType)){
            String name = input.next();
            int tid = input.nextInt();
            String dato = input.next();
            map2.add(new Konkurrence(name,tid,dato));                          
         }else{
            input.nextLine();
         }
      } 
     
      for(int i = 0 ; i < map2.size() ; i++){
         String name = map2.get(i).getName();
         for(int j = i+1 ; j < map2.size() ; j++){
            if(name.equals(map2.get(j).getName())){
               int tidi = map2.get(i).getTid();
               int tidj = map2.get(j).getTid();
               if(tidi < tidj){
                  map2.remove(j);
                  i=i-1;
               }else{
                  map2.remove(i);
                  i=i-1;
               }               
            }
         }    
      } 
     
     
      for(int i = 0; i<map2.size()-1 ; i++){
      
         int tid = map2.get(i).getTid();
         int tid2 = map2.get(i+1).getTid();
      
         if(tid2<tid){   
            Collections.swap(map2, i+1, i);        
         }
      
      }
      
      for(Konkurrence m : map2){
         System.out.println(m.getName() + "/" + m.getTid());
      }
   }
   
   public void trackTimeCompetition(String swimType)throws FileNotFoundException{   
      Scanner input = new Scanner(new File("konkurrencetider.txt"));
      while (input.hasNext()) {
         String word = input.next();
         if (word.equals(swimType)){
            String name = input.next();
            int tid = input.nextInt();
            String dato = input.next();
            String competition = input.next();
            int placering = input.nextInt();
            map2.add(new Konkurrence(name,tid,dato,competition,placering));                          
         }else{
            input.nextLine();
         }
      } 
     
      for(int i = 0 ; i < map2.size() ; i++){
         String name = map2.get(i).getName();
         for(int j = i+1 ; j < map2.size() ; j++){
            if(name.equals(map2.get(j).getName())){
               int tidi = map2.get(i).getTid();
               int tidj = map2.get(j).getTid();
               if(tidi < tidj){
                  map2.remove(j);
                  i=i-1;
               }else{
                  map2.remove(i);
                  i=i-1;
               }               
            }
         }    
      } 
     
     
      for(int i = 0; i<map2.size()-1 ; i++){
      
         int tid = map2.get(i).getTid();
         int tid2 = map2.get(i+1).getTid();
      
         if(tid2<tid){   
            Collections.swap(map2, i+1, i);        
         }
      
      }
      
      for(Konkurrence m : map2){
         System.out.println(m.getName() + "/" + m.getTid()+ "/" + m.getPlacering()+ "/" + m.getCompetition());
      }
   }
   
}