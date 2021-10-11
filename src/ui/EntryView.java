package ui;

import config.Config;
import data.Entry;
import de.ur.mi.oop.graphics.Compound;
import de.ur.mi.oop.graphics.Image;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class EntryView {

    private Compound view;
    private float labelXPos;
    private float nameLabelYPos;
    private float numberLabelYPos;

    EntryView(float x, float y, float width, float height, Entry entry) {
        view = new Compound(x, y);
        view.setWidth(width);
        view.setHeight(height);

        Rectangle entryBackground = new Rectangle(x, y, (int) width, Config.PHONEBOOK_ENTRY_HEIGHT, Config.PHONEBOOK_ENTRY_BACKGROUND_COLOR);
        entryBackground.setBorderWeight(0);
        view.add(entryBackground);

        Image image = new Image(x, y, entry.getImagePath());
        image.setWidth(height);
        image.setHeight(height);
        view.add(image);

        labelXPos = image.getXPos() + image.getWidth() + Config.PHONEBOOK_ENTRY_MARGIN + (Config.PHONEBOOK_ENTRY_HEIGHT / 5);
        System.out.println(view.getYPos());
        nameLabelYPos = image.getYPos() + (Config.PHONEBOOK_ENTRY_HEIGHT / 3);
        System.out.println(nameLabelYPos);
        numberLabelYPos = (float) (view.getYPos() + (Config.PHONEBOOK_ENTRY_HEIGHT / 1.4));

        Label nameLabel = new Label(labelXPos, nameLabelYPos, entry.getName());
        nameLabel.setColor(Config.APP_RESET_COLOR);
        nameLabel.setFontSize(Config.PHONEBOOK_ENTRY_HEIGHT / 4);
        view.add(nameLabel);

        Label numberLabel = new Label(labelXPos, numberLabelYPos, entry.getFullNumber());
        numberLabel.setColor(Config.APP_RESET_COLOR);
        numberLabel.setFontSize(Config.PHONEBOOK_ENTRY_HEIGHT / 5);
        view.add(numberLabel);
    }

    public Compound getView() {
        return this.view;
    }

    public void resetAppearance() {
        view.getObjectAt(labelXPos, nameLabelYPos).setColor(Config.APP_RESET_COLOR);
        view.getObjectAt(labelXPos, numberLabelYPos).setColor(Config.APP_RESET_COLOR);
    }

    public void changeAppearance() {
        view.getObjectAt(labelXPos, nameLabelYPos).setColor(Config.PHONEBOOK_FONT_COLOR);
        view.getObjectAt(labelXPos, numberLabelYPos).setColor(Config.PHONEBOOK_FONT_COLOR);
    }
}