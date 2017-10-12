package factory;

import data.Pokemon;
import dto.PokemonDTO;

public class PokemonFactory {

    public Pokemon createPokemon(PokemonDTO pokemonDTO) {
        return new Pokemon(pokemonDTO.getId(), pokemonDTO.getName(), pokemonDTO.getNickname(), pokemonDTO.getItem(),
                pokemonDTO.getAbility(), pokemonDTO.getLevel(), pokemonDTO.getType1(), pokemonDTO.getType2(),
                pokemonDTO.getHpEVs(), pokemonDTO.getAttackEVs(), pokemonDTO.getDefenceEVs(),
                pokemonDTO.getSpecialAttackEVs(), pokemonDTO.getSpecialDefenceEVs(), pokemonDTO.getSpeedEVs(),
                pokemonDTO.getHpIVs(), pokemonDTO.getAttackIVs(), pokemonDTO.getDefenceIVs(),
                pokemonDTO.getSpecialAttackIVs(), pokemonDTO.getSpecialDefenceIVs(), pokemonDTO.getSpeedIVs(),
                pokemonDTO.getMove1(), pokemonDTO.getMove2(), pokemonDTO.getMove3(), pokemonDTO.getMove4());
    }
}
