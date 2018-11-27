public class Member{

   private int age;
   private String membertype;
   private String memberstatus;
   private String memberpart;
   private int kontigent;
   private String name;
   private boolean betalt = true;

   public Member(String name,int age, String memberstatus, String memberpart,String membertype, int kontigent){
   
      this.age = age;
      this.memberpart = memberpart;
      this.memberstatus = memberstatus;
      this.membertype = membertype;
      this.kontigent = kontigent;
      this.name = name;
   
   }
   
   public Member(String name){
      this.name = name;
   }

   public int getAge(){
      return age;}
   public String getMemberType(){
      return membertype;}
   public String getMemberStatus(){
      return memberstatus;}
   public String getMemberPart(){
      return memberpart;}
   public int getKontigent(){
      return kontigent;}
   public String getName(){
      return name;}
   public void setBetalt(boolean betalt){
      this.betalt = betalt;
   }
   public boolean getBetalt(){
      return betalt;
   }
}