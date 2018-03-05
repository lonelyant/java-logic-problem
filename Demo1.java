import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Demo1 {

	/***********************************************************
	 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子， 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
	 * 问每个月的兔子总数为多少？ 这里只打印出10个月的兔子对数。
	 * 
	 * 第N天的兔子总数，可以看做是 N-1天的兔子数 + 刚好在第N天成熟的兔子数（因为成熟之后会生一对） 本题中是 第N天的兔子数=N-1天的 +
	 * N-2天，如果是四个月成熟的话，第N天的兔子数=N-1天的 + N-3天
	 */
	@Test
	public void rubbit() {
		for (int i = 1; i < 11; i++) {
			System.out.println("第" + i + "个月兔子数是" + calcrubbit(i));
		}
	}

	public int calcrubbit(int month) {
		if (month > 2) {
			return calcrubbit(month - 1) + calcrubbit(month - 2);
		} else {
			return 1;
		}
	}

	/***********************************************************
	 * 题目：判断101-200之间有多少个素数，并输出所有素数
	 * 
	 * 素数：在大于1的自然数中，除了1和它本身以外不再有其他因数
	 */
	@Test
	public void one() {
		boolean flag;
		for (int i = 101; i < 201; i++) {
			flag = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println(i);
			}
		}
	}

	/***********************************************************
	 * 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。 例如：153是一个
	 * "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方
	 */
	@Test
	public void two() {
		int g, s, b;
		for (int i = 100; i < 1000; i++) {
			g = i % 10;
			s = i % 100 / 10;
			b = i / 100;
			if (g * g * g + s * s * s + b * b * b == i) {
				System.out.println(i);
			}
		}
	}

	/*******************************************************
	 * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
	 */
	@Test
	public void three() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数：");
		int num = sc.nextInt();
		int i = 2;
		System.out.print(num + "=");
		while (i < num) {
			if (num % i == 0) {
				System.out.print(i + "*");
				num = num / i;
			} else {
				i++;
			}
		}
		System.out.println(num);
	}

	/*********************************************
	 * 利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
	 */
	@Test
	public void four() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int score = sc.nextInt();
			if (score == -1)
				break;
			System.out.println(score >= 90 ? "A" : score < 60 ? "C" : "B");
		}

	}

	/**********************************************
	 * 输入两个正整数m和n，求其最大公约数和最小公倍数
	 * 
	 * 在循环中,只要除数不等于0,用较大数除以较小的数,将小的一个数作为下一轮循环的大数,
	 * 取得的余数作为下一轮循环的较小的数,如此循环直到较小的数的值为0,返回较大的数, 此数即为最大公约数,最小公倍数为两数之积除以最大公约数
	 */
	@Test
	public void five() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sub = m * n;
		if (m < n) {
			// 交换两个变量的值，确保m>n
			m = m ^ n;
			n = m ^ n;
			m = m ^ n;
		}
		while (n != 0) {
			int i = m % n;
			m = n;
			n = i;
		}
		System.out.println("最大公约数为：" + m + ",最小公倍数为：" + sub / m);
	}

	/*
	 * 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数
	 * 
	 * 注：汉子会占用2个字符
	 */
	@Test
	public void six() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();

		String E2 = "[a-zA-Z]"; // 字母范围
		String E3 = "[0-9]"; // 数字范围
		String E4 = "[ ]"; // 空格

		int countLetter = 0;
		int countNumber = 0;
		int countSpace = 0;
		int countOther = 0;

		char[] arrayChar = str.toCharArray();
		String[] arrayString = new String[arrayChar.length];
		for (int i = 0; i < arrayChar.length; i++)
			arrayString[i] = String.valueOf(arrayChar[i]);

		for (String str2 : arrayString) { // 意思将引用arrayString赋值给str2
			// 相当于for(int i=0; i<arrayString.length; i++)
			if (str2.matches(E2)) {
				countLetter++;
			} else if (str2.matches(E3)) {
				countNumber++;
			} else if (str2.matches(E4)) {
				countSpace++;
			} else {
				countOther++;
			}
		}
		System.out.println("输入的字符串中字母有: " + countLetter + "个");
		System.out.println("输入的字符串中数字有: " + countNumber + "个");
		System.out.println("输入的字符串中空格有: " + countSpace + "个");
		System.out.println("输入的字符串中其他有: " + countOther + "个");
	}

	/*
	 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
	 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制
	 */
	@Test
	public void seven() {
		Scanner sc = new Scanner(System.in);
		System.out.println("a的值是：");
		int a = sc.nextInt();
		System.out.println("几个数相加：");
		int num = sc.nextInt();
		System.out.print("s=");
		int sum = 0;
		int nownum = a;
		for (int i = 0; i < num; i++) {
			sum += nownum;
			if (i == num - 1)
				System.out.print(nownum + "=");
			else
				System.out.print(nownum + "+");
			nownum = nownum * 10 + a;
		}
		System.out.println(sum);
	}

	/*
	 * 一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。 例如6=1＋2＋3.编程找出1000以内的所有完数
	 */
	@Test
	public void eight() {
		int sum;
		for (int i = 1; i <= 1000; i++) {
			sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0)
					sum += j;
			}
			if (i == sum)
				System.out.println(i);
		}
	}

	/*
	 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半再落下， 求它在第10次落地时，共经过多少米？第10次反弹多高？
	 */
	@Test
	public void nine() {
		double start = 100.0d;
		double sum = 0.0d;
		double rise;
		for (int i = 1; i <= 10; i++) {
			rise = start / 2;
			if (i == 1)
				sum = start;
			else {
				sum += 2 * start;
			}
			start = rise;
			System.out
					.println("第" + i + "次落地，共经过了" + sum + "米，本次反弹高度为+" + rise);
		}
	}

	/*
	 * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
	 */
	@Test
	public void ten() {
		int sum = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i != j)
					for (int k = 1; k <= 4; k++) {
						if (i != j && j != k && i != k) {
							System.out.println(i * 100 + j * 10 + k);
							sum++;
						}
					}
			}
		}
		System.out.println(sum);
	}

	/*
	 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数， 请问该数是多少？
	 * 
	 * 完全平方数：若一个数能表示成某个整数的平方的形式，则称这个数为完全平方数
	 */
	@Test
	public void eleven() {
		int num = 0;
		int m;
		int n;
		while (true) {
			m = num + 100;
			n = num + 168;
			if (Math.sqrt((double) m) % 1 == 0
					&& Math.sqrt((double) n) % 1 == 0) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}

	/*
	 * 输入某年某月某日，判断这一天是这一年的第几天
	 * 
	 * 闰年:①：非整百年数除以4，无余为闰，有余为平；②整百年数除以400，无余为闰有余平 二月：平年28天、闰年29天
	 */
	@Test
	public void twelve() {
		int year;
		int mouth;
		int day = 0;
		int days;
		// 累计天数
		int d = 0;
		int e;
		Scanner scanner = new Scanner(System.in);
		do {
			e = 0;
			System.out.println("输入年:");
			year = scanner.nextInt();
			System.out.println("输入月:");
			mouth = scanner.nextInt();
			System.out.println("输入日:");
			days = scanner.nextInt();
			if (mouth < 0 || mouth > 12 || days < 0 || days > 31) {
				System.out.println("input error!");
				e = 1;
			}
		} while (e == 1);
		for (int i = 1; i < mouth; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: {
				day = 31;
				break;
			}
			case 4:
			case 6:
			case 9:
			case 11: {
				day = 30;
				break;
			}
			case 2: {
				/**
				 * 闰年:①：非整百年数除以4，无余为闰，有余为平；②整百年数除以400，无余为闰有余平 二月：平年28天、闰年29天
				 */
				if ((year % 100 != 0 && year % 4 == 0)
						|| (year % 100 == 0 && year % 400 == 0)) {
					day = 29;
				} else {
					day = 28;
				}
			}
			default:
				break;
			}
			d += day;
		}
		System.out.println("这是" + year + "年的" + (d + days) + "天");
	}

	/*
	 * 输入三个整数x,y,z，请把这三个数由小到大输出
	 */
	@Test
	public void thirteen() {
		Scanner sc = new Scanner(System.in);
		int[] sort = new int[3];
		for (int i = 0; i < sort.length; i++) {
			sort[i] = sc.nextInt();
		}
		Arrays.sort(sort);
		for (int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}
	}

	/*
	 * 输出9*9口诀
	 */
	@Test
	public void fourteen() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + " ");
			}
			System.out.print("\n");
		}
	}

	/*
	 * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
	 * 以后每天早上都吃了前一天剩下的一半零一个。 到第10天早上想再吃时，见只剩下一个桃子了。 求第一天共摘了多少
	 */
	@Test
	public void fifteen_one() {
		int sum = 1;
		int left = 1;
		boolean flag = true;
		while (flag) {
			for (int i = 1; i < 10; i++) {
				left = left / 2 - 1;
				if (left < 0)
					break;
				if (i == 9 && left == 1) {
					System.out.println(sum);
					flag = false;
				}
			}
			sum++;
			left = sum;
		}

	}

	@Test
	public void fifteen_two() {
		int sum = 1;
		for (int i = 1; i < 10; i++) {
			sum = (sum + 1) * 2;
		}
		System.out.println(sum);
	}

	/*
	 * 两个乒乓球队进行比赛，各出三人。 甲队为a,b,c三人，乙队为x,y,z三人。 已抽签决定比赛名单。有人向队员打听比赛的名单。
	 * a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单
	 */
	@Test
	public void sixteen() {

	}

	/*
	 * 打印出如下图案（菱形） * *** ***** ******* ***** *** *
	 */
	@Test
	public void seventeen() {
		int n = 7;
		int mid = (n + 1) / 2;
		int space;
		for (int i = 1; i <= n; i++) {
			if (i > mid)
				space = i - mid;
			else if (i < mid)
				space = mid - i;
			else
				space = 0;
			int star = (mid - space) * 2 - 1;
			System.out.println(printdigui(star, "", "*"));
		}
	}

	public String printdigui(int i, String str, String s) {
		if (i > 0) {
			str += s;
			return printdigui(i - 1, str, s);
		} else {
			return str;
		}

	}

	/*
	 * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
	 */
	@Test
	public void eighteen() {
		double sum = 0d;
		double fz = 2d;
		double fm = 1d;
		double nextfm;
		for (int i = 0; i < 20; i++) {
			sum += (fz / fm);
			nextfm = fz;
			System.out.println(fz + "/" + fm + "=" + sum);
			fz = fz + fm;
			fm = nextfm;
		}
		System.out.println(sum);
	}

	/*
	 * 求1+2!+3!+...+20!的和
	 */
	@Test
	public void ninteen() {
		long sum = 0L;
		for (int i = 1; i <= 20; i++) {
			sum = sum + jiecheng(i);
			System.out.println(sum);
		}
		System.out.println("总和：" + sum);
	}

	public long jiecheng(int num) {
		if (num > 1)
			return num * jiecheng(num - 1);
		else
			return 1;
	}

	/*
	 * 利用递归方法求5!
	 */
	@Test
	public void twenty() {
		int num = 5;
		System.out.println(num + "！=" + calcJC(num));
	}

	public int calcJC(int i) {
		if (i > 1)
			return calcJC(i - 1) * i;
		else
			return 1;
	}

	/*
	 * 有5个人坐在一起， 问第五个人多少岁？他说比第4个人大2岁。 问第4个人岁数，他说比第3个人大2岁。 问第三个人，又说比第2人大两岁。
	 * 问第2个人，说比第一个人大两岁。 最后问第一个人，他说是10岁。 请问第五个人多大？
	 */
	@Test
	public void _21() {
		System.out.println(calcAge(5));
	}

	public int calcAge(int n) {
		if (n == 1)
			return 10;
		else
			return 2 + calcAge(n - 1);
	}

	/*
	 * 给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字
	 */
	@Test
	public void _22() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 1;// 位数
		while (num / 10 > 0) {
			count++;
			System.out.print(num % 10);
			num = num / 10;
		}
		System.out.println(num);// 最后一位数字
		System.out.println(count);
	}

	/*
	 * 一个5位数，判断它是不是回文数。 即12321是回文数，个位与万位相同，十位与千位相同。
	 */
	@Test
	public void _23() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int g = num % 10;
		int s = num / 10 % 10;
		int b = num / 100 % 10;
		int q = num / 1000 % 10;
		int w = num / 10000;
		if (g == w && s == q)
			System.out.println(num + "是回文数");
		else
			System.out.println(num + "不是回文数");
	}

	/*
	 * 请输入星期几的第一个字母来判断一下是星期几， 如果第一个字母一样，则继续判断第二个字母
	 */
	@Test
	public void _24() {// 没有设置第一次输入错误后再次输入
		Scanner in = new Scanner(System.in);

		char firstletter, secondletter; // 存放第一第二个字母
		System.out.println("请输入第一字母");
		String letter = in.next();

		firstletter = letter.charAt(0);
		switch (firstletter) {
		case 'm':
		case 'M':
			System.out.println("是星期一");
			break;
		case 'w':
		case 'W':
			System.out.println("是星期三");
			break;
		case 'f':
		case 'F':
			System.out.println("是星期五");
			break;
		case 't':
		case 'T':
			System.out.println("仅由该字母无法判断出星期几，请输入第二个字母");
			letter = in.next();
			secondletter = letter.charAt(0);
			if (secondletter == 'u' || secondletter == 'U') {
				System.out.println("是星期二");
				break;
			} else if (secondletter == 'h' || secondletter == 'H') {
				System.out.println("是星期四");
				break;
			} else {
				System.out.println("输入错误");
			}
		case 's':
		case 'S':
			System.out.println("仅由该字母无法判断出星期几，请输入第二个字母");
			letter = in.next();
			secondletter = letter.charAt(0);
			if (secondletter == 'a' || secondletter == 'A') {
				System.out.println("是星期六");
				break;
			} else if (secondletter == 'u' || secondletter == 'U') {
				System.out.println("是星期天");
				break;
			} else {
				System.out.println("输入错误");
			}
		}
	}

	/*
	 * 求100之内的素数
	 */
	@Test
	public void _25() {
		boolean flag;
		for (int i = 0; i < 100; i++) {
			flag = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println(i);
			}
		}
	}

	/*
	 * 对10个数进行排序
	 */
	@Test
	public void _26_1() {
		int[] array = new int[] { 12, 56, 778, 5, 15, 6, 9, 45, 5, 999 };
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	@Test
	public void _26_2() {
		int[] array = new int[] { 12, 56, 778, 5, 15, 6, 9, 45, 999, 5 };
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/*
	 * 求一个3*3矩阵对角线元素之和
	 */
	@Test
	public void _27() {
		Scanner in = new Scanner(System.in);

		// 输入数据
		int[][] mat = new int[3][3];
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.println("请输入第" + i + "行第" + j + "列的整数");
				mat[i - 1][j - 1] = in.nextInt();
			}
		}

		// 显示数据
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.printf("%d\t", mat[i][j]); // \t是制表符
			System.out.println();
		}

		// 计算对角线元素和
		// 从左上至右下的数归为主对角线，从左下至右上的数归为副对角线。
		int sum1 = mat[0][0] + mat[1][1] + mat[2][2];
		int sum2 = mat[2][0] + mat[1][1] + mat[0][2];
		System.out.println("主对角线上元素和为 " + sum1);
		System.out.println("副对角线上元素和为 " + sum2);
	}

	/*
	 * 有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中
	 */
	@Test
	public void _28() {
		int[] array = new int[] { 1, 3, 5, 7, 9, 11, 13, 15 };
		int[] newarray = new int[array.length + 1];
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		for (int i = 0; i < array.length; i++) {
			newarray[i + 1] = array[i];
		}
		// 将新数插入数组的最左边，然后开始进行比较
		newarray[0] = in;
		for (int i = 0; i < newarray.length - 1; i++) {
			if (newarray[i] > newarray[i + 1]) {
				newarray[i] = newarray[i] ^ newarray[i + 1];
				newarray[i + 1] = newarray[i] ^ newarray[i + 1];
				newarray[i] = newarray[i] ^ newarray[i + 1];
			} else {
				break;
			}
		}
		for (int i = 0; i < newarray.length; i++) {
			System.out.print(newarray[i] + " ");
		}
	}

	/*
	 * 将一个数组逆序输出
	 */
	@Test
	public void _29() {
		int[] ary = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		System.out.print("数组初始顺序为：");
		for (int i = 0; i < ary.length; i++)
			System.out.print(ary[i] + " ");
		System.out.println(); // 换行

		System.out.print("数组的逆序为：");
		for (int i = ary.length - 1; i >= 0; i--)
			System.out.print(ary[i] + " ");
		System.out.println();
	}

	/*
	 * 取一个整数a从右端开始的4～7位
	 */
	@Test
	public void _30() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一个大于等于 7 位的整数");
		long sum = in.nextLong();
		Long sum1 = new Long(sum);
		String sum2 = sum1.toString();
		System.out
				.println(sum2.substring(sum2.length() - 7, sum2.length() - 3));
	}

	/*
	 * 打印出杨辉三角形,要求打印出10行
	 */
	@Test
	public void _31() {
		int[][] arr = new int[10][];
		for (int i = 0; i < 10; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}

	}

	/*
	 * 输入3个数a,b,c，按大小顺序输出
	 */
	@Test
	public void _32() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i = 1; i <= 3; i++) {
			System.out.print("输入第" + i + "个数：");
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	/*
	 * 输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组
	 */
	@Test
	public void _33() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ");

		int max = 0, min = arr[0], m = 0, n = 0;// 临时数字以及此数字的脚标
		for (int i = 0; i < arr.length; i++) {
			if (max <= arr[i]) {
				max = arr[i];
				m = i;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (min >= arr[i]) {
				min = arr[i];
				n = i;
			}
		}
		// 交换
		// 将原来的第一个数替换到最大数的处
		arr[m] = arr[0];
		// 替换最大的数为第一个
		arr[0] = max;
		// 同理替换最小数
		arr[n] = arr[arr.length - 1];
		arr[arr.length - 1] = min;

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	/*
	 * 有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
	 */
	@Test
	public void _34() {
		int N = 10;
		int[] a = new int[N];
		Scanner s = new Scanner(System.in);
		System.out.println("请输入10个整数：");
		for (int i = 0; i < N; i++) {
			a[i] = s.nextInt();
		}
		System.out.print("你输入的数组为：");
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n请输入向后移动的位数：");
		int m = s.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = a[N - m + i];
		}
		for (int i = N - 1; i >= m; i--) { // 这里不能用i++的方法求，不然会出现重复
			a[i] = a[i - m];
		}
		for (int i = 0; i < m; i++) {
			a[i] = b[i];
		}

		for (int i : a) {
			System.out.print(i + " ");

		}
	}

	/*
	 * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位
	 */
	@Test
	public void _35() {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		boolean[] man = new boolean[total];
		for (int i = 0; i < man.length; i++) {
			man[i] = true;// TRUE表示此人没有退出圈子
		}
		int len = man.length;// 圈内人数
		int t = 0;// 目前数到几了
		while (len > 1) {
			for (int i = 0; i < man.length; i++) {
				if (man[i]) {
					t++;
					if (t == 3) {
						t = 0;
						man[i] = false;
						len--;
					}
				}
			}
		}
		System.out.println("最后的情况：" + Arrays.toString(man));
		for (int i = 0; i < man.length; i++) {
			if (man[i]) // 最后留下来的人没有被flase
			{
				System.out.println("原来剩下的数：" + (i + 1)); // i + 1 是因为数组从 0 开始
			}
		}
	}

	/*
	 * 字符串排序
	 */
	@Test
	public void _36() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] strchar = str.toCharArray();
		Arrays.sort(strchar);
		String newstr = new String(strchar);
		System.out.println(newstr);
	}

	/*
	 * 海滩上有一堆桃子，五只猴子来分。 第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
	 * 第二只猴子把剩下的桃子又平均分成五份,又多了一个，它同样把多的一个扔入海中，拿走了一份，
	 * 第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
	 * 
	 * 最少的情况，第五只猴子拿的时候至少6个桃子
	 */
	@Test
	public void _37() {
		int total = 6;
		double last = total;
		loop1: while (true) {
			last = total;
			for (int i = 0; i < 5; i++) {
				last = ((last - 1) / 5) * 4;
			}
			if (last % 1 != 0) {
				total++;
			} else {
				// total = (int) (last*5+1);
				break loop1;
			}
		}
		System.out.println(total);
	}

	/*
	 * 809*??=800*??+9*??
	 * 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果
	 * 
	 * 12
	 */
	@Test
	public void _38() {
		for (int i = 10; i < 100; i++) {
			if (809 * i == 800 * i + 9 * i && 8 * i > 10 && 8 * i < 100
					&& 9 * i > 100 && 9 * i < 1000) {
				System.out.println(i);
				break;
			}
		}
	}

	/*
	 * 一个偶数总能表示为两个素数之和
	 */
	@Test
	public void _39() {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入一个大于等于4偶数。");
		int num = in.nextInt();

		if (num < 4)
			System.out.println("输入错误！");
		if (num % 2 == 0) {
			int i, j;
			for (i = 2; i <= num / 2; i++) {
				if (isPrime(i)) {
					j = num - i;
					if (isPrime(j))
						System.out.println(num + " = " + i + " + " + j);
				}
			}
		}
	}

	public static boolean isPrime(int k) {
		for (int i = 2; i < Math.sqrt(k); i++) {
			if (k % i == 0)
				return false;
		}
		return true;
	}

	/*
	 * 读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊
	 */
	@Test
	public void _40() {
		for (int i = 0; i < 7; i++) {
			int num = (int) (Math.random() * 50) + 1;
			System.out.println(num);
			for (int j = 0; j < num; j++) {
				System.out.print("＊");
			}
			System.out.println("");
		}
	}

	/*
	 * 某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的， 加密规则如下： 每位数字都加上5,然后用和除以10的余数代替该数字，
	 * 再将第一位和第四位交换，第二位和第三位交换
	 */
	@Test
	public void _41() {
		System.out.println("输入加密前4位数字：");
		Scanner sc = null;
		int num;
		while (true) {
			sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				num = sc.nextInt();
				if (num >= 1000 && num < 10000) {
					break;
				} else {
					System.out.println("Number Error!Please input again:");
				}
			} else {
				System.out.println("Type Error!Please input again:");
			}
		}

		int g, s, b, q;
		g = num % 10;
		s = num / 10 % 10;
		b = num / 100 % 10;
		q = num / 1000;

		g = (g + 5) % 10;
		s = (s + 5) % 10;
		b = (b + 5) % 10;
		q = (q + 5) % 10;

		int newnum = g * 1000 + s * 100 + b * 10 + q;

		System.out.println(newnum);
	}

	/*
	 * 计算字符串中子串出现的次数
	 */
	@Test
	public void _42() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一个字符串");
		String sen = in.next();
		System.out.println("请输入要查找的子字符串");
		String str = in.next();

		Pattern p = Pattern.compile(str, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sen);
		int count = 0;
		while (m.find()) {
			count++;
		}
		System.out.println(str + "在" + sen + "出现的次数为" + count);
	}

	/*
	 * 有2个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），计算出平均成绩，况原有的数据和计算出的平均分数存放在磁盘文件
	 * "stud "中。
	 */
	@Test
	public void _43(){
		int stunum = 2;//学生数量
		String[][] stu = new String[stunum][6];  // [0]放平均成绩[1-3]放三门课成绩[4]放学号[5]放姓名
		Scanner sc = null;
		float sum;
		for (int i = 1; i <= stunum; i++) {
			sum = 0f;
			sc = new Scanner(System.in);
			System.out.print("输入第"+i+"个学生的学号：");
			stu[i-1][4] = sc.next();
			System.out.print("输入第"+i+"个学生的姓名：");
			stu[i-1][5] = sc.next();
			for (int j = 1; j <=3; j++) {
				//sum = 0f;
				System.out.print("输入"+stu[i-1][5]+"的第"+j+"门课成绩:");
				stu[i-1][j] = sc.nextFloat()+"";
				sum +=  Float.parseFloat(stu[i-1][j]);
				System.out.println(sum);
			}
			stu[i-1][0] = sum/3+"";
		}
		
		/*for (String[] strings : stu) {
			for (String string : strings) {
				System.out.print(string+" ");
			}
			System.out.println("");
		}*/
		
		try {
			File f = new File("C:/Users/Administrator/Desktop/stu.txt");
			if (f.exists()) {
				System.err.println("目标文件已经存在！将被覆盖！");
				f.delete();
				f.createNewFile();
			}else{
				f.createNewFile();
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write("姓名"+"\t"+"学号"+"\t"+"成绩1"+"\t"+"成绩2"+"\t"+"成绩3"+"\t"+"平均分"+"\r\n");
			for (int i = 0; i < 2; i++) {
				bw.write(stu[i][5]+"\t"+stu[i][4]+"\t"+stu[i][1]+"\t"+stu[i][2]+"\t"+stu[i][3]+"\t"+stu[i][0]+"\r\n");
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			System.err.println("错误~");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
