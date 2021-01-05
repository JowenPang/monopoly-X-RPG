# fop-assignment
[ 4.15PM 29/12] NEIL -- Update Board.java (size of the each square enlarged by one to fit 4 players in)

[ 6.12PM 29/12] Ann Joe -- Update Shop.java (wanted for Jowen to test out something)

[11.11AM 30/12] NEIL -- Update Empty.java (for Ann Joe to trial and error)

[2.24pm 30/12] Ann Joe- update Empty.java

[11.18pm 30/12] Jowen - update Board( player array change to static so that Sin can access)
                      - update Sin (now can access to player array ,  no more null pointer exception
                      - added git , if you free can go download git , the feature is very useful in your IDE , like can push and pull to update , no need copy paste
                        but the process a bit complicated , i also dunno how to do it actually haha
                       
[12.56am 1/1] Jowen - Update Board.java - resetSquare() method to shuffle the arrangement of tile in board
                                        - printBoard() can show short message inside board(player name + dice value)
                                        
                     - Create Sin.java - will trigger battle between player if two players in same tiles(haven't set condition to be >level5)
                                       - battle with monster if only one player in the tile
                                      
                    - Update Monster.java - constructor, monster object will be create in Main
                    
                    - Update Role.java - add one more constructor , player will access the empty constructor , monster will access constructor with parameter
                    
                    - Update Main.java - related to shuffle tile in Board
for testing *

[10.26pm 2/1] Ann Joe- create Chest.java - when reach the tiles of chest can either obtain gold or rare item, now i do as when they reach chest tile then choose 1 or 2.
                                           if choose 1 then will random the amount of gold, else if choose 2 will randomise the rare item
                                           
                     - update Square.java - delete the chest inisde square as i created the chest.java
                     - update Start.java - delete the set level inside the start because level up depends on the EXP
                     
                    
[6.52pm 3/1] cf - update main.java (code to print winner & condition to end game)
                - update board.java (determine winner & create monster[] array with 5 monsters)
                - update monster.java (update toString())
                - update square.java (update how sin duo tri use randomized monster)
                
[2.34am 5/1] cf - update board.java (cancel out player quited game) (update determine winner)

[9.05pm 5/1] Neil 
- Update determineWinner method in board (to compare amount of Gold else comparing levels)
- Link battles against battles in SIN, DUO, TRI
- Organize sections to avoid confusions

What we left for now?
--> player battle areas, maybe need amend something
--> damage formula may have bugs, can consider them haha idk
--> shall we use wait()?

