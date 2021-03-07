public class PrintStar {
   public static void DrawTriangle(int N){
      String star = "*";
		int x = 0;
		while (x < N){
			System.out.println(star);
			star = star +"*";
			x = x + 1;
		}
      
   }
   
   public static void main(String[] args) {
      DrawTriangle(3);
      
   }
}