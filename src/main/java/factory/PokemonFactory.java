package factory;

import data.Pokemon;
import dto.PokemonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokemonFactory {

    private final static Logger logger = LoggerFactory.getLogger(PokemonFactory.class);

    public Pokemon createPokemon(PokemonDTO pokemonDTO) {
        return new Pokemon.PokemonBuilder()
                .withId(pokemonDTO.getId())
                .withName(pokemonDTO.getName())
                .withNickname(pokemonDTO.getNickname())
                .withItem(pokemonDTO.getItem())
                .withAbility(pokemonDTO.getAbility())
                .withLevel(pokemonDTO.getLevel())
                .withGender(pokemonDTO.getGender())
                .withShiny(pokemonDTO.getShiny())
                .withNature(pokemonDTO.getNature())
                .withHappiness(pokemonDTO.getHappiness())
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
                .build();
    }
}
