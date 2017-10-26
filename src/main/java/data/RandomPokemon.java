package data;

import java.io.Serializable;

public class RandomPokemon implements Serializable {

    private static Long serialVersionUID = 1L;

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


    public static final class RandomPokemonBuilder {
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

        public RandomPokemonBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public RandomPokemonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RandomPokemonBuilder withNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public RandomPokemonBuilder withItem(String item) {
            this.item = item;
            return this;
        }

        public RandomPokemonBuilder withAbility(String ability) {
            this.ability = ability;
            return this;
        }

        public RandomPokemonBuilder withLevel(Integer level) {
            this.level = level;
            return this;
        }

        public RandomPokemonBuilder withType1(String type1) {
            this.type1 = type1;
            return this;
        }

        public RandomPokemonBuilder withType2(String type2) {
            this.type2 = type2;
            return this;
        }

        public RandomPokemonBuilder withHp(Integer hp) {
            this.hp = hp;
            return this;
        }

        public RandomPokemonBuilder withAttack(Integer attack) {
            this.attack = attack;
            return this;
        }

        public RandomPokemonBuilder withDefence(Integer defence) {
            this.defence = defence;
            return this;
        }

        public RandomPokemonBuilder withSpecialAttack(Integer specialAttack) {
            this.specialAttack = specialAttack;
            return this;
        }

        public RandomPokemonBuilder withSpecialDefence(Integer specialDefence) {
            this.specialDefence = specialDefence;
            return this;
        }

        public RandomPokemonBuilder withSpeed(Integer speed) {
            this.speed = speed;
            return this;
        }

        public RandomPokemonBuilder withMove1(String move1) {
            this.move1 = move1;
            return this;
        }

        public RandomPokemonBuilder withMove2(String move2) {
            this.move2 = move2;
            return this;
        }

        public RandomPokemonBuilder withMove3(String move3) {
            this.move3 = move3;
            return this;
        }

        public RandomPokemonBuilder withMove4(String move4) {
            this.move4 = move4;
            return this;
        }

        public RandomPokemon build() {
            RandomPokemon randomPokemon = new RandomPokemon();
            randomPokemon.setId(id);
            randomPokemon.setName(name);
            randomPokemon.setNickname(nickname);
            randomPokemon.setItem(item);
            randomPokemon.setAbility(ability);
            randomPokemon.setLevel(level);
            randomPokemon.setType1(type1);
            randomPokemon.setType2(type2);
            randomPokemon.setHp(hp);
            randomPokemon.setAttack(attack);
            randomPokemon.setDefence(defence);
            randomPokemon.setSpecialAttack(specialAttack);
            randomPokemon.setSpecialDefence(specialDefence);
            randomPokemon.setSpeed(speed);
            randomPokemon.setMove1(move1);
            randomPokemon.setMove2(move2);
            randomPokemon.setMove3(move3);
            randomPokemon.setMove4(move4);
            return randomPokemon;
        }
    }
}
