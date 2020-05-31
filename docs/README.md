# LPOO_16 - Space Invaders

## The Game
Space Invaders is a fixed shooter game in which the player controls a ship by moving it horizontally across the bottom of the screen and firing at the enemies.</br>
The aim is to defeat some rows of moving enemies, horizontally accross the screen.</br>
The ship has some walls protecting it from the enemies and has a limited number of lifes.</br> 
The enemies can also fire at the ship and have different strengths.</br>
**Project Collaborators:** Pedro Azevedo (up201806728@fe.up.pt) and Filipe Recharte (up201806743@fe.up.pt) for LPOO 2019/2020

## Implemented Features

* **Moving SpaceShip** - The player is able to control the ship moving it to the left or right.</br>
* **Enemies** - The game has enemies that will shoot against the ship.</br>
* **Walls** - . The ship is partially protected by several stationary defense walls.</br>
* **Enemy Shooting** - The aliens attempt to destroy the ship by firing at it.</br>
* **Ship Shooting** - The ship attempts to kill all enemies by firing at them.</br>
* **SpaceShip with Lifes** - The ship has lifes that decrease when a shot hits the ship.</br>
* **Enemies with strength** - Some enemies are more difficult to kill than others.</br>

## Planned Features not implemented

* **Score** - The player has a score.</br>

## Design
### MVC
In this project, we decide to follow the architectural pattern **Model-View-Controller(MVC)**.
#### Model
We use the [Model](https://github.com/FEUP-LPOO/lpoo-2020-g16/tree/master/src/main/java/com/spaceinvaders/model) package to store all the data of the game.
#### View
Our [View](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/src/main/java/com/spaceinvaders/view) package is the only package that imports lanterna and it is used only to display images from the [Model](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/) on the screen and receive inputs from the user.
#### Controller
Finally, we have a [Controller](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/src/main/java/com/spaceinvaders/controller/) package that uses the input from the [View](https://github.com/FEUP-LPOO/lpoo-2020-g16/tree/master/src/main/java/com/spaceinvaders/view/lanternaview) and updates the [Model](https://github.com/FEUP-LPOO/lpoo-2020-g16/tree/master/src/main/java/com/spaceinvaders/model) data, by sending the respective command from the specific input. Also, it uses the [Model](https://github.com/FEUP-LPOO/lpoo-2020-g16/tree/master/src/main/java/com/spaceinvaders/model) data to render the images to the screen.
In conclusion, we use the Model to store information, the View to interact with the user and the Controller to execute the rules of the game.

### The data to perform a command should be encapsulated
**Problem in context**</br>
We needed to implement the commands in a way that would allow us to easily add new commands to the game, and update them without changing the existing code, and avoid the code that performs the given action to be spread.</br></br>

**The Pattern**</br>
We decided to use the **Command pattern** because it makes our code cleaner and help us developing the game, allowing us to add new commands to it, manipulate them whenever we want, and change their inner details of how to perform without changing the calling of the command. </br></br>

**Implementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/Command%20(1).png">
</p>

These classes can be found in the following files:
* [GameView](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/lanternaview/GameView.java)</br>
* [Arena](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/arena/Arena.java)</br>
* [GameController](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/GameController.java)</br>
* [Command](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/commands/Command.java)</br>
* [MoveShipLeftCommand](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/commands/shipcommands/MoveShipLeftCommand.java)</br>
* [MoveShipRightCommand](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/commands/shipcommands/MoveShipRightCommand.java)</br>
* [ShootShipCommand](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/commands/shipcommands/ShootShipCommand.java)</br>

**Consequences**</br> 
This Design Pattern decoupled our invoker from each specific command, because the invoker does not need to know anything about what the command does. All of that is now encapsulated on each command. **Our PlayState does not know anything about moving the ship or shooting.**</br>

### Different factories should create objects of different types
**Problem in context**</br>
We have to make different objects of the same type. For example, we have an object Wall and we need to create walls with different designs. Also, we have an object enemy and other object ship, and we would like to have those objects with different designs and behaviors. It would be useful if we have diferent factories in order to create those objects in different ways.</br></br>

**The Pattern**</br>
We will use a variation of the **Factory Method** where we have multiple factories creating the same object with different designs and behaviors. It makes the creation of those objects easier and more organized. For example, if we want to add a wall with a different design, we just need to create one factory class for the object.</br></br>

**Imlementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/docs/imgs/FactoryMethod.png">
</p>

These classes can be found in the following files:
* [Fragment](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Fragment.java)</br>
* [Wall](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/wall/Wall.java)</br>
* [WallCreator](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/wall/WallCreator.java)</br>
* [DefaultWallCreator](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/wall/DefaultWallCreator.java)</br>

**Consequences**</br>
We do not have to create different classes for different wall types. We can have only one product wall and have different factories to create the Wall with different designs

### The game needs a structure to let the player navigate through menus
**Problem in context**</br>
We needed to implement menus and messages to let the user know whats happening on the game. For that we could use a bunch of if states but that would make our code unorganized and uncertain.

**The Pattern**</br>
We decided to use the **State pattern** because it makes our code cleaner and organized letting the user navigate through the different menus. Instead of implementing all behaviors on its own, the original object, called context, that is our GameController, stores a reference to one of the state objects that represents its current state, and delegates all the state-related work to that object.

**Imlementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/State%20(1).png">
</p>

These classes can be found in the following files:
* [GameController](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/GameController.java)</br>
* [GameState](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/GameState.java)</br>
* [GameOverState](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/GameOverState.java)</br>
* [PlayState](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/playstate/PlayState.java)</br>
* [MenuState](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/MenuState.java)</br>
* [InformationState](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/InformationState.java)</br>

**Consequences**</br>
The code is a lot more organized. Our GameController is much more simple and every state has it's own behavior for each key pressed by the player. As a result, we can add new states or change existing ones independently of each other, reducing the maintenance cost.

### The game objects should be visited by a visitor
**Problem in context**</br>
We need to add some elements to the arena or check if a shot colided with a game object. The problem is that we would need to have a bunch of if (... instanceof ...) for each game object and if we add a game object, we would have to add a new if (... instanceof ...) in every class which uses it.

**The Pattern**</br>
We find out that the **Visitor Pattern** can be very helpful in this situation because we get rid of all the if (... instanceof ...) and we have a class Visitor, which have a visit() method for each game object with the visited object in the parameters. The objects which are visited by a visitor implements the interface visited which has a accept() method, giving the visitor the visited object.

**Imlementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/VisitorPattern.png">
</p>

These classes can be found in the following files:
* [IElementVisited](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/element/IElementVisited.java)</br>
* [IElementVisitor](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/element/IElementVisitor.java)</br>
* [ElementVisitor](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/element/IElementVisitor.java)</br>
* [ICollideableVisited](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/collisions/ICollideableVisited.java)</br>
* [ICollideableVisitor](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/collisions/ICollideableVisitor.java)</br>
* [CollideableVisitor](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/collisions/CollideableVisitor.java)</br>
* [Enemy](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/enemy/Enemy.java)</br>
* [Ship](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/ship/Ship.java)</br>
* [Shot](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/shot/Shot.java)</br>
* [Wall](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/wall/Wall.java)</br>
* [Fragment](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/wall/Fragment.java)</br>
* [Arena](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/arena/Arena.java)</br>

**Consequences**</br>
If we need to add more elements to arena, we only need to add visit methods to the visitor, instead of changing multiples classes and add multiple if (... instanceof ...). Also, makes the code more organize. However, it may be dificult to understand the purpose of those classes, we lose a bit of class encapsulation and is more complex to implement than simply using instanceof.

### We should recicle shots
**Problem in context**</br>
We are making a game with lots of enemies shooting everywhere. It would be too inefficient if whenever a shot collide to some game object or goes out of bonus we move it to trash, and whenever a shooter shot, we create a complete new shot.

**The Pattern**</br>
To resolve that, we decided to use the **Object Pool Design Pattern**. In the Object Pool Design pattern, we have a pool of objects (in this case we have a pool of shots) and, instead of moving one shot to trash, we move it to the shot pool. Also, instead of creating a new shot, we extract one shot from the pool and use the [Shooters](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/shots/Shooter.java) to recycle it.

**Imlementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/ObjectPoolPattern.png">
</p>

These classes can be found in the following files:
* [ObjectPool<T>](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/pools/ObjectPool.java)</br>
* [ShotPool](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/pools/ShotPool.java)</br>
* [ShotsController](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/ShotsController.java)</br>
* [EnemiesShotsGenerator](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/EnemiesShotsGenerator.java)</br>
* [Arena](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/model/arena/Arena.java)</br>

**Consequences**</br>
Improve preformance. Harder to implement than simply destroying and creating shots. Even harder when we are dealing with more complex objects with subclasses.

### Organizing the images to render
**Problem in context**</br>
We have a lot of object images to draw, different images of the same objects. So we need to find a way that makes our rendering code well structured.

**The Pattern**</br>
To solve this problem we use a variation of the **Factory pattern**. We replace direct object construction calls (using the new operator) with calls to a special factory method. The objects are still created via the new operator, but it’s being called from within the factory method, and that method will build and return the desired object accordingly to the [ImageInfo](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ImageInfo.java) passed as a parameter.

**Implementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/FactoryView.png">
</p>

These classes can be found in the following files:
* [ImageFactory](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ImageFactory.java)</br>
* [ArenaImageFactory](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ArenaImageFactory.java)</br>
* [ShipImageFactory](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ShipImageFactory.java)</br>
* [ShotImageFactory](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ShotImageFactory.java)</br>
* [EnemyImageFactory](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/EnemyImageFactory.java)</br>
* [DefaultFragmentImageFactory](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/DefaultFragmentImageFactory.java)</br>

**Consequences**</br>
Basically our interface has a method that receives the type of object to build/choose and then returns a text image. That method is common to all factories. In factories that build different images, like the enemies and shots factories, we decided to build methods that return the text image to be rendered. In that case, the implementation of createTextImage method will only decide wich factory method (that builds the desired image) should be returned.

## Code smells and Refactoring suggestions

### Long Parameter List

The [Arena](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/arena/Arena.java) class is receiving too many parameters (4) unnecessarily: there are three related parameters. Too many parameters are bad for code readability and organization.</br>
</br>
A way to improve the code is to join the *weight* and *height* parameters in one object, and the *backgroundColor* on another. Those classes are already implemented but by the time of this report they are not connected to the arena class, only to the [Ship](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Ship.java) one. **We will get to them at the end of this topic.**</br>

### Feature Envy

The [Arena](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/arena/Arena.java) class has many methods accessing to a lot of data from the ship. The problem with this situation, is because it breaks encapsulation.</br>
</br>
An alternative way that we think might help is to separate the arena from the ship and join them in a class that contains all of the information and objects of the game, so that the arena would be independent from the ship and other elements that we might create in the future.

### Large class and Duplicate code
In the [Image](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/image/Image.java) class we can identify two code smells: **Large class** and **Duplicate code**.

The problem with the **Large class** is the large amount of methods that the developers have to remember. There are 12 methods in the [Image](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/image/Image.java).

The **Duplicate code** occurs in the methods **calculateMaxPixelX()** and **calculateMaxPixelY()**. This is problematic because it makes the class larger and less clean.

To solve those problems we will create a class **PixelMatrix**, which contains the list of Pixels, and we will move the methods **calculateMaxPixelX()**, **calculateMaxPixelY()**, **findPixelIndex()**, **removePixel()**, **addPixel()**, **changePixelCharacter()** and **getPixels()** from [Image](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/image/Image.java) to **PixelMatrix**.
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
We use Data class in [Size](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/geometry/Size.java), [Vector](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/geometry/Vector.java), [Pixel](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/image/Pixel.java), [Box](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Box.java), [Element](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Element.java), [Enemy](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Enemy.java) and [Fragment](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Fragment.java).
The classes [Enemy](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Enemy.java) and [Fragment](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Fragment.java) are incompleted at this point and we will add behaviors later in the project.
In the remaining classes, we will, for example, implement methods like **equals()** to verify if two objects of the same class are equal. However, as those classes are the base of the project, we would like to keep them as simple as possible, with few behaviors, since they do not know anything about the game.

**Notes**</br>
We have some **Speculative Generality** code smells in our code because there are objects in our game that are not used yet but we are sure that they will be update and used in the future since they are essential for our game to be playable: the [Wall](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/wall/Wall.java) class, the [Enemy](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Enemy.java) class and every class related to them like creators and renderers.

---

We implemented a [Box](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Box.java) class that extends the [Element](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/Element.java) class to save the size of everything we have in our game. Then, an [Image](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/image/Image.java) class saves a matrix of [Pixels](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/image/Pixel.java), each Pixel contains the position and the character for that position.</br>
**Summing up:** Our Image is owned by every drawable object, when we draw an object we are drawing their image. This is already implemented to the Ship. We start by [Creating the ship](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/model/ShipCreator.java), and then the [ShipRender](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/maintermediatester/src/main/java/com/spaceinvaders/view/ShipRenderer.java) will return their image using the [ImageRenderer](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/intermediate/src/main/java/com/spaceinvaders/view/ImageRenderer.java).</br>
This help us avoid some code smells making our code more organized, and give us flexibility to draw different variations of objects in the future.

---

## Testing
The following screenshot shows our **tests coverage**.</br>
<p align="center">
  <img src="https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/docs/imgs/TestCoverage.png">
</p>

The **mutation testing report** can be accessed [here](https://github.com/FEUP-LPOO/lpoo-2020-g16/tree/master/docs/test_reports/pitest_2).</br></br>
We are using Mockito framework in our tests to create mocks and set the exact return values it should give us to perform the test we want.</br>
**Notes**</br>
* Some test coverage results are very low because there are some classes that don't need to be tested like the [GameController](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/GameController.java) class that has a lot of methods containing calls to other methods that are already being tested in their respective classes. 
* Other classes have a lot of trivial methods like getters and setters, that we are not testing. Most of the view package contains graphic functions to put strings on the screen, and testing them is useless. This can explain the low test coverage values on the view package.
* In the view package, some tests failed because we are using functions from the Graphics class, and unfortunately this class does not have a constructor wich creates problems using Mockito. Running those tests we were confronted with a *java.lang.NullPointerException*.</br>Due to that the view tests didn't go as expected.

* When we were creating tests, we have some dificulties like testing **private methods**, **void methods** or **methods with random functions**. Some of this methods were obvious and did not require testing, but others were more complicated and we have to find a way to test them. One aproach we use to solve this problem was creating a class with public methods and use those methods in the method that was being tested. This does not test the method we want but we do not need to test it anymore because we tested the dependent methods and makes the nethod simple enough to not test it. The problem is that we breaks a bit class encapsulation, because instead of having only one class with one responsability, we have more. For example, we wanted to test the method generateEnemiesShots() in [ShotsController](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/ShotsController.java), which has a random function inside. In order to test it, we created the class [EnemiesShotsGenerator](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/EnemiesShotsGenerator.java) with the methods generate() and enemyReadyToShoot(), which were simpler to test. Then, we change the method we wanted to test, calling the [EnemiesShotsGenerator](https://github.com/FEUP-LPOO/lpoo-2020-g16/blob/master/src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/EnemiesShotsGenerator.java) methods and the method turned simple enough to not require testing it. We made this decision because we know our project would be simple and we would not lose too much encapsulation, and also because it is more important that this method has a good coverage by the tests than an excelent design.

## Self-evaluation

* Pedro Azevedo **50%**</br>
* Filipe Recharte **50%**</br>
