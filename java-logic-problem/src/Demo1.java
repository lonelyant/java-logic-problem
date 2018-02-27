import org.junit.Test;

public class Demo1 {

	public static void main(String[] args) {

	}

	/***********************************************************
	 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子， 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
	 * 问每个月的兔子总数为多少？
	 * 这里只打印出10个月的兔子对数。
	 * 
	 * 第N天的兔子总数，可以看做是 N-1天的兔子数 + 刚好在第N天成熟的兔子数（因为成熟之后会生一对）
	 * 本题中是 第N天的兔子数=N-1天的 + N-2天，如果是四个月成熟的话，第N天的兔子数=N-1天的 + N-3天
	 */
	@Test
	public void rubbit() {
		for (int i = 1; i < 11; i++) {
			System.out.println("第"+i+"个月的兔子数为："+ calcrubbit(i));
		}
	}
	public int calcrubbit(int month){
		if(month > 2){
			return calcrubbit(month-1)+calcrubbit(month-2);
		}else{
			return 1;
		}
	}
	
	
	
}
