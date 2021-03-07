public class MaxArray{
	public static int max (int[] m){
		len = m.length;
		int max_num = 0;
		for (int i = 0; i < len; i++){
			if (m[i] > max_num){
				max_num = m[i];
			}
		}
		System.out.println(max_num);

	}
	public static void main(String[] args){
		int[] m = new int[]{1,2,3};
		max(m);
	}
}