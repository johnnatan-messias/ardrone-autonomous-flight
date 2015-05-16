var serialport = require('serialport') 
var autonomy = require('ardrone-autonomy');
var mission = autonomy.createMission();
var content;
var altitude = 1;
var isInTheAir = false;
var value = 1;
var angle = 90;
var timeHover = 1000;
var sp = new serialport.SerialPort("/dev/ttyO3", { 
  baudrate: 9600,
  parser: serialport.parsers.readline('\r\n')
});

console.log("Running");

sp.on('data', function(data) {
  content = data;
  console.log(content);
  execute();
})

function execute(){
    switch(content){
      case "MODE":
      break;
    case "POWER":
      if(!isInTheAir){
        console.log("TakeOff");
        mission.takeoff()
          .zero()
          .hover(timeHover)
          .altitude(value);
          isInTheAir = true;
      }else{
        console.log("Landing");
        mission.land();
        isInTheAir = false;
      }
      break;
    case "MUTE":
      console.log("Exit Program");
      process.exit(0);
      break;
    case "1":
      console.log("Execute Mission Square");
      createMissionSquare();
      break;
    case "2":
      console.log("Execute Mission Line");
      createMissionLine();
      break;
    case "3":
      console.log("Execute Mission Triangle");
      createMissionTriangle();
      break;
    case "4":
      console.log("Mission Circle");
      createMissionCircle();
      break;
    case "5":
      console.log("Move Left: " + value + "m");
      mission.left(value);
      break;
    case "6":
      console.log("Move Right: " + value + "m");
      mission.right(value);
      break;
    case "7":
      console.log("Value: " + (--value) + "m");
      break;
    case "8":
      console.log("Value: " + (++value) + "m");
      break;
    case "9":
      console.log("Going to the start point");
      mission.go({x:0, y:0});
      break;
    case "0":
      console.log("Is Working Yeah");
      console.log("Value: " + value + "m");
      console.log("Angle: " + angle + "°");
      break;
    case "PLAYPAUSE":
      console.log("Altitude: " + value + "m");
      mission.altitude(value);
      break;
    case "+":
      console.log("Move Yaw right: " + angle + "°");
      mission.cw(angle);
      break;
    case "-":
      console.log("Move Yaw left: " + angle + "°");
      mission.ccw(angle);
      break;
    case "BACK":
      console.log("Move Back: " + value + "m");
      mission.backward(value);
      break;
    case "FORWARD":
      console.log("Move Front: " + value + "m");
      mission.forward(value);
      break;
    case "LOOP":
      angle -= 15;
      console.log("Angle: " + angle + "°");
      break;
    case "USD":
      angle += 15;
      console.log("Angle: " + angle + "°");
      break;
    case "EQ":
      console.log("Run Mission");
      executeMission();
      break;
  }
}

function createMissionSquare(){
  mission.takeoff()
   .zero()
   .hover(500)
   .altitude(1)
   .forward(2)
   .cw(90)
   .forward(2)
   .cw(90)
   .forward(2)
   .cw(90)
   .go({x:0, y:0})
   .cw(90)
   .hover(1000)
   .land();
}

function createMissionTriangle(){
  mission.takeoff()
    .zero()
    .hover(500)
    .altitude(1)
    .ccw(30)
    .forward(2)
    .cw(120)
    .forward(2)
    .cw(120)
    .go({x:0, y:0})
    .hover(500)
    .land();

}

function createMissionLine(){
  mission.takeoff()
    .zero()
    .hover(500)
    .altitude(1)
    .forward(1)
    .go({x:0, y:0})
    .hover(1000)
    .land();
}

function createMissionCircle(){
  var angleRad = 0;
  var two_pi = Math.PI * 2;
  var radian = 2;
  mission.takeoff()
    .zero()
    .hover(500)
    .altitude(1)
    mission.go({x:radian, y:0});

  while(angleRad < two_pi){
    droneX = radian * Math.sin(angleRad);
    droneY = radian * Math.cos(angleRad);
    angleRad += 0.2; 
    mission.go({x:droneX, y:droneY});
  }

  mission.go({x:0, y:0})
    .hover(1000)
    .land();
}

function degreeToRad(degree){
  return (degree * Math.PI) / 180;
}

function radToDegree(rad){
  return (180 * rad) / Math.PI;
}

function executeMission(){
     mission.run(function (err, result){
  if(err){
    console.trace("Error: %s",err.message);
    mission.client().stop();
    mission.client().land();
  }else{
    console.log("Mission success!");
    process.exit(0);
  }
});
}
