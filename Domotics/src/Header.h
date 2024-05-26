#ifndef HEADER_H
#define HEADER_H
// LIBRARIES
#include <LiquidCrystal_I2C.h>
#include <IRremote.h>
#include <MFRC522.h>
#include <string.h>
#include <Wire.h>
#include <SPI.h>

#define RST_PIN 3
#define SS_PIN 10
#define BUZZER 8
#define RED 6
#define GREEN 5
#define YELLOW 9
int LED[3] = {YELLOW, GREEN, RED};
int brightness[] = {1, 1, 1};
int fadeValue[] = {0, 0, 0};
int fade[] = {0, 0, 0};
int LED_Selector = 0;
int Selector = 0;

MFRC522 mfrc522(SS_PIN, RST_PIN);
String MODES[] = {"   RFID Reader", " LIGHT Control", "Fan Speed", "Temperature", "Warning!"};
LiquidCrystal_I2C lcd(0x27, 16, 2); // set the LCD address to 0x27 for a 16 chars and 2 line display
bool backlight = true;
IRrecv IR(A3);
int cursor = 0;
String ID;

// FILES
#include <Icons.h>
#include <Display.h>
#include <RFID.h>
#include <Buzzer.h>
#include <Remote.h>
#endif
