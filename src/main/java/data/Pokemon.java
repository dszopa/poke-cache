package data;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private static Long serialVersionUID = 1L;

    private Long id;

    // Pokemon Info
    private String name;
    private String nickname;
    private String item;
    private String ability;
    private Integer level;

    // Typing
    private String type1;
    private String type2;

    // Stats
    private Integer hpEVs;
    private Integer attackEVs;
    private Integer defenceEVs;
    private Integer specialAttackEVs;
    private Integer specialDefenceEVs;
    private Integer speedEVs;

    private Integer hpIVs;
    private Integer attackIVs;
    private Integer defenceIVs;
    private Integer specialAttackIVs;
    private Integer specialDefenceIVs;
    private Integer speedIVs;

    // Move names
    private String move1;
    private String move2;
    private String move3;
    private String move4;

    public Pokemon() {}

    public Pokemon(String name, String nickname, String item, String ability, Integer level, String type1, String type2,
                   Integer hpEVs, Integer attackEVs, Integer defenceEVs, Integer specialAttackEVs, Integer specialDefenceEVs, Integer speedEVs,
                   Integer hpIVs, Integer attackIVs, Integer defenceIVs, Integer specialAttackIVs, Integer specialDefenceIVs, Integer speedIVs,
                   String move1, String move2, String move3, String move4) {
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

    public Pokemon(Long id, String name, String nickname, String item, String ability, Integer level, String type1,
                   String type2, Integer hpEVs, Integer attackEVs, Integer defenceEVs, Integer specialAttackEVs, Integer specialDefenceEVs,
                   Integer speedEVs, Integer hpIVs, Integer attackIVs, Integer defenceIVs, Integer specialAttackIVs, Integer specialDefenceIVs,
                   Integer speedIVs, String move1, String move2, String move3, String move4) {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
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

    public Integer getHpEVs() {
        return hpEVs;
    }

    public void setHpEVs(Integer hpEVs) {
        this.hpEVs = hpEVs;
    }

    public Integer getAttackEVs() {
        return attackEVs;
    }

    public void setAttackEVs(Integer attackEVs) {
        this.attackEVs = attackEVs;
    }

    public Integer getDefenceEVs() {
        return defenceEVs;
    }

    public void setDefenceEVs(Integer defenceEVs) {
        this.defenceEVs = defenceEVs;
    }

    public Integer getSpecialAttackEVs() {
        return specialAttackEVs;
    }

    public void setSpecialAttackEVs(Integer specialAttackEVs) {
        this.specialAttackEVs = specialAttackEVs;
    }

    public Integer getSpecialDefenceEVs() {
        return specialDefenceEVs;
    }

    public void setSpecialDefenceEVs(Integer specialDefenceEVs) {
        this.specialDefenceEVs = specialDefenceEVs;
    }

    public Integer getSpeedEVs() {
        return speedEVs;
    }

    public void setSpeedEVs(Integer speedEVs) {
        this.speedEVs = speedEVs;
    }

    public Integer getHpIVs() {
        return hpIVs;
    }

    public void setHpIVs(Integer hpIVs) {
        this.hpIVs = hpIVs;
    }

    public Integer getAttackIVs() {
        return attackIVs;
    }

    public void setAttackIVs(Integer attackIVs) {
        this.attackIVs = attackIVs;
    }

    public Integer getDefenceIVs() {
        return defenceIVs;
    }

    public void setDefenceIVs(Integer defenceIVs) {
        this.defenceIVs = defenceIVs;
    }

    public Integer getSpecialAttackIVs() {
        return specialAttackIVs;
    }

    public void setSpecialAttackIVs(Integer specialAttackIVs) {
        this.specialAttackIVs = specialAttackIVs;
    }

    public Integer getSpecialDefenceIVs() {
        return specialDefenceIVs;
    }

    public void setSpecialDefenceIVs(Integer specialDefenceIVs) {
        this.specialDefenceIVs = specialDefenceIVs;
    }

    public Integer getSpeedIVs() {
        return speedIVs;
    }

    public void setSpeedIVs(Integer speedIVs) {
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
