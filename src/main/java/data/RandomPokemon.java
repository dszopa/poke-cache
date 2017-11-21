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

    @Override
    public String toString() {
        return "RandomPokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", item='" + item + '\'' +
                ", ability='" + ability + '\'' +
                ", level=" + level +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                ", specialAttack=" + specialAttack +
                ", specialDefence=" + specialDefence +
                ", speed=" + speed +
                ", move1='" + move1 + '\'' +
                ", move2='" + move2 + '\'' +
                ", move3='" + move3 + '\'' +
                ", move4='" + move4 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RandomPokemon that = (RandomPokemon) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (ability != null ? !ability.equals(that.ability) : that.ability != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (type1 != null ? !type1.equals(that.type1) : that.type1 != null) return false;
        if (type2 != null ? !type2.equals(that.type2) : that.type2 != null) return false;
        if (hp != null ? !hp.equals(that.hp) : that.hp != null) return false;
        if (attack != null ? !attack.equals(that.attack) : that.attack != null) return false;
        if (defence != null ? !defence.equals(that.defence) : that.defence != null) return false;
        if (specialAttack != null ? !specialAttack.equals(that.specialAttack) : that.specialAttack != null)
            return false;
        if (specialDefence != null ? !specialDefence.equals(that.specialDefence) : that.specialDefence != null)
            return false;
        if (speed != null ? !speed.equals(that.speed) : that.speed != null) return false;
        if (move1 != null ? !move1.equals(that.move1) : that.move1 != null) return false;
        if (move2 != null ? !move2.equals(that.move2) : that.move2 != null) return false;
        if (move3 != null ? !move3.equals(that.move3) : that.move3 != null) return false;
        return move4 != null ? move4.equals(that.move4) : that.move4 == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (ability != null ? ability.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (type1 != null ? type1.hashCode() : 0);
        result = 31 * result + (type2 != null ? type2.hashCode() : 0);
        result = 31 * result + (hp != null ? hp.hashCode() : 0);
        result = 31 * result + (attack != null ? attack.hashCode() : 0);
        result = 31 * result + (defence != null ? defence.hashCode() : 0);
        result = 31 * result + (specialAttack != null ? specialAttack.hashCode() : 0);
        result = 31 * result + (specialDefence != null ? specialDefence.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (move1 != null ? move1.hashCode() : 0);
        result = 31 * result + (move2 != null ? move2.hashCode() : 0);
        result = 31 * result + (move3 != null ? move3.hashCode() : 0);
        result = 31 * result + (move4 != null ? move4.hashCode() : 0);
        return result;
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
