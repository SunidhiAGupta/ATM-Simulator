import java.util.*;
import java.text.*;

public class Deposit
{
	int accno,amount,current_abal,prev_abal;

	Deposit(int accno,int amount)
	{
		this.accno=accno;
		this.amount=amount;
		Query q=new Query();


		this.prev_abal=q.getacc(accno,"abal");



			this.current_abal=this.prev_abal+amount;

			q.update_deposit(this.current_abal,accno,amount);
			q.update_deposit_trans(this.current_abal,accno,amount);



	}



}