# fop-assignment

latest update - jowen (2.12pm 29/12)

-- Board.java --

   1. play() --> created condition even if player does not reach the Start tile but pass through it , will print out level up message also
   2. print() --> before that we access player's name use player.name, now set to private dy , so all change to player.getName()
   3. added comment

-- Player.java -- 

   1. every instance variable is given Private now , so i generate get set for each instance variable , get set will be use if we want to access from other class
   2. added one instance variable boolean quitGame - i already set , if user input 3 in the option which is Quit, it will setQuitGame to true, 
                                                     use by kai yang , when isQuitGame() , then the player wont be playing game in main
   3. player now have arraylist of weapon and item , will be add and remove in Shop, 
      
      should we initially set some item in the backpack for player?
      
      (NEIL)-- i think make it like each player will have a sword, two heal potion then i think is okay if add one more (we set it like default backpack） 
  
-- Main.java -- 

   1. Neil updated with instructions
   
   (NEIL)-- the instructions will only appear when player types "-help", and the game only starts when they type "-start" OR type "yes" after typing "-help".
   
   2. setQuitGame to true if user choose to quit game
   
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
[ 4.15PM 29/12] 
NEIL -- Update Board.java (size of the each square enlarged by one to fit 4 players in)

[ 6.12PM 29/12]
Ann Joe -- Update Shop.java (wanted for Jowen to test out something)

[11.11AM 30/12]
NEIL -- Update Empty.java (for Ann Joe to trial and error)

[2.03pm 30/12]
Ann Joe- update Empty.java 
