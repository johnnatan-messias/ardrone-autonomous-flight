#include <IRremote.h>

int receiverPin = 11;
int speakerPin = 10;
String value;
IRrecv irrecv(receiverPin);
decode_results results;

void setup(){
  Serial.begin(9600);
  pinMode(speakerPin, OUTPUT);
  irrecv.enableIRIn();
}

void loop(){
  if(irrecv.decode(&results)){
    translateIR();
    irrecv.resume();
    digitalWrite(speakerPin, HIGH);
    delay(50);
    
  }else{
    digitalWrite(speakerPin, LOW);
  }
}

void translateIR(){
   switch(results.value){
     case 0xFFA25D:
       value = "POWER";
       break;
     case 0xFF629D:
       value = "MODE";
       break;       
     case 0xFFE21D:
       value = "MUTE";
       break; 
     case 0xFF22DD:
       value = "PLAYPAUSE";
       break;
     case 0xFF02FD:
       value = "BACK";
       break;   
     case 0xFFC23D:
       value = "FORWARD";
       break;  
     case 0xFFE01F:
       value = "EQ";
       break;  
     case 0xFFA857:
       value = "-";
       break;  
     case 0xFF906F:
       value = "+";
       break;  
     case 0xFF6897:
       value = "0";
       break;  
     case 0xFF9867:
       value = "LOOP";
       break;  
     case 0xFFB04F:
       value = "USD";
       break;  
     case 0xFF30CF:
       value = "1";
       break;  
     case 0xFF18E7:
       value = "2";
       break;  
     case 0xFF7A85:
       value = "3";
       break;  
     case 0xFF10EF:
       value = "4";
       break;  
     case 0xFF38C7:
       value = "5";
       break; 
     case 0xFF5AA5:
       value = "6";
       break; 
     case 0xFF42BD:
       value = "7";
       break; 
     case 0xFF4AB5:
       value = "8";
       break; 
     case 0xFF52AD:
       value = "9";
       break;  
    case 0xFFFFFFFF:
      break;
    default:
       value = "ERROR";  
   }
    Serial.println(value); 
    delay(500);
}
