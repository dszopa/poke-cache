[![Build Status](https://travis-ci.org/dszopa/poke-cache.svg?branch=master)](https://travis-ci.org/dszopa/poke-cache)
[![codecov](https://codecov.io/gh/dszopa/poke-cache/branch/master/graph/badge.svg)](https://codecov.io/gh/dszopa/poke-cache)

# Poke-Cache

### Functionality
- [x] Storing & Retrieval of Pokemon
- [x] Storing & Retrieval of Pokemon Teams
- [x] Storing & Retrieval of Text Pokemon
- [x] Storing & Retrieval of Random Pokemon
- [ ] Storing & Retrieval of Text Pokemon Teams
- [ ] Conversion of Pokemon & Pokemon Teams to Text Form
- [ ] Team Analysis - Strengths & Weaknesses - Team
- [ ] Team Analysis - Strengths & Weaknesses - Individual Pokemon
- [ ] Team Analysis - Vs Popular metagame (Smogon Sets)
- [ ] Scripts to gather Pokemon Data
- [ ] Generate Random Pokemon Sets
- [ ] /documentation Page

### Setup
1. `git clone https://github.com/dszopa/poke-cache.git`
2.  `cd poke-cache`
3. `./gradlew jar`
4. `java -jar build/libs/poke-cache-0.0.0.jar`


### TODO
- Make sure nulls can't be returned, Spark returns 404 if you return null in a controller.
