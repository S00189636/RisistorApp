package edu.mohamedshiha.risistorapp;

public enum BandChart {
    Black(0,"#000000"),
    Brown(1,"#88540B"),
    Red(2,"#FF0800"),
    Orange(3,"#ED9121","1K"),
    Yellow(4,"#FFB200","10K"),
    Green(5,"#006400","100K"),
    Blue(6,"#00009C","1M"),
    Violet(7,"#8F00FF","10M"),
    Gray(8,"#B2BEB5","100M"),
    White(9,"#FFFAF0","1B"),
    ;



    private int value;
    private String Char;
    private String colourHex ;

    BandChart(int i, String s,String _char) {
        value = i;
        colourHex = s;
        Char =_char;
    }
    BandChart(int i, String s) {
        value = i;
        colourHex = s;
        Char = i == 0 ? "1" : String.valueOf(Math.pow(10,i));
    }

    public int getValue() {
        return value;
    }
    public String getChar() {
        return Char;
    }

    public String getColourHex() {
        return colourHex;
    }

}
