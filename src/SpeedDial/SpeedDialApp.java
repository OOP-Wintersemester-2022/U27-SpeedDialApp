package SpeedDial;

import config.Config;
import data.PhoneBook;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.*;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import ui.PhoneBookView;

import java.io.File;
import java.io.FileNotFoundException;

public class SpeedDialApp extends GraphicsApp implements GraphicsAppMouseListener, Config {

    private PhoneBook phoneBook;
    private PhoneBookView phoneBookView;

    public void initialize() {
        initPhoneBook();
        initApplication();
        initComponents();
    }

    private void initPhoneBook() {
        File contacts = new File(FILE_PATH);
        try {
            phoneBook = PhoneBook.createFromFile(contacts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initApplication() {
        setCanvasSize(APP_WIDTH, APP_HEIGHT);
    }

    private void initComponents() {
        phoneBookView = new PhoneBookView(0, PHONEBOOK_ENTRY_MARGIN, APP_WIDTH, phoneBook);
    }

    @Override
    public void draw() {
        drawBackground(APP_BACKGROUND_COLOR);
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