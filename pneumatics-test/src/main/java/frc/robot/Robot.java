/*Jonah Lefkoff--2018/19 season
 *Pnematics testing code
*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class Robot extends IterativeRobot {
  Compressor compressor;
  DoubleSolenoid solenoid1;
  Joystick pad;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    compressor = new Compressor(0);
    solenoid1 = new DoubleSolenoid(0,1);
    pad = new Joystick(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
    compressor = new Compressor(0);
	}

 
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    boolean enabled = compressor.enabled();
    boolean pressureSwitch = compressor.getPressureSwitchValue();
    double current = compressor.getCompressorCurrent();
    SmartDashboard.putBoolean("compressor on: ", enabled);
    SmartDashboard.putBoolean("pressure switch triggered?: ", pressureSwitch);
    SmartDashboard.putNumber("compressor current draw: ", current);
    
    Timer.delay(30);
    solenoid1.set(DoubleSolenoid.Value.kOff);
    Timer.delay(1);
    solenoid1.set(DoubleSolenoid.Value.kForward);
    Timer.delay(1);
    solenoid1.set(DoubleSolenoid.Value.kReverse);
    Timer.delay(1);
    solenoid1.set(DoubleSolenoid.Value.kOff);

    boolean in = pad.getRawButton(1);
    boolean out = pad.getRawButton(2);

    SmartDashboard.putBoolean("x pressed", in);
    SmartDashboard.putBoolean("a pressed", out);
    

    // if(in){
    //   solenoid1.set(DoubleSolenoid.Value.kForward);
    // }
    // else{
    //   solenoid1.set(DoubleSolenoid.Value.kOff);
    // }
    // if(out){
    //   solenoid1.set(DoubleSolenoid.Value.kReverse);
    // }
    // else{
    //   solenoid1.set(DoubleSolenoid.Value.kOff);
    // }

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
