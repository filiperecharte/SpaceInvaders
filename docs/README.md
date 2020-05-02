# LPOO_16 - Space Invaders

## The Game
Space Invaders is a fixed shooter game in which the player controls a ship by moving it horizontally across the bottom of the screen and firing at the enemies.</br>
The aim is to defeat some rows of moving enemies, horizontally accross the screen.</br>
The ship has some walls protecting it from the enemies and has a limited number of lifes.</br> 
The enemies can also fire at the ship and have different strengths.</br>
**Project Collaborators:** Pedro Azevedo (up201806728@fe.up.pt) and Filipe Recharte (up201806743@fe.up.pt) for LPOO 2019/2020

## Implemented Features

* **Moving SpaceShip** - The player is able to control the ship moving it to the left or right.</br>

## Planned Features

* **Enemies** - The game has enemies that will shoot against the ship.</br>
* **Walls** - . The ship is partially protected by several stationary defense walls.</br>
* **Enemy Shooting** - The aliens attempt to destroy the ship by firing at it.</br>
* **Ship Shooting** - The ship attempts to kill all enemies by firing at them.</br>
* **Score** - The player has a score.</br>
* **SpaceShip with Lifes** - The ship has lifes that decrease when a shot hits the ship.</br>
* **Enemies with strength** - Some enemies are more difficult to kill than others.</br>

## Design
### The data to perform a command should be encapsulated
**Problem in context**</br>
We needed to implement the commands in a way that would allow us to easily add new commands to the game, and update them without changing the existing code, and avoid the code that performs the given action to be spread.</br></br>

**The Pattern**</br>
We decided to use the **Command pattern** because it makes our code cleaner and help us developing the game, allowing us to add new commands to it, manipulate them whenever we want, and change their inner details of how to perform without changing the calling of the command. </br></br>

**Imlementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img width="594" height="326" src="https://i.imgur.com/GJUjPLT.png">
</p>

These classes can be found in the following files:
* [GameView](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/GameView.java)</br>
* [Arena](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/arena/Arena.java)</br>
* [GameEngine](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/GameEngine.java)</br>
* [Command](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/commands/Command.java)</br>
* [MoveShipLeftCommand](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/commands/shipcommands/MoveShipLeftCommand.java)</br>
* [MoveShipRightCommand](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/commands/shipcommands/MoveShipRightCommand.java)</br>

**Consequences**</br> 
This Design Pattern decoupled our invoker from each specific command, because the invoker does not need to know anything about what the command does. All of that is now encapsulated on each command. **Our GameEngine does not know anything about moving the ship.**</br>

### The data to perform a command should be encapsulated


## Code smells and Refactoring suggestions

## Testing

