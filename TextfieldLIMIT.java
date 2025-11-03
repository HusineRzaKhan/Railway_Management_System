package RaliwayManagementSystem;

import javax.swing.text.*;

//Class for setting the limits of characters in textfields
public class TextfieldLIMIT extends PlainDocument{
    private int limit;

    TextfieldLIMIT(int limit) {
        super();
        this.limit = limit;
    }
}