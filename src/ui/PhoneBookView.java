package ui;

import config.Config;
import data.Contact;
import data.PhoneBook;
import de.ur.mi.oop.graphics.Label;

import java.util.ArrayList;

public class PhoneBookView {

    private ArrayList<ContactView> contactViews;
    private Label titleLabel;
    private final int xPos;
    private final int yPos;
    private final int width;

    public PhoneBookView(int x, int y, int width) {
        xPos = x;
        yPos = y;
        this.width = width;
        initLabel();
    }

    private void initLabel() {
        titleLabel = new Label(0, 0, "Contacts");
        titleLabel.setFontSize(48);
        titleLabel.setColor(Config.PHONEBOOK_FONT_COLOR);
        titleLabel.setPosition(xPos + Config.PHONEBOOK_ENTRY_MARGIN, yPos + titleLabel.getHeightEstimate());
    }

    public void setEntries(PhoneBook book) {
        ArrayList<Contact> contacts = book.getContacts();
        contactViews = new ArrayList<ContactView>();
        for (int i = 0; i < contacts.size(); i++) {
            ContactView view = createViewForContact(contacts.get(i), i);
            view.hideAdditionalInformation();
            contactViews.add(view);
        }
    }

    public void draw() {
        titleLabel.draw();
        if (contactViews == null) {
            return;
        }
        for (ContactView view : contactViews) {
            view.getView().draw();
        }
    }

    private ContactView createViewForContact(Contact contact, int position) {
        float y = yPos + titleLabel.getHeightEstimate() + 2 * Config.PHONEBOOK_ENTRY_MARGIN + ((Config.PHONEBOOK_ENTRY_HEIGHT + Config.PHONEBOOK_ENTRY_MARGIN) * position);
        return new ContactView(xPos, y, width, Config.PHONEBOOK_ENTRY_HEIGHT, contact);
    }

    public void onClick(int x, int y) {
        for (ContactView contactView : contactViews) {
            if (contactView.getView().hitTest(x, y)) {
                contactView.showAdditionalInformation();
            } else {
                contactView.hideAdditionalInformation();
            }
        }
    }
}