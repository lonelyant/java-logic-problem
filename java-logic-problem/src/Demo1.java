import org.junit.Test;

public class Demo1 {

	public static void main(String[] args) {

	}

	/***********************************************************
	 * ��Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ� С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ�������
	 * ��ÿ���µ���������Ϊ���٣�
	 * ����ֻ��ӡ��10���µ����Ӷ�����
	 * 
	 * ��N����������������Կ����� N-1��������� + �պ��ڵ�N����������������Ϊ����֮�����һ�ԣ�
	 * �������� ��N���������=N-1��� + N-2�죬������ĸ��³���Ļ�����N���������=N-1��� + N-3��
	 */
	@Test
	public void rubbit() {
		for (int i = 1; i < 11; i++) {
			System.out.println("��"+i+"���µ�������Ϊ��"+ calcrubbit(i));
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
