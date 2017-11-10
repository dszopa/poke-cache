package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    // Typing
    private List<String> types = new ArrayList<>();

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
    private List<String> moves = new ArrayList<>();

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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
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

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
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
        // Typing
        private List<String> types = new ArrayList<>();
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
        private List<String> moves = new ArrayList<>();

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

        public PokemonBuilder withTypes(List<String> types) {
            this.types = types;
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

        public PokemonBuilder withMoves(List<String> moves) {
            this.moves = moves;
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
            pokemon.setTypes(types);
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
            pokemon.setMoves(moves);
            return pokemon;
        }
    }
}
