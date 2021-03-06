package service;

import data.RandomPokemon;
import dto.RandomPokemonDTO;
import factory.RandomPokemonDtoFactory;
import factory.RandomPokemonFactory;
import repository.RandomPokemonRepository;

public class RandomPokemonService {

    private final RandomPokemonRepository randomPokemonRepository;
    private final RandomPokemonFactory randomPokemonFactory;
    private final RandomPokemonDtoFactory randomPokemonDtoFactory;

    public RandomPokemonService(RandomPokemonRepository randomPokemonRepository,
                                RandomPokemonFactory randomPokemonFactory,
                                RandomPokemonDtoFactory randomPokemonDtoFactory) {
        this.randomPokemonRepository = randomPokemonRepository;
        this.randomPokemonFactory = randomPokemonFactory;
        this.randomPokemonDtoFactory = randomPokemonDtoFactory;
    }

    /**
     * Gets a RandomPokemonDTO by its database id
     * @param id
     *  The RandomPokemon's id.
     * @return
     *  A RandomPokemonDTO with values filled from the database.
     */
    public RandomPokemonDTO getRandomPokemonById(Long id) {
        RandomPokemon randomPokemon = randomPokemonRepository.getRandomPokemonById(id);
        if (randomPokemon == null) {
            return null;
        }
        return randomPokemonDtoFactory.createRandomPokemonDTO(randomPokemon);
    }

    /**
     * Persists a RandomPokemon based off of the given RandomPokemonDTO object.
     * @param randomPokemonDTO
     *  The RandomPokemonDTO object that will be persisted.
     * @return
     *  The persisted RandomPokemonDTO.
     */
    public RandomPokemonDTO createRandomPokemon(RandomPokemonDTO randomPokemonDTO) {
        RandomPokemon randomPokemon = randomPokemonFactory.createRandomPokemon(randomPokemonDTO);
        randomPokemon = randomPokemonRepository.saveRandomPokemon(randomPokemon);
        if (randomPokemon == null) {
            return null;
        }
        randomPokemonDTO.setId(randomPokemon.getId());
        return randomPokemonDTO;
    }
}
