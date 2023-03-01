// calling libraries and defining fnctions
#include <iostream>  //basic functions
#include ".Define.h"  //for predefined const Variables and colors
#include ".Game.h"    //for predefined Variables
using namespace std; // to avoid using std with every io funciont

  // main function
int main(void){
    /*to clear the terminal screen from any history commands (function file:screen.h)
    diplay the fancy TIK TAC TOE logo    (function file:screen.h)*/
    cls();
    logo();

    /*asking the user constantly for a choice to play single or multiplayer
    NOTE:ANY OTHER VALUE THE PROGRAM WON"T ACCEPT
    entering a infinite loop to take a specified choice from user*/

    string choice; 
    do{
        cout << "Multi-Player/Single Player? [m/s]:"; 
        cin >> choice;                                

        
        if (choice.compare("S") != 0 && choice.compare("s") != 0 && choice.compare("m") != 0 && choice.compare("M") != 0)
            cout << RED << "please enter one of the following options\n" << WHITE;
        else
            if (choice.compare("S") == 0 || choice.compare("s") == 0) {
                string difficulty, playername;
                cout << YELLOW << "player name" << WHITE << ":"; 
                cin >> playername;                               

                do{ 
                    cout << "Difficulty:" << GREEN << "Easy" << WHITE << "/" << RED << "Hard" << WHITE << ":";
                    cin >> difficulty; 

                    if (difficulty.compare("easy") != 0 && difficulty.compare("Easy") != 0 && difficulty.compare("hard") != 0 && difficulty.compare("Hard") != 0)
                        cout << RED << "invalid Option!\n"<< WHITE;
                    else 
                        if (difficulty.compare("easy") == 0 || difficulty.compare("Easy") == 0)
                        singleplayer(playername, false);

                         else if (difficulty.compare("hard") == 0 || difficulty.compare("Hard") == 0)
                        singleplayer(playername, true); 

                } while (difficulty.compare("easy") != 0 && difficulty.compare("Easy") != 0 && difficulty.compare("hard") != 0 && difficulty.compare("Hard") != 0);
            }
            else{
                string player1name, player2name;
                cout << YELLOW << "player1 name" << WHITE << ":";
                cin >> player1name;
                cout << YELLOW << "player2 name" << WHITE << ":";
                cin >> player2name;
                multiplayer(player1name, player2name);
            }
    } while (choice.compare("S") != 0 && choice.compare("s") != 0 && choice.compare("m") != 0 && choice.compare("M") != 0);

    return   0;
} 
  