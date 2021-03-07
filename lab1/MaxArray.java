public class MaxArray{
	public static int max (int[] m){
		int m_len = m.length;
		int max_num = 0;
		for (int i = 0; i < m_len; i++){
			if (m[i] > max_num){
				max_num = m[i];
			}
		}
		System.out.println(max_num);
		return max_num;
		

	}
	public static void main(String[] args){
		int[] m = new int[]{9, 2, 15, 2, 22, 10, 6};
		max(m);
	}
}