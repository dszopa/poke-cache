package factory;

import data.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PokemonFactory {

    private final static Logger logger = LoggerFactory.getLogger(PokemonFactory.class);

    public Pokemon createPokemonFromResultSet(ResultSet rs) {
        try {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String nickname = rs.getString("nickname");
            String item = rs.getString("item");
            String ability = rs.getString("ability");
            int level = rs.getInt("level");
            String type1 = rs.getString("type1");
            String type2 = rs.getString("type2");
            int hpEVs = rs.getInt("hp_evs");
            int attackEVs = rs.getInt("attack_evs");
            int defenceEVs = rs.getInt("defence_evs");
            int specialAttackEVs = rs.getInt("special_attack_evs");
            int specialDefenceEVs = rs.getInt("special_defence_evs");
            int speedEVs = rs.getInt("speed_evs");
            int hpIVs = rs.getInt("hp_ivs");
            int attackIVs = rs.getInt("attack_ivs");
            int defenceIVs = rs.getInt("defence_ivs");
            int specialAttackIVs = rs.getInt("special_attack_ivs");
            int specialDefenceIVs = rs.getInt("special_defence_ivs");
            int speedIVs = rs.getInt("speed_ivs");
            String move1 = rs.getString("move1");
            String move2 = rs.getString("move2");
            String move3 = rs.getString("move3");
            String move4 = rs.getString("move4");

            return new Pokemon(id, name, nickname, item, ability, level, type1, type2,
                    hpEVs, attackEVs, defenceEVs, specialAttackEVs, specialDefenceEVs, speedEVs,
                    hpIVs, attackIVs, defenceIVs, specialAttackIVs, specialDefenceIVs, speedIVs,
                    move1, move2, move3, move4);

        } catch (SQLException e) {
            logger.error("Unable to create Pokemon object from ResultSet", e);
            return null;
        }
    }
}
