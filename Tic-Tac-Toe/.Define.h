// defining File.H
#ifndef Define_H
#define Define_H
#define Boardsize 3 
#define _POSIX1_SOURCE 2          // for system based command (bash)

// bash colored output
void reset(){
    printf("\033[0m");
} 
#define RESET "\033[0m"   // Original color
#define RED "\033[1;31m"    // Red
#define Purple "\033[0;35m"
#define GREEN "\033[1;32m"  // Green
#define YELLOW "\033[1;33m" // Yellow
#define GOLD "\033[3;33m" // Yellow
#define GREY "\033[90m"   // Yellow
#define BLUE "\033[1;34m"   // Blue
#define WHITE "\033[1;37m"  // White
#define CYAN "\033[1;36m"   // Cyan

#endif //! Define_H