package cn.edu.bjfu.en.im.homework_2;

public class BookVO {
	String bookName;
	int bookPrice;

	BookVO(String thisBookName, int thisBookPrice) {
		bookName = thisBookName;
		bookPrice = thisBookPrice;
	}

	@Override
	public String toString() {
		return "BookOV [bookName=" + bookName + ", bookPrice=" + bookPrice
				+ "]";
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

}