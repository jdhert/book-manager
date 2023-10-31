package library;

import java.util.ArrayList;

// BookManager를 구현하는 구현 객체
public class BM extends BookManager {

    private ArrayList<Book> bookList = new ArrayList<>();

    @Override
    public void addBook(Book book) {
            bookList.add(book);
            System.out.println("--- 도서 [" + book.getName() + "] 등록이 완료되었습니다. ---");
    }
    public  boolean idCheck(long id){
        for (Book b: bookList){
            if(b.getId() == id)
                return false;
        } return true;
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
    public boolean checkBook(long id){

        for (Book b: bookList){
            if(b.getId() == id) {
                return true;
            }
        }
        System.out.println("해당 도서가 존재하지 않습니다!!! ");
        return false;

    }

    @Override
    public void updateBook(Book book) {
        for (Book b: bookList){
            if(book.getId().equals(b.getId())) {
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
                b.setIsbn(book.getIsbn());
                b.setPublishedDate(book.getPublishedDate());
            }
        }
        System.out.println("수정이 완료되었습니다.");

    }

    @Override
    public void removeBook(long id) {
        boolean check = true;
        for (Book b: bookList) {
            if (id == b.getId()) {
                bookList.remove(b);
                System.out.println("삭제가 완료되었습니다.");
                check = false;
                break;
            }
        }
        if(check)
            System.out.println("해당 도서가 존재하지 않습니다.");
    }
}
