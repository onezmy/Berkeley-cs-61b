public class LargerDemo{
	/** Returns the Larger of x and y. */
	public static int larger(int x,int y){
		if(x > y) {
			return x;
		}
		return y;
	}
	public static void main(String[] args){
		System.out.println(larger(-5,10));

	}
}
/*
1.function must be delared as part of a class in Java; inside a class --> methods
2.use public static to define a function
3.declare output type, declare input type
4.return only one value
5.main code insided main()*/