package factory;

import data.Pokemon;
import dto.PokemonDTO;

public class PokemonDtoFactory {

    public PokemonDTO createPokemonDTO(Pokemon pokemon) {
        return new PokemonDTO.PokemonDTOBuilder()
                .withId(pokemon.getId())
                .withName(pokemon.getName())
                .withNickname(pokemon.getNickname())
                .withItem(pokemon.getItem())
                .withAbility(pokemon.getAbility())
                .withLevel(pokemon.getLevel())
                .withType1(pokemon.getType1())
                .withType2(pokemon.getType2())
                .withHpEVs(pokemon.getHpEVs())
                .withAttackEVs(pokemon.getAttackEVs())
                .withDefenceEVs(pokemon.getDefenceEVs())
                .withSpecialAttackEVs(pokemon.getSpecialAttackEVs())
                .withSpecialDefenceEVs(pokemon.getSpecialDefenceEVs())
                .withSpeedEVs(pokemon.getSpeedEVs())
                .withHpIVs(pokemon.getHpIVs())
                .withAttackIVs(pokemon.getAttackIVs())
                .withDefenceIVs(pokemon.getDefenceIVs())
                .withSpecialAttackIVs(pokemon.getSpecialAttackIVs())
                .withSpecialDefenceIVs(pokemon.getSpecialDefenceIVs())
                .withSpeedIVs(pokemon.getSpeedIVs())
                .withMove1(pokemon.getMove1())
                .withMove2(pokemon.getMove2())
                .withMove3(pokemon.getMove3())
                .withMove4(pokemon.getMove4())
                .build();
    }
}
