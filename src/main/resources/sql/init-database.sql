# Create pokemon table
CREATE TABLE pokemon (
  id BIGINT KEY AUTO_INCREMENT,
  name VARCHAR(255),
  nickname VARCHAR(255),
  item VARCHAR(255),
  ability VARCHAR(255),
  level INT,
  gender VARCHAR(255),
  shiny BOOLEAN,
  nature VARCHAR(255),
  happiness INT,
  hp_evs INT,
  attack_evs INT,
  defence_evs INT,
  special_attack_evs INT,
  special_defence_evs INT,
  speed_evs INT,
  hp_ivs INT,
  attack_ivs INT,
  defence_ivs INT,
  special_attack_ivs INT,
  special_defence_ivs INT,
  speed_ivs INT
);

# TODO change to use pokemon_type
# Create random_pokemon table
CREATE TABLE random_pokemon (
  id BIGINT KEY AUTO_INCREMENT,
  name VARCHAR(255),
  item VARCHAR(255),
  ability VARCHAR(255),
  level INT,
  type1 VARCHAR(255),
  type2 VARCHAR(255),
  hp INT,
  attack INT,
  defence INT,
  special_attack INT,
  special_defence INT,
  speed INT,
  move1 VARCHAR(255),
  move2 VARCHAR(255),
  move3 VARCHAR(255),
  move4 VARCHAR(255)
);

# Create Pokemon Type Table
CREATE TABLE pokemon_type (
  id BIGINT KEY AUTO_INCREMENT,
  name VARCHAR(255),
  slot INT,
  pokemon_id BIGINT,
  FOREIGN KEY (pokemon_id) REFERENCES pokemon(id)
);

# Create Pokemon Move Table
CREATE TABLE pokemon_move (
  id BIGINT KEY AUTO_INCREMENT,
  name VARCHAR(255),
  slot INT,
  pokemon_id BIGINT,
  FOREIGN KEY (pokemon_id) references pokemon(id)
);

# Create pokemon_team table
CREATE TABLE pokemon_team (
  id BIGINT KEY AUTO_INCREMENT,
  team_name VARCHAR(255),
  format VARCHAR(255),
  pokemon1_id BIGINT,
  pokemon2_id BIGINT,
  pokemon3_id BIGINT,
  pokemon4_id BIGINT,
  pokemon5_id BIGINT,
  pokemon6_id BIGINT,
  FOREIGN KEY (pokemon1_id) REFERENCES pokemon(id),
  FOREIGN KEY (pokemon2_id) REFERENCES pokemon(id),
  FOREIGN KEY (pokemon3_id) REFERENCES pokemon(id),
  FOREIGN KEY (pokemon4_id) REFERENCES pokemon(id),
  FOREIGN KEY (pokemon5_id) REFERENCES pokemon(id),
  FOREIGN KEY (pokemon6_id) REFERENCES pokemon(id)
);