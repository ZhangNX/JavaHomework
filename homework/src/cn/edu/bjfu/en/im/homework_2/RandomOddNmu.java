package cn.edu.bjfu.en.im.homework_2;

import java.util.Arrays;
import java.util.Random;

public class RandomOddNmu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random aRandom = new Random();
		int[] arr = new int[100];
		for (int i = 0; i < 100; ) {
			int temp = aRandom.nextInt(101);
			if (temp % 2 == 1) {
				arr[i] = temp;
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
