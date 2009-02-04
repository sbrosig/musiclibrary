package ancillary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sbrosig
 */
public enum Note {
    C ("C",0),
    C_SHARP ("C#",1),
    B ("B",-1),
    B_FLAT ("Bb",-2),
    D ("D",2);

    String name;
    int transpose;

    private Note (String name, int transpose) {
        this.name = name;
        this.transpose = transpose;
    }

    public int getTranspose() {
        return transpose;
    }

    public String getName() {
        return name;
    }




}
