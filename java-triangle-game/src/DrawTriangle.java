import javax.swing.*;
import java.applet.*;
import java.awt.*;

//name: Paul Denteh
//id number: 040916262
//class: BCE LVL 400
//session:Evening
//Date started: 10th october, 2019
//Date Modified: 14th october, 2019
//Date completed: 18th october, 2019


public class DrawTriangle extends Applet
{
    //the instance variables of the class
    public double number1;
    public double number2;
    public double number3;
    public double angle1;
    public double angle2;
    public double angle3;
    public double y3Coordinates;
    public double x3Coordinates;




    // a method to calculate the area of the triangle
    public double getArea(double number1, double number2, double number3)
    {
        double s;
        double area ;
        s = (number1 + number2 + number3)/2;
        area =  Math.sqrt(s*(s-number1)*(s-number2)*(s-number3));

        return area;
    }


    // a method to calculate  the angle of the triangle
    public double getAngle(double opp, double rSide, double lSide)
    {
        double angleParameter;
        double angle;
        double toDegrees;
        angleParameter = ((-Math.pow(opp,2)+Math.pow(rSide,2)+Math.pow(lSide,2))/(2*lSide*rSide));
        angle =  Math.acos(angleParameter);
        toDegrees = Math.toDegrees(angle);

        return toDegrees;
    }

    //a method to determine the type of the triangle
    public void typeOfTriangle(double number1,double number2, double number3,double angle1, double angle2, double angle3)
    {
        if(number1 == number2 && number2 == number3 && number1 == number3 ){
            JOptionPane.showMessageDialog(null, "You have  formed an equilateral triangle");
        }
        else if (angle1 == 90 || angle2 == 90 || angle3 == 90)
        {
            JOptionPane.showMessageDialog(null, "You  have formed a right angle triangle");
        }

        else if( number1 != number2 && number2 != number3 && number1 != number3)
        {
            JOptionPane.showMessageDialog(null, "You  have formed a Scalene triangle");
        }
        else if(number1 == number2 || number1 == number3 || number2 == number3)
        {
            JOptionPane.showMessageDialog(null, "Your have formed an Isosceles triangle");
        }
    }

    public void original ()
    {

    }

    //this is where the main applet programs starts
    //applet has four(4) main life cycle, namely
    //init, start(applet processing), start and stop

    public void init()
    {
        //height = getSize().height;
        //width = getSize().width;
        // setName("MyApplet");
        resize(2000,1000);
    }
    // our main applet method
    public void paint(Graphics g)
    {
        for(int counter = 0; counter <=2  ; counter++) {
            try // error handling
            {

                //user entering 3 inputs
                number1 = Double.parseDouble(JOptionPane.showInputDialog("Please Enter first number"));
                number2 = Double.parseDouble(JOptionPane.showInputDialog("Please Enter second number"));
                number3 = Double.parseDouble(JOptionPane.showInputDialog("Please Enter third number"));


                // statement to check the validity of triangle
                if (number1 + number2 > number3 && number2 + number3 > number1 && number1 + number3 > number2) {

                    counter = 3;
                    //formula to get the last y coordinate, i.e y3
                    y3Coordinates = (Math.pow(number1, 2) - Math.pow(number2, 2) + Math.pow(number3, 2)) / (2 * number1);

                    //formula to the get the last x coordinate, i.e x3
                    x3Coordinates = Math.sqrt((Math.pow(number3, 2)) - Math.pow(y3Coordinates, 2));

                    int scalar = 100; //set a scaler factor to magnify the triangular drawing
                    //assuming our initial x,y coordinates to be (0,0)
                    int[] x = {100, 100, (int) (x3Coordinates * scalar)}; //x coordinates
                    int[] y = {100, (int) (number1 * scalar), (int) (y3Coordinates * scalar)};// y coordinates
                    g.drawPolygon(x, y, 3); //the fuction the draws the triangle


                    DrawTriangle triangle = new DrawTriangle(); //creating an instance of the class DrawTriangle

                    angle1 = triangle.getAngle(number2, number1, number3); //calculates first angle
                    angle2 = triangle.getAngle(number3, number1, number2); //calculates second angle
                    angle3 = triangle.getAngle(number1, number2, number3); //calculates the last angle

                    double area = triangle.getArea(number1, number2, number3); //calling the getArea method
                    triangle.typeOfTriangle(number1, number2, number3, angle1, angle2, angle3); //calling the typeOfTriangle method

                    //printing the area
                    JOptionPane.showMessageDialog(null, "The area of the triangle is: " + area + " unit square");
                    //printing the angles
                    JOptionPane.showMessageDialog(null, "your first angle is: " + angle1 + " degrees");

                    JOptionPane.showMessageDialog(null, "your 2nd angle is: " + angle2 + " degrees");

                    JOptionPane.showMessageDialog(null, "your 2nd angle is: " + angle3 + " degrees");

                } else {

                    JOptionPane.showMessageDialog(null, "sorry your numbers can not form a triangle");
                }


            } catch (NumberFormatException ex)//catching errors
            {

                //user entering 3 inputs
                number1 = Double.parseDouble(JOptionPane.showInputDialog("Please Enter first number"));
                number2 = Double.parseDouble(JOptionPane.showInputDialog("Please Enter second number"));
                number3 = Double.parseDouble(JOptionPane.showInputDialog("Please Enter third number"));


                // statement to check the validity of triangle
                if (number1 + number2 > number3 && number2 + number3 > number1 && number1 + number3 > number2) {

                    counter = 3;
                    //formula to get the last y coordinate, i.e y3
                    y3Coordinates = (Math.pow(number1, 2) - Math.pow(number2, 2) + Math.pow(number3, 2)) / (2 * number1);

                    //formula to the get the last x coordinate, i.e x3
                    x3Coordinates = Math.sqrt((Math.pow(number3, 2)) - Math.pow(y3Coordinates, 2));

                    int scalar = 100; //set a scaler factor to magnify the triangular drawing
                    //assuming our initial x,y coordinates to be (0,0)
                    int[] x = {100, 100, (int) (x3Coordinates * scalar)}; //x coordinates
                    int[] y = {100, (int) (number1 * scalar), (int) (y3Coordinates * scalar)};// y coordinates
                    g.drawPolygon(x, y, 3); //the fuction the draws the triangle


                    DrawTriangle triangle = new DrawTriangle(); //creating an instance of the class DrawTriangle

                    angle1 = triangle.getAngle(number2, number1, number3); //calculates first angle
                    angle2 = triangle.getAngle(number3, number1, number2); //calculates second angle
                    angle3 = triangle.getAngle(number1, number2, number3); //calculates the last angle

                    double area = triangle.getArea(number1, number2, number3); //calling the getArea method
                    triangle.typeOfTriangle(number1, number2, number3, angle1, angle2, angle3); //calling the typeOfTriangle method

                    //printing the area
                    JOptionPane.showMessageDialog(null, "The area of the triangle is: " + area + " unit square");
                    //printing the angles
                    JOptionPane.showMessageDialog(null, "your first angle is: " + angle1 + " degrees");

                    JOptionPane.showMessageDialog(null, "your 2nd angle is: " + angle2 + " degrees");

                } else {

                    JOptionPane.showMessageDialog(null, "sorry your numbers can not form a triangle");
                }


            }
        }


    }
}