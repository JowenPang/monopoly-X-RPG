# fop-assignment

latest update - jowen (2.12pm 29/12)

--Board.java

   1. play() --> created condition even if player does not reach the Start tile but pass through it , will print out level up message also
   2. print() --> before that we access player's name use player.name, now set to private dy , so all change to player.getName()
   3. added comment

--Player.java

   1. every instance variable is given Private now , so i generate get set for each instance variable , get set will be use if we want to access from other class
   2. added one instance variable boolean quitGame - i already set , if user input 3 in the option which is Quit, it will setQuitGame to true, 
                                                     use by kai yang , when isQuitGame() , then the player wont be playing game in main
   3. player now have arraylist of weapon and item , will be add and remove in Shop, 
      
      should we initially set some item in the backpack for player?
  
--Main.java

   1. Neil updated with instructions
   2. setQuitGame to true if user choose to quit game
   

    
