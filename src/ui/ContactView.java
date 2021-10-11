package ui;

import config.Config;
import data.Contact;
import de.ur.mi.oop.graphics.Compound;
import de.ur.mi.oop.graphics.Image;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

import java.util.ArrayList;

public class ContactView {

    private final Compound view;
    private final ArrayList<Label> labelsWithAdditionalInformation;

    ContactView(float x, float y, float width, float height, Contact contact) {
        view = new Compound(x, y);
        view.setWidth(width);
        view.setHeight(height);
        // Add solid rectangle as background for contact view
        Rectangle entryBackground = new Rectangle(0, 0, width, Config.PHONEBOOK_ENTRY_HEIGHT, Config.PHONEBOOK_ENTRY_BACKGROUND_COLOR);
        view.addRelative(entryBackground);
        // Add contact image at left side of contact view
        Image image = new Image(0, 0, contact.imagePath);
        image.setWidth(height, true);
        image.setHeight(height, true);
        view.addRelative(image);
        // Create name label in contact view
        Label nameLabel = new Label(0, 0, contact.name);
        nameLabel.setColor(Config.PHONEBOOK_FONT_COLOR);
        nameLabel.setFontSize(Config.NAME_LABEL_FONT_SIZE);
        nameLabel.setPosition(height + Config.PHONEBOOK_ENTRY_MARGIN, nameLabel.getHeightEstimate());
        view.addRelative(nameLabel);
        // Create address label in Contact View
        Label addressLabel = new Label(0, 0, contact.address + ", " + contact.zipCode);
        addressLabel.setColor(Config.PHONEBOOK_FONT_COLOR);
        addressLabel.setFontSize(Config.INFORMATION_LABEL_FONT_SIZE);
        /*
         * Position address label at bottom of name label, using nameLabel's height instead of y position,
         * since the first label is not yet rendered, and it's position might be off.
         */
        addressLabel.setPosition(nameLabel.getXPos(), nameLabel.getHeightEstimate() + addressLabel.getHeightEstimate());
        view.addRelative(addressLabel);

        // Create phone number label in Contact View
        Label phoneNumberLabel = new Label(0, 0, "Phone: " + contact.phoneNumber);
        phoneNumberLabel.setColor(Config.PHONEBOOK_FONT_COLOR);
        phoneNumberLabel.setFontSize(Config.INFORMATION_LABEL_FONT_SIZE);
        /*
         * Position phone number label at bottom of number label, using previous labels heights instead of y position,
         * since the other labels are not yet rendered, and their position might be off.
         */
        phoneNumberLabel.setPosition(nameLabel.getXPos(), nameLabel.getHeightEstimate() + addressLabel.getHeightEstimate() + phoneNumberLabel.getHeightEstimate());
        view.addRelative(phoneNumberLabel);
        // Save references to certain labels for easy access when showing/hidding additional information
        labelsWithAdditionalInformation = new ArrayList<Label>();
        labelsWithAdditionalInformation.add(addressLabel);
        labelsWithAdditionalInformation.add(phoneNumberLabel);
    }

    public Compound getView() {
        return this.view;
    }

    public void hideAdditionalInformation() {
        for (Label label : labelsWithAdditionalInformation) {
            label.setColor(Config.PHONEBOOK_ENTRY_BACKGROUND_COLOR);
        }
    }

    public void showAdditionalInformation() {
        for (Label label : labelsWithAdditionalInformation) {
            label.setColor(Config.PHONEBOOK_FONT_COLOR);
            label.setColor(Config.PHONEBOOK_FONT_COLOR);
        }
    }
}