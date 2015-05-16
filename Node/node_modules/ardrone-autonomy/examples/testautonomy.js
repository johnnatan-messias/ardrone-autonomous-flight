var autonomy = require('ardrone-autonomy');
var mission = autonomy.createMission();

mission.takeoff()
	   .zero()
	   .altitude(5)
	   .forward(5)
	   .right(3)
	   .backward(5)
	   .left(3)
	   .hover(1000)
	   .land();

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