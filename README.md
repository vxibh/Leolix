# Chess Engine in Java

A Java-based chess engine that supports two-player mode, computer gameplay, and game customization.

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [How to Play](#how-to-play)
- [Customization](#customization)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Introduction

Welcome to the Chess Engine in Java project! This chess engine is designed using Object-Oriented Programming (OOP) principles, providing a modular and extensible structure for a rich chess-playing experience. In the realm of software development, OOP is a paradigm that organizes code around the concept of objects, encapsulation, inheritance, and polymorphism. Let's delve into how these principles are implemented in this Java chess engine.

### Object-Oriented Programming (OOP)

OOP is a programming paradigm that organizes code around the concept of objects, which are instances of classes. Each class defines a blueprint for objects, encapsulating data and behavior within a single unit. The four main principles of OOP are:

1. **Encapsulation**: Bundling data and methods that operate on that data within a single unit (class). It hides the internal state of the object and requires interaction through well-defined interfaces.

2. **Inheritance**: Creating a new class based on an existing class, inheriting its attributes and behaviors. This promotes code reuse and the creation of a hierarchy of classes.

3. **Polymorphism**: Allowing objects of different classes to be treated as objects of a common superclass. It enables a single interface to represent various types and behaviors.

4. **Abstraction**: Simplifying complex systems by modeling classes based on real-world entities. Abstraction focuses on the essential characteristics of an object, ignoring irrelevant details.

### Implementation in this Chess Engine

#### 1. Encapsulation

In the chess engine, each chess piece and the board itself is represented by separate classes, encapsulating their specific behaviors and attributes. Methods within these classes interact with the internal state of the object, promoting data integrity.

#### 2. Inheritance

The inheritance principle is applied to model different types of chess pieces. For example, a `Pawn` class inherits common attributes and behaviors from a more general `Piece` class. This hierarchical structure allows for code reuse and easy extension.

#### 3. Polymorphism

Polymorphism is evident in the way moves are handled. The `Move` class, for instance, is a common interface for various types of moves, such as standard moves, captures, and special moves. This enables flexibility in processing different move types without knowing the specific implementation.

#### 4. Abstraction

Abstraction is achieved by modeling the chess game using classes that represent fundamental chess entities—pieces, players, moves, and the board. The details of each class are abstracted, providing a high-level view of the chess game's structure and interactions.

By employing OOP principles, this Java chess engine helped me in providing a maintainable, extensible, and comprehensible codebase, fostering a more enjoyable and educational experience in learning Java and its other features too!

## Getting Started

1. **Clone the repository to your local machine**.

2. **Open the project in your favorite Java IDE**.

3. **Compile and run the application**.

   - Build and run the project using your IDE's build and run commands.
   - Make sure you have the necessary dependencies installed.
   - *Guava by Google* is required for all the aspects to function properly.

## How to Play

1. **Two-Player Mode**:
   - Start a new game and select "Two Players."
   - Take turns making moves on the chessboard.

2. **Against the Computer**:
   - Choose the "Setup Game" option from the menu.
   - Select the desired player types, colors, and depth of the computer's move search.
   - Start the game and make your moves.

3. **Load Games from FEN & PGN Format**:
   - Use the "Load Game" option to load games from FEN or PGN files.

## Customization

Customize the game settings and appearance according to your preferences:

- **Player Types**: Choose between Human and Computer players.
- **Game Colors**: Select the color scheme for the chessboard. We are able to change color of Board tiles and Piece art too.
- **Depth of Move Search**: Adjust the difficulty of the computer opponent by setting the depth of its move search.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or create a pull request.

## License

This Chess Engine is open-source and available under the [MIT License](LICENSE).

## Acknowledgements
  
### Books
- **"Effective Java" by Joshua Bloch**
  A comprehensive guide that covers Java and OOP concepts.

### Websites and Forums
- **Chess Programming Wiki([chessprogramming.org](https://www.chessprogramming.org))**
  A collaborative resource that provides information on chess programming, algorithms, and engines. It's a valuable reference for developers.

- **Stack Overflow**
  Stack Overflow has a dedicated tag for chess-related questions, where developers discuss and share solutions to common chess programming challenges. It helped me in solving my doubts related to concepts and logics.

#### Open-Source Engines:
- Stockfish ([stockfishchess.org](https://stockfishchess.org))
  The strongest open-source chess engine. Studying its source code can provide insights into advanced chess algorithms and techniques.

- Crafty Chess ([craftychess.com](http://www.craftychess.com))
  An open-source chess engine written in C. It's known for its clarity of code, making it a good resource for learning.
  
#### Forums and Communities:
- Lichess Forums ([lichess.org](https://lichess.org))
  Lichess being an open-source project for Chess community helps developers for contribute to Chess Programming. The forums on this website helped me in correcting various coding errors.
  
Well! that's all for this project. I will furthur improve on this project whenever time permits. 
See ya'll then!
