package constant;

import java.util.regex.Pattern;

public class RegExps {
    // Defines a comma separated list, no alphabetic characters. Ex: 1,2,3
    public static final Pattern commaListNoAlphabet = Pattern.compile("^([0-9]+,)*[0-9]+$");
}
