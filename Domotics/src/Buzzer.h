#include <Header.h>
#define BUZZER_H


void start_sound()
{

    tone(BUZZER, 800);
    delay(200);
    tone(BUZZER, 800);
    delay(200);
    noTone(BUZZER);
    return;
}

void Access_sound(bool auth)
{

    if (auth)
    {
        tone(BUZZER, 1000); // Play tone at 1000 Hz
        delay(200);         // for 200 ms
        tone(BUZZER, 1200); // Play tone at 1200 Hz
        delay(200);         // for 200 ms
        tone(BUZZER, 1400); // Play tone at 1400 Hz
        delay(200);         // for 200 ms
        noTone(BUZZER);     // Stop the tone
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