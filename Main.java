
package bookshelf;

import bookshelf.bookstore.Book;
/**
 *
 * @author lenovo
 */
public class Main {
    public static void main(String[] args){
        BookShelf my_bsf = BookShelf.getInstance();
        for(int i = 0; i < 5; i++){
            Book b = Genertor.createBook();
            my_bsf.addBook(b);
        }
        my_bsf.printContent();
    }
}
