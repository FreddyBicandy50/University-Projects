//defining the Header File
#ifndef  Game_H
#define Game_H
#include <iostream>     //basic functions 
#include <chrono>       //for system colock function
#include <random>       //to random numbers
#include <sstream>      //to stringstream func 
#include ".Define.h"     //for predefined const Variables
#include ".screen.h"     //for init/update board,print winner... 
#include ".AI.h"         //for Minimax function
using namespace std;    
using namespace std::chrono;

//Initializing these variables publicly will save me some memory and parameters. 
//game Components
Table *Board = (Table *)malloc(sizeof(Table) * Boardsize); // array of Board size of 3
bool playerturn;
char Winner_Announcement,p1,p2;   //to hold winner X/O, player Move=[X/O]/Computer_Move=[X/O]
int Game_runing,player1_score = 0, player2_score = 0;  //counters the 1st to count how many spot left the others for players score
void restart_game(string , bool ,bool,string); //function to prompt a restart when the game just end


//initialise the board with numbers form 1 till 9 and printing it 
void setup_game(){

    /*parsing the Board as a pointer so we can remodify It later on, 
    the true parameter indicates  the game just started (function from:screen.h)*/
        board_update(true, Board, player1_score, player2_score,false); 
    
    //get a forced random number via colock value to acheive balance in game
    u_int16_t seed = system_clock::now().time_since_epoch().count();
    srand(seed); // Set the numbers for int.

    //check if random function gave me 1 p1 will play as X and p2 as O 
    if (rand() % 2 + 1 == 1) {
        p1 = 'X';
        p2 = 'O';
    }else{
        p1='O';
        p2='X';
    }
}

//function to check if we have a winner after 5 attemps
bool check_winner(){
    
    //rows
    for (int row = 0; row < Boardsize; row++)
        if (Board[row].Moves[1]==Board[row].Moves[0] && Board[row].Moves[2] == Board[row].Moves[0]){
            Winner_Announcement = Board[row].Moves[0];  
            for (int i = 0; i <Boardsize ; i++) Board[row].Trace[i]=true; 
            return true;
        }
    
    
    //columns
    for (int column = 0; column < Boardsize; column++)
        if (Board[1].Moves[column] == Board[0].Moves[column] && Board[2].Moves[column] == Board[0].Moves[column]) {
            Winner_Announcement = Board[1].Moves[column];
            for (int i = 0; i <Boardsize ; i++) Board[i].Trace[column]=true; 
            return true;
        }  
   
 
    //diagionles
        //left
        int counter=0,temp=Boardsize;
        for (int row = 0; row < Boardsize; row++){
            for (int column = 0; column < Boardsize; column++)
                if (column == row) if (Board[row].Moves[column] == Board[row + 1].Moves[column + 1]) counter++;
            if (counter==2){
                Winner_Announcement = Board[0].Moves[0];
                Board[0].Trace[0]=true; 
                Board[1].Trace[1]=true; 
                Board[2].Trace[2]=true; 
                return true;
            }
        }

        //right diagonal
        counter=0;
        for (int row=0; row<Boardsize; row++){
            temp-=1;
            for (int column=0; column<Boardsize; column++) 
                if (column == temp) if(Board[row].Moves[column]==Board[row+1].Moves[temp-1]) counter++; 
            if(counter==2){
                Winner_Announcement = Board[0].Moves[2];
                Board[0].Trace[2]=true; 
                Board[1].Trace[1]=true; 
                Board[2].Trace[0]=true; 
                return true;
            }
        }
    
    return false;
}

//to set players moves on the Board
void set_move(bool isp1,string spot){ 
   for (int row=0; row<Boardsize; row++) for (int column=0; column<Boardsize; column++)
        if (Board[row].Moves[column]==spot[0]  ){ 
            if(isp1==true){ 
                Board[row].Moves[column]=p1; 
                playerturn=false;
            }else{
                Board[row].Moves[column]=p2; 
                playerturn=true;
            }
            board_update(false,Board,player1_score,player2_score,false); 
            Game_runing++;
        }  
            

}
//this function will activate if the user choose to play with boot 
void singleplayer(string playername,bool AI){

    // initialise the board and decide who will play with X or O
    setup_game();   
    Game_runing=0;
    if(p1=='X') playerturn=true;
    else playerturn=false; 

    while(true){
        /*if the game spot counter is at 9 no spots left 
          we will check if we have a winner or NOT*/
        if (Game_runing == 9 && check_winner() == false) {
            print_result(false," ",Winner_Announcement);
            restart_game(playername,true,AI," ");
        }

        /*the minimum wage to win a tic tac toe game is by
            5 moves so we tested if we filled 5 spots yet
            the checking for a winner will take its process
            after each start of the loop*/
        if (Game_runing >= 5 && check_winner()==true){
            //if we do have a winner we need to know who it is and announce it out
            if (Winner_Announcement == p1) {
                player1_score++;
                board_update(false,Board,player1_score,player2_score,true);
                print_result(true, playername, Winner_Announcement);
            }else {
                player2_score++;
                board_update(false,Board,player1_score,player2_score,true);
                print_result(true, "computer", Winner_Announcement);
            }
            restart_game(playername,true,AI," "); 
        }
        
        /*in tic tac toe game X is always the first  as Maximiser
        and O is the minimiser*/ 
        if(playerturn==true){
            //asking the user constantly for a spot in the rage
            string spot;
            do{ 
                cout << playername << " Turn" << YELLOW << ">" << WHITE;
                cin >> spot;
                if ((spot.length() > 1) || (spot[0] < '1' || spot[0] > '9')){
                    cout << RED << "invaild Spot!" << WHITE << endl;
                    spot = ' ';
                } 
            }while (spot[0] < '1' || spot[0] > '9');
            // setting the player spot decision
            set_move(true,spot);
            if(playerturn!=false ) cout<<RED<<"Aleardy Occupied"<<WHITE<<endl; 
         
        }else{
            //is player choose easy option the bot wil play randomly
            if(AI!=true){
                do{
                    //generating random numbers form 1/9
                    u_int16_t seed = system_clock::now().time_since_epoch().count();
                    srand(seed); // Set the numbers for int.
                    stringstream tochar;
                    tochar << rand() % 9 + 1;
                    char spot[3];
                    tochar >> spot[0]; 
                    set_move(false,spot);
               } while (playerturn!=true);
            }else{
                string bestmove=compMove(Board,9-Game_runing,p1,p2);    
               set_move(false,bestmove);
            }  
        }  
    }  
}

void multiplayer(string player1name, string player2name){
    // initialise the board
    setup_game();
    if (p1 == 'X') playerturn = true;
    else playerturn = false; 
    Game_runing=0;

    /*the same mechanism of the game for single player
    is used by the multiplayer just for know the p2 is a human
    and rather than generating a number we will take a value from him*/
     
    while (true){
        if (Game_runing == 9 && check_winner() == false){
            print_result(false, " ", Winner_Announcement);
            restart_game(player1name, false, false, player2name);
        }
        if (Game_runing >= 5 && check_winner() == true){
            if (Winner_Announcement == p1){
                player1_score++;
                board_update(false, Board, player1_score, player2_score, true);
                print_result(true, player1name, Winner_Announcement);
            }else{
                player2_score++;
                board_update(false, Board, player1_score, player2_score, true);
                print_result(true, player2name, Winner_Announcement);
            }
            restart_game(player1name, false, false, player2name);
        }

        if (playerturn == true){
            string spot;
            do{
                if (p1 == 'X')
                    cout << player1name << " Turn(" << RED << p1 << WHITE << ")" << YELLOW << ">" << WHITE;
                else
                    cout << player1name << " Turn(" << GREEN << p1 << WHITE << ")" << YELLOW << ">" << WHITE;

                cin >> spot;
                if ((spot.length() > 1) || (spot[0] < '1' || spot[0] > '9')){
                    cout << RED << "invaild Spot!" << WHITE << endl;
                    spot = ' ';
                }
            }while (spot[0] < '1' || spot[0] > '9');

            set_move(true,spot);
            if (playerturn != false) cout << RED << "Aleardy Occupied" << WHITE << endl;
        }else {
            string spot;
            do {
                if (p2 == 'X')
                    cout << player2name << " Turn(" << RED << p2 << WHITE << ")" << YELLOW << ">" << WHITE;
                else
                     cout << player2name << " Turn(" << GREEN << p2 << WHITE << ")" << YELLOW << ">" << WHITE;

                cin >> spot;
                if ((spot.length() > 1) || (spot[0] < '1' || spot[0] > '9')) {
                    cout << RED << "invaild Spot!" << WHITE << endl;
                    spot = ' ';
                }
            } while (spot[0] < '1' || spot[0] > '9');
            set_move(false,spot); 
            if (playerturn != true) cout << RED << "Aleardy Occupied" << WHITE << endl;
        }
         
    }
}

//it will be activated when every the game ends asking the user for antoher match or quit
void restart_game(string player1name, bool MOD, bool AI, string player2name) {
        cout << "again?[y/n]:";
        string restart;
        do {
            cin >> restart;
            if (restart.length() > 1)
                restart = 'K';
        } while (restart[0] != 'y' && restart[0] != 'n' && restart[0] != 'Y' && restart[0] != 'N');

        if (restart[0] == 'y' || restart[0] == 'Y')
            if (MOD == true)
                singleplayer(player1name, AI);
            else
                multiplayer(player1name, player2name);
        
        else exit(0);
}
#endif // ! Game_H
 