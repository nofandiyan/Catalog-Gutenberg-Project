package gutenbergcatalogproject;

public class LinkList {

    public Link first;       // ref to first link on list
// -------------------------------------------------------------

    public LinkList() {        // constructor
        first = null;
// no items on list yet
    }
// -------------------------------------------------------------

    public boolean isEmpty() {      // true if list is empty
        return (first == null);
    }
// -------------------------------------------------------------// insert at start of list

    public void insertFirst(String Author, String Title, String No, String Properties) {
        Link newLink = new Link(Author, Title, No, Properties);  // make new link
        newLink.next = first;    // newLink --> old first
        first = newLink;      // first --> newLink
    }
// -------------------------------------------------------------

    public Link deleteFirst() {      // delete first item
// (assumes list not empty)
        Link temp = first;      // save reference to link
        first = first.next;     // delete it: first-->old next
        return temp;        // return deleted link
    }
// -------------------------------------------------------------

    public String displayLink(Link current) {      // display ourself

        String returnVal = "Author  : " + current.Author + "---";
        returnVal += "Title      : " + current.Title + "---";
        returnVal += "No        : " + current.No + "---";
        if(!current.Properties.equals("")){
            returnVal += "Properties : ---" + current.Properties + "---";
        }

        return returnVal;
    }
// -------------------------------------------------------------}               // end class LinkList
}
