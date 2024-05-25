

#include <LiquidCrystal_I2C.h>
#include <IRremote.h>
#include <Display.h>
#include <Buzzer.h>
#include <Remote.h>
#include <string.h>
#include <Wire.h>
#include <RFID.h>

#define BUZZER 8
#define YELLOW 3
#define GREEN 6
#define RED 5

String MODES[] = {"RFID Reader", "LED Brightness", "Fan Speed", "Temperature", "Warning!"};
bool backlight = true;
int fadeValue = 0;
IRrecv IR(A3);
int fade = 0;
String ID;

void IR_RECEIVER();
void ID_Check();
void light_control();
void Access(bool);

void setup()
{
	Serial.begin(9600);
	SPI.begin();

	// INIT
	lcd.init();
	mfrc522.PCD_Init();

	lcd.backlight();
	IR.enableIRIn();

	// PIN MODE
	pinMode(YELLOW, OUTPUT);
	pinMode(GREEN, OUTPUT);
	pinMode(RED, OUTPUT);
	//
	// Launch Software
	start_sound();
	Receiver_MOD(MODES[0]);
	IR.start();
}

void loop()
{

	// check RFID Cards
	ID_Check();

	// check for remote presses
	IR_RECEIVER();
}

void IR_RECEIVER()
{
	if (IR.decode())
	{

		lcd.clear();
		Serial.println(IR.decodedIRData.decodedRawData, HEX);

		// Check for specific remote codes
		if (IR.decodedIRData.decodedRawData == POWER)
		{
			Display_CardInfo("POWER", 0);
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
		else if (IR.decodedIRData.decodedRawData == PLUS)
		{
			Display_CardInfo("PLUS", 0);
			if (fade < 5)
			{
				fadeValue += 51;
				light_control();
				fade++;
			}
		}
		else if (IR.decodedIRData.decodedRawData == MINUS)
		{
			Display_CardInfo("MINUS", 0);
			if (fade > 0)
			{
				fadeValue -= 51;
				light_control();
				fade--;
			}
		}
		else if (IR.decodedIRData.decodedRawData == MODE)
			Display_CardInfo("MODE", 0);
		else
			Display_CardInfo("UNKNOWN", 0);
		lcd.clear();
		lcd.print(IR.decodedIRData.decodedRawData, HEX);
		delay(50);
		IR.resume(); // Receive the next value
	}
}
void ID_Check()
{
	if (!mfrc522.PICC_IsNewCardPresent() || !mfrc522.PICC_ReadCardSerial())
		return;

	ID = Read_RFID();
	ID.toUpperCase();
	if (ID.substring(1) == "23 13 16 1C")
		Access(true);
	else
		Access(false);

	IR.start();
	return;
}

void light_control()
{
	analogWrite(RED, fadeValue);
	delay(30);
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
		Receiver_MOD(MODES[0]);
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
		Receiver_MOD(MODES[0]);
	}
}
