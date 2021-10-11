package SpeedDial;

import config.Config;
import data.PhoneBook;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.GraphicsAppMouseListener;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import ui.PhoneBookView;

import java.io.File;
import java.io.FileNotFoundException;

public class SpeedDialApp extends GraphicsApp implements GraphicsAppMouseListener {

    private PhoneBook phoneBook;
    private PhoneBookView phoneBookView;

    public void initialize() {
        initPhoneBook();
        initApplication();
        initComponents();
    }

    private void initPhoneBook() {
        File contacts = new File(Config.FILE_PATH);
        try {
            phoneBook = PhoneBook.createFromFile(contacts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initApplication() {
        setCanvasSize(Config.APP_WIDTH, Config.APP_HEIGHT);
    }

    private void initComponents() {
        phoneBookView = new PhoneBookView(0, Config.PHONEBOOK_ENTRY_MARGIN, Config.APP_WIDTH);
        phoneBookView.setEntries(phoneBook);
    }

    @Override
    public void draw() {
        drawBackground(Config.APP_BACKGROUND_COLOR);
        phoneBookView.draw();
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        phoneBookView.onClick(event.getXPos(), event.getYPos());
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}