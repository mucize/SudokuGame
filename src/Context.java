//Strategy'deki deðiþiklikleri uygulayan sýnýf
public class Context {
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public int executeStrategy(){
      return strategy.level();
   }
}