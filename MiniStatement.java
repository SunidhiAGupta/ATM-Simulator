import java.util.*;
import javax.swing.*;
import java.awt.*;
class MiniStatement extends JFrame
{
	public int accno,abal,lbal;

	Container c1;
	MiniStatement(int accno)
	{
		this.accno=accno;
		Query q=new Query();
	q.ministatement(accno);


	}
}