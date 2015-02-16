//Strategy'deki de�i�iklikleri uygulayan s�n�f
public class Context {
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public int executeStrategy(){
      return strategy.level();
   }
}