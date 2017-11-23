package constant;

import org.junit.Test;

import static constant.RegExps.*;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class RegexUTest {

    private static String nicknameGenderItemString = "Sparky Boy (Tapu Koko) (M) @ Choice Scarf   ";
    private static String nicknameGenderString = "blabo boyo(M) (Hawlucha) (M)  ";
    private static String nicknameItemString = "blabo boyo (Hawlucha) @ Choice Scarf  ";
    private static String nicknameString = "blabo(F) boyo(Tapu) (Hawlucha)  ";
    private static String genderItemString = "Hawlucha (M) @ Normal Gem  ";
    private static String genderString = "Hawlucha (M)  ";
    private static String itemString = "Hawlucha @ Eviolite  ";

    @Test
    public void testNicknameGenderItem() {
        Boolean matchNicknameGenderItem = nicknameGenderItem.matcher(nicknameGenderItemString).find();
        assertTrue(matchNicknameGenderItem);

        Boolean matchNicknameGender = nicknameGenderItem.matcher(nicknameGenderString).find();
        assertFalse(matchNicknameGender);

        Boolean matchNicknameItem = nicknameGenderItem.matcher(nicknameItemString).find();
        assertFalse(matchNicknameItem);

        Boolean matchNickname = nicknameGenderItem.matcher(nicknameString).find();
        assertFalse(matchNickname);

        Boolean matchGenderItem = nicknameGenderItem.matcher(genderItemString).find();
        assertFalse(matchGenderItem);

        Boolean matchGender = nicknameGenderItem.matcher(genderString).find();
        assertFalse(matchGender);

        Boolean matchItem = nicknameGenderItem.matcher(itemString).find();
        assertFalse(matchItem);
    }

    @Test
    public void testNicknameGender() {
        Boolean matchNicknameGenderItem = nicknameGender.matcher(nicknameGenderItemString).find();
        assertFalse(matchNicknameGenderItem);

        Boolean matchNicknameGender = nicknameGender.matcher(nicknameGenderString).find();
        assertTrue(matchNicknameGender);

        Boolean matchNicknameItem = nicknameGender.matcher(nicknameItemString).find();
        assertFalse(matchNicknameItem);

        Boolean matchNickname = nicknameGender.matcher(nicknameString).find();
        assertFalse(matchNickname);

        Boolean matchGenderItem = nicknameGender.matcher(genderItemString).find();
        assertFalse(matchGenderItem);

        Boolean matchGender = nicknameGender.matcher(genderString).find();
        assertFalse(matchGender);

        Boolean matchItem = nicknameGender.matcher(itemString).find();
        assertFalse(matchItem);
    }

    @Test
    public void testNicknameItem() {
        Boolean matchNicknameGenderItem = nicknameItem.matcher(nicknameGenderItemString).find();
        assertFalse(matchNicknameGenderItem);

        Boolean matchNicknameGender = nicknameItem.matcher(nicknameGenderString).find();
        assertFalse(matchNicknameGender);

        Boolean matchNicknameItem = nicknameItem.matcher(nicknameItemString).find();
        assertTrue(matchNicknameItem);

        Boolean matchNickname = nicknameItem.matcher(nicknameString).find();
        assertFalse(matchNickname);

        Boolean matchGenderItem = nicknameItem.matcher(genderItemString).find();
        assertFalse(matchGenderItem);

        Boolean matchGender = nicknameItem.matcher(genderString).find();
        assertFalse(matchGender);

        Boolean matchItem = nicknameItem.matcher(itemString).find();
        assertFalse(matchItem);
    }

    @Test
    public void testNickname() {
        Boolean matchNicknameGenderItem = nickname.matcher(nicknameGenderItemString).find();
        assertFalse(matchNicknameGenderItem);

        Boolean matchNicknameGender = nickname.matcher(nicknameGenderString).find();
        assertFalse(matchNicknameGender);

        Boolean matchNicknameItem = nickname.matcher(nicknameItemString).find();
        assertFalse(matchNicknameItem);

        Boolean matchNickname = nickname.matcher(nicknameString).find();
        assertTrue(matchNickname);

        Boolean matchGenderItem = nickname.matcher(genderItemString).find();
        assertFalse(matchGenderItem);

        Boolean matchGender = nickname.matcher(genderString).find();
        assertFalse(matchGender);

        Boolean matchItem = nickname.matcher(itemString).find();
        assertFalse(matchItem);
    }

    @Test
    public void matchGenderItem() {
        // Is known to overlap with nicknameGenderItem

        Boolean matchNicknameGenderItem = genderItem.matcher(nicknameGenderItemString).find();
        assertTrue(matchNicknameGenderItem);

        Boolean matchNicknameGender = genderItem.matcher(nicknameGenderString).find();
        assertFalse(matchNicknameGender);

        Boolean matchNicknameItem = genderItem.matcher(nicknameItemString).find();
        assertFalse(matchNicknameItem);

        Boolean matchNickname = genderItem.matcher(nicknameString).find();
        assertFalse(matchNickname);

        Boolean matchGenderItem = genderItem.matcher(genderItemString).find();
        assertTrue(matchGenderItem);

        Boolean matchGender = genderItem.matcher(genderString).find();
        assertFalse(matchGender);

        Boolean matchItem = genderItem.matcher(itemString).find();
        assertFalse(matchItem);
    }

    @Test
    public void testGender() {
        // Is known to overlap with nicknameGender

        Boolean matchNicknameGenderItem = gender.matcher(nicknameGenderItemString).find();
        assertFalse(matchNicknameGenderItem);

        Boolean matchNicknameGender = gender.matcher(nicknameGenderString).find();
        assertTrue(matchNicknameGender);

        Boolean matchNicknameItem = gender.matcher(nicknameItemString).find();
        assertFalse(matchNicknameItem);

        Boolean matchNickname = gender.matcher(nicknameString).find();
        assertFalse(matchNickname);

        Boolean matchGenderItem = gender.matcher(genderItemString).find();
        assertFalse(matchGenderItem);

        Boolean matchGender = gender.matcher(genderString).find();
        assertTrue(matchGender);

        Boolean matchItem = gender.matcher(itemString).find();
        assertFalse(matchItem);
    }

    @Test
    public void testItem() {
        // Is known to overlap with nicknameGenderItem, nicknameItem, & genderItem

        Boolean matchNicknameGenderItem = item.matcher(nicknameGenderItemString).find();
        assertTrue(matchNicknameGenderItem);

        Boolean matchNicknameGender = item.matcher(nicknameGenderString).find();
        assertFalse(matchNicknameGender);

        Boolean matchNicknameItem = item.matcher(nicknameItemString).find();
        assertTrue(matchNicknameItem);

        Boolean matchNickname = item.matcher(nicknameString).find();
        assertFalse(matchNickname);

        Boolean matchGenderItem = item.matcher(genderItemString).find();
        assertTrue(matchGenderItem);

        Boolean matchGender = item.matcher(genderString).find();
        assertFalse(matchGender);

        Boolean matchItem = item.matcher(itemString).find();
        assertTrue(matchItem);
    }
}
