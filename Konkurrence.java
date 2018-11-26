import java.util.*;

public class Konkurrence extends Member{

   private String trainer;
   private int tid;
   private String dato;
   private String competition;
   private int placering;
   ArrayList<String> swimDiscipline = new ArrayList<String>();

   public Konkurrence(String name,int age,String memberstatus, String memberpart,String membertype, int kontigent){
      super(name,age,memberstatus,memberpart,membertype,kontigent);
   }

   public Konkurrence(String name,String trainer,int age,String memberstatus, String memberpart,String membertype, int kontigent, String disciplin1){
      super(name, age,memberstatus,memberpart,membertype,kontigent);
      
      String[] elements = disciplin1.split(",");
      
      for(int i=0 ; i<elements.length;i++){  
      swimDiscipline.add(elements[i]);
      }
      
      this.trainer = trainer; 
   }
   
   public Konkurrence(String name,int tid, String dato){
    super(name);
    this.tid = tid;
    this.dato = dato;
   }
   
   public Konkurrence(String name,int tid, String dato, String competition,int placering){
    super(name);
    this.tid = tid;
    this.dato = dato;
    this.competition = competition;
    this.placering = placering;
   }


   public String getDisciplin(){
      
      String discipline = "";
   
      for(int i=0; i<swimDiscipline.size(); i++){
         discipline += swimDiscipline.get(i)+",";
      }
      return discipline;
   }
   
   public String getTrainer(){
      return trainer;}
   public int getTid(){
      return tid;}
   public String getCompetition(){
      return competition;}
   public int getPlacering(){
      return placering;}
}