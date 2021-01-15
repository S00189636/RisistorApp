package edu.mohamedshiha.risistorapp;

public enum ToleranceChart {
        Brown(1,"#88540B","±1%"),
        Red(2,"#FF0800","±2%"),
        Green(0.5f,"#006400","±0.5%"),
        Blue(0.25f,"#00009C","±0.25%"),
        Violet(0.1f,"#8F00FF","±0.1%"),
        Gray(0.05f,"#B2BEB5","±0.05%"),
        Gold(5f,"#B8860B","±5%"),
        Silver(10,"#8C92AC","±10%"),
        None(20,"#C72C48","±20%"),
        ;

        public String getColourHex() {
                return colourHex;
        }

        public String getValueString() {
                return ValueString;
        }

        public float getValue() {
                return value;
        }

        private String colourHex ;
        private String ValueString ;
        private float value ;

        ToleranceChart(float v ,String s, String s1) {
                value =v;
                colourHex = s;
                ValueString = s1;
        }
}
