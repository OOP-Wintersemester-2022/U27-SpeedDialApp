package ui;

import config.Config;
import data.Entry;
import de.ur.mi.oop.graphics.Compound;
import de.ur.mi.oop.graphics.Image;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class EntryView implements Config {

    private Compound view;
    private float labelXPos;
    private float nameLabelYPos;
    private float numberLabelYPos;

    EntryView(float x, float y, float width, float height, Entry entry) {
        view = new Compound(x, y);
        view.setWidth(width);
        view.setHeight(height);

        Rectangle entryBackground = new Rectangle(x, y, (int) width, PHONEBOOK_ENTRY_HEIGHT, PHONEBOOK_ENTRY_BACKGROUND_COLOR);
        entryBackground.setBorderWeight(0);
        view.add(entryBackground);

        Image image = new Image(x, y, entry.getImagePath());
        image.setWidth(height);
        image.setHeight(height);
        view.add(image);

        labelXPos = image.getXPos() + image.getWidth() + PHONEBOOK_ENTRY_MARGIN + (PHONEBOOK_ENTRY_HEIGHT / 5);
        System.out.println(view.getYPos());
        nameLabelYPos = image.getYPos() + (PHONEBOOK_ENTRY_HEIGHT / 3);
        System.out.println(nameLabelYPos);
        numberLabelYPos = (float) (view.getYPos() + (PHONEBOOK_ENTRY_HEIGHT / 1.4));

        Label nameLabel = new Label(labelXPos, nameLabelYPos, entry.getName());
        nameLabel.setColor(APP_RESET_COLOR);
        nameLabel.setFontSize(PHONEBOOK_ENTRY_HEIGHT / 4);
        view.add(nameLabel);

        Label numberLabel = new Label(labelXPos, numberLabelYPos, entry.getFullNumber());
        numberLabel.setColor(APP_RESET_COLOR);
        numberLabel.setFontSize(PHONEBOOK_ENTRY_HEIGHT / 5);
        view.add(numberLabel);
    }

    public Compound getView() {
        return this.view;
    }

    public void resetAppearance() {
        view.getObjectAt(labelXPos, nameLabelYPos).setColor(APP_RESET_COLOR);
        view.getObjectAt(labelXPos, numberLabelYPos).setColor(APP_RESET_COLOR);
    }

    public void changeAppearance() {
        view.getObjectAt(labelXPos, nameLabelYPos).setColor(PHONEBOOK_FONT_COLOR);
        view.getObjectAt(labelXPos, numberLabelYPos).setColor(PHONEBOOK_FONT_COLOR);
    }
}