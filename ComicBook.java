package bookshelf.bookstore;

/**
 *
 * @author lenovo
 */
public class ComicBook extends Book {
    private boolean color;
    ComicBook(){
        this.genre = "Comic book";
    }
    
    public void setColor(boolean color){
        this.color = color;
    }
    
    @Override
    public void printContent(){
        System.out.println(this.ISBN+": color print [ "+this.color+"], "+this.getGenre()+","+this.getPages()+"pp.");
    }
}
