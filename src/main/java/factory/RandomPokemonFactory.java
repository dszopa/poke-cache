package factory;

import data.RandomPokemon;
import dto.RandomPokemonDTO;

public class RandomPokemonFactory {

    public RandomPokemon createRandomPokemon(RandomPokemonDTO randomPokemonDTO) {
        return new RandomPokemon(randomPokemonDTO.getId(), randomPokemonDTO.getName(), randomPokemonDTO.getNickname(),
                randomPokemonDTO.getItem(), randomPokemonDTO.getAbility(), randomPokemonDTO.getLevel(),
                randomPokemonDTO.getType1(), randomPokemonDTO.getType2(), randomPokemonDTO.getHp(),
                randomPokemonDTO.getAttack(), randomPokemonDTO.getDefence(), randomPokemonDTO.getSpecialAttack(),
                randomPokemonDTO.getSpecialDefence(), randomPokemonDTO.getSpeed(), randomPokemonDTO.getMove1(),
                randomPokemonDTO.getMove2(), randomPokemonDTO.getMove3(), randomPokemonDTO.getMove4());
    }
}
