package library;

import java.util.ArrayList;

// BookManager를 구현하는 구현 객체
public class BM extends BookManager {

    private ArrayList<Book> bookList = new ArrayList<>();
    private static int m;
    @Override
    public void addBook(Book book) {
        bookList.add(book);
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
    public void printBook(long id){
        for(int i=0; i< bookList.size();i++) {
            if (id == bookList.get(i).getId()) {
                m = i;
                System.out.print(bookList.get(i).getId());
                System.out.print(" ");
                System.out.print(bookList.get(i).getName());
                System.out.print(" ");
                System.out.print(bookList.get(i).getAuthor());
                System.out.print(" ");
                System.out.print(bookList.get(i).getIsbn());
                System.out.print(" ");
                System.out.print(bookList.get(i).getPublishedDate());
                System.out.println();
            }
        }
    }

    @Override
    public void updateBook(Book book) {
        bookList.set(m, book);
        System.out.println("수정이 완료되었습니다.");
    }
    public void checkBook(long id){
        int i;
        for(i=0; i< bookList.size();i++) {
            if (id == bookList.get(i).getId()) {
                bookList.remove(i);
                System.out.println("삭제가 완료되었습니다.");
                break;
            }
        }
        if(i >= bookList.size())
            System.out.println("해당 도서가 존재하지 않습니다.");
    }

    @Override
    public void removeBook(Book book) {
//        bookList.remove(book);
//        if()
    }
}
