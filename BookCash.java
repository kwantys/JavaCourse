package bookshelf.bookstore;

import java.util.HashMap;
import java.util.Map;

public class BookCash {
    private static Map<Integer, Book> bookMap = new HashMap <Integer,Book>();
    
    public static Book getBook(int id){
        Book toBeCloneBook = bookMap.get(id);
        return (Book) toBeCloneBook.clone();
    }
    
    public static void loadCache(){
        FantasyBook fb1 = new FantasyBook();
        bookMap.put(1, fb1);
        
        ComicBook cb1 = new ComicBook();
        cb1.setColor(true);
        bookMap.put(2, cb1);
        
        ComicBook cb2 = new ComicBook();
        bookMap.put(3, cb2);
    }
}
