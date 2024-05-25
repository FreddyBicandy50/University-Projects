/*




*/

#include <LiquidCrystal_I2C.h>
#include <Display.h>
#include <Buzzer.h>
#include <RFID.h>
#include <Wire.h>

#define BUZZER 8

String ID;

void Access_sound(bool);
void Access(bool);

void setup()
{
	Serial.begin(9600);
	SPI.begin();
	lcd.init();
	mfrc522.PCD_Init();
	lcd.backlight();

	start_sound();

	lcd.setCursor(0, 0);
	Display_CardInfo("Scanning...", 0);
}
void loop()
{

	lcd.setCursor(0, 0);
	noTone(BUZZER);

	if (!mfrc522.PICC_IsNewCardPresent() || !mfrc522.PICC_ReadCardSerial())
		return;

	ID = Read_RFID();
	ID.toUpperCase();
	if (ID.substring(1) == "23 13 16 1C")
		Access(true);
	else
		Access(false);
}

void Access(bool auth)
{
	if (auth)
	{
		Access_sound(true);
		// display info
		lcd.clear();
		Display_CardInfo(ID, 0);
		Display_CardInfo("Access granted", 1);

		delay(2000);
		lcd.clear();
		Display_CardInfo("Scanning...", 0);
	}
	else
	{
		Access_sound(false);
		// display info
		lcd.clear();
		Display_CardInfo(ID, 0);
		Display_CardInfo("Access denied", 1);
		// reset display
		delay(2000);
		lcd.clear();
		Display_CardInfo("Scanning...", 0);
	}
}
