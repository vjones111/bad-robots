// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;
  
  // SparkMax is a type of motor, the channel is where to find it on robot
  private final PWMSparkMax m_motor1 = new PWMSparkMax(0);
  private final PWMSparkMax m_motor2 = new PWMSparkMax(1);

  private final PS5Controller m_ctrl = new PS5Controller(0); // port number is whatever, we're not *actually* doing it proper

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  private enum Spin {
    FORWARDS,
    BACKWARDS,
    OFF;

    private final double SPEED = 1.0;

    public void set_motors(PWMSparkMax left, PWMSparkMax right) {
      switch (this) {
      case FORWARDS:
        left.set(SPEED); // speed is in [-1,1]
        right.set(-SPEED);
        System.out.println("going forth");
        break;
      case BACKWARDS:
        left.set(-SPEED);
        right.set(SPEED);
        System.out.println("retreating");
        break;
      case OFF:
        left.stopMotor();
        right.stopMotor();
        System.out.println("legs broken");
        break;
      }
    }
  }

  private Spin spin = Spin.OFF;

  /** This function is called periodically during operator control.
   * If you believe the docs, this is once per 20ms
   */
  @Override
  public void teleopPeriodic() {
    /*
      "intake" of smth like a ball: two motors rolling the ball inwards/outwards
    */

    Spin before = this.spin;

    if (m_ctrl.getCircleButtonPressed()) {
      if (this.spin == Spin.FORWARDS) {
        this.spin = Spin.OFF;
      } else {
        this.spin = Spin.FORWARDS;
      }
    } else if (m_ctrl.getSquareButtonPressed()) {
      if (this.spin == Spin.BACKWARDS) {
        this.spin = Spin.OFF;
      } else {
        this.spin = Spin.BACKWARDS;
      }
    }
    
    // avoid wasted i/o calls to motors
    if (this.spin != before) {
      this.spin.set_motors(m_motor1, m_motor2);
    }
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
