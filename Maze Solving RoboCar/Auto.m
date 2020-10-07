DisconnectBrick(brick);
brick = ConnectBrick('EVOO');
global key
InitKeyboard();
%A few variables of the port positions
colorSensor = 1;
ultrasonicSensor = 2;
gyroSensor = 3;

scanningMotor = 'A';
rightMotor = 'B';
leftMotor = 'C';
liftMotor = 'D';

motorSpeed = 45;
slowModeSpeed = 25;
turnSpeed = 15;
turnTime = 1;
currAngle = 0;
scanSpeed = 10;
vol = 0;

timesForward = 0;
color = 0;

brick.ResetMotorAngle(scanningMotor);
%Set the colormode of the light sensor to Color Code
%Will output the color code of the object
brick.SetColorMode(colorSensor, 4);
brick.GyroCalibrate(gyroSensor);

slowMode = false;

findPickUp = true;
manualControl = false;
findDropOff = false;

counter = 0;
hasNotStopped = true;

%Find the Pickup Location
while findPickUp
    counter = 0;
    hasNotStopped = true;
    while counter < 12
        
        color = brick.ColorRGB(1);
        if color(1) < 6000 && color(1) > 200 && color(2) < 60 && color(2) > 10
            if hasNotStopped
                brick.StopAllMotors();
                pause(2);
                hasNotStopped = false;
            end
        elseif color(1) < 60 && color(1) > 5 && color(2) < 140 && color(2) > 25 && color(3) > 120 && color(3) < 6000
            brick.StopAllMotors();
            findPickUp = false;
            manualControl = true;
            break;
        end
        switch key
         case 'm'
            brick.StopAllMotors();
            findPickUp = false;
            manualControl = true;
            break;
        end
        
        difAngle = brick.GyroAngle(gyroSensor);
        
        pDif = (currAngle - difAngle);
        
        if pDif < 0
            brick.MoveMotor('B', motorSpeed);
            brick.MoveMotor('C', motorSpeed - (2));
        else
            brick.MoveMotor('B', motorSpeed);
            brick.MoveMotor('C', motorSpeed + (2));
        end
        
        md = mod(counter, 6);
        if md == 0
            brick.playTone(vol, 233, 75);	%Bb3
        elseif md == 2
            brick.playTone(vol, 392, 75);	%G4
        elseif md == 4
            brick.playTone(vol, 311, 75);	%Eb4
        end
        
        pause(0.05);
        counter = counter + 1;
        if brick.UltrasonicDist(ultrasonicSensor) < 15
            counter = 100;
        end
        
    end
    brick.StopAllMotors();
    %Set the distance to the left wall
    %The ultrasonic sensor should be looking at the left wall
    
    brick.MoveMotorAngleRel(scanningMotor, 90, -90, 'Brake');
    brick.WaitForMotor(scanningMotor);
    left = brick.UltrasonicDist(ultrasonicSensor);
    brick.MoveMotorAngleRel(scanningMotor, 90, 90, 'Brake');
    brick.WaitForMotor(scanningMotor);
    
    center = brick.UltrasonicDist(ultrasonicSensor);
    
    brick.MoveMotorAngleRel(scanningMotor, 90, 90, 'Brake');
    brick.WaitForMotor(scanningMotor);
    
    right = brick.UltrasonicDist(ultrasonicSensor);
    
    brick.MoveMotorAngleRel(scanningMotor, 90, -90, 'Brake');
    brick.WaitForMotor(scanningMotor);
    
    
    if left > 40
        brick.StopAllMotors();
        
        while (brick.GyroAngle(gyroSensor) - currAngle) > -85
            brick.MoveMotor(rightMotor, turnSpeed);
            brick.MoveMotor(leftMotor, -turnSpeed);
            brick.playTone(vol, 466, 20);
            fprintf("Left: %d\n", brick.GyroAngle(gyroSensor));
            pause(0.05);
        end
        
        brick.StopAllMotors();
        currAngle = brick.GyroAngle(gyroSensor);
        pause(0.5);
        timesForward = 0;
    elseif center > 50
        brick.playTone(vol, 233, 50);
        timesForward = timesForward + 1;
        currAngle = brick.GyroAngle(gyroSensor);
    elseif right > 50
        brick.StopAllMotors();
        
        while (brick.GyroAngle(gyroSensor) - currAngle) < 85
            brick.MoveMotor(rightMotor, -turnSpeed);
            brick.MoveMotor(leftMotor, turnSpeed);
            brick.playTone(vol, 587, 20);
            fprintf("Right: %d\n", brick.GyroAngle(gyroSensor));
            pause(0.05);
        end
        
        brick.StopAllMotors();
        currAngle = brick.GyroAngle(gyroSensor);
        pause(0.5);
        timesForward = 0;
    elseif center > 254 || timesForward > 6
        brick.StopAllMotors();
        brick.MoveMotor(rightMotor, -turnSpeed + 2);
        brick.MoveMotor(leftMotor, -turnSpeed);
        pause(2.5);
        brick.StopAllMotors();
        
        brick.MoveMotorAngleRel(scanningMotor, 90, -90, 'Brake');
        brick.WaitForMotor(scanningMotor);
        left = brick.UltrasonicDist(ultrasonicSensor);
        brick.MoveMotorAngleRel(scanningMotor, 90, 90, 'Brake');
        brick.WaitForMotor(scanningMotor);
        
        center = brick.UltrasonicDist(ultrasonicSensor);
        
        brick.MoveMotorAngleRel(scanningMotor, 90, 90, 'Brake');
        brick.WaitForMotor(scanningMotor);
        
        right = brick.UltrasonicDist(ultrasonicSensor);
        
        brick.MoveMotorAngleRel(scanningMotor, 90, -90, 'Brake');
        brick.WaitForMotor(scanningMotor);
        
        if left > 30
            brick.StopAllMotors();
            
            while (brick.GyroAngle(gyroSensor) - currAngle) > -85
                brick.MoveMotor(rightMotor, turnSpeed);
                brick.MoveMotor(leftMotor, -turnSpeed);
                brick.playTone(vol, 466, 20);
                fprintf("Left: %d\n", brick.GyroAngle(gyroSensor));
                pause(0.05);
            end
            
            brick.StopAllMotors();
            currAngle = brick.GyroAngle(gyroSensor);
            pause(0.5);
            timesForward = 0;
        elseif center > 50
            brick.playTone(vol, 233, 50);
            timesForward = timesForward + 1;
            currAngle = brick.GyroAngle(gyroSensor);
        elseif right > 50
            brick.StopAllMotors();
            
            while (brick.GyroAngle(gyroSensor) - currAngle) < 85
                brick.MoveMotor(rightMotor, -turnSpeed);
                brick.MoveMotor(leftMotor, turnSpeed);
                brick.playTone(vol, 587, 20);
                fprintf("Right: %d\n", brick.GyroAngle(gyroSensor));
                pause(0.05);
            end
            
            brick.StopAllMotors();
            currAngle = brick.GyroAngle(gyroSensor);
            pause(0.5);
            timesForward = 0;
        else
            brick.StopAllMotors();
            
            while (brick.GyroAngle(gyroSensor) - currAngle) < 170
                brick.MoveMotor(rightMotor, -turnSpeed);
                brick.MoveMotor(leftMotor, turnSpeed);
                brick.playTone(vol, 349, 20);
                fprintf("Dead End: %d\n", brick.GyroAngle(gyroSensor));
                pause(0.05);
            end
            
            brick.StopAllMotors();
            currAngle = brick.GyroAngle(gyroSensor);
            pause(0.5);
            timesForward = 0;
        end
    else
        brick.StopAllMotors();
        
        while (brick.GyroAngle(gyroSensor) - currAngle) < 170
            brick.MoveMotor(rightMotor, -turnSpeed);
            brick.MoveMotor(leftMotor, turnSpeed);
            brick.playTone(vol, 349, 20);
            fprintf("Dead End: %d\n", brick.GyroAngle(gyroSensor));
            pause(0.05);
        end
        
        brick.StopAllMotors();
        currAngle = brick.GyroAngle(gyroSensor);
        pause(0.5);
        timesForward = 0;
    end
end

disp('Manual control enabled.');
disp('Controls: Arrow keys for movement');
disp('Controls: Q-Disable slowmode, E-Enable Slow mode');
disp('Controls: W-Lift arm, S-Drop arm');
disp('Controls: K-Return to Autonomous movement');

while manualControl
    pause(0.05);
    switch key
        case 'uparrow'
            if(slowMode)
                brick.MoveMotor(rightMotor, slowModeSpeed);
                brick.MoveMotor(leftMotor, slowModeSpeed);
            else
                brick.MoveMotor(rightMotor, motorSpeed);
                brick.MoveMotor(leftMotor, motorSpeed);
            end
            
        case 'downarrow'
            if(slowMode)
                brick.MoveMotor(rightMotor, -slowModeSpeed);
                brick.MoveMotor(leftMotor, -slowModeSpeed);
            else
                brick.MoveMotor(rightMotor, -motorSpeed);
                brick.MoveMotor(leftMotor, -motorSpeed);
            end
            
        case 'leftarrow'
            if(slowMode)
                brick.MoveMotor(rightMotor, slowModeSpeed);
                brick.MoveMotor(leftMotor, -slowModeSpeed);
            else
                brick.MoveMotor(rightMotor, motorSpeed);
                brick.MoveMotor(leftMotor, -motorSpeed);
            end
            
        case 'rightarrow'
            if(slowMode)
                brick.MoveMotor(rightMotor, -slowModeSpeed);
                brick.MoveMotor(leftMotor, slowModeSpeed);
            else
                brick.MoveMotor(rightMotor, -motorSpeed);
                brick.MoveMotor(leftMotor, motorSpeed);
            end
            
        case 0
            brick.StopMotor('C');
            brick.StopMotor('B');
            brick.StopMotor('D', 'Brake');
            
        case 'w'
            brick.MoveMotorAngleRel(liftMotor, 60, 50, 'Brake');
            
        case 's'
            brick.MoveMotorAngleRel(liftMotor, 60, -50, 'Brake');
            
        case 'q'
            slowMode = false;
            disp('Slow mode disabled');
            
        case 'e'
            slowMode = true;
            disp('Slow mode enabled');
            
        case 'k'
            manualControl = false;
            findDropOff = true;
            brick.StopAllMotors();
            disp('Manual control disabled. Autonomous movement enabled');
            break;
    end
end
brick.GyroCalibrate(gyroSensor);
currAngle = 0;


while findDropOff
    counter = 0;
    hasNotStopped = true;
    while counter < 12
        
        color = brick.ColorRGB(1);
        if color(1) < 6000 && color(1) > 200 && color(2) < 60 && color(2) > 10
            if hasNotStopped
                brick.StopAllMotors();
                pause(2);
                hasNotStopped = false;
            end
        elseif color(1) < 60 && color(1) > 10 && color(2) < 6000 && color(2) > 40 && color(3) > 25 && color(3) < 100
            brick.StopAllMotors();
            findDropOff = false;
            manualControl = true;
            break;
        end
        switch key
         case 'm'
            brick.StopAllMotors();
            findDropOff = false;
            manualControl = true;
            break;
        end
        
        difAngle = brick.GyroAngle(gyroSensor);
        
        pDif = (currAngle - difAngle);
        
        if pDif < 0
            brick.MoveMotor('B', motorSpeed);
            brick.MoveMotor('C', motorSpeed - (2));
        else
            brick.MoveMotor('B', motorSpeed);
            brick.MoveMotor('C', motorSpeed + (2));
        end
        
        md = mod(counter, 6);
        if md == 0
            brick.playTone(vol, 233, 75);	%Bb3
        elseif md == 2
            brick.playTone(vol, 392, 75);	%G4
        elseif md == 4
            brick.playTone(vol, 311, 75);	%Eb4
        end
        
        pause(0.05);
        counter = counter + 1;
        if brick.UltrasonicDist(ultrasonicSensor) < 15
            counter = 100;
        end
        
    end
    brick.StopAllMotors();
    %Set the distance to the left wall
    %The ultrasonic sensor should be looking at the left wall
    
    brick.MoveMotorAngleRel(scanningMotor, 90, -90, 'Brake');
    brick.WaitForMotor(scanningMotor);
    left = brick.UltrasonicDist(ultrasonicSensor);
    brick.MoveMotorAngleRel(scanningMotor, 90, 90, 'Brake');
    brick.WaitForMotor(scanningMotor);
    
    center = brick.UltrasonicDist(ultrasonicSensor);
    
    brick.MoveMotorAngleRel(scanningMotor, 90, 90, 'Brake');
    brick.WaitForMotor(scanningMotor);
    
    right = brick.UltrasonicDist(ultrasonicSensor);
    
    brick.MoveMotorAngleRel(scanningMotor, 90, -90, 'Brake');
    brick.WaitForMotor(scanningMotor);
    
    if center > 254 || timesForward > 6
        brick.StopAllMotors();
        brick.MoveMotor(rightMotor, -turnSpeed + 2);
        brick.MoveMotor(leftMotor, -turnSpeed);
        pause(2.5);
        brick.StopAllMotors();
        
        brick.MoveMotorAngleRel(scanningMotor, 90, -90, 'Brake');
        brick.WaitForMotor(scanningMotor);
        left = brick.UltrasonicDist(ultrasonicSensor);
        brick.MoveMotorAngleRel(scanningMotor, 90, 90, 'Brake');
        brick.WaitForMotor(scanningMotor);
        
        center = brick.UltrasonicDist(ultrasonicSensor);
        
        brick.MoveMotorAngleRel(scanningMotor, 90, 90, 'Brake');
        brick.WaitForMotor(scanningMotor);
        
        right = brick.UltrasonicDist(ultrasonicSensor);
        
        brick.MoveMotorAngleRel(scanningMotor, 90, -90, 'Brake');
        brick.WaitForMotor(scanningMotor);
        
        if left > 50
            brick.StopAllMotors();
            
            while (brick.GyroAngle(gyroSensor) - currAngle) > -85
                brick.MoveMotor(rightMotor, turnSpeed);
                brick.MoveMotor(leftMotor, -turnSpeed);
                brick.playTone(vol, 466, 20);
                fprintf("Left: %d\n", brick.GyroAngle(gyroSensor));
                pause(0.05);
            end
            
            brick.StopAllMotors();
            currAngle = brick.GyroAngle(gyroSensor);
            pause(0.5);
            timesForward = 0;
        elseif center > 50
            brick.playTone(vol, 233, 50);
            timesForward = timesForward + 1;
            currAngle = brick.GyroAngle(gyroSensor);
        elseif right > 50
            brick.StopAllMotors();
            
            while (brick.GyroAngle(gyroSensor) - currAngle) < 85
                brick.MoveMotor(rightMotor, -turnSpeed);
                brick.MoveMotor(leftMotor, turnSpeed);
                brick.playTone(vol, 587, 20);
                fprintf("Right: %d\n", brick.GyroAngle(gyroSensor));
                pause(0.05);
            end
            
            brick.StopAllMotors();
            currAngle = brick.GyroAngle(gyroSensor);
            pause(0.5);
            timesForward = 0;
        else
            brick.StopAllMotors();
            
            while (brick.GyroAngle(gyroSensor) - currAngle) < 170
                brick.MoveMotor(rightMotor, -turnSpeed);
                brick.MoveMotor(leftMotor, turnSpeed);
                brick.playTone(vol, 349, 20);
                fprintf("Dead End: %d\n", brick.GyroAngle(gyroSensor));
                pause(0.05);
            end
            
            brick.StopAllMotors();
            currAngle = brick.GyroAngle(gyroSensor);
            pause(0.5);
            timesForward = 0;
        end
    elseif left > 50
        brick.StopAllMotors();
        
        while (brick.GyroAngle(gyroSensor) - currAngle) > -85
            brick.MoveMotor(rightMotor, turnSpeed);
            brick.MoveMotor(leftMotor, -turnSpeed);
            brick.playTone(vol, 466, 20);
            fprintf("Left: %d\n", brick.GyroAngle(gyroSensor));
            pause(0.05);
        end
        
        brick.StopAllMotors();
        currAngle = brick.GyroAngle(gyroSensor);
        pause(0.5);
        timesForward = 0;
    elseif center > 50
        brick.playTone(vol, 233, 50);
        timesForward = timesForward + 1;
        currAngle = brick.GyroAngle(gyroSensor);
    elseif right > 50
        brick.StopAllMotors();
        
        while (brick.GyroAngle(gyroSensor) - currAngle) < 85
            brick.MoveMotor(rightMotor, -turnSpeed);
            brick.MoveMotor(leftMotor, turnSpeed);
            brick.playTone(vol, 587, 20);
            fprintf("Right: %d\n", brick.GyroAngle(gyroSensor));
            pause(0.05);
        end
        
        brick.StopAllMotors();
        currAngle = brick.GyroAngle(gyroSensor);
        pause(0.5);
        timesForward = 0;
    else
        brick.StopAllMotors();
        
        while (brick.GyroAngle(gyroSensor) - currAngle) < 170
            brick.MoveMotor(rightMotor, -turnSpeed);
            brick.MoveMotor(leftMotor, turnSpeed);
            brick.playTone(vol, 349, 20);
            fprintf("Dead End: %d\n", brick.GyroAngle(gyroSensor));
            pause(0.05);
        end
        
        brick.StopAllMotors();
        currAngle = brick.GyroAngle(gyroSensor);
        pause(0.5);
        timesForward = 0;
    end
end

disp('Manual control enabled.');
disp('Controls: Arrow keys for movement');
disp('Controls: Q-Disable slowmode, E-Enable Slow mode');
disp('Controls: W-Lift arm, S-Drop arm');
disp('Controls: K-END!!!!');

while manualControl
    pause(0.05);
    switch key
        case 'uparrow'
            if(slowMode)
                brick.MoveMotor(rightMotor, slowModeSpeed);
                brick.MoveMotor(leftMotor, slowModeSpeed);
            else
                brick.MoveMotor(rightMotor, motorSpeed);
                brick.MoveMotor(leftMotor, motorSpeed);
            end
            
        case 'downarrow'
            if(slowMode)
                brick.MoveMotor(rightMotor, -slowModeSpeed);
                brick.MoveMotor(leftMotor, -slowModeSpeed);
            else
                brick.MoveMotor(rightMotor, -motorSpeed);
                brick.MoveMotor(leftMotor, -motorSpeed);
            end
            
        case 'leftarrow'
            if(slowMode)
                brick.MoveMotor(rightMotor, slowModeSpeed);
                brick.MoveMotor(leftMotor, -slowModeSpeed);
            else
                brick.MoveMotor(rightMotor, motorSpeed);
                brick.MoveMotor(leftMotor, -motorSpeed);
            end
            
        case 'rightarrow'
            if(slowMode)
                brick.MoveMotor(rightMotor, -slowModeSpeed);
                brick.MoveMotor(leftMotor, slowModeSpeed);
            else
                brick.MoveMotor(rightMotor, -motorSpeed);
                brick.MoveMotor(leftMotor, motorSpeed);
            end
            
        case 0
            brick.StopMotor('C');
            brick.StopMotor('B');
            brick.StopMotor('D', 'Brake');
            
        case 'w'
            brick.MoveMotorAngleRel(liftMotor, 60, 50, 'Brake');
            
        case 's'
            brick.MoveMotorAngleRel(liftMotor, 60, -50, 'Brake');
            
        case 'q'
            slowMode = false;
            disp('Slow mode disabled');
            
        case 'e'
            slowMode = true;
            disp('Slow mode enabled');
            
        case 'k'
            manualControl = false;
            brick.StopAllMotors();
            disp('Manual control disabled. You"re Done');
            break;
    end
end

brick.StopAllMotors();
CloseKeyboard();

function [hue,lu] = findColor(bricka)
color = bricka.ColorRGB(1);
r = color(1);
g = color(2);
b = color(3);

rD = double(r)/1024.0;
gD = double(g)/1024.0;
bD = double(b)/1024.0;

mi = min([rD,gD,bD]);
ma = max([rD,gD,bD]);
lu = (mi+ma)/2;

hue = 0;

if rD == ma
    hue = (gD-bD)/(ma-mi);
end
if gD == ma
    hue = 2+(bD-rD)/(ma-mi);
end
if bD == ma
    hue = 4+(rD-gD)/(ma-mi);
end

hue = hue*60;
lu = lu * 100;
end

function [pitch] = genTone(r)
rt = mod(r, 3);
pitch = 110;
switch rt
    case 0
        pitch = 110;
    case 1
        pitch = 130;
    case 2
        pitch = 165;
end
end