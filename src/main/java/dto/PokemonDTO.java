package dto;

public class PokemonDTO {

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
