package cn.edu.bjfu.en.im;

import java.util.List;
import java.util.ArrayList;

import cn.edu.bjfu.en.im.BookOV;

public class BookSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BookOV> bookArr = new ArrayList<BookOV>();
		bookArr.add(new BookOV("���÷�����", 20));
		bookArr.add(new BookOV("����ͳ��", 30));
		bookArr.add(new BookOV("ͳ��ѧԭ��", 20));
		BookOV c = bookArr.get(1);
		System.out.println(c.toString());
		bookArr.remove(1);
		BookOV z = bookArr.get(1);
		System.out.println(z.toString());
	}

}