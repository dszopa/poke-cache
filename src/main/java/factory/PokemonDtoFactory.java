package factory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.Pokemon;
import dto.PokemonDTO;
import dto.TextPokemonDTO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;

import static constant.RegExps.*;

public class PokemonDtoFactory {

    private final static Logger logger = LoggerFactory.getLogger(PokemonDtoFactory.class);
    private final HttpClientFactory httpClientFactory;

    public PokemonDtoFactory(HttpClientFactory httpClientFactory) {
        this.httpClientFactory = httpClientFactory;
    }

    public PokemonDTO createPokemonDTO(Pokemon pokemon, List<String> types, List<String> moves) {
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
                .withTypes(types)
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
                .withMoves(moves)
                .build();
    }

    public PokemonDTO createPokemonDTO(TextPokemonDTO textPokemonDTO) {
        Long id = null;
        String name = "";
        String nicknameString = "";
        String itemString = "";
        String ability = "";
        Integer level = 100;
        String genderString = "";
        Boolean shiny = false;
        String nature = "Serious";
        Integer happiness = 255;
        List<String> types = new ArrayList<>();
        Integer hpEVs = 0;
        Integer attackEVs = 0;
        Integer defenceEVs = 0;
        Integer specialAttackEVs = 0;
        Integer specialDefenceEVs = 0;
        Integer speedEVs = 0;
        Integer hpIVs = 0;
        Integer attackIVs = 0;
        Integer defenceIVs = 0;
        Integer specialAttackIVs = 0;
        Integer specialDefenceIVs = 0;
        Integer speedIVs = 0;
        List<String> moves = new ArrayList<>();

        Scanner scanner = new Scanner(textPokemonDTO.getText());
        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher;
            if (count == 0) {
                if ((matcher = nicknameGenderItem.matcher(line)).find()) {
                    nicknameString = line.substring(0, matcher.end(1)).trim();
                    name = line.substring(matcher.start(2) + 2, matcher.end(2) -1).trim();
                    genderString = line.substring(matcher.start(4) + 2, matcher.end(4) - 1).trim();
                    itemString = line.substring(matcher.end(6), matcher.end(7)).trim();
                } else if ((matcher = nicknameGender.matcher(line)).find()) {
                    nicknameString = line.substring(0, matcher.end(1)).trim();
                    name = line.substring(matcher.start(2) + 2, matcher.end(2) - 1).trim();
                    genderString = line.substring(matcher.start(4) + 2, matcher.end(4) - 1).trim();
                } else if ((matcher = nicknameItem.matcher(line)).find()) {
                    nicknameString = line.substring(0, matcher.end(1)).trim();
                    name = line.substring(matcher.start(2) + 2, matcher.end(2) - 1).trim();
                    itemString = line.substring(matcher.end(5), matcher.end(6)).trim();
                } else if ((matcher = nickname.matcher(line)).find()) {
                    nicknameString = line.substring(0, matcher.end(1)).trim();
                    name = line.substring(matcher.start(2) + 2, matcher.end(2) - 1).trim();
                } else if (genderItem.matcher(line).find()) {
                    name = line.substring(0, matcher.end(1)).trim();
                    genderString = line.substring(matcher.start(2) + 2, matcher.end(2) - 1).trim();
                    itemString = line.substring(matcher.end(4), matcher.end(5)).trim();
                } else if (gender.matcher(line).find()) {
                    name = line.substring(0, matcher.end(1)).trim();
                    genderString = line.substring(matcher.start(2) + 2, matcher.end(2) - 1).trim();
                } else if (item.matcher(line).find()) {
                    name = line.substring(0, matcher.end(1)).trim();
                    itemString = line.substring(matcher.end(2), matcher.end(3)).trim();
                } else { // Has to be just PokemonName
                    name = line.trim();
                }
            } else if (line.contains("Ability: ")) {
                ability = line.substring(9, line.length()).trim();
            } else if (line.contains("Level: ")) {
                level = Integer.parseInt(line.substring(7, line.length()).trim());
            } else if (line.contains("Shiny: ")) {
                shiny = line.substring(7, line.length()).trim().toUpperCase().equals("YES");
            } else if (line.contains("Happiness: ")) {
                happiness = Integer.parseInt(line.substring(11, line.length()).trim());
            } else if (line.contains("EVs: ")) {
                Scanner innerScan = new Scanner(line);
                innerScan.next();

                while (innerScan.hasNext()) {
                    int value = Integer.parseInt(innerScan.next());
                    String stat = innerScan.next();

                    // If not the end, go one more
                    if (innerScan.hasNext()) {
                        innerScan.next();
                    }

                    if (stat.equals("HP")) {
                        hpEVs = value;
                    } else if (stat.equals("Atk")) {
                        attackEVs = value;
                    } else if (stat.equals("Def")) {
                        defenceEVs = value;
                    } else if (stat.equals("SpA")) {
                        specialAttackEVs = value;
                    } else if ( stat.equals("SpD")) {
                        specialDefenceEVs = value;
                    } else if (stat.equals("Spe")) {
                        speedEVs = value;
                    }
                }
            } else if (line.contains("Nature")) {
                Scanner innerScan = new Scanner(line);
                nature = innerScan.next();
            } else if (line.contains("IVs")) {
                Scanner innerScan = new Scanner(line);
                innerScan.next();

                while (innerScan.hasNext()) {
                    int value = Integer.parseInt(innerScan.next());
                    String stat = innerScan.next();

                    // If not the end, go one more
                    if (innerScan.hasNext()) {
                        innerScan.next();
                    }

                    if (stat.equals("HP")) {
                        hpIVs = value;
                    } else if (stat.equals("Atk")) {
                        attackIVs = value;
                    } else if (stat.equals("Def")) {
                        defenceIVs = value;
                    } else if (stat.equals("SpA")) {
                        specialAttackIVs = value;
                    } else if (stat.equals("SpD")) {
                        specialDefenceIVs = value;
                    } else if (stat.equals("Spe")) {
                        speedIVs = value;
                    }
                }
            } else if (line.contains("- ")) {
                moves.add(line.substring(1, line.length()).trim());
            } else {
                logger.error("Invalid line found. Line: " + line);
            }

            count++;
        }

        if (!name.isEmpty()) {
            types = _getTypes(name);
        }

        return new PokemonDTO.PokemonDTOBuilder()
                .withId(id)
                .withName(name)
                .withNickname(nicknameString)
                .withItem(itemString)
                .withAbility(ability)
                .withLevel(level)
                .withGender(genderString)
                .withShiny(shiny)
                .withNature(nature)
                .withHappiness(happiness)
                .withTypes(types)
                .withHpEVs(hpEVs)
                .withAttackEVs(attackEVs)
                .withDefenceEVs(defenceEVs)
                .withSpecialAttackEVs(specialAttackEVs)
                .withSpecialDefenceEVs(specialDefenceEVs)
                .withSpeedEVs(speedEVs)
                .withHpIVs(hpIVs)
                .withAttackIVs(attackIVs)
                .withDefenceIVs(defenceIVs)
                .withSpecialAttackIVs(specialAttackIVs)
                .withSpecialDefenceIVs(specialDefenceIVs)
                .withSpeedIVs(speedIVs)
                .withMoves(moves)
                .build();
    }

    private List<String> _getTypes(String pokemonName) {
        List<String> types = new ArrayList<>();
        Map<Integer, String> typeMap = new HashMap<>();
        try {
            HttpGet httpGet = new HttpGet("http://pokeapi.co/api/v2/pokemon/" + pokemonName.toLowerCase());
            HttpResponse httpResponse = httpClientFactory.getHttpClient().execute(httpGet);

            HttpEntity httpEntity = httpResponse.getEntity();

            if (httpEntity != null) {
                String retStr = EntityUtils.toString(httpEntity);
                JsonObject jsonObject = new JsonParser().parse(retStr).getAsJsonObject();
                JsonArray typesArray = jsonObject.getAsJsonArray("types");

                for (int i = 0; i < typesArray.size(); i++) {
                    Integer slot = typesArray.get(i).getAsJsonObject().getAsJsonPrimitive("slot").getAsInt();
                    String typeName = typesArray.get(i).getAsJsonObject().getAsJsonObject("type").get("name")
                            .getAsString().toUpperCase();
                    typeMap.put(slot, typeName);
                }
            }

            String type1;
            if ((type1 = typeMap.get(1)) != null) {
                types.add(type1);
            }

            String type2;
            if ((type2 = typeMap.get(2)) != null) {
                types.add(type2);
            }

            return types;

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
