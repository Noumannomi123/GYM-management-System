package utils;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
public class NoSpaceDocumentFilter extends DocumentFilter {

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        if (!containsSpace(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        if (!containsSpace(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean containsSpace(String text) {
        return text != null && text.contains(" ");
    }
}
