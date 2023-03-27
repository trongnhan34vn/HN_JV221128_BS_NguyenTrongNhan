package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook,Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    Scanner scanner = new Scanner(System.in);

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Book() {
    }

    @Override
    public void inputData() {
        System.out.println("Nhập tên sách: ");
        bookName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sách: ");
        title = scanner.nextLine();
        System.out.println("Nhập số trang sách: ");
        numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá sách nhập vào: ");
        importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá bán sách: ");
        exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái sách: ");
        bookStatus = Boolean.parseBoolean(scanner.nextLine());
        interest = exportPrice - importPrice;
    }

    @Override
    public void displayData() {
        System.out.println("---------------------------------------");
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tiêu đề sách: " + title);
        System.out.println("Số trang: " + numberOfPages);
        System.out.println("Giá nhập sách: " + importPrice);
        System.out.println("Giá bán sách: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Trạng thái: " + ((bookStatus) ? "còn sách" : "hết sách"));
        System.out.println("---------------------------------------");
    }

    @Override
    public int compareTo(Book o) {
        return (int) (o.interest - interest);
    }
}
