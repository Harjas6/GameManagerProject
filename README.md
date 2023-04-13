
# Game Manager

### What will this application do?

This application will be able to log the games a user has inputs and track the
hours spent on each game through *manual* updates as well as store details about the
games difficulty, genre, price, personal ranking, and whether it is owned or not.
It can also tell you what games you are able to buy according to the users budget.
It can also derive average values for the price/difficulty/hours played of each game.

### Who will use it?

Anybody who wishes to manage or view all the games they have played/wanted and
also wish to compare them or see basic stats.

### Why is this project of interest to you?

This is of interest to me as I always have wanted to see/compare how many hours
I have spent on game as in game timers either do not exists or can be innacurate for games
sometimes. I also wanted a way to track/manage games I have or want to get
so this app will help me with that, especially track money spent. 

### User Stories

- As a user, I would like to add a new game, to a list of games.
- As a user, I would like to be able to increment
the hours spent on a game multiple times (ex. be able to add to a running total).
- As a user, I would like to be able to change fields of a game without
needing to delete and re-enter the game (edit games fields within the list).
- As a user, I would like to be able to games sorted by all the info I put about them (name, genre, hours, etc.)
- As a user, I would like to see the averages hours played/prices/difficulty of the games in the list
- As a user, I would like to see what games are under my budget from the games that are not owned in the list.

- As a user, when I quit the program, I want to be reminded to save my list to  a file and the choice to.
- As a user, when I start the application, I want to be given the option to load my saved list from file.

### Grading Instructions
- **Visual component** will be displayed through completing actions below.
- To add a new game to the Game Manager hit the plus button (**Adding X to Y**).
- To remove a game, hit the trash can and follow the on-screen prompt 
(**First required method related to list**).
- To sort by a field of the games, hit the titles on the top of the screen as
  they act like sorting buttons. Hitting them again will then sort by the reverse order
(**Second required method related to list**).
- To save hit the floppy disk icon (**Saving state**).
- To load hit the button with the arrow pointing down (**Loading state**).

## Phase 4: Task 2
A sample of what would be printed to the console after a basic
run through of the program is below.

### Overall Example of Events Logged

```
< Date at time of logging >  
Added game SampleGame      
< Date at time of logging >   
Sorted by Name  
< Date at time of logging >  
Removed game named SampleGame 
 ```

### Abnormalities in the Logging 
#### Sorting
If you press a sort button a second time or any even numbered time
(sorting in the reverse priority), you will notice
the following.    

*Using the name field for example.*
```
< Date at time of logging >  
Sorted by Name  
< Date at time of logging >  
Sorted by Name reverse
```

Even though we performed only one event - sorting the 
list in reverse priority - two things printed out. 
This is because the reverse sort function sorts the
list normally by calling the respective sort function 
and then reverses it, causing two events to be logged 
in one go. It is not an error.

####  Loading
The loading functionality creates a new temporary instance of the `GameManager` 
and adds all the saved games to it. It then calls the `clearAll` function on the main `GameManager`
that is displayed on the GUI and then call the `addAll` method on the primary instance
which then copies all the temporary `GameManagers` information into the main `GameManager`.
This was done as the Singleton Pattern was not known to me at the time and 
Java kept creating new instances on its own. Due to this design issues the model does end up getting updated and this 
is what would print out.

```
< Date at time of logging >  
Added savedGame_1  
< Date at time of logging >    
Added savedGame_2  
< Date at time of logging >  
Added savedGame...  
< Date at time of logging >  
Added savedGame_n  
< Date at time of logging >  
Clears all games in game list  
< Date at time of logging >  
Added all games into this list 
```


## Phase 4: Task 3

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

___
***URL for JsonSerializationDemo***
<https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo>