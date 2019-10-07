
public interface LockADT {
	void setX(int x1);
	void setY(int y1);
	void setZ(int z1);
	void alter(int x1, int y1, int z1);
	void setCurrently(int cur);
	int currently();
	void turn(int direction, int number);
	void close();
	boolean inquire();
	boolean attempt();
}
