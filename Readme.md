# Conway's Game of Life

## Overview

Conway's Game of Life is a cellular automaton devised by the mathematician John Conway. It simulates a universe made of an infinite two-dimensional orthogonal grid of square cells. Each cell can be in one of two states: alive or dead. The state of the cells evolves through discrete time steps based on a set of rules related to the states of neighboring cells.

This Java implementation supports both finite and infinite universes and is structured using SOLID principles to ensure clean, maintainable, and extensible code.

## Core Features

- *Finite and Infinite Grid Modes:* Configurable via UniverseMode (FINITE or INFINITE).
- *Tick-based Evolution:* Simulation progresses generation by generation.
- *Pluggable Strategy:* Game evolution logic is abstracted using the EvolutionStrategy interface.
- *Multiple Patterns Supported:* Patterns like Glider, LWSS etc. using PatternHelper.
- *Renderer Abstraction:* Console-based rendering with the option to plug in future UI renderers.
- *Test Coverage:* Comprehensive unit tests using JUnit 5.

## Architecture

### Key Classes

`Game:` Main simulation loop.

`ClassicGameOfLife:` Default rule implementation of Conway's Game of Life.

`Board:` Maintains the state of live cells and bounds.

`Cell:` Represents coordinates of a single cell.


## Setup Instructions

### Requirements
- Java 21
- Maven for building

### Running the Project

#### via Terminal
1. Clone the repository or download the source.
2. Clean install `mvn clean install`
3. Run the fat jar. `java -jar chargepoint-1.0.0-fat.jar`
4. Output can be seen in the console.

#### via Docker
1. Clone the repository or download the source.
2. cd ops
3. docker compose build --no-cache
4. docker compose up

