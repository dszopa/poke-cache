package factory;

import data.Pokemon;
import dto.PokemonDTO;

public class PokemonFactory {

    public Pokemon createPokemon(PokemonDTO pokemonDTO) {
        return new Pokemon.PokemonBuilder()
                .withId(pokemonDTO.getId())
                .withName(pokemonDTO.getName())
                .withNickname(pokemonDTO.getNickname())
                .withItem(pokemonDTO.getItem())
                .withAbility(pokemonDTO.getAbility())
                .withLevel(pokemonDTO.getLevel())
                .withType1(pokemonDTO.getType1())
                .withType2(pokemonDTO.getType2())
                .withHpEVs(pokemonDTO.getHpEVs())
                .withAttackEVs(pokemonDTO.getAttackEVs())
                .withDefenceEVs(pokemonDTO.getDefenceEVs())
                .withSpecialAttackEVs(pokemonDTO.getSpecialAttackEVs())
                .withSpecialDefenceEVs(pokemonDTO.getSpecialDefenceEVs())
                .withSpeedEVs(pokemonDTO.getSpeedEVs())
                .withHpIVs(pokemonDTO.getHpIVs())
                .withAttackIVs(pokemonDTO.getAttackIVs())
                .withDefenceIVs(pokemonDTO.getDefenceIVs())
                .withSpecialAttackIVs(pokemonDTO.getSpecialAttackIVs())
                .withSpecialDefenceIVs(pokemonDTO.getSpecialDefenceIVs())
                .withSpeedIVs(pokemonDTO.getSpeedIVs())
                .withMove1(pokemonDTO.getMove1())
                .withMove2(pokemonDTO.getMove2())
                .withMove3(pokemonDTO.getMove3())
                .withMove4(pokemonDTO.getMove4())
                .build();
    }
}
