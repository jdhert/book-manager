package library;

import java.util.ArrayList;

// BookManager를 구현하는 구현 객체
public class BM extends BookManager {

    private ArrayList<Book> bookList = new ArrayList<>();
    private static int m;
    @Override
    public void addBook(Book book) {
        boolean check = true;
        for(int i=0; i<bookList.size(); i++) {
            if (book.getId() == bookList.get(i).getId())
                check = false;
        }
        if (check == false)
            System.out.println("ID값이 이미 존재합니다. ");
        else {
            bookList.add(book);
            System.out.println("--- 도서 [" + book.getName() + "] 등록이 완료되었습니다. ---");
        }
    }

    @Override
    public void printAllBook() {
        for (Book book : bookList) {
            System.out.print(book.getId());
            System.out.print(" ");
            System.out.print(book.getName());
            System.out.print(" ");
            System.out.print(book.getAuthor());
            System.out.print(" ");
            System.out.print(book.getIsbn());
            System.out.print(" ");
            System.out.print(book.getPublishedDate());
            System.out.println();
        }
    }
    public boolean printBook(long id){
        boolean check = false;
        for(int i=0; i< bookList.size();i++) {
            if (id == bookList.get(i).getId()) {
                m = i;
                System.out.print(bookList.get(i).getId());
                System.out.print(" / ");
                System.out.print(bookList.get(i).getName());
                System.out.print(" / ");
                System.out.print(bookList.get(i).getAuthor());
                System.out.print(" / ");
                System.out.print(bookList.get(i).getIsbn());
                System.out.print(" / ");
                System.out.print(bookList.get(i).getPublishedDate());
                System.out.println();
                check = true;
            }
        }  if(check == false) {
            System.out.println("해당 도서가 존재하지 않습니다!!! ");
            return check;
        } else return check;
    }

    @Override
    public void updateBook(Book book) {
        bookList.set(m, book);
        System.out.println("수정이 완료되었습니다.");
    }


    @Override
    public void removeBook(long id) {
        boolean check = true;
        for(int i=0; i< bookList.size();i++) {
            if (id == bookList.get(i).getId()) {
                bookList.remove(i);
                System.out.println("삭제가 완료되었습니다.");
                check = false;
            }
        }
        if(check)
            System.out.println("해당 도서가 존재하지 않습니다.");
    }
}
