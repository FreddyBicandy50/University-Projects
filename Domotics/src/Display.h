#include <LiquidCrystal_I2C.h>
#include <Wire.h>
#include <Arduino.h>

#define Display_H

LiquidCrystal_I2C lcd(0x27, 16, 2); // set the LCD address to 0x27 for a 16 chars and 2 line display

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
}