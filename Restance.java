import java.util.*;

public class Restance{

   //Field
   

   //Show members in restance
   public void restance(){
   
      ArrayList<Member> list = new MemberHandling().getList();
      
      int rand = (int)(Math.random()*list.size());
      int rand1 = (int)(Math.random()*list.size());
   
      System.out.println("");
      System.out.println("Disse personer skylder kontigent: ");
      list.get(rand).setBetalt(false);
      list.get(rand1).setBetalt(false);
      System.out.println("");
   
      for(Member m : list){
         if (m.getBetalt() == false){
            System.out.println("Navn: "+ m.getName() + " " + "Alder: " + m.getAge() + " " + "Type: " + m.getMemberType() + " " + "Status: "+m.getMemberStatus() + " " +"Aktivitet: "+ m.getMemberPart() + " " +"Belob: "+ m.getKontigent());       
         }
      } 
      for(Member m : list){
         m.setBetalt(true);         
      } 
   }
}


