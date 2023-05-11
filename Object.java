/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drone_david;

/**
 *
 * @author davidlimbu
 */
public abstract class Object {
	protected double x, y;						// position and size of Object
	static int ObjectCounter = 0;						// used to give each Object a unique identifier
	protected int ObjectID;							// unique identifier for item

	Object() {
		this(100, 100);
	}
	/**
	 * Object
	 * construct a Object of radius ir at ix,iy
	 * @param ix x position of the object
	 * @param iy y position of the object
	 * @param ir radius/size of the object
	 */
	Object (double ix, double iy) {
		x = ix;
		y = iy;
		ObjectID = ObjectCounter++;			// set the identifier and increment class static
	}
	/**
	 * getX
	 * return x position
	 * @return x position
	 */
	public double getX() { return x; }
	/**
	 * getY
	 * return y position
	 * @return y position
	 */
	public double getY() { return y; }
	/**
	 * getRad
	 * return radius of Object
	 * @return radius/size
	 */
	/** 
	 * setXY
	 * set the Object at position nx,ny
	 * @param nx new x position
	 * @param ny new y position
	 */
	public void setXY(double nx, double ny) {
		x = nx;
		y = ny;
	}
	/**
	 * getID
	 * return the identity of Object
	 * @return ID of the object
	 */
	public int getID() {return ObjectID; }
	/**
	 * drawObject
	 * draw a Object into the canvas
	 * @param mc canvas
	 */
	public void drawObject(MyCanvas mc) {
		
	}
	
	/**
	 * getStrType
	 * @return type 
	 */
	protected String getStrType() {
		return "Object";
	}
	/** 
	 * toString
	 * return string describing Object
	 */
	public String toString() {
		return getStrType()+" at "+Math.round(x)+", "+Math.round(y);
	}
	/**
	 * checkObject
	 * abstract method for checking a Object in arena b
	 * @param b drone arena
	 */
	protected void checkObject(DroneArena b) {}
	/**
	 * adjustObject
	 * abstract method for adjusting a Object (?moving it)
	 */
	protected void adjustObject() {}
	/**
	 * hitting
	 * is Object at ox,oy size or hitting this Object
	 * @param ox old x 
	 * @param oy old y
	 * @param or old radius
	 * @return true if hitting
	 */
	/*public boolean hitting(double ox, double oy, double or) {
		return (ox-x)*(ox-x) + (oy-y)*(oy-y) < (or+rad)*(or+rad);
	}		// hitting if dist between Object and ox,oy < ist rad + or
	*/
	/** is Object hitting the other Object
	 * 
	 * @param Obj  the other Object
	 * @return true if hitting
	 */
	/*public boolean hitting (Object obj) {
		return hitting(obj.getX(), obj.getY(), obj.getRad());
	}
	*/
	/**
	 * saving 
	 * empty to be added to 
	 * @return empty string
	 */
	public String saving() {
		return "";
	}
}