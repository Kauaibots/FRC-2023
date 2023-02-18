// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoConstants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoBasic extends SequentialCommandGroup {
  /** Creates a new AutoBasic. */
  private final Trajectory traj1, traj2;
  private final SwerveCommander runner;
  public AutoBasic() {
     traj1 = TrajectoryGenerator.generateTrajectory(new Pose2d(0,0, new Rotation2d(0)),
     List.of(new Translation2d(1,1)), 
     new Pose2d(2, 0, new Rotation2d(Math.toRadians(0))), 
     AutoConstants.config);
     runner = new SwerveCommander();

     traj2 = TrajectoryGenerator.generateTrajectory(
      new Pose2d(2, 0, new Rotation2d(Math.toRadians(0))), 
      List.of(new Translation2d(1,1)),
      new Pose2d(0,0, new Rotation2d(0)), 
      AutoConstants.config);
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(runner.RunTrajectory(traj1), runner.RunTrajectory(traj2));
  }
}
