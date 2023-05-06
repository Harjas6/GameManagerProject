
# Game Manager

### What will this application do?

This application will be able to log the games a user has inputs and track the
hours spent on each game through *manual* updates as well as store details about the
game's. It can also tell you what games you are able to buy according to the users budget and
it can also derive average values for the price/difficulty/hours played of each game.

### Who will use it?

Anybody who wishes to manage or view all the games they have played/wanted and
also wish to compare them or see basic stats.

### Why is this project of interest to you?

This is of interest to me as I always have wanted to see/compare how many hours
I have spent on game as in game timers either do not exist or can be inaccurate for games
sometimes. I also wanted a way to track/manage games I have or want to get
so this app will help me with that, especially track money spent. 

### User Stories

- As a user, I would like to add a new game, to a list of games.
- As a user, I would like to be able to games sorted by all the info I put about them (name, genre, hours, etc.)
- As a user, I want to be able to save the state of the application.
- As a user, when I start the application, I want the option of loading a saved state.
- As a user, I would like to see the averages hours played/prices/difficulty of the games in the list
- As a user, I would like to be able to increment
  the hours spent on a game multiple times (ex. be able to add to a running total).
- As a user, I would like to be able to change fields of a game without
  needing to delete and re-enter the game (edit games fields within the list).
- As a user, I would like to see what games are under my budget from the games that are not owned in the list.



### Instructions for Use
- To add a new game to the Game Manager hit the plus button.
- To remove a game, hit the trash can and follow the on-screen prompt 
- To sort by a field of the games, hit the titles on the top of the screen as
  they act like sorting buttons. Hitting them again will then sort by the reverse order .
- To save hit the floppy disk icon.
- To load hit the button with the arrow pointing down.

## Reflection

One main thing I would change is setting clear boundaries from the beginning on what I will
implement in the final project. The lack of this resulted in add many more features
to the console version of the app, but not having the time to implement them for the `gui`.  

Reflecting on my project and diagram there are certain design choices
I would reconsider and change with the knowledge I have now. 
A glaring issue I can see through the UML diagram is how
the Singleton Pattern would have been useful for `GameManager` class.
Due to the lack of the pattern, I had to pass `GameManager` as an argument to most
classes in my `gui` package. The lack of the Singleton Pattern also had created problems
for me as Java kept creating new instances on its own when loading a save file,
prompting me to workaround it by adding methods to my model which copied value
from lists. If at the time I had known and used the Singleton Pattern, this 
issue would have never popped up. I could also employ the Singleton Pattern for my 
`MainPanel` class as I only ever want one instance of it and I similarly pass it as a argument 
to many other classes.

The advantages of this would be as stated above, I would have
no need to create brute force methods to overcome the previously
stated issue. It also removes the need to pass one object around many times.
This results in cleaner and more readable code, while also ensuring
the object being manipulated is always the correct one.

A disadvantage is if I wanted to expand this to have multiple 
`GameManager`'s active at once - which was the original plan for this project
if more time was available - the Singleton Pattern would not allow for that
as it restricts you to one singular instance.  
Essentially, this refactoring has all the standard advantages and 
disadvantages to employing the Singleton Pattern.

Another thing I would change is I would pass the all the classes in the `comparators`  as
package as anonymous functions as they are only used once and never again. There are no
cons to this as the code would work the same and each comparator class only
has one function anyway, which can easily be turned into an anonymous function the
singular time it is used in the model.
