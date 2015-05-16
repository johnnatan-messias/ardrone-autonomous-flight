int analTempPin = A0;
float temp = 0;
float correctFactor = 0.768744354;

void setup(){
  Serial.begin(9600);
}

void loop(){
  temp = analogRead(analTempPin);
  temp = ((5.0 * correcFactor) * temp * 100.0)/1024.0;  
  Serial.println(temp);
  delay(200);
}
