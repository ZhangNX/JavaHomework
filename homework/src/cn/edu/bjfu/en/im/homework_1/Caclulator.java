package cn.edu.bjfu.en.im.homework_1;

public class Caclulator {
	int temp;
	Caclulator(){
		temp=0;
	}
	public  int add(int addNum){
		return temp+=addNum;
	}
	public  int sub(int subNum){
		return temp-=subNum;
	}
	public  int clear(){
		return temp=0;
	}
}
