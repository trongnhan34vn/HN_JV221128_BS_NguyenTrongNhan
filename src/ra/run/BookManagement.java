package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Book> listBooks = new ArrayList<>();
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách\n" +
                    "2. Hiển thị thông tin các sách\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần\n" +
                    "4. Xóa sách theo mã sách\n" +
                    "5. Tìm kiếm sách theo tên sách\n" +
                    "6. Thay đổi trạng thái của sách theo mã sách\n" +
                    "7. Thoát");

            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    Thêm mới n sách
                    createBooks(listBooks);
                    break;
                case 2:
//                    Hiển thị danh sách
                    displayListBooks(listBooks);
                    break;
                case 3:
//                    Sắp xếp danh sách
                    sortByInterest(listBooks);
                    break;
                case 4:
//                    Delete
                    deleteById(listBooks);
                    break;
                case 5:
//                    Tìm kiếm sách
                    findByName(listBooks);
                    break;
                case 6:
//                    Thay đổi trạng thái sách
                    changeBookStatus(listBooks);
                    break;
                case 7:
                    System.out.println("Kết thúc!");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void createBooks(List<Book> listBooks) {
        System.out.println("Nhập vào số lượng sách: ");
        int mountNewBooks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < mountNewBooks; i++) {
            System.out.println("Nhập vào thông tin sách thứ " + (i + 1));
            Book newBook = new Book();
            newBook.inputData();
            if (listBooks.isEmpty()) {
                newBook.setBookId(1);
            } else {
                newBook.setBookId(listBooks.get(listBooks.size() - 1).getBookId() + 1);
            }
            listBooks.add(newBook);
        }
        System.out.println("Thêm mới " + mountNewBooks + " quyển sách thành công!");
        displayListBooks(listBooks);
    }

    public static void displayListBooks(List<Book> listBooks) {
        System.out.println("Danh sách sách đang lưu trữ: ");
        for (Book book : listBooks) {
            book.displayData();
        }
    }

    public static void sortByInterest(List<Book> listBooks) {
        Collections.sort(listBooks);
        System.out.println("Sắp xếp thành công!");
    }

    public static void deleteById(List<Book> listBooks) {
        displayListBooks(listBooks);
        while (true) {
            System.out.println("Nhập vào mã sách cần xoá: ");
            int idDel = Integer.parseInt(scanner.nextLine());
            Book selectBook = findById(idDel, listBooks);
            if (selectBook != null) {
                listBooks.remove(selectBook);
                System.out.println("Xoá sách thành công!");
                return;
            } else {
                System.out.println("Không tìm thấy sách! Vui lòng nhập lại!");
            }
        }
    }

    public static Book findById(int id, List<Book> listBooks) {
        boolean isExist = false;
        for (Book book : listBooks) {
            if (book.getBookId() == id) {
                isExist = true;
                return book;
            }
        }
        return null;
    }

    public static void findByName(List<Book> listBooks) {
        displayListBooks(listBooks);
        while (true) {
            System.out.println("Nhập tên sách cần tìm kiếm: ");
            String searchBookName = scanner.nextLine();
            boolean isExist = false;
            List<Book> searchBook = new ArrayList<>(listBooks);
            for (Book book : listBooks) {
                if (book.getBookName().equalsIgnoreCase(searchBookName)) {
                    isExist = true;
//                    searchBook = book;
                    break;
                }
            }
            if (isExist) {
                searchBook.removeIf(book -> !book.getBookName().equalsIgnoreCase(searchBookName));
                displayListBooks(searchBook);
                return;
            } else {
                System.out.println("Không tìm thấy sách! Vui lòng nhập lại!");
            }
        }
    }

    public static void changeBookStatus(List<Book> listBooks) {
        displayListBooks(listBooks);
        while (true) {
            System.out.println("Nhập mã sách thay đổi trạng thái: ");
            int changeId = Integer.parseInt(scanner.nextLine());
            Book selectBook = findById(changeId, listBooks);
            if (selectBook != null) {
                selectBook.setBookStatus(!selectBook.isBookStatus());
                System.out.println("Chuyển trạng thái thành công!");
                return;
            } else {
                System.out.println("Không tìm thấy sách! Vui lòng nhập lại!");
            }
        }
    }
}
