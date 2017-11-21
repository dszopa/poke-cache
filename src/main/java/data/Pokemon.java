package data;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private static Long serialVersionUID = 2L;

    private Long id;

    // Pokemon Info
    private String name;
    private String nickname;
    private String item;
    private String ability;
    private Integer level;
    private String gender;
    private Boolean shiny;
    private String nature;
    private Integer happiness;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getShiny() {
        return shiny;
    }

    public void setShiny(Boolean shiny) {
        this.shiny = shiny;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
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

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", item='" + item + '\'' +
                ", ability='" + ability + '\'' +
                ", level=" + level +
                ", gender='" + gender + '\'' +
                ", shiny=" + shiny +
                ", nature='" + nature + '\'' +
                ", happiness=" + happiness +
                ", hpEVs=" + hpEVs +
                ", attackEVs=" + attackEVs +
                ", defenceEVs=" + defenceEVs +
                ", specialAttackEVs=" + specialAttackEVs +
                ", specialDefenceEVs=" + specialDefenceEVs +
                ", speedEVs=" + speedEVs +
                ", hpIVs=" + hpIVs +
                ", attackIVs=" + attackIVs +
                ", defenceIVs=" + defenceIVs +
                ", specialAttackIVs=" + specialAttackIVs +
                ", specialDefenceIVs=" + specialDefenceIVs +
                ", speedIVs=" + speedIVs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;

        if (id != null ? !id.equals(pokemon.id) : pokemon.id != null) return false;
        if (name != null ? !name.equals(pokemon.name) : pokemon.name != null) return false;
        if (nickname != null ? !nickname.equals(pokemon.nickname) : pokemon.nickname != null) return false;
        if (item != null ? !item.equals(pokemon.item) : pokemon.item != null) return false;
        if (ability != null ? !ability.equals(pokemon.ability) : pokemon.ability != null) return false;
        if (level != null ? !level.equals(pokemon.level) : pokemon.level != null) return false;
        if (gender != null ? !gender.equals(pokemon.gender) : pokemon.gender != null) return false;
        if (shiny != null ? !shiny.equals(pokemon.shiny) : pokemon.shiny != null) return false;
        if (nature != null ? !nature.equals(pokemon.nature) : pokemon.nature != null) return false;
        if (happiness != null ? !happiness.equals(pokemon.happiness) : pokemon.happiness != null) return false;
        if (hpEVs != null ? !hpEVs.equals(pokemon.hpEVs) : pokemon.hpEVs != null) return false;
        if (attackEVs != null ? !attackEVs.equals(pokemon.attackEVs) : pokemon.attackEVs != null) return false;
        if (defenceEVs != null ? !defenceEVs.equals(pokemon.defenceEVs) : pokemon.defenceEVs != null) return false;
        if (specialAttackEVs != null ? !specialAttackEVs.equals(pokemon.specialAttackEVs) : pokemon.specialAttackEVs != null)
            return false;
        if (specialDefenceEVs != null ? !specialDefenceEVs.equals(pokemon.specialDefenceEVs) : pokemon.specialDefenceEVs != null)
            return false;
        if (speedEVs != null ? !speedEVs.equals(pokemon.speedEVs) : pokemon.speedEVs != null) return false;
        if (hpIVs != null ? !hpIVs.equals(pokemon.hpIVs) : pokemon.hpIVs != null) return false;
        if (attackIVs != null ? !attackIVs.equals(pokemon.attackIVs) : pokemon.attackIVs != null) return false;
        if (defenceIVs != null ? !defenceIVs.equals(pokemon.defenceIVs) : pokemon.defenceIVs != null) return false;
        if (specialAttackIVs != null ? !specialAttackIVs.equals(pokemon.specialAttackIVs) : pokemon.specialAttackIVs != null)
            return false;
        if (specialDefenceIVs != null ? !specialDefenceIVs.equals(pokemon.specialDefenceIVs) : pokemon.specialDefenceIVs != null)
            return false;
        return speedIVs != null ? speedIVs.equals(pokemon.speedIVs) : pokemon.speedIVs == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (ability != null ? ability.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (shiny != null ? shiny.hashCode() : 0);
        result = 31 * result + (nature != null ? nature.hashCode() : 0);
        result = 31 * result + (happiness != null ? happiness.hashCode() : 0);
        result = 31 * result + (hpEVs != null ? hpEVs.hashCode() : 0);
        result = 31 * result + (attackEVs != null ? attackEVs.hashCode() : 0);
        result = 31 * result + (defenceEVs != null ? defenceEVs.hashCode() : 0);
        result = 31 * result + (specialAttackEVs != null ? specialAttackEVs.hashCode() : 0);
        result = 31 * result + (specialDefenceEVs != null ? specialDefenceEVs.hashCode() : 0);
        result = 31 * result + (speedEVs != null ? speedEVs.hashCode() : 0);
        result = 31 * result + (hpIVs != null ? hpIVs.hashCode() : 0);
        result = 31 * result + (attackIVs != null ? attackIVs.hashCode() : 0);
        result = 31 * result + (defenceIVs != null ? defenceIVs.hashCode() : 0);
        result = 31 * result + (specialAttackIVs != null ? specialAttackIVs.hashCode() : 0);
        result = 31 * result + (specialDefenceIVs != null ? specialDefenceIVs.hashCode() : 0);
        result = 31 * result + (speedIVs != null ? speedIVs.hashCode() : 0);
        return result;
    }

    public static final class PokemonBuilder {
        private Long id;
        // Pokemon Info
        private String name;
        private String nickname;
        private String item;
        private String ability;
        private Integer level;
        private String gender;
        private Boolean shiny;
        private String nature;
        private Integer happiness;
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

        public PokemonBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PokemonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PokemonBuilder withNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public PokemonBuilder withItem(String item) {
            this.item = item;
            return this;
        }

        public PokemonBuilder withAbility(String ability) {
            this.ability = ability;
            return this;
        }

        public PokemonBuilder withLevel(Integer level) {
            this.level = level;
            return this;
        }

        public PokemonBuilder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public PokemonBuilder withShiny(Boolean shiny) {
            this.shiny = shiny;
            return this;
        }

        public PokemonBuilder withNature(String nature) {
            this.nature = nature;
            return this;
        }

        public PokemonBuilder withHappiness(Integer happiness) {
            this.happiness = happiness;
            return this;
        }

        public PokemonBuilder withHpEVs(Integer hpEVs) {
            this.hpEVs = hpEVs;
            return this;
        }

        public PokemonBuilder withAttackEVs(Integer attackEVs) {
            this.attackEVs = attackEVs;
            return this;
        }

        public PokemonBuilder withDefenceEVs(Integer defenceEVs) {
            this.defenceEVs = defenceEVs;
            return this;
        }

        public PokemonBuilder withSpecialAttackEVs(Integer specialAttackEVs) {
            this.specialAttackEVs = specialAttackEVs;
            return this;
        }

        public PokemonBuilder withSpecialDefenceEVs(Integer specialDefenceEVs) {
            this.specialDefenceEVs = specialDefenceEVs;
            return this;
        }

        public PokemonBuilder withSpeedEVs(Integer speedEVs) {
            this.speedEVs = speedEVs;
            return this;
        }

        public PokemonBuilder withHpIVs(Integer hpIVs) {
            this.hpIVs = hpIVs;
            return this;
        }

        public PokemonBuilder withAttackIVs(Integer attackIVs) {
            this.attackIVs = attackIVs;
            return this;
        }

        public PokemonBuilder withDefenceIVs(Integer defenceIVs) {
            this.defenceIVs = defenceIVs;
            return this;
        }

        public PokemonBuilder withSpecialAttackIVs(Integer specialAttackIVs) {
            this.specialAttackIVs = specialAttackIVs;
            return this;
        }

        public PokemonBuilder withSpecialDefenceIVs(Integer specialDefenceIVs) {
            this.specialDefenceIVs = specialDefenceIVs;
            return this;
        }

        public PokemonBuilder withSpeedIVs(Integer speedIVs) {
            this.speedIVs = speedIVs;
            return this;
        }

        public Pokemon build() {
            Pokemon pokemon = new Pokemon();
            pokemon.setId(id);
            pokemon.setName(name);
            pokemon.setNickname(nickname);
            pokemon.setItem(item);
            pokemon.setAbility(ability);
            pokemon.setLevel(level);
            pokemon.setGender(gender);
            pokemon.setShiny(shiny);
            pokemon.setNature(nature);
            pokemon.setHappiness(happiness);
            pokemon.setHpEVs(hpEVs);
            pokemon.setAttackEVs(attackEVs);
            pokemon.setDefenceEVs(defenceEVs);
            pokemon.setSpecialAttackEVs(specialAttackEVs);
            pokemon.setSpecialDefenceEVs(specialDefenceEVs);
            pokemon.setSpeedEVs(speedEVs);
            pokemon.setHpIVs(hpIVs);
            pokemon.setAttackIVs(attackIVs);
            pokemon.setDefenceIVs(defenceIVs);
            pokemon.setSpecialAttackIVs(specialAttackIVs);
            pokemon.setSpecialDefenceIVs(specialDefenceIVs);
            pokemon.setSpeedIVs(speedIVs);
            return pokemon;
        }
    }
}
