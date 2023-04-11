# My Personal Project

## Game Manager

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

## Grading Instructions
- **Visual component** will be displayed through completing actions below.
- To add a new game to the Game Manager hit the plus button (**Adding X to Y**).
- To remove a game, hit the trash can and follow the on-screen prompt 
(**First required method related to list**).
- To sort by a field of the games, hit the titles on the top of the screen as
  they act like sorting buttons. Hitting them again will then sort by the reverse order
(**Second required method related to list**).
- To save hit the floppy disk icon (**Saving state**).
- To load hit the button with the arrow pointing down (**Loading state**).

### Phase 4: Task 2
A sample of what would be printed to the console after doing each 
action once is below. They have been organized by the type of even they are for readabilty.

#### Sorting

Assuming alll sorting buttons were hit left to right as displayed.  

< Date at time of logging >  
Sorted by Name  
< Date at time of logging >  
Sorted by ranking  
< Date at time of logging >  
Sorted by difficulty  
< Date at time of logging >  
Sorted by Hours  
< Date at time of logging >  
Sorted by price  
< Date at time of logging >  
Sorted by Genre  
< Date at time of logging >  
Sorted by owned  

If you press a sort button a second time or any even numbered time
(sorting in the reverse priority), you will notice
the following.    

*Using the name field for example.*

< Date at time of logging >  
Sorted by Name  
< Date at time of logging >  
Sorted by Name reverse

Even though we performed only one event, sorting the 
list in reverse priority, two things printed out. 
This is because the reverse sort function sorts the
list normally by calling the respective sort function 
and then reverses it, causing two events to be logged 
in one go. It is not an error.

#### Adding & Removing

< Date at time of logging >  
Added game SampleGame  
< Date at time of logging >  
Removed game named SampleGame

#### Saving & Loading
Saving has no event logged as it doesn't change the model.  

**Loading** however does, as it creates a new temporary instance of the GameManager 
with the loaded information and then calls the clearAll function on the main GameManager
that is displayed on the GUI and then call the addAll method on the primary instance
which then adds all the temporary GameManagers information into the main GameManager.
This was done as the Singleton Pattern was not known to me at the time and 
Java kept creating new instances on its own. Due to this design issues the model does end up getting updated and this 
is what would print out.

< Date at time of logging >  
Clears all games in game list  
< Date at time of logging >  
Added all games into this list


### Phase 4: Task 3


___
***URL for JsonSerializationDemo***
<https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo>