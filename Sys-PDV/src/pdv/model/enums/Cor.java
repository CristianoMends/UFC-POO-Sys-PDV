package pdv.model.enums;

import java.awt.Color;

public enum Cor {

	AzulDodger(30, 145, 255),
	BrancoPuro(250, 250, 250),
	CinzaMedio(80, 80, 80);

    private int red;
    private int green;
    private int blue;

    Cor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color getColor() {
        return new Color(red, green, blue);
    }
}
