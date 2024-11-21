// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private final CANSparkFlex LeftMaster = new CANSparkFlex(1, MotorType.kBrushless);
  private final CANSparkFlex RightMaster = new CANSparkFlex(2, MotorType.kBrushless);
  private final CANSparkFlex LeftSlave = new CANSparkFlex(3, MotorType.kBrushless);
  private final CANSparkFlex RightSlave = new CANSparkFlex(4, MotorType.kBrushless);
  
  private final DifferentialDrive diffDrive = new DifferentialDrive(LeftMaster, RightMaster);

  public DriveTrain() {
    LeftMaster.setInverted(true);
    
    LeftSlave.follow(LeftMaster);
    RightSlave.follow(RightMaster);
  }

  public void Drive(XboxController controller){
    double xSpeed = controller.getLeftY();
    double ySpeed = controller.getRightX();

    if (Math.abs(xSpeed) < 0.3){
      xSpeed = 0;
    } 
    if (Math.abs(ySpeed) < 0.3){
      ySpeed = 0;
    } 

    diffDrive.arcadeDrive(xSpeed, ySpeed);

  }
 
}
