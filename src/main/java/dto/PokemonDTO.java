package dto;

public class PokemonDTO {

    private Long id;

    // Pokemon Info
    private String name;
    private String nickname;
    private String item;
    private String ability;
    private int level;

    // Typing
    private String type1;
    private String type2;

    // Stats
    private int hpEVs;
    private int attackEVs;
    private int defenceEVs;
    private int specialAttackEVs;
    private int specialDefenceEVs;
    private int speedEVs;

    private int hpIVs;
    private int attackIVs;
    private int defenceIVs;
    private int specialAttackIVs;
    private int specialDefenceIVs;
    private int speedIVs;

    // Move names
    private String move1;
    private String move2;
    private String move3;
    private String move4;

    public PokemonDTO() {}

    public PokemonDTO(String name, String nickname, String item, String ability, int level, String type1, String type2,
                      int hpEVs, int attackEVs, int defenceEVs, int specialAttackEVs, int specialDefenceEVs,
                      int speedEVs, int hpIVs, int attackIVs, int defenceIVs, int specialAttackIVs,
                      int specialDefenceIVs, int speedIVs, String move1, String move2, String move3, String move4) {
        this.name = name;
        this.nickname = nickname;
        this.item = item;
        this.ability = ability;
        this.level = level;
        this.type1 = type1;
        this.type2 = type2;
        this.hpEVs = hpEVs;
        this.attackEVs = attackEVs;
        this.defenceEVs = defenceEVs;
        this.specialAttackEVs = specialAttackEVs;
        this.specialDefenceEVs = specialDefenceEVs;
        this.speedEVs = speedEVs;
        this.hpIVs = hpIVs;
        this.attackIVs = attackIVs;
        this.defenceIVs = defenceIVs;
        this.specialAttackIVs = specialAttackIVs;
        this.specialDefenceIVs = specialDefenceIVs;
        this.speedIVs = speedIVs;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }

    public PokemonDTO(Long id, String name, String nickname, String item, String ability, int level, String type1,
                      String type2, int hpEVs, int attackEVs, int defenceEVs, int specialAttackEVs,
                      int specialDefenceEVs, int speedEVs, int hpIVs, int attackIVs, int defenceIVs,
                      int specialAttackIVs, int specialDefenceIVs, int speedIVs, String move1, String move2,
                      String move3, String move4) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.item = item;
        this.ability = ability;
        this.level = level;
        this.type1 = type1;
        this.type2 = type2;
        this.hpEVs = hpEVs;
        this.attackEVs = attackEVs;
        this.defenceEVs = defenceEVs;
        this.specialAttackEVs = specialAttackEVs;
        this.specialDefenceEVs = specialDefenceEVs;
        this.speedEVs = speedEVs;
        this.hpIVs = hpIVs;
        this.attackIVs = attackIVs;
        this.defenceIVs = defenceIVs;
        this.specialAttackIVs = specialAttackIVs;
        this.specialDefenceIVs = specialDefenceIVs;
        this.speedIVs = speedIVs;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getHpEVs() {
        return hpEVs;
    }

    public void setHpEVs(int hpEVs) {
        this.hpEVs = hpEVs;
    }

    public int getAttackEVs() {
        return attackEVs;
    }

    public void setAttackEVs(int attackEVs) {
        this.attackEVs = attackEVs;
    }

    public int getDefenceEVs() {
        return defenceEVs;
    }

    public void setDefenceEVs(int defenceEVs) {
        this.defenceEVs = defenceEVs;
    }

    public int getSpecialAttackEVs() {
        return specialAttackEVs;
    }

    public void setSpecialAttackEVs(int specialAttackEVs) {
        this.specialAttackEVs = specialAttackEVs;
    }

    public int getSpecialDefenceEVs() {
        return specialDefenceEVs;
    }

    public void setSpecialDefenceEVs(int specialDefenceEVs) {
        this.specialDefenceEVs = specialDefenceEVs;
    }

    public int getSpeedEVs() {
        return speedEVs;
    }

    public void setSpeedEVs(int speedEVs) {
        this.speedEVs = speedEVs;
    }

    public int getHpIVs() {
        return hpIVs;
    }

    public void setHpIVs(int hpIVs) {
        this.hpIVs = hpIVs;
    }

    public int getAttackIVs() {
        return attackIVs;
    }

    public void setAttackIVs(int attackIVs) {
        this.attackIVs = attackIVs;
    }

    public int getDefenceIVs() {
        return defenceIVs;
    }

    public void setDefenceIVs(int defenceIVs) {
        this.defenceIVs = defenceIVs;
    }

    public int getSpecialAttackIVs() {
        return specialAttackIVs;
    }

    public void setSpecialAttackIVs(int specialAttackIVs) {
        this.specialAttackIVs = specialAttackIVs;
    }

    public int getSpecialDefenceIVs() {
        return specialDefenceIVs;
    }

    public void setSpecialDefenceIVs(int specialDefenceIVs) {
        this.specialDefenceIVs = specialDefenceIVs;
    }

    public int getSpeedIVs() {
        return speedIVs;
    }

    public void setSpeedIVs(int speedIVs) {
        this.speedIVs = speedIVs;
    }

    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }

    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }

    public String getMove3() {
        return move3;
    }

    public void setMove3(String move3) {
        this.move3 = move3;
    }

    public String getMove4() {
        return move4;
    }

    public void setMove4(String move4) {
        this.move4 = move4;
    }
}
