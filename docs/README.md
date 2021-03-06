# LPOO_16 - Space Invaders

## The Game
Space Invaders is a fixed shooter game in which the player controls a ship by moving it horizontally across the bottom of the screen and firing at the enemies.</br>
The aim is to defeat some rows of moving enemies, horizontally accross the screen.</br>
The ship has some walls protecting it from the enemies and has a limited number of lifes.</br> 
The enemies can also fire at the ship and have different strengths.</br>
**Project Collaborators:** Pedro Azevedo (up201806728@fe.up.pt) and Filipe Recharte (up201806743@fe.up.pt) for LPOO 2019/2020

## Design
### MVC
In this project, we decide to follow the architectural pattern **Model-View-Controller(MVC)**.
#### Model
We use the [Model](../src/main/java/com/spaceinvaders/model) package to store all the data of the game.
#### View
Our [View](../src/main/java/com/spaceinvaders/view/) package is the only package that imports lanterna and it is used only to display images from the [Model](../src/main/java/com/spaceinvaders/model/) on the screen and receive inputs from the user.
#### Controller
Finally, we have a [Controller](../src/main/java/com/spaceinvaders/controller/) package that uses the input from the [View](../src/main/java/com/spaceinvaders/view/lanternaview) and updates the [Model](../src/main/java/com/spaceinvaders/model) data, by sending the respective command from the specific input. Also, it uses the [Model](../src/main/java/com/spaceinvaders/model) data and [View](../src/main/java/com/spaceinvaders/view/lanternaview) to render the images to the screen.
In conclusion, we use the Model to store information, the View to interact with the user and the Controller to execute the rules of the game.

### The data to perform a command should be encapsulated
**Problem in context**</br>
We needed to implement the commands in a way that would allow us to easily add new commands to the game, and update them without changing the existing code, and avoid the code that performs the given action to be spread.</br></br>

**The Pattern**</br>
We decided to use the **Command pattern** because it makes our code cleaner and help us developing the game, allowing us to add new commands to it, manipulate them whenever we want, and change their inner details of how to perform without changing the calling of the command. </br></br>

**Implementation**</br>
The following figure shows how the pattern's roles were mapped to the game classes.</br>
<p align="center">
  <img src="../docs/imgs/Command%20(1).png">
</p>

These classes can be found in the following files:
* [GameView](../src/main/java/com/spaceinvaders/view/lanternaview/GameView.java)</br>
* [PlayState](../src/main/java/com/spaceinvaders/controller/states/playstate/PlayState.java)</br>
* [Arena](../src/main/java/com/spaceinvaders/model/arena/Arena.java)</br>
* [Ship](../src/main/java/com/spaceinvaders/model/ship/Ship.java)</br>
* [GameController](../src/main/java/com/spaceinvaders/controller/GameController.java)</br>
* [Command](../src/main/java/com/spaceinvaders/controller/commands/Command.java)</br>
* [MoveShipLeftCommand](../src/main/java/com/spaceinvaders/controller/commands/shipcommands/MoveShipLeftCommand.java)</br>
* [MoveShipRightCommand](../src/main/java/com/spaceinvaders/controller/commands/shipcommands/MoveShipRightCommand.java)</br>
* [ShootShipCommand](../src/main/java/com/spaceinvaders/controller/commands/shipcommands/ShootShipCommand.java)</br>

**Consequences**</br> 
This Design Pattern decoupled our invoker from each specific command, because the invoker does not need to know anything about what the command does. All of that is now encapsulated on each command. **Our PlayState does not know anything about moving the ship or shooting.**</br>

### Different factories should create objects of different types
**Problem in context**</br>
We have to make different objects of the same type. For example, we have an object Wall and we need to create walls with different designs. Also, we have an object enemy and other object ship, and we would like to have those objects with different designs and behaviors. It would be useful if we have different factories in order to create those objects in different ways.</br></br>

**The Pattern**</br>
We will use the **Factory Method** where we have multiple factories creating the same object with different designs and behaviors. It makes the creation of those objects easier and more organized. For example, if we want to add a wall with a different design, we just need to create one factory class for the object.</br></br>

**Implementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="../docs/imgs/FactoryMethod.png">
</p>

These classes can be found in the following files:
* [Fragment](../src/main/java/com/spaceinvaders/model/Fragment.java)</br>
* [Wall](../src/main/java/com/spaceinvaders/model/wall/Wall.java)</br>
* [WallCreator](../src/main/java/com/spaceinvaders/model/wall/WallCreator.java)</br>
* [DefaultWallCreator](../src/main/java/com/spaceinvaders/model/wall/DefaultWallCreator.java)</br>

**Consequences**</br>
We do not have to create different classes for different wall types. We can have only one product wall and have different factories to create the Wall with different designs

### The game needs a structure to let the player navigate through menus
**Problem in context**</br>
We needed to implement menus and messages to let the user know whats happening on the game. For that we could use a bunch of if states but that would make our code unorganized and uncertain.

**The Pattern**</br>
We decided to use the **State pattern** because it makes our code cleaner and organized leting the user navigate through the different menus. Instead of implementing all behaviors on its own, the original object, called context, that is our GameController, stores a reference to one of the state objects that represents its current state, and delegates all the state-related work to that object.

**Implementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="../docs/imgs/State%20(1).png">
</p>

These classes can be found in the following files:
* [GameController](../src/main/java/com/spaceinvaders/controller/GameController.java)</br>
* [GameState](../src/main/java/com/spaceinvaders/controller/states/GameState.java)</br>
* [GameOverState](../src/main/java/com/spaceinvaders/controller/states/GameOverState.java)</br>
* [PlayState](../src/main/java/com/spaceinvaders/controller/states/playstate/PlayState.java)</br>
* [MenuState](../src/main/java/com/spaceinvaders/controller/states/MenuState.java)</br>
* [InformationState](../src/main/java/com/spaceinvaders/controller/states/InformationState.java)</br>

**Consequences**</br>
The code is a lot more organized. Our GameController is much more simple and every state has it's own behavior for each key pressed by the player. As a result, we can add new states or change existing ones independently of each other, reducing the maintenance cost.

### The game objects should be visited by a visitor
**Problem in context**</br>
We need to add some elements to the arena or check if a shot collided with a game object. The problem is that we would need to have a bunch of if (... instanceof ...) for each game object, and if we add one, we would have to add a new if (... instanceof ...) in every class that uses it.

**The Pattern**</br>
We find out that the **Visitor Pattern** can be very helpful in this situation because we get rid of all the if (... instanceof ...) and we have a class Visitor, which have a visit() method for each game object with the visited object in the parameters. The objects which are visited by a visitor implements the interface visited which has a accept() method, giving the visitor the visited object.

**Implementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="../docs/imgs/VisitorPattern.png">
</p>

These classes can be found in the following files:
* [IElementVisited](../src/main/java/com/spaceinvaders/model/element/IElementVisited.java)</br>
* [IElementVisitor](../src/main/java/com/spaceinvaders/model/element/IElementVisitor.java)</br>
* [ElementVisitor](../src/main/java/com/spaceinvaders/model/element/IElementVisitor.java)</br>
* [ICollideableVisited](../src/main/java/com/spaceinvaders/model/collisions/ICollideableVisited.java)</br>
* [ICollideableVisitor](../src/main/java/com/spaceinvaders/model/collisions/ICollideableVisitor.java)</br>
* [CollideableVisitor](../src/main/java/com/spaceinvaders/model/collisions/CollideableVisitor.java)</br>
* [Enemy](../src/main/java/com/spaceinvaders/model/enemy/Enemy.java)</br>
* [Ship](../src/main/java/com/spaceinvaders/model/ship/Ship.java)</br>
* [Shot](../src/main/java/com/spaceinvaders/model/shot/Shot.java)</br>
* [Wall](../src/main/java/com/spaceinvaders/model/wall/Wall.java)</br>
* [Fragment](../src/main/java/com/spaceinvaders/model/wall/Fragment.java)</br>
* [Arena](../src/main/java/com/spaceinvaders/model/arena/Arena.java)</br>

**Consequences**</br>
If we need to add more elements to arena, we only need to add visit methods to the visitor, instead of changing multiples classes and add multiple if (... instanceof ...), making the code more organized. However, it may be difficult to understand the purpose of those classes, we lose a bit of class encapsulation and it is more complex to implement than just simply use instanceof.

### We should recicle shots
**Problem in context**</br>
We are making a game with lots of enemies shooting everywhere. It would be too inefficient if whenever a shot collides into some game object or goes out of bonus, we moved it to trash, or, whenever a shooter shot, we created a complete new shot.

**The Pattern**</br>
To solve that, we decided to use the **Object Pool Design Pattern**. In the Object Pool Design pattern, we have a pool of objects (in this case we have a pool of shots) and, instead of moving one shot to trash, we move it to the shot pool. Also, instead of creating a new shot, we extract one from the pool and use the [Shooters](../src/main/java/com/spaceinvaders/model/shots/Shooter.java) to recycle it.

**Implementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="../docs/imgs/ObjectPoolPattern.png">
</p>

These classes can be found in the following files:
* [ObjectPool](../src/main/java/com/spaceinvaders/model/pools/ObjectPool.java)</br>
* [ShotPool](../src/main/java/com/spaceinvaders/model/pools/ShotPool.java)</br>
* [ShotsController](../src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/ShotsController.java)</br>
* [EnemiesShotsGenerator](../src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/EnemiesShotsGenerator.java)</br>
* [Arena](../src/main/java/com/spaceinvaders/model/arena/Arena.java)</br>

**Consequences**</br>
Improve preformance. Harder to implement than simply destroying and creating shots. Even harder when we are dealing with more complex objects with subclasses.

### Organizing the images to render
**Problem in context**</br>
We have a lot of object images to draw, different images of the same objects. So we need to find a way that makes our rendering code well structured.

**The Pattern**</br>
To solve this problem we do not use exactly the **Factory pattern** but some kind of aproximation to that. We replace direct object construction calls (using the new operator) with calls to a special factory method. The objects are still created via the new operator, but it’s being called from within the factory method, and that method will build and return the desired object accordingly to the [ImageInfo](../src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ImageInfo.java) passed as a parameter.

**Implementation**</br>
The following figure shows how the pattern’s roles were mapped to the game classes.</br>
<p align="center">
  <img src="../docs/imgs/FactoryView.png">
</p>

These classes can be found in the following files:
* [ImageFactory](../src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ImageFactory.java)</br>
* [ArenaImageFactory](../src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ArenaImageFactory.java)</br>
* [ShipImageFactory](../src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ShipImageFactory.java)</br>
* [ShotImageFactory](../src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/ShotImageFactory.java)</br>
* [EnemyImageFactory](../src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/EnemyImageFactory.java)</br>
* [DefaultFragmentImageFactory](../src/main/java/com/spaceinvaders/view/lanternaview/imagesfactories/DefaultFragmentImageFactory.java)</br>

**Consequences**</br>
Basically our interface has a method that receives the type of object to build/choose and then returns a text image. That method is common to all factories. In factories that build different images, like the enemies and shots factories, we decided to build methods that return the text image to be rendered. In that case, the implementation of createTextImage method will only decide wich factory method (that builds the desired image) should be returned.

## Code smells and Refactoring suggestions

### Feature Envy

The [Arena](../src/main/java/com/spaceinvaders/model/arena/Arena.java) class has many methods accessing to a lot of data from the ship. The problem with this situation, is because it breaks encapsulation.</br>
</br>
An alternative way that we think might help is to separate the arena from the ship and join them in a class that contains all of the information and objects of the game, so that the arena would be independent from the ship and other elements that we might create in the future.

### Data class
We use Data class in [Vector](../src/main/java/com/spaceinvaders/model/geometry/Vector.java) and [Element](../src/main/java/com/spaceinvaders/model/element/Element.java).
We could, for example, implement methods like **equals()** to verify if two objects of the same class are equal. However, as those classes are the base of the project, we would like to keep them as simple as possible, with few behaviors, since they do not know anything about the game.

### Switch Statements
We started to have the **Switch Statements** code smell when we removed our image from model and made the images independent from the objects. The problem is that we cannot remove completly this dependency because in the game, each object has their own image. In the cases of the [Arena](../src/main/java/com/spaceinvaders/model/arena/Arena.java), the [Ship](../src/main/java/com/spaceinvaders/model/ship/Ship.java) and the [Fragment](../src/main/java/com/spaceinvaders/model/wall/Fragment.java) we do not need to use switch statements because we have only one type of object in the game. However, the [Enemy](../src/main/java/com/spaceinvaders/model/enemy/Enemy.java) and the [Shot](../src/main/java/com/spaceinvaders/model/shots/Shot.java) have different objects in the game (Enemies: [OldEnemy](../src/main/java/com/spaceinvaders/model/enemy/enemyvariants/OldEnemy.java), [YoungEnemy](../src/main/java/com/spaceinvaders/model/enemy/enemyvariants/YoungEnemy.java), [WiseEnemy](../src/main/java/com/spaceinvaders/model/enemy/enemyvariants/WiseEnemy.java), [StrongEnemy](../src/main/java/com/spaceinvaders/model/enemy/enemyvariants/StrongEnemy.java), [SuperiorEnemy](../src/main/java/com/spaceinvaders/model/enemy/enemyvariants/SuperiorEnemy.java)) ; (Shots: WeakShot, ImmatureShot, SlickShot, PowerfulShot, LegendaryShot).</br> We did not use classes to represent each type of shots because each one of them has only the Damage behavior and the Movable behavior. Instead of having a method in the enemy class: { return new ImmatureShot(); } we can simply have {return new Shot(...)} (As the teacher said in the last class). The problem is that we need to have an id to associate the object with its image. We decided to use a String representing the name of the image, as an id, that we use in the imagesFactories.</br> Finally, when we pass the image name to the factory, we could not avoid the switch statment, because, depending on the image name, we need to produce a different image. This smell is not a big problem because we only need two switch statements.

## Testing
The following screenshot shows our **tests coverage**.</br>
<p align="center">
  <img src="../docs/imgs/TestCoverage.png">
</p>

The **mutation testing report** can be accessed [here](../docs/test_reports/pitest_2).</br></br>
We are using Mockito framework in our tests to create mocks and set the exact return values it should give us to perform the test we want.</br>
**Notes**</br>
* Some test coverage results are very low because there are some classes that don't need to be tested, like the [GameController](../src/main/java/com/spaceinvaders/controller/GameController.java) class, wich has a lot of methods containing calls to other methods that are already being tested in their respective classes. </br>
Other classes have a lot of trivial methods like getters and setters, that we are not testing. </br>
* Most of the view package contains graphic functions to put strings on the screen, and testing them is useless. This can explain the low test coverage values on the view package.
* In the view package, some tests failed because we are using functions from the Graphics class, and unfortunately this class does not have a constructor wich creates problems using Mockito. Running those tests we were confronted with a *java.lang.NullPointerException*.</br>Due to that the view tests didn't go as expected.

* When we were creating tests, we had some difficulties testing **private methods**, **void methods** and **methods with random functions**. Some of those methods were obvious and did not require testing, but others were more complicated and we had to find a way to test them. One aproach we used to solve this problem was creating a class with public methods and use those methods in the method that was being tested. This does not test the method we want but we do not need to test it anymore because we tested the dependent methods, and makes the method simple enough to not test it. The problem is that we break a bit of class encapsulation, because instead of having only one class with one responsability, we have more. For example, we wanted to test the method generateEnemiesShots() in [ShotsController](../src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/ShotsController.java), which has a random function inside. In order to test it, we created the class [EnemiesShotsGenerator](../src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/EnemiesShotsGenerator.java) with the methods generate() and enemyReadyToShoot(), which were simpler to test. Then, we change the method that we want to test, calling the [EnemiesShotsGenerator](../src/main/java/com/spaceinvaders/controller/states/playstate/playstatecontrollers/EnemiesShotsGenerator.java) methods and the method turned simple enough to not require testing it.</br> We made this decision because we knew that our project would be simple and we would not lose too much encapsulation, and also because it is more important for this method to have a good test coverage than an excelent design.

	## Playing the game

<p align="center">
  <img src="../docs/imgs/spaceInvaders.gif">
</p>

## Self-evaluation

* Pedro Azevedo **50%**</br>
* Filipe Recharte **50%**</br>

## Notes
up201806728@ms.uporto.pt and MrComboF10 are the same account of Pedro Azevedo up201806728 (no idea why this happens)
