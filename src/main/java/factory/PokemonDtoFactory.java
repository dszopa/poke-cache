package factory;

import data.Pokemon;
import dto.PokemonDTO;

public class PokemonDtoFactory {

    public PokemonDTO createFromPokemon(Pokemon pokemon) {
        return new PokemonDTO(pokemon.getId(), pokemon.getName(), pokemon.getNickname(), pokemon.getItem(),
                pokemon.getAbility(), pokemon.getLevel(), pokemon.getType1(), pokemon.getType2(), pokemon.getHpEVs(),
                pokemon.getAttackEVs(), pokemon.getDefenceEVs(), pokemon.getSpecialAttackEVs(),
                pokemon.getSpecialDefenceEVs(), pokemon.getSpeedEVs(), pokemon.getHpIVs(), pokemon.getAttackIVs(),
                pokemon.getDefenceIVs(), pokemon.getSpecialAttackIVs(), pokemon.getSpecialDefenceIVs(),
                pokemon.getSpeedIVs(), pokemon.getMove1(), pokemon.getMove2(), pokemon.getMove3(), pokemon.getMove4());
    }
}
