/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Spark leftMotor1;
  private Spark leftMotor2;
  private Spark rightMotor1;
  private Spark rightMotor2;

  private SpeedControllerGroup leftMotors;
  private SpeedControllerGroup rightMotors;  

  private DifferentialDrive diffDrive;

  public DriveTrain(){
    leftMotor1 = new Spark(RobotMap.leftMotor1);
    leftMotor2 = new Spark(RobotMap.leftMotor2);
    rightMotor1 = new Spark(RobotMap.rightMotor1);
    rightMotor2 = new Spark(RobotMap.rightMotor2);
    leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
    rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);  
    diffDrive = new DifferentialDrive(leftMotors, rightMotors);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive()); //default command for subsystem
  }

  public void arcadeDrive(double move, double turn){
    diffDrive.arcadeDrive(move, turn);
  }
}
