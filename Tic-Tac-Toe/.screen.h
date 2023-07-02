#ifndef screen_H 
#define screen_H
#include <iostream> //basic functions
#include <cstdlib>  //for the struct 
#include <cstring>  //for string functions
#include <sstream>  //for string stream
#include ".Define.h" //for predefined vraibales/Colors
using namespace std;
/*this is the Board that have 2 Blocks 
the frist is for moves and hold a char as u see 
the other is for tracing the winner and light is out for 
an easy view */
typedef struct{
    char Moves[Boardsize];
    bool Trace[Boardsize];
} Table;
string color[Boardsize][Boardsize];


//the fancy logo will prompt on the game running 
void logo(){
    printf("%s   _______     %s    ______               %s______         \n",RED,YELLOW,GREEN);
    printf("%s  /_  __(_)____%s   /_  __/___  _____    %s/_  __/___  ___ \n",RED,YELLOW,GREEN);
    printf("%s   / / / / ___/%s    / / / __ `/ ___/     %s/ / / __ \\/ _ \\ \n",RED,YELLOW,GREEN);
    printf("%s  / / / / /__ %s    / / / /_/ / /__      %s/ / / /_/ /  __/\n", RED, YELLOW, GREEN);
    printf("%s /_/ /_/\\___/%s    /_/  \\__,_/\\___/   %s  /_/  \\____/\\___/ \n", RED, YELLOW, GREEN);

    reset();
}

//a function to clear screen from history for a better view 
void cls(){
    system("clear"); 
    
} 

//it will print the winner name 
void print_result(bool winner,string winnername,char player){
    if (winner == true) { 
        if(player=='X'){
            printf("\n\t\t\t\t   %s%s",RED, winnername.c_str());
            reset();
            printf("%s Win       \n", GOLD);
        }else{
            printf("\n\t\t\t\t      %s%s",GREEN, winnername.c_str());
            reset();
            printf("%s Win       \n", GOLD);
        }
        reset();
    }else{
        printf("\n\t\t\t\t       %sTIE!        \n",GREY);
        reset();
    }
   
}

/*this will fill the board with number from 1 till 9  at the start of the game
then it will always update the board whenever a new spot has just got filled*/
Table *board_update(bool start,Table *Board,int player1_score,int player2_score,bool winnertracer ){
    system("clear");
    printf("\t\t\t\t      %sScore",GREY);
    printf("\n\t\t\t\t%s      %d %s|%s %d     \n", WHITE, player1_score, GREY,WHITE,player2_score);
    printf("\n");
    if (start==true){
        int counter=1;
        for (int row=0; row<Boardsize ; row++)
            for (int column=0; column<Boardsize; column++){
                stringstream tostring;
                tostring <<counter ;
                tostring >> Board[row].Moves[column]; 
                Board[row].Trace[column] = false;
                color[row][column]=WHITE;
                counter++;
            } 
    }else {
        
        if(winnertracer==false){ 
            for (int row = 0; row < Boardsize; row++) for (int column = 0; column < Boardsize; column++) {
                    string getboard_values;
                    getboard_values.push_back(Board[row].Moves[column]);

                    if(getboard_values.compare("X")==0) color[row][column] = RED;
                    else if(getboard_values.compare("O")==0) color[row][column] = GREEN;
                } 
            
        }else{
            for (int row = 0; row < Boardsize; row++) for (int column = 0; column < Boardsize; column++) {
                string getboard_values;
                getboard_values.push_back(Board[row].Moves[column]);

                if(Board[row].Trace[column]==true)  
                    if(Board[row].Moves[column]=='X') color[row][column] = RED;    
                    else color[row][column] = GREEN; 
                else color[row][column] = WHITE;
            } 
        }
    }

    //the board shape
    printf("\t\t\t\t%s     |     |     \n", YELLOW);
    printf("\t\t\t\t%s  %c %s |  %s%c %s |  %s%c\n", color[0][0].c_str(), Board[0].Moves[0], YELLOW, color[0][1].c_str(), Board[0].Moves[1], YELLOW, color[0][2].c_str(), Board[0].Moves[2]);
    printf("\t\t\t\t%s_____|_____|_____\n", YELLOW);
    printf("\t\t\t\t     |     |     \n", YELLOW);
    printf("\t\t\t\t%s  %c%s  |  %s%c%s  |  %s%c\n", color[1][0].c_str(), Board[1].Moves[0], YELLOW, color[1][1].c_str(), Board[1].Moves[1], YELLOW, color[1][2].c_str(), Board[1].Moves[2]);
    printf("\t\t\t\t%s_____|_____|_____\n", YELLOW);
    printf("\t\t\t\t%s     |     |     \n", YELLOW);
    printf("\t\t\t\t%s  %c %s |  %s%c  %s|  %s%c  \n", color[2][0].c_str(), Board[2].Moves[0], YELLOW, color[2][1].c_str(), Board[2].Moves[1], YELLOW, color[2][2].c_str(), Board[2].Moves[2]);
    printf("\t\t\t\t%s     |     |     \n", YELLOW);
    reset();
   
     

    return 0;
}
#endif