package constant;

import java.util.regex.Pattern;

public class RegExps {

    // Defines a comma separated list, no alphabetic characters. Ex: 1,2,3
    public static final Pattern commaListNoAlphabet = Pattern.compile("^([0-9]+,)*[0-9]+$");

    // Matches: nickname (pokemonName) (gender) @ item
    public static final Pattern nicknameGenderItem = Pattern.compile("(.)+( \\((\\w| )+\\))( \\((M|F)\\)){1}( @ )([a-z]|[A-Z]|[0-9]| )+$");

    // Matches: nickname (pokemonName) (gender)
    public static final Pattern nicknameGender = Pattern.compile("(.)+( \\((\\w| )+\\))( \\((M|F)\\))( )*$");

    // Matches: nickname (pokemonName) @ item
    public static final Pattern nicknameItem = Pattern.compile("(.)+( (?!\\((M|F)\\))\\((\\w| )+\\))( @ )([a-z]|[A-Z]|[0-9]| )+$");

    // Matches: nickname (pokemonName)
    public static final Pattern nickname = Pattern.compile("(.)+( (?!\\((M|F)\\))\\((\\w| )+\\))( )*$");

    // Matches: pokemonName (gender) @ item
    // Also matches nicknameGenderItem
    public static final Pattern genderItem = Pattern.compile("(.)+( \\((M|F)\\))( @ )([a-z]|[A-Z]|[0-9]| )+$");

    // Matches: pokemonName (gender)
    // Also matches nicknameGender
    public static final Pattern gender = Pattern.compile("(.)+( \\((M|F)\\))( )*$");

    // Matches: pokemonName @ item
    // Also matches nicknameItem, nicknameGenderItem, & genderItem
    public static final Pattern item = Pattern.compile("^(.)+( @ )([a-z]|[A-Z]|[0-9]| )+$");
}
