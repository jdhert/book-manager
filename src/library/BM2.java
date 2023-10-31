package library;

import java.net.Inet4Address;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BM2 extends BookManager{

    private static ArrayList<Book> bookList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);



    @Override
    void init() {
        bookList.add(new Book(1L, "돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331796"),
                LocalDate.parse("2020-06-15")));
        bookList.add(new EBook(2L,"K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-02-20"),
                "300MB"));
        bookList.add(new AudioBook(3L, "위기의 역사", "오건영", Long.parseLong("9791169850360"), LocalDate.parse("2023-07-19"),
                "562MB", "한국어", 120));
    }

    @Override
    void interactWithUser() {

            while (true) {
                System.out.println("■■■■■■ 도서 관리 프로그램 ■■■■■■");
                System.out.println("(1) 도서 조회");
                System.out.println("(2) 도서 등록");
                System.out.println("(3) 도서 수정");
                System.out.println("(4) 도서 삭제");
                System.out.println("(q) 프로그램 종료");
                System.out.print("선택 >> ");
                String userInput = sc.nextLine();

                switch (userInput) {
                    case "1":
                        // 조회
                        printAllBook();
                        break;
                    case "2":
                        // 등록
                        addBook();
                        break;
                    case "3":
                        // 수정
                        updateBook();
                        break;
                    case "4":
                        // 삭제
                        removeBook();
                        break;
                    case "q":
                        // 메소드를 종료
                        System.out.println("프로그램 종료!");
                        return;
                    default:
                        System.out.println("보기에 나와있는 것을 입력하세요!!! :( ");
                        break;
                }

            }
    }

    @Override
    public void printAllBook() {
        System.out.println("■■■■■■■■ 도서 목록 조회 ■■■■■■■■");
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
            if(book instanceof EBook) {
                System.out.print(" ");
                System.out.print(((EBook) book).getFileSize());
            } else if (book instanceof  AudioBook) {
                System.out.print(" ");
                System.out.print(((AudioBook) book).getFileSize());
                System.out.print(" ");
                System.out.print(((AudioBook) book).getLanguage());
                System.out.print(" ");
                System.out.print(((AudioBook) book).getPlayTime());
            }
            System.out.println();
        }
    }

    public void addBook() {
        System.out.println("■■■■■■■■■■■ 도서 등록 ■■■■■■■■■■■");
        // 1. 콘솔화면을 통해 사용자로부터 도서정보를 입력을 받는다.
        // id, 제목, 저자, isbn, 출판일 (5가지) (v)
        // 위의 정보로 책 객체를 생성한다. (v)
        // 2. 도서를 등록한다.
        // 사서를 통해 도서 저장 요청
        String file = "";
        String language = "";
        String time = "";
        System.out.println("어떤 책을 등록하시겠습니까? 1. Book 2. EBook 3. AudioBook");
        String form = sc.nextLine();
        int f = Integer.parseInt(form);
        if(f >= 4) {
            System.out.println("잘못된 숫자 입력하였습니다!!! :( ");
            return;
        }
        System.out.print("(1) 도서번호를 입력해주세요.(유일한 번호) >> ");
        String id = sc.nextLine();
        if(idCheck(Long.parseLong(id))) {
            System.out.print("(2) 도서명을 입력해주세요. >> ");
            String name = sc.nextLine();
            System.out.print("(3) 저자명을 입력해주세요. >> ");
            String author = sc.nextLine();
            System.out.print("(4) isbn을 입력해주세요. >> ");
            String isbn = sc.nextLine();
            System.out.print("(5) 출간일을 입력해주세요.(YYYY-MM-DD형식) >> ");
            String publishDate = sc.nextLine();
            if(f >= 2) {
                System.out.print("(6) 파일 사이즈를 입력해주세요. >> ");
                file = sc.nextLine();
                if(f >= 3) {
                    System.out.print("(7) 언어를 입력해주세요. >> ");
                    language = sc.nextLine();
                    System.out.print("(8) 오디오북 길이를 입력해주세요.(숫자) >> ");
                    time = sc.nextLine();
                }
            }
            // id, isbn는 String 타입이므로 Long으로 변환 후 매개값을 주어야한다.
            // publishedDate는 String 타입인데 LocalDate 타입으로 변환해주어야 한다. ==> "구글링"
            switch (f) {
                case 1:
                    Book book1 = new Book(Long.parseLong(id),
                            name,
                            author,
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate));
                    bookList.add(book1);
                    System.out.println("--- 도서 [" + book1.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                case 2:
                    Book book2 = new EBook(Long.parseLong(id),
                            name,
                            author,
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate), file);
                    bookList.add(book2);
                    System.out.println("--- 도서 [" + book2.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                case 3:
                    Book book3 = new AudioBook(Long.parseLong(id),
                            name,
                            author,
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate), file, language, Integer.parseInt(time));
                    bookList.add(book3);
                    System.out.println("--- 도서 [" + book3.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                default:
                    break;
            }

        } else System.out.println("ID값이 이미 존재합니다. ");
    }

    @Override
    public void updateBook() {
        System.out.println("수정 메서드 실행");
        System.out.print("수정하고자 하는 도서번호를 입력하세요: ");
        long id = Long.parseLong(sc.nextLine());
        int m = checkBook(id);
        if (m >= 0) {
            String fileSize = "";
            String language = "";
            String time = "";
            System.out.println("[수정 정보를 입력해주세요]");
            System.out.print("제목: ");
            String name = sc.nextLine();
            System.out.print("저자: ");
            String author = sc.nextLine();
            System.out.print("isbn: ");
            String isbn = sc.nextLine();
            System.out.print("출판일(YYYY-MM-DD): ");
            String publishDate = sc.nextLine();
            if (m >= 2) {
                System.out.print("파일사이즈: ");
                fileSize = sc.nextLine();
            }
            if (m >= 3) {
                System.out.print("언어: ");
                language = sc.nextLine();
                System.out.print("재생시간(숫자): ");
                time = sc.nextLine();
            }
            switch (m) {
                case 1:
                    Book book = new Book(id,
                            name,
                            author,
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate));
                    for (Book b : bookList) {
                        if (book.getId().equals(b.getId())) {
                            b.setName(book.getName());
                            b.setAuthor(book.getAuthor());
                            b.setIsbn(book.getIsbn());
                            b.setPublishedDate(book.getPublishedDate());
                        }
                    }
                    break;
                case 2:
                    Book book2 = new EBook(id,
                            name,
                            author,
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate), fileSize);
                    for (Book b : bookList) {
                        if (book2.getId().equals(b.getId())) {
                            b.setName(book2.getName());
                            b.setAuthor(book2.getAuthor());
                            b.setIsbn(book2.getIsbn());
                            b.setPublishedDate(book2.getPublishedDate());
                            ((EBook) b).setFileSize(fileSize);
                        }
                    }
                    break;
                case 3:
                    Book book3 = new AudioBook(id,
                            name,
                            author,
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate), fileSize, language, Integer.parseInt(time));
                    for (Book b : bookList) {
                        if (book3.getId().equals(b.getId())) {
                            b.setName(book3.getName());
                            b.setAuthor(book3.getAuthor());
                            b.setIsbn(book3.getIsbn());
                            b.setPublishedDate(book3.getPublishedDate());
                            ((AudioBook) b).setFileSize(fileSize);
                            ((AudioBook) b).setLanguage(language);
                            ((AudioBook) b).setPlayTime(Integer.parseInt(time));
                        }
                    }
                    break;
                default:
                    break;

            }
        }

//            for (Book b: bookList){
//                if(book.getId().equals(b.getId())) {
//                    b.setName(book.getName());
//                    b.setAuthor(book.getAuthor());
//                    b.setIsbn(book.getIsbn());
//                    b.setPublishedDate(book.getPublishedDate());
//                }

        System.out.println("수정이 완료되었습니다.");
    }


    public void removeBook() {
        boolean check = true;
        System.out.println("■■■■■■■■■■■ 도서 삭제 ■■■■■■■■■■■");
        System.out.println("삭제하고자 하는 도서의 도서번호를 입력하세요.");
        System.out.print("선택 >> ");
        long id = Long.parseLong(sc.nextLine());
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


    public int checkBook(long id){

        for (Book b: bookList){
            if(b.getId() == id) {
                if(b instanceof  EBook)
                    return 2;
                else if (b instanceof  AudioBook) {
                    return 3;
                }
                return 1;
            }
        }
        System.out.println("해당 도서가 존재하지 않습니다!!! ");
        return -1;

    }


    public boolean idCheck(long id){
        for (Book b: bookList){
            if(b.getId() == id)
                return false;
        } return true;


        }


}

