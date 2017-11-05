package dto;

import constant.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonDTO {

    private static final String invalidType = "Not a valid type. valid types are: " + Arrays.toString(Type.values());

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

    public List<ErrorDTO> validate() {
        List<ErrorDTO> errors = new ArrayList<>();

        if (name == null) {
            errors.add(new ErrorDTO("name", "attribute was not given, name must be provided"));
        }

        if (ability == null) {
            errors.add(new ErrorDTO("ability", "attribute was not given, ability must be provided"));
        }

        if (level == null) {
            errors.add(new ErrorDTO("level", "attribute was not given, level must be provided"));
        }

        if (level < 1 || level > 100) {
            errors.add(new ErrorDTO("level", "level must be a number between 1 and 100"));
        }

        if (type1 == null) {
            errors.add(new ErrorDTO("type1", "pokemon must have a primary type"));
        }

        if (type1 != null) {
            try {
                Type.valueOf(type1.toUpperCase());
            } catch (IllegalArgumentException e) {
                errors.add(new ErrorDTO("type1", invalidType));
            }
        }

        if (type2 != null) {
            try {
                Type.valueOf(type2.toUpperCase());
            } catch (IllegalArgumentException e) {
                errors.add(new ErrorDTO("type2", invalidType));
            }
        }

        if (hpEVs == null) {
            errors.add(new ErrorDTO("hpEVs", "attribute was not given, hpEVs must be provided"));
        }

        if (hpEVs < 0 || hpEVs > 252) {
            errors.add(new ErrorDTO("hpEVs", "hpEVs must be a number between 0 and 252"));
        }

        if (attackEVs == null) {
            errors.add(new ErrorDTO("attackEVs", "attribute was not given, attackEVs must be provided"));
        }

        if (attackEVs < 0 || attackEVs > 252) {
            errors.add(new ErrorDTO("attackEVs", "attackEVs must be a number between 0 and 252"));
        }

        if (defenceEVs == null) {
            errors.add(new ErrorDTO("defenceEVs", "attribute was not given, defenceEVs must be provided"));
        }

        if (defenceEVs < 0 || defenceEVs > 252) {
            errors.add(new ErrorDTO("defenceEVs", "defenceEVs must be a number between 0 and 252"));
        }

        if (specialAttackEVs == null) {
            errors.add(new ErrorDTO("specialAttackEVs", "attribute was not given, specialAttackEVs must be provided"));
        }

        if (specialAttackEVs < 0 || specialAttackEVs > 252) {
            errors.add(new ErrorDTO("specialAttackEVs", "specialAttackEVs must be a number between 0 and 252"));
        }

        if (specialDefenceEVs == null) {
            errors.add(new ErrorDTO("specialDefenceEVs", "attribute was not given, specialDefenceEVs must be provided"));
        }

        if (specialDefenceEVs < 0 || specialDefenceEVs > 252) {
            errors.add(new ErrorDTO("specialDefenceEVs", "specialDefenceEVs must be a number between 0 and 252"));
        }

        if (speedEVs == null) {
            errors.add(new ErrorDTO("speedEVs", "attribute was not given, speedEVs must be provided"));
        }

        if (speedEVs < 0 || speedEVs > 252) {
            errors.add(new ErrorDTO("speedEVs", "speedEVs must be a number between 0 and 252"));
        }

        if (hpEVs + attackEVs + defenceEVs + specialAttackEVs + specialDefenceEVs + speedEVs > 508) {
            errors.add(new ErrorDTO("EV Total", "a pokemon cannot have more than 508 total EVs"));
        }

        if (hpIVs == null) {
            errors.add(new ErrorDTO("hpIVs", "attribute was not given, hpIVs must be provided"));
        }

        if (hpIVs < 0 || hpIVs > 31) {
            errors.add(new ErrorDTO("hpIVs", "hpIVs must be a number between 0 and 31"));
        }

        if (attackIVs == null) {
            errors.add(new ErrorDTO("attackIVs", "attribute was not given, attackIVs must be provided"));
        }

        if (attackIVs < 0 || attackIVs > 31) {
            errors.add(new ErrorDTO("attackIVs", "attackIVs must be a number between 0 and 31"));
        }

        if (defenceIVs == null) {
            errors.add(new ErrorDTO("defenceIVs", "attribute was not given, defenceIVs must be provided"));
        }

        if (defenceIVs < 0 || defenceIVs > 31) {
            errors.add(new ErrorDTO("defenceIVs", "defenceIVs must be a number between 0 and 31"));
        }

        if (specialAttackIVs == null) {
            errors.add(new ErrorDTO("specialAttackIVs", "attribute was not given, specialAttackIVs must be provided"));
        }

        if (specialAttackIVs < 0 || specialAttackIVs > 31) {
            errors.add(new ErrorDTO("specialAttackIVs", "specialAttackIVs must be a number between 0 and 31"));
        }

        if (specialDefenceIVs == null) {
            errors.add(new ErrorDTO("specialDefenceIVs", "attribute was not given, specialDefenceIVs must be provided"));
        }

        if (specialDefenceIVs < 0 || specialDefenceIVs > 31) {
            errors.add(new ErrorDTO("specialDefenceIVs", "specialDefenceIVs must be a number between 0 and 31"));
        }

        if (speedIVs == null) {
            errors.add(new ErrorDTO("speedIVs", "attribute was not given, speedIVs must be provided"));
        }

        if (speedIVs < 0 || speedIVs > 31) {
            errors.add(new ErrorDTO("speedIVs", "speedIVs must be a number between 0 and 31"));
        }

        if (move1 == null && move2 == null && move3 == null && move4 == null) {
            errors.add(new ErrorDTO("move1, move2, move3, move4", "a pokemon must have atleast one move"));
        }

        return errors;
    }

    public static final class PokemonDTOBuilder {
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

        public PokemonDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PokemonDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PokemonDTOBuilder withNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public PokemonDTOBuilder withItem(String item) {
            this.item = item;
            return this;
        }

        public PokemonDTOBuilder withAbility(String ability) {
            this.ability = ability;
            return this;
        }

        public PokemonDTOBuilder withLevel(Integer level) {
            this.level = level;
            return this;
        }

        public PokemonDTOBuilder withType1(String type1) {
            this.type1 = type1;
            return this;
        }

        public PokemonDTOBuilder withType2(String type2) {
            this.type2 = type2;
            return this;
        }

        public PokemonDTOBuilder withHpEVs(Integer hpEVs) {
            this.hpEVs = hpEVs;
            return this;
        }

        public PokemonDTOBuilder withAttackEVs(Integer attackEVs) {
            this.attackEVs = attackEVs;
            return this;
        }

        public PokemonDTOBuilder withDefenceEVs(Integer defenceEVs) {
            this.defenceEVs = defenceEVs;
            return this;
        }

        public PokemonDTOBuilder withSpecialAttackEVs(Integer specialAttackEVs) {
            this.specialAttackEVs = specialAttackEVs;
            return this;
        }

        public PokemonDTOBuilder withSpecialDefenceEVs(Integer specialDefenceEVs) {
            this.specialDefenceEVs = specialDefenceEVs;
            return this;
        }

        public PokemonDTOBuilder withSpeedEVs(Integer speedEVs) {
            this.speedEVs = speedEVs;
            return this;
        }

        public PokemonDTOBuilder withHpIVs(Integer hpIVs) {
            this.hpIVs = hpIVs;
            return this;
        }

        public PokemonDTOBuilder withAttackIVs(Integer attackIVs) {
            this.attackIVs = attackIVs;
            return this;
        }

        public PokemonDTOBuilder withDefenceIVs(Integer defenceIVs) {
            this.defenceIVs = defenceIVs;
            return this;
        }

        public PokemonDTOBuilder withSpecialAttackIVs(Integer specialAttackIVs) {
            this.specialAttackIVs = specialAttackIVs;
            return this;
        }

        public PokemonDTOBuilder withSpecialDefenceIVs(Integer specialDefenceIVs) {
            this.specialDefenceIVs = specialDefenceIVs;
            return this;
        }

        public PokemonDTOBuilder withSpeedIVs(Integer speedIVs) {
            this.speedIVs = speedIVs;
            return this;
        }

        public PokemonDTOBuilder withMove1(String move1) {
            this.move1 = move1;
            return this;
        }

        public PokemonDTOBuilder withMove2(String move2) {
            this.move2 = move2;
            return this;
        }

        public PokemonDTOBuilder withMove3(String move3) {
            this.move3 = move3;
            return this;
        }

        public PokemonDTOBuilder withMove4(String move4) {
            this.move4 = move4;
            return this;
        }

        public PokemonDTO build() {
            PokemonDTO pokemonDTO = new PokemonDTO();
            pokemonDTO.setId(id);
            pokemonDTO.setName(name);
            pokemonDTO.setNickname(nickname);
            pokemonDTO.setItem(item);
            pokemonDTO.setAbility(ability);
            pokemonDTO.setLevel(level);
            pokemonDTO.setType1(type1);
            pokemonDTO.setType2(type2);
            pokemonDTO.setHpEVs(hpEVs);
            pokemonDTO.setAttackEVs(attackEVs);
            pokemonDTO.setDefenceEVs(defenceEVs);
            pokemonDTO.setSpecialAttackEVs(specialAttackEVs);
            pokemonDTO.setSpecialDefenceEVs(specialDefenceEVs);
            pokemonDTO.setSpeedEVs(speedEVs);
            pokemonDTO.setHpIVs(hpIVs);
            pokemonDTO.setAttackIVs(attackIVs);
            pokemonDTO.setDefenceIVs(defenceIVs);
            pokemonDTO.setSpecialAttackIVs(specialAttackIVs);
            pokemonDTO.setSpecialDefenceIVs(specialDefenceIVs);
            pokemonDTO.setSpeedIVs(speedIVs);
            pokemonDTO.setMove1(move1);
            pokemonDTO.setMove2(move2);
            pokemonDTO.setMove3(move3);
            pokemonDTO.setMove4(move4);
            return pokemonDTO;
        }
    }
}
