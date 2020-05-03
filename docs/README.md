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
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/Command.png">
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

### Different factories should create objects of different types
**Problem in context**</br>
We have to make different objects of the same type. For example, we have an object Wall and we need to create walls with different designs. Also, we have an object enemy and other object ship, and we would like to have those objects with different designs and behavors. It would be useful if we have diferent factories in order to create those objects in different ways.</br></br>

**The Pattern**</br>
We will use a variation of the **Factory Method** where we have multiple factories creating the same object with different desings and behaviors. It makes the creation of those objects easier and more organized. For example, if we want to add a wall with a different design, we just need to create one factory class for the object.</br></br>

**Imlementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/FactoryMethod.png">
</p>

These classes can be found in the following files:
* [Fragment](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Fragment.java)</br>
* [Wall](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/wall/Wall.java)</br>
* [WallCreator](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/wall/WallCreator.java)</br>
* [DefaultWallCreator](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/wall/DefaultWallCreator.java)</br>

**Consequences**</br>
We do not have to create different classes for different wall types. We can have only one product wall and have different factories to create the Wall with different designs

## Code smells and Refactoring suggestions

### Long Parameter List

The [Arena](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/arena/Arena.java) class is receiving too much parameters (4) unnecessarily: there are three related parameters. Too much parameters are bad for code readability and organization.</br>
</br>
A way to improve the code is to join the *weight* and *height* parameters in one object, and the *backgroundColor* on another. Those classes are already implemented but by the time of this report they are not connected to the arena class, only to the [Ship](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Ship.java) one. **We will get to them at the end of this topic.**</br>

### Feature Envy

The [Arena](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/arena/Arena.java) class has many methods accessing to a lot of data from the ship. The problem with this situation, is because it breaks encapsulation.</br>
</br>
An alternative way that we think might help is to separate the arena from the ship and join them in a class that contains all of the information and objects of the game, so that the arena would be independent from the ship and other elements that we might create in the future.

### Large class and Duplicate code
In the [Image](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/image/Image.java) class we can identify two code smells: **Large class** and **Duplicate code**.

The problem with the **Large class** is the large amount of methods that the developers has to remember. There are 12 methods in the [Image](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/image/Image.java).

The **Duplicate code** occurs in the methods **calculateMaxPixelX()** and **calculateMaxPixelY()**. This is problematic because it makes the class larger and less clean.

To solve those problems we will create a class **PixelMatrix**, which contains the list of Pixels, and we will move the methods **calculateMaxPixelX()**, **calculateMaxPixelY()**, **findPixelIndex()**, **removePixel()**, **addPixel()**, **changePixelCharacter()** and **getPixels()** from [Image](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/image/Image.java) to **PixelMatrix**.
We also will change the implementation of the methods **calculateMaxPixelX()** and **calculateMaxPixelY()** to the following:
```
Pixel pixel = Collections.max(pixels, Comparator.comparing(p -> p.getPosition().getX()));
return pixel.getPosition().getX();
```
```
Pixel pixel = Collections.max(pixels, Comparator.comparing(p -> p.getPosition().getY()));
return pixel.getPosition().getY();
```
This uses the Collections class of the java.util package and makes the code smaller and cleaner.

### Data class
We use Data class in [Size](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/geometry/Size.java), [Vector](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/geometry/Vector.java), [Pixel](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/image/Pixel.java), [Box](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Box.java), [Element](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Element.java), [Enemy](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Enemy.java) and [Fragment](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Fragment.java).
The classes [Enemy](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Enemy.java) and [Fragment](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Fragment.java) are incompleted at this point and we will add behaviors later in the project.
The remaining classes, we will, for example, implement methods like **equals()** to verify if two objects of the same class are equals. However, as those classes are the bases of the project, we would like to keep as simple as possible, with few behavior, since they do not know anything about the game.

**Notes**</br>
We have some **Speculative Generality** code smells in our code because there are objects in our game that are not used yet but we are sure that they will be update and used in the future since they are essential for our game to be playable: the [Wall](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/wall/Wall.java) class, the [Enemy](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Enemy.java) class and every class related to them like creators and renderers.

---

We implemented a [Box](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Box.java) class that extends the [Element](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/Element.java) class to save the size of everything we have in our game. Then, an [Image](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/image/Image.java) class saves a matrix of [Pixels](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/image/Pixel.java), each Pixel contains the position and the character for that position.</br>
**Summing up:** Our Image is owned by every drawable object, when we draw an object we are drawing their image. This is already implemented to the Ship. We start by [Creating the ship](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/ShipCreator.java), and then the [ShipRender](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/ShipRenderer.java) will return their image using the [ImageRenderer](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/ImageRenderer.java).</br>
This help us avoiding some code smells making our code more organized, and give us flexibility to draw diferent variations of objects in the future.

---

## Testing
The following screenshot shows our **tests coverage** at this point.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/TestCoverage.png">
</p>

The **mutation testing report** can be accessed [here](https://github.com/FEUP-LPOO/lpoo-2020-g16/tree/master/docs/test_reports/pitest).</br></br>
**Notes**</br>
We have two tests on the view package, one to test the **arena rendering** and other to test the **ship rendering**.These tests fail because we are using functions from the Graphics class, and unfortunately this class does not have a constructor wich creates problems using Mockito. Running those tests we are confronted with a *java.lang.NullPointerException*.</br>
Due to that they are commented and can be found [here](https://github.com/FEUP-LPOO/lpoo-2020-g16/tree/master/src/test/java/com/spaceinvaders/viewtest).

## Self-evaluation

* Pedro Azevedo **50%**</br>
* Filipe Recharte **50%**</br>
