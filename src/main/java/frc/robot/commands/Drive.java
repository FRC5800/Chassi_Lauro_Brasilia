// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class Drive extends Command {
  /** Creates a new Drive. */
  private DriveTrain driveTrain;
  private XboxController controller;

  public Drive(DriveTrain driveTrain, XboxController controller) {
    this.driveTrain = driveTrain;
    this.controller = controller;

    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    driveTrain.Drive(controller);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
