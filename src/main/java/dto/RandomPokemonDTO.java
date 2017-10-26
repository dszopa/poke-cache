package dto;

public class RandomPokemonDTO {

    private Long id;

    private String name;
    private String nickname;
    private String item;
    private String ability;
    private Integer level;

    // Typing
    private String type1;
    private String type2;

    // Stats
    private Integer hp;
    private Integer attack;
    private Integer defence;
    private Integer specialAttack;
    private Integer specialDefence;
    private Integer speed;

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

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    public Integer getSpecialDefence() {
        return specialDefence;
    }

    public void setSpecialDefence(Integer specialDefence) {
        this.specialDefence = specialDefence;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
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

    public static final class RandomPokemonDTOBuilder {
        private Long id;
        private String name;
        private String nickname;
        private String item;
        private String ability;
        private Integer level;
        // Typing
        private String type1;
        private String type2;
        // Stats
        private Integer hp;
        private Integer attack;
        private Integer defence;
        private Integer specialAttack;
        private Integer specialDefence;
        private Integer speed;
        // Move names
        private String move1;
        private String move2;
        private String move3;
        private String move4;

        public RandomPokemonDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public RandomPokemonDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RandomPokemonDTOBuilder withNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public RandomPokemonDTOBuilder withItem(String item) {
            this.item = item;
            return this;
        }

        public RandomPokemonDTOBuilder withAbility(String ability) {
            this.ability = ability;
            return this;
        }

        public RandomPokemonDTOBuilder withLevel(Integer level) {
            this.level = level;
            return this;
        }

        public RandomPokemonDTOBuilder withType1(String type1) {
            this.type1 = type1;
            return this;
        }

        public RandomPokemonDTOBuilder withType2(String type2) {
            this.type2 = type2;
            return this;
        }

        public RandomPokemonDTOBuilder withHp(Integer hp) {
            this.hp = hp;
            return this;
        }

        public RandomPokemonDTOBuilder withAttack(Integer attack) {
            this.attack = attack;
            return this;
        }

        public RandomPokemonDTOBuilder withDefence(Integer defence) {
            this.defence = defence;
            return this;
        }

        public RandomPokemonDTOBuilder withSpecialAttack(Integer specialAttack) {
            this.specialAttack = specialAttack;
            return this;
        }

        public RandomPokemonDTOBuilder withSpecialDefence(Integer specialDefence) {
            this.specialDefence = specialDefence;
            return this;
        }

        public RandomPokemonDTOBuilder withSpeed(Integer speed) {
            this.speed = speed;
            return this;
        }

        public RandomPokemonDTOBuilder withMove1(String move1) {
            this.move1 = move1;
            return this;
        }

        public RandomPokemonDTOBuilder withMove2(String move2) {
            this.move2 = move2;
            return this;
        }

        public RandomPokemonDTOBuilder withMove3(String move3) {
            this.move3 = move3;
            return this;
        }

        public RandomPokemonDTOBuilder withMove4(String move4) {
            this.move4 = move4;
            return this;
        }

        public RandomPokemonDTO build() {
            RandomPokemonDTO randomPokemonDTO = new RandomPokemonDTO();
            randomPokemonDTO.setId(id);
            randomPokemonDTO.setName(name);
            randomPokemonDTO.setNickname(nickname);
            randomPokemonDTO.setItem(item);
            randomPokemonDTO.setAbility(ability);
            randomPokemonDTO.setLevel(level);
            randomPokemonDTO.setType1(type1);
            randomPokemonDTO.setType2(type2);
            randomPokemonDTO.setHp(hp);
            randomPokemonDTO.setAttack(attack);
            randomPokemonDTO.setDefence(defence);
            randomPokemonDTO.setSpecialAttack(specialAttack);
            randomPokemonDTO.setSpecialDefence(specialDefence);
            randomPokemonDTO.setSpeed(speed);
            randomPokemonDTO.setMove1(move1);
            randomPokemonDTO.setMove2(move2);
            randomPokemonDTO.setMove3(move3);
            randomPokemonDTO.setMove4(move4);
            return randomPokemonDTO;
        }
    }
}
