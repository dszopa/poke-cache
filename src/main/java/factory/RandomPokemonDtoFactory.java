package factory;

import data.RandomPokemon;
import dto.RandomPokemonDTO;

public class RandomPokemonDtoFactory {

    public RandomPokemonDTO createRandomPokemonDTO(RandomPokemon randomPokemon) {
        return new RandomPokemonDTO.RandomPokemonDTOBuilder()
                .withId(randomPokemon.getId())
                .withName(randomPokemon.getName())
                .withItem(randomPokemon.getItem())
                .withAbility(randomPokemon.getAbility())
                .withLevel(randomPokemon.getLevel())
                .withType1(randomPokemon.getType1())
                .withType2(randomPokemon.getType2())
                .withHp(randomPokemon.getHp())
                .withAttack(randomPokemon.getAttack())
                .withDefence(randomPokemon.getDefence())
                .withSpecialAttack(randomPokemon.getSpecialAttack())
                .withSpecialDefence(randomPokemon.getSpecialDefence())
                .withSpeed(randomPokemon.getSpeed())
                .withMove1(randomPokemon.getMove1())
                .withMove2(randomPokemon.getMove2())
                .withMove3(randomPokemon.getMove3())
                .withMove4(randomPokemon.getMove4())
                .build();
    }
}
