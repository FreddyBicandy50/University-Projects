/*




*/

#include <SPI.h>
#include <MFRC522.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>

#define BUZZER 8
#define RST_PIN 9
#define SS_PIN 10

void sound(bool);
String Read_RFID();
void display(String, int);

MFRC522 mfrc522(SS_PIN, RST_PIN);
LiquidCrystal_I2C lcd(0x27, 16, 2); // set the LCD address to 0x27 for a 16 chars and 2 line display

void setup()
{
	Serial.begin(9600);
	SPI.begin();
	lcd.init();		 // initialize the lcd
	lcd.backlight(); // open the backlight

	mfrc522.PCD_Init();
	tone(BUZZER,800);
	delay(200);
	tone(BUZZER,800);
	delay(200);
	noTone(BUZZER);
	display("Scanning...", 0);
}
void loop()
{
	String ID;
	lcd.setCursor(0, 0); 
	if (!mfrc522.PICC_IsNewCardPresent() || !mfrc522.PICC_ReadCardSerial())
		return;

	ID = Read_RFID();
	ID.toUpperCase();

	if (ID.substring(1) == "23 13 16 1C")
	{
		sound(true);
		lcd.clear();
		display("ID:", 0);
		display(ID, 0);
		display("Access granted", 1);
		return;
	}
	else
	{
		sound(false);
		lcd.clear();
		display("ID:", 0);
		display(ID, 0);
		display("Access denied", 1);
		return;
	}
}

String Read_RFID()
{
	String content = "";
	for (byte i = 0; i < mfrc522.uid.size; i++)
	{
		Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");
		Serial.print(mfrc522.uid.uidByte[i], HEX);
		content.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
		content.concat(String(mfrc522.uid.uidByte[i], HEX));
	}
	return content;
}
void display(String message, int position)
{
	lcd.setCursor(0, position);
	lcd.print(message);
}
void sound(bool auth)
{

	if (auth)
	{
		tone(BUZZER, 1000); // Play tone at 1000 Hz
		delay(200);			// for 200 ms
		tone(BUZZER, 1200); // Play tone at 1200 Hz
		delay(200);			// for 200 ms
		tone(BUZZER, 1400); // Play tone at 1400 Hz
		delay(200);			// for 200 ms
		noTone(BUZZER);		// Stop the tone
	}
	else
	{
		tone(BUZZER, 500);
		delay(300);
		noTone(BUZZER);
		delay(100);
		tone(BUZZER, 500);
		delay(300);
		noTone(BUZZER);
	}
}