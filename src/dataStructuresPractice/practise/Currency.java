package dataStructuresPractice.practise;

public enum Currency {
   PENNY(1), DIME(2), QUARTER(4);
   int value;

   private Currency(int value){
       this.value = value;
   }

   public int getValue(){
       return this.value;
   }

}
