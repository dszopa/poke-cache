package factory;

import data.RandomPokemon;
import dto.RandomPokemonDTO;

public class RandomPokemonFactory {

    public RandomPokemon createRandomPokemon(RandomPokemonDTO randomPokemonDTO) {
        return new RandomPokemon.RandomPokemonBuilder()
                .withId(randomPokemonDTO.getId())
                .withName(randomPokemonDTO.getName())
                .withNickname(randomPokemonDTO.getNickname())
                .withItem(randomPokemonDTO.getItem())
                .withAbility(randomPokemonDTO.getAbility())
                .withLevel(randomPokemonDTO.getLevel())
                .withType1(randomPokemonDTO.getType1())
                .withType2(randomPokemonDTO.getType2())
                .withHp(randomPokemonDTO.getHp())
                .withAttack(randomPokemonDTO.getAttack())
                .withDefence(randomPokemonDTO.getDefence())
                .withSpecialAttack(randomPokemonDTO.getSpecialAttack())
                .withSpecialDefence(randomPokemonDTO.getSpecialDefence())
                .withSpeed(randomPokemonDTO.getSpeed())
                .withMove1(randomPokemonDTO.getMove1())
                .withMove2(randomPokemonDTO.getMove2())
                .withMove3(randomPokemonDTO.getMove3())
                .withMove4(randomPokemonDTO.getMove4())
                .build();
    }
}
