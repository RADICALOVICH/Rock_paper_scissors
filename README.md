# Rock Paper Scissors

A simple console-based Rock Paper Scissors game implemented in Java. Play against the computer in multiple rounds and track your statistics.

## About

This is a classic Rock Paper Scissors game where you play against a computer opponent. The game features:
- Multiple rounds gameplay
- Win/loss/draw statistics tracking
- Simple console interface
- Clean, testable architecture

## Project Structure

```
src/
├── main/java/vp/rockpaperscissors/
│   ├── Main.java          # Console interface and game loop
│   ├── Game.java          # Core game logic and statistics
│   ├── Move.java          # Enum for game moves (Rock, Paper, Scissors)
│   └── GameResult.java    # Enum for game outcomes (Win, Lose, Draw)
└── test/java/vp/rockpaperscissors/
    ├── MoveTest.java      # Tests for Move logic
    ├── GameTest.java      # Tests for Game logic
    └── GameResultTest.java # Tests for GameResult
```

## How It Works

1. **Move** - Represents the three possible moves (Rock, Paper, Scissors) with logic to determine which move beats another.

2. **GameResult** - Represents the three possible outcomes of a round (Win, Lose, Draw).

3. **Game** - Core game engine that:
   - Generates random computer moves
   - Determines the result of each round
   - Tracks statistics (wins, losses, draws)

4. **Main** - Console interface that:
   - Prompts the user for their move
   - Displays the results
   - Shows running statistics
   - Allows continuous gameplay until the user quits

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Building the Project

To build the project, run:

```bash
mvn clean compile
```

This will compile the source code and place the compiled classes in the `target/classes` directory.

## Running the Application

To run the game:

```bash
mvn exec:java -Dexec.mainClass="vp.rockpaperscissors.Main"
```

Or if you have the compiled classes:

```bash
java -cp target/classes vp.rockpaperscissors.Main
```

## Running Tests

To run all tests:

```bash
mvn test
```

The project includes comprehensive unit tests covering:
- Move logic (winning conditions)
- Game result determination
- Statistics tracking
- Random move generation

## Gameplay

1. When you run the application, you'll see a menu with options:
   - `1` - Rock (камень)
   - `2` - Paper (бумага)
   - `3` - Scissors (ножницы)
   - `q` - Quit the game

2. Enter your choice (1, 2, or 3) and press Enter.

3. The computer will randomly select its move, and the result will be displayed.

4. Statistics are shown after each round.

5. Continue playing or type `q` to exit.

## Example

```
=== Камень, Ножницы, Бумага ===
Введите 'q' для выхода

Выберите ход:
1 - камень
2 - бумага
3 - ножницы
1
Ваш ход: камень
Ход компьютера: ножницы
Вы выиграли!

Статистика:
Побед: 1
Поражений: 0
Ничьих: 0
```
