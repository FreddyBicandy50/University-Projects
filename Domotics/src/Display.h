#include <LiquidCrystal_I2C.h>
#include <Wire.h>
#include <Arduino.h>

#define Display_H

LiquidCrystal_I2C lcd(0x27, 16, 2); // set the LCD address to 0x27 for a 16 chars and 2 line display
bool backlight = true;
int pos = 0;

byte customChar[] = {
    B00100,
    B01110,
    B11111,
    B11111,
    B11111,
    B11111,
    B01010,
    B01000};

void LED(int cursor)
{
    lcd.createChar(0, customChar);
    lcd.home();
    lcd.setCursor(cursor, 1);
    for (int i = 0; i < 7; i++)
    {
        /* code */
    }
    lcd.write(0);
    
}

void Display_CardInfo(String message, int position)
{
    int i;

    i = 0;
    while (message[i] != '\0')
    {
        lcd.setCursor(i, position);
        lcd.print(message[i]);
        delay(10);
        i++;
    }
    pos = i;
}

int Receiver_MOD(String MODE)
{
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print(MODE);
    lcd.setCursor(0, 1);
    if (MODE == "   RFID Reader")
        Display_CardInfo("Scanning...", 1);
  
    return pos;
}

void Display_power()
{
    if (backlight)
    {
        backlight = !backlight;
        lcd.noBacklight();
    }
    else
    {
        backlight = !backlight;
        lcd.backlight();
    }
}