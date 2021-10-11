package config;
import de.ur.mi.oop.colors.Color;

public interface Config {

    /** App **/
    public static final int APP_WIDTH = 500;
    public static final int APP_HEIGHT = 900;
    public static final Color APP_BACKGROUND_COLOR = new Color(255,255,255);
    public static final Color APP_RESET_COLOR = new Color(0,0,0,0);

    /** Data **/
    public static final String FILE_PATH = "data/contacts.csv";

    /** List **/
    public static final Color PHONEBOOK_ENTRY_BACKGROUND_COLOR = new Color(53,146,196);
    public static final Color PHONEBOOK_FONT_COLOR = new Color(250, 250, 250, 255);
    public static final int PHONEBOOK_ENTRY_HEIGHT = 90;
    public static final int PHONEBOOK_ENTRY_MARGIN = 5;

}