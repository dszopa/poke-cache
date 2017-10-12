package factory;

import data.RandomPokemon;
import dto.RandomPokemonDTO;

public class RandomPokemonDtoFactory {

    public RandomPokemonDTO createRandomPokemonDTO(RandomPokemon randomPokemon) {
        return new RandomPokemonDTO(randomPokemon.getId(), randomPokemon.getName(), randomPokemon.getNickname(),
                randomPokemon.getItem(), randomPokemon.getAbility(), randomPokemon.getLevel(), randomPokemon.getType1(),
                randomPokemon.getType2(), randomPokemon.getHp(), randomPokemon.getAttack(), randomPokemon.getDefence(),
                randomPokemon.getSpecialAttack(), randomPokemon.getSpecialDefence(), randomPokemon.getSpeed(),
                randomPokemon.getMove1(), randomPokemon.getMove2(), randomPokemon.getMove3(), randomPokemon.getMove4());
    }
}
