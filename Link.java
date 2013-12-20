package gutenbergcatalogproject;

public class Link {

    public String Author;        // data item (key)
    public String Title;      // data item
    public String No;
    public Link next;        // next link in list
    public String Properties;
// -------------------------------------------------------------

    public Link(String Author, String Title, String No, String Properties) {    // constructor
        this.Author = Author;        // initialize data
        this.Title = Title;
        this.No = No;
        this.Properties = Properties;
// ("next" is automatically
// set to null)
    }
// -------------------------------------------------------------
}               // end class Link
