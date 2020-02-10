package org.firstinspires.ftc.robotcontroller.internal;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "mixTele", group = "9191")
public class mixedTele extends OpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor linearLift;
    private DcMotor intakeLeft;
    private DcMotor intakeRight;
    private CRServo gripperLeft;
    private CRServo gripperRight;
    private Servo foundationOne;
    private Servo foundationTwo;
    private Servo capStone;
    private CRServo pushBlock;
    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        linearLift = hardwareMap.dcMotor.get("LL");
        intakeLeft = hardwareMap.dcMotor.get("IL");
        intakeRight = hardwareMap.dcMotor.get("IR");
        gripperLeft = hardwareMap.crservo.get("GF");
        gripperRight = hardwareMap.crservo.get("GB");
        foundationOne = hardwareMap.servo.get("F1");
        foundationTwo = hardwareMap.servo.get("F2");
        pushBlock = hardwareMap.crservo.get("PB");
        capStone = hardwareMap.servo.get("CS");
    }

    @Override
    public void loop() {
        double r = Math.hypot(gamepad1.right_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.right_stick_x) - Math.PI / 4;
        double rightX = gamepad1.left_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;
        frontLeft.setPower(v1);
        frontRight.setPower(v2);
        backLeft.setPower(v3);
        backRight.setPower(v4);
        intakeRight.setPower(gamepad2.right_stick_y);
        intakeLeft.setPower(-gamepad2.right_stick_y);
       /* linearLift.setPower(gamepad2.right_stick_y * .65);
        pushBlock.setPower(gamepad2.right_stick_x * .65);
        if(gamepad2.a){
            gripperLeft.setPower(1);
            gripperRight.setPower(1);
        } else if(gamepad2.y){
            gripperRight.setPower(-1);
            gripperLeft.setPower(-1);
        } else{
            gripperLeft.setPower(0);
            gripperRight.setPower(0);
        } /*if(gamepad1.y){
            foundationTwo.setPosition(foundationTwo.getPosition() + .01);
            foundationOne.setPosition(foundationOne.getPosition() + .01);
        } else if(gamepad1.a) {
            foundationOne.setPosition(foundationOne.getPosition() - .01);
            foundationTwo.setPosition(foundationTwo.getPosition() - .01);
        } if(gamepad1.left_bumper){
            capStone.setPosition(capStone.getPosition() - .01);
        } else if(gamepad1.right_bumper){
            capStone.setPosition(capStone.getPosition() + .01);
        }
    */}
}
