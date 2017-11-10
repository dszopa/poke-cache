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
                .withGender(pokemon.getGender())
                .withShiny(pokemon.getShiny())
                .withNature(pokemon.getNature())
                .withHappiness(pokemon.getHappiness())
                .withTypes(pokemon.getTypes())
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
                .withMoves(pokemon.getMoves())
                .build();
    }
}
