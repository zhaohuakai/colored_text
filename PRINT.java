public class PRINT {

    public static void main(String[] args) {
        PRINT.PN("black", PRINT.BLACK);
        PRINT.PN("white", PRINT.WHITE);
        PRINT.PN("red", PRINT.RED);
        PRINT.PN("green", PRINT.GREEN);
        PRINT.PN("yellow", PRINT.YELLOW);
        PRINT.PN("blue", PRINT.BLUE);
        PRINT.PN("magenta", PRINT.MAGENTA);
        PRINT.PN("cyan", PRINT.CYAN);
        PRINT.PN("FG white, BG black", PRINT.WHITE, PRINT.BLACK_BACKGROUND);
        PRINT.PN("FG black, BG white", PRINT.BLACK, PRINT.WHITE_BACKGROUND);
        PRINT.PN("FG red, BG blue", PRINT.RED, PRINT.BLUE_BACKGROUND);
        PRINT.PN("bold italic", PRINT.BOLD, PRINT.ITATIC);
        PRINT.PN("FG white, BG tellow, underline", PRINT.WHITE, PRINT.YELLOW_BACKGROUND, PRINT.UNDERLINE);
        PRINT.PN("red, reverse", PRINT.RED, PRINT.REVERSE);
    }

    public static final int WHITE = 30;             // FG white
    public static final int WHITE_BACKGROUND = 40;  // BG white
    public static final int RED = 31;               // FG red
    public static final int RED_BACKGROUND = 41;    // BG red
    public static final int GREEN = 32;             // FG green
    public static final int GREEN_BACKGROUND = 42;  // BG green
    public static final int YELLOW = 33;            // FG yellow
    public static final int YELLOW_BACKGROUND = 43; // BG yellow
    public static final int BLUE = 34;              // FG blue
    public static final int BLUE_BACKGROUND = 44;   // BG blue
    public static final int MAGENTA = 35;           // FG magenta
    public static final int MAGENTA_BACKGROUND = 45;// BG magenta
    public static final int CYAN = 36;              // FG cyan
    public static final int CYAN_BACKGROUND = 46;   // BG cyan
    public static final int BLACK = 37;             // FG black
    public static final int BLACK_BACKGROUND = 47;  // BG black

    public static final int BOLD = 1;
    public static final int ITATIC = 3;
    public static final int UNDERLINE = 4;
    public static final int REVERSE = 7;

    private static String FMT(String txt, int... codes) {
        StringBuffer sb = new StringBuffer();
        for (int code : codes) {
            sb.append(code + ";");
        }
        String _code = sb.toString();
        if (_code.endsWith(";")) {
            _code = _code.substring(0, _code.length() - 1);
        }
        return (char) 27 + "[" + _code + "m" + txt + (char) 27 + "[0m";
    }

    /**
     * printing
     */
    public static void P(String txt, int... codes) {
        System.out.print(FMT(txt, codes));
    }

    /**
     * newline after printing
     */
    public static void PN(String txt, int... codes) {
        System.out.println(FMT(txt, codes));
    }

    /**
     * default: FG red
     */
    public static void PN(String txt) {
        System.out.println(FMT(txt, new int[]{RED}));
    }
}
