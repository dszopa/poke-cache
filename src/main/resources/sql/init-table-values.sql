# Populate Pokemon
INSERT INTO pokemon (
  name, nickname, item, ability, level, type1, type2,
  hp_evs, attack_evs, defence_evs, special_attack_evs, special_defence_evs, speed_evs,
  hp_ivs, attack_ivs, defence_ivs, special_attack_ivs, special_defence_ivs, speed_ivs,
  move1, move2, move3, move4
) VALUES
  (
      'Squirtle', 'Squirt', 'Choice Band', 'Hydration', 100, 'Water', NULL,
      0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0,
      'Bubble', 'Water Gun', 'Hydro Pump', 'Cut'
  ),
  (
      'Charmander', 'Char-Char', NULL, 'Blaze', 5, 'Fire', NULL,
      1, 2, 3, 4, 5, 6,
      1, 2, 3, 4, 5, 6,
      'Scratch', 'Ember', 'Growl', NULL
  ),
  (
      'Bulbasaur', 'Seed', 'Miracle Seed', 'Overgrow', 10, 'Grass', 'Poison',
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10,
      'Growl', 'Bullet Seed', 'Hidden Power', NULL
  ),
  (
      'Caterpie', NULL, NULL, 'Shield Dust', 1, 'Bug', NULL,
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10,
      'String Shot', 'Tackle', NULL, NULL
  ),
  (
      'Aggron', NULL, 'Assault Vest', 'Sturdy', 100, 'Steel', 'Rock',
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10,
      'Avalanche', 'Body Slam', 'Brick Break', 'Earthquake'
  ),
  (
      'Chansey', NULL, 'Eviolite', 'Natural Cure', 100, 'Normal', NULL,
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10,
      'Seismic Toss', 'Counter', 'Hyper Voice', 'Heal Bell'
  ),
  (
      'Tapu Bulu', NULL, NULL, 'Grassy Surge', 100, 'Grass', 'Fairy',
      10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10,
      'Horn Leech', 'Light Screen', 'Reflect', 'Roar'
  );

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