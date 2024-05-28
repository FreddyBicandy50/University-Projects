#include "Header.h"

void ID_Check();
void Access(bool);
void IR_RECEIVER();
void light_control(bool);
void temp();
void flash();

void setup()
{
	Serial.begin(9600);
	SPI.begin();

	// // INIT
	lcd.init();
	mfrc522.PCD_Init();

	lcd.backlight();
	IR.enableIRIn();

	// PIN MODE
	// OUTPUT
	pinMode(YELLOW, OUTPUT);
	pinMode(GREEN, OUTPUT);
	pinMode(RED, OUTPUT);

	// INPUT
	pinMode(TEMP, INPUT);
	pinMode(FLAME, INPUT);

	// Launch Software
	start_sound();
	Receiver_MOD(MODES[Selector]);
	IR.start();
}

void loop()
{
	int prev = celsius;
	rawTemp = analogRead(TEMP);
	celsius = map(((rawTemp - 20) * 3.04), 0, 1023, -40, 125);

	// // check RFID Cards
	if (Selector == 0)
		ID_Check();
	else if (Selector == 3)
		if (celsius != prev)
			temp();
	// check for remote presses
	IR_RECEIVER();
}

void IR_RECEIVER()
{
	if (IR.decode())
	{

		// Serial.println(IR.decodedIRData.decodedRawData, HEX);
		// Check for specific remote codes
		if (IR.decodedIRData.decodedRawData == POWER)
			Display_power();
		else if (IR.decodedIRData.decodedRawData == ZERO)
		{
			if (Selector == 1)
			{
				LED_Selector = 0;
				lcd.clear();
				Receiver_MOD(MODES[1]);
				current_brightness();
			}
		}
		else if (IR.decodedIRData.decodedRawData == ONE)
		{
			if (Selector == 1)
			{
				LED_Selector = 1;
				lcd.clear();
				Receiver_MOD(MODES[1]);
				current_brightness();
			}
		}
		else if (IR.decodedIRData.decodedRawData == TWO)
		{
			if (Selector == 1)
			{
				LED_Selector = 2;
				lcd.clear();
				Receiver_MOD(MODES[1]);
				current_brightness();
			}
		}
		else if (IR.decodedIRData.decodedRawData == PLUS)
		{
			if (Selector == 1)
			{
				light_control(true);
			}
		}
		else if (IR.decodedIRData.decodedRawData == MINUS)
		{
			if (Selector == 1)
			{
				light_control(false);
			}
		}
		else if (IR.decodedIRData.decodedRawData == MODE)
		{
			Selector == 3 ? Selector = 0 : Selector++;

			Receiver_MOD(MODES[Selector]);
			switch (Selector)
			{
			case 0:
				start_sound();
				break;
			case 1:
				if (brightness[0] == 1 && brightness[1] == 1 && brightness[2] == 1)
					flash();
				break;
			case 2:
				Display("Coming Soon!", 1);
				break;
			case 3:
				temp();
				break;
			case 4:
				break;

			default:
				start_sound();
			}

			IR.start();
		}
		delay(50);
		IR.resume(); // Receive the next value
	}
}

void light_control(bool fadeUp)
{
	if (fadeUp)
	{
		if (fade[LED_Selector] < 9)
		{
			lcd.clear();
			fadeValue[LED_Selector] += 28;

			analogWrite(LED[LED_Selector], fadeValue[LED_Selector]);
			Receiver_MOD(MODES[1]);
			fade[LED_Selector]++;
			brightness[LED_Selector] = fade[LED_Selector] * 2;

			if (brightness[LED_Selector] > 18)
				brightness[LED_Selector] = 18;
		}
	}
	else
	{
		if (fade[LED_Selector] > 0)
		{
			lcd.clear();
			fadeValue[LED_Selector] -= 28;

			analogWrite(LED[LED_Selector], fadeValue[LED_Selector]);
			Receiver_MOD(MODES[1]);
			fade[LED_Selector]--;
			brightness[LED_Selector] = fade[LED_Selector] * 2;

			if (brightness[LED_Selector] < 0)
				brightness[LED_Selector] = 0;
		}
	}
	current_brightness();
	delay(30);
}
void temp()
{

	if (celsius < 0)
	{
		celsius += 199;
	}
	else if (celsius > 80)
	{
		int res = celsius - 20;
		celsius = celsius - res;
	}

	lcd.clear();
	Receiver_MOD(MODES[Selector]);
	lcd.setCursor(0, 1);
	lcd.print(celsius);
	if (celsius >= 80)
	{
		buzzerAlert();
		for (int i = 0; i <= 255; i += 5)
		{
			analogWrite(LED[2], i);
			delay(10);
		}
		return;
	}

	delay(1000);
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

void Access(bool auth)
{
	if (auth)
	{
		Access_sound(true);
		// display info
		lcd.clear();
		Display(ID, 0);
		Display("Access granted", 1);
		delay(2000);
		Receiver_MOD(MODES[0]);
	}
	else
	{
		Access_sound(false);
		// display info
		lcd.clear();
		Display(ID, 0);
		Display("Access denied", 1);
		// reset display
		delay(2000);
		Receiver_MOD(MODES[0]);
	}
}

void flash()
{
	for (int i = 0; i < 2; i++)
	{
		digitalWrite(RED, 1);
		digitalWrite(YELLOW, 1);
		digitalWrite(GREEN, 1);

		delay(30);

		digitalWrite(RED, 0);
		digitalWrite(YELLOW, 0);
		digitalWrite(GREEN, 0);
	}
}