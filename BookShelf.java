package bookshelf;

import bookshelf.bookstore.Book;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author lenovo
 */
public class BookShelf {
    private static BookShelf instance;
    private List<Book> storage;
    
    private BookShelf(){
        this.storage = new LinkedList<Book>();
    }
    
    public static BookShelf getInstance(){
        if(instance == null){
            instance = new BookShelf();
        }
        return instance;
    }
    
    public void addBook(Book b){
        storage.add(b);
    }
    
    public void printContent(){
        System.out.println("On my shelf");
        for(Book b:storage){
            b.printContent();
        }
    }
}
