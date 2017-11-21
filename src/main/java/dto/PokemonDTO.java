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

        if (types.isEmpty()) {
            errors.add(new ErrorDTO("types", "attribute was not given, types must be provided"));
        }

        if (!types.isEmpty()) {
            for (int i = 0; i < types.size(); i++) {
                try {
                    Type.valueOf(types.get(i).toUpperCase());
                } catch (IllegalArgumentException e) {
                    errors.add(new ErrorDTO("type" + i, invalidType));
                }
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

        if (moves.isEmpty()) {
            errors.add(new ErrorDTO("moves", "a pokemon must have atleast one move"));
        }

        return errors;
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

    @Override
    public String toString() {
        return "PokemonDTO{" +
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
                ", types=" + types +
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
                ", moves=" + moves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonDTO that = (PokemonDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (ability != null ? !ability.equals(that.ability) : that.ability != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (shiny != null ? !shiny.equals(that.shiny) : that.shiny != null) return false;
        if (nature != null ? !nature.equals(that.nature) : that.nature != null) return false;
        if (happiness != null ? !happiness.equals(that.happiness) : that.happiness != null) return false;
        if (types != null ? !types.equals(that.types) : that.types != null) return false;
        if (hpEVs != null ? !hpEVs.equals(that.hpEVs) : that.hpEVs != null) return false;
        if (attackEVs != null ? !attackEVs.equals(that.attackEVs) : that.attackEVs != null) return false;
        if (defenceEVs != null ? !defenceEVs.equals(that.defenceEVs) : that.defenceEVs != null) return false;
        if (specialAttackEVs != null ? !specialAttackEVs.equals(that.specialAttackEVs) : that.specialAttackEVs != null)
            return false;
        if (specialDefenceEVs != null ? !specialDefenceEVs.equals(that.specialDefenceEVs) : that.specialDefenceEVs != null)
            return false;
        if (speedEVs != null ? !speedEVs.equals(that.speedEVs) : that.speedEVs != null) return false;
        if (hpIVs != null ? !hpIVs.equals(that.hpIVs) : that.hpIVs != null) return false;
        if (attackIVs != null ? !attackIVs.equals(that.attackIVs) : that.attackIVs != null) return false;
        if (defenceIVs != null ? !defenceIVs.equals(that.defenceIVs) : that.defenceIVs != null) return false;
        if (specialAttackIVs != null ? !specialAttackIVs.equals(that.specialAttackIVs) : that.specialAttackIVs != null)
            return false;
        if (specialDefenceIVs != null ? !specialDefenceIVs.equals(that.specialDefenceIVs) : that.specialDefenceIVs != null)
            return false;
        if (speedIVs != null ? !speedIVs.equals(that.speedIVs) : that.speedIVs != null) return false;
        return moves != null ? moves.equals(that.moves) : that.moves == null;
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
        result = 31 * result + (types != null ? types.hashCode() : 0);
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
        result = 31 * result + (moves != null ? moves.hashCode() : 0);
        return result;
    }

    public static final class PokemonDTOBuilder {
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

        public PokemonDTOBuilder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public PokemonDTOBuilder withShiny(Boolean shiny) {
            this.shiny = shiny;
            return this;
        }

        public PokemonDTOBuilder withNature(String nature) {
            this.nature = nature;
            return this;
        }

        public PokemonDTOBuilder withHappiness(Integer happiness) {
            this.happiness = happiness;
            return this;
        }

        public PokemonDTOBuilder withTypes(List<String> types) {
            this.types = types;
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

        public PokemonDTOBuilder withMoves(List<String> moves) {
            this.moves = moves;
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
            pokemonDTO.setGender(gender);
            pokemonDTO.setShiny(shiny);
            pokemonDTO.setNature(nature);
            pokemonDTO.setHappiness(happiness);
            pokemonDTO.setTypes(types);
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
            pokemonDTO.setMoves(moves);
            return pokemonDTO;
        }
    }
}
