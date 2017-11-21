# Populate Pokemon
INSERT INTO pokemon (
  name, nickname, item, ability, level,
  hp_evs, attack_evs, defence_evs, special_attack_evs, special_defence_evs, speed_evs,
  hp_ivs, attack_ivs, defence_ivs, special_attack_ivs, special_defence_ivs, speed_ivs
) VALUES
  (
      'Squirtle', 'Squirt', 'Choice Band', 'Hydration', 100,
      0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0
  ),
  (
      'Charmander', 'Char-Char', NULL, 'Blaze', 5,
      1, 2, 3, 4, 5, 6,
      1, 2, 3, 4, 5, 6
  ),
  (
      'Bulbasaur', 'Seed', 'Miracle Seed', 'Overgrow', 10,
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10
  ),
  (
      'Caterpie', NULL, NULL, 'Shield Dust', 1,
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10
  ),
  (
      'Aggron', NULL, 'Assault Vest', 'Sturdy', 100,
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10
  ),
  (
      'Chansey', NULL, 'Eviolite', 'Natural Cure', 100,
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10
  ),
  (
      'Tapu Bulu', NULL, NULL, 'Grassy Surge', 100,
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10
  );

# TODO: need to update this when changes to type & move happen for random pokemon
# Populate Random Pokemon
INSERT INTO random_pokemon (
  name, nickname, item, ability, level, type1, type2,
  hp, attack, defence, special_attack, special_defence, speed,
  move1, move2, move3, move4
) VALUES
  (
    'Squirtle', 'Squirt', 'Choice Band', 'Hydration', 100, 'Water', NULL,
    1, 2, 3, 4, 5, 6,
    'Bubble', 'Water Gun', 'Hydro Pump', 'Cut'
  ),
  (
    'Charmander', 'Char-Char', NULL, 'Blaze', 5, 'Fire', NULL,
    1, 2, 3, 4, 5, 6,
    'Scratch', 'Ember', 'Growl', NULL
  ),
  (
    'Bulbasaur', 'Seed', 'Miracle Seed', 'Overgrow', 10, 'Grass', 'Poison',
    1, 2, 3, 4, 5, 6,
    'Growl', 'Bullet Seed', 'Hidden Power', NULL
  ),
  (
    'Caterpie', NULL, NULL, 'Shield Dust', 1, 'Bug', NULL,
    1, 2, 3, 4, 5, 6,
    'String Shot', 'Tackle', NULL, NULL
  ),
  (
    'Aggron', NULL, 'Assault Vest', 'Sturdy', 100, 'Steel', 'Rock',
    1, 2, 3, 4, 5, 6,
    'Avalanche', 'Body Slam', 'Brick Break', 'Earthquake'
  ),
  (
    'Chansey', NULL, 'Eviolite', 'Natural Cure', 100, 'Normal', NULL,
    1, 2, 3, 4, 5, 6,
    'Seismic Toss', 'Counter', 'Hyper Voice', 'Heal Bell'
  ),
  (
    'Tapu Bulu', NULL, NULL, 'Grassy Surge', 100, 'Grass', 'Fairy',
    1, 2, 3, 4, 5, 6,
    'Horn Leech', 'Light Screen', 'Reflect', 'Roar'
  );

# Populate pokemon_types
INSERT INTO pokemon_type (name, slot, pokemon_id) VALUES
  ('Water', 1, 1),
  #
  ('Fire', 1, 2),
  #
  ('Grass', 1, 3),
  ('Poison', 2, 3),
  #
  ('Bug', 1, 4),
  #
  ('Steel', 1, 5),
  ('Rock', 2, 5),
  #
  ('Normal', 1, 6),
  #
  ('Fairy', 1, 7),
  ('Grass', 2, 7);

# Populate pokemon_moves
INSERT INTO pokemon_move (name, slot, pokemon_id) VALUES
  ('Bubble', 1, 1),
  ('Water Gun', 2, 1),
  ('Hydro Pump', 3, 1),
  ('Rapid Spin', 4, 1),
  #
  ('Ember', 1, 2),
  ('Flamethrower', 2, 2),
  ('Metal Claw', 3, 2),
  #
  ('Leech Seed', 1, 3),
  ('Toxic', 2, 3),
  ('Protect', 3, 3),
  ('Synthesis', 4, 3),
  #
  ('String Shot', 1, 4),
  ('Tackle', 2, 4),
  #
  ('Heavy Slam', 1, 5),
  ('Earthquake', 2, 5),
  ('Fire Blast', 3, 5),
  ('Surf', 4, 5),
  #
  ('Softboiled', 1, 6),
  ('Seismic Toss', 2, 6),
  ('Toxic', 3, 6),
  #
  ('Horn Leech', 1, 7),
  ('Bulk Up', 2, 7),
  ('Play Rough', 3, 7),
  ('Stone Edge', 4, 7);

# Populate Pokemon Teams
INSERT INTO pokemon_team (
  team_name, format, pokemon1_id, pokemon2_id, pokemon3_id, pokemon4_id, pokemon5_id, pokemon6_id
) VALUES
  (
      'Super Team', 'OU', 1, 2, 3, 4, 5, 6
  ),
  (
      'Small Team', 'NU', 7, 1, 3, 4, NULL, NULL
  ),
  (
      'No Format Team', NULL, 1, 2, 3, 6, 7, 5
  );