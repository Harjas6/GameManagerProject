
# Game Manager

### What does this application do?

The graphic version of this application allows you to add and remove games with details about their hours played,
personal ranking, difficulty, price, and various other fields. It then also allows you to sort by these fields. You can also save or load 
a list of the games you have added.

The console version of this app allows you do all the above, alongside find games under a inputted budget, 
find the avergae price or diffuculty of games, and change the values of the games after adding them.

### Instructions for Use of GUI
- To add a new game to the Game Manager hit the plus button.
- To remove a game, hit the trash can and follow the on-screen prompt 
- To sort by a field of the games, hit the titles on the top of the screen as
  they act like sorting buttons. Hitting them again will then sort by the reverse order .
- To save hit the floppy disk icon.
- To load hit the button with the arrow pointing down.


### Why did I choose to make this project?

This is of interest to me as I always have wanted to see/compare how many hours
I have spent on game as in game timers either do not exist or can be inaccurate for certain games.\
I also wanted a way to track/manage games I have or want to get as I tend to get lost in a backlog of games
I would like to play eventually, so this app will help me with that. 


## Reflection

One main thing I would change is setting clear boundaries from the beginning on what I will
implement in the final project. The lack of this resulted in adding many more features 
to the console version of the app as I thought them up, but not having the time to implement them for the `gui`.  

Reflecting on my project and UML diagram there are certain design choices
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
`GameManager`'s active at once - which was the original plan for this project - 
the Singleton Pattern would not allow for thatas it restricts you to one singular instance.  
Essentially, this refactoring has all the standard advantages and 
disadvantages to employing the Singleton Pattern.

Another thing I would change is I would pass the all the classes in the `comparators`  as
package as anonymous functions as they are only used once and never again. There are no
cons to this as the code would work the same and each comparator class only
has one function anyway, which can easily be turned into an anonymous function the
singular time it is used in the model.
