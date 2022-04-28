import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Query
{	int ac;
	String user=null;
	ResultSet rs,rs1;
	static String dbsource="jdbc:odbc:atmdb";
	//static String dbsource="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=atmdb.mdb;";
    Connection connection=null;
	Statement statement=null;
	static String driver= "sun.jdbc.odbc.JdbcOdbcDriver";
	public void mydata()
	{

	try
	{
		

    Class.forName(driver);
    
    connection = DriverManager.getConnection(dbsource, "", "");
    statement=connection.createStatement();
    System.out.println(3);
    rs=statement.executeQuery("select cno,name from customers");
    System.out.println(4);
    ResultSetMetaData metadata=rs.getMetaData();
    int cols= metadata.getColumnCount();

    for ( int i = 1; i <= cols; i++ )
            System.out.printf( "%-8s\t", metadata.getColumnName( i ) );
         System.out.println();

         while ( rs.next() )
         {
            for ( int i = 1; i <= cols; i++ )
               System.out.printf( "%-8s\t", rs.getObject( i ) );
            System.out.println();
         } // end while
      }  // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         System.exit( 1 );
      } // end catch
      catch ( ClassNotFoundException classNotFound )
      {
         classNotFound.printStackTrace();
         System.exit( 1 );
      } // end catch
      finally // ensure statement and connection are closed properly
      {
         try
         {
            statement.close();
            connection.close();
         } // end try
         catch ( Exception exception )
         {
            exception.printStackTrace();
            System.exit( 1 );
         } // end catch
      } // end finally
   } // end mydata


   public String val_password(int usr,int pass)
   {

   	try
   	{
   		System.out.println(" -------------- AMIT IS HERE IN QUERY PREPARATION  ------");
   		System.out.println(" --------------CONNECTION : "+connection );
   	   	Class.forName(driver);
   	 System.out.println(" --------------driver uploaded" );
    	connection = DriverManager.getConnection(dbsource, "atm", "atm");
    		

    	statement=connection.createStatement();
System.out.println(1);
    	rs1=statement.executeQuery("select name from customers where cno="+usr+" AND pin="+pass);
    	System.out.println(2);
    	ResultSetMetaData metadata=rs1.getMetaData();
    	int cols= metadata.getColumnCount();


         while ( rs1.next() )
         {
            for ( int i = 1; i <= cols; i++ )
               user= rs1.getString( i ) ;

         } // end while
         rs1.close();



       }//end try
       catch(Exception e)
       {
       	System.out.println("Exception while creating connection");
       	e.printStackTrace();
       }
       finally // ensure statement and connection are closed properly
      {
         try
         {
        	  if( statement!=null)  statement.close();
        	  if( connection!=null) connection.close();
         } // end try
         catch ( Exception exception )
         {
            exception.printStackTrace();
            System.exit( 1 );
         } // end catch
      } // end finally




    		return user;


   }



   public int getacc(int usr,String choice)
   {
   	try
   	{
   	   	Class.forName(driver);
    	connection = DriverManager.getConnection(dbsource, "", "");

    	statement=connection.createStatement();
    if(choice=="s")
    {
    	System.out.println(5);
    	rs1=statement.executeQuery("select accno from account where cno="+usr+ "AND accno>1000 and accno<2000");
    	System.out.println(6);
    }
    	
    	else if(choice=="c"){
    		System.out.println(7);
    		rs1=statement.executeQuery("select accno from account where cno="+usr+ "AND accno>2000 and accno<3000");
    System.out.println(8);
    	}
    	else if(choice=="abal")
    	{
    		System.out.println(9);
    		rs1=statement.executeQuery("select availablebal from account where accno="+usr);
    		
    	}
    
    	ResultSetMetaData metadata=rs1.getMetaData();
    	
    	int cols= metadata.getColumnCount();
    	System.out.println("Ankit bajaj is on 10th row-->"+10);

         while ( rs1.next() )
         {
            for ( int i = 1; i <= cols; i++ )
              user= rs1.getString( i ) ;

             ac=Integer.parseInt(user);
             System.out.println("Ankit bajaj is on 10th row-->"+10);
         } // end while
         rs1.close();
         System.out.println("Ankit bajaj is on 10th row-->"+10);


       }//end try
       catch(Exception e)
       {
       	System.out.println("ankit bajaj is there-->"+e );
       	e.printStackTrace();
       }
       finally // ensure statement and connection are closed properly
      {
         try
         {
            statement.close();
            connection.close();
         } // end try
         catch ( Exception exception )
         {
        	 System.out.println("Ankit bajaj is on 10th row-->"+10);
        	 exception.printStackTrace();
            System.exit( 1 );
         } // end catch
      } // end finally

    		return ac;


   }


    public void  update_withdrawal(int abal,int lbal,int accno,int amount)
   {
   	try
   	{							java.util.Date today = new java.util.Date();
    							SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa ");
   							    String date = formatter.format(today);

   	   	Class.forName(driver);
    	connection = DriverManager.getConnection(dbsource, "", "");

    	statement=connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);

    	//statement.executeQuery("update account set availablebal="+abal+" where accno="+accno);
    	statement.executeUpdate("update account set availablebal="+abal+" where accno="+accno);
    	//statement.executeQuery("insert into transactions  values (' ',' ',"+amount+",'  ',"+date+","+accno+")");


         //rs1.close();


       }//end try
       catch(Exception e)
       {
       	System.out.println(e);
       }
       finally // ensure statement and connection are closed properly
      {
         try
         {
            statement.close();
            connection.close();
         } // end try
         catch ( Exception exception )
         {
            exception.printStackTrace();
            System.exit( 1 );
         } // end catch
      } // end finally




   }

   public void  update_deposit(int abal,int accno,int amount)
   {
   	try
   	{

   								java.util.Date today = new java.util.Date();
    							SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa ");
   							    String date = formatter.format(today);

   	   	Class.forName(driver);
    	connection = DriverManager.getConnection(dbsource, "", "");

    	statement=connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);

    	//statement.executeQuery("update account set availablebal="+abal+" where accno="+accno);
    	statement.executeUpdate("update account set availablebal="+abal+" where accno="+accno);
    	//statement.executeQuery("insert into transactions  values ( , , ,"+amount+","+date+","+accno+");");




       }//end try
       catch(Exception e)
       {
       	System.out.println(e);
       }
       finally // ensure statement and connection are closed properly
      {
         try
         {
            statement.close();
            connection.close();
         } // end try
         catch ( Exception exception )
         {
            exception.printStackTrace();
            System.exit( 1 );
         } // end catch
      } // end finally




   }

   public String[] ministatement(int accno)
	{
		String res[]=new String[20];
	try
	{

    Class.forName(driver);
    connection = DriverManager.getConnection(dbsource, "", "");

    statement=connection.createStatement();
    System.out.println(11);
    rs=statement.executeQuery("select * from transactions where accno="+accno);
    System.out.println(12);
    ResultSetMetaData metadata=rs.getMetaData();
    int cols= metadata.getColumnCount();

    for ( int i = 1; i <= cols; i++ )
           res[0]= metadata.getColumnName( 1 )+"     	DEBIT  .     			"+ "           "+"	 CREDIT  .  		"+"       "+"	DATE ";


         int i=1;
         while ( rs.next() )
         {

               res[i]= rs.getInt(1)+"     	INR. " +rs.getInt(3)+"  "+ "        "+"						     INR. " +rs.getInt(4) +"        			  "+ rs.getInt(6)+"/"+rs.getInt(7)+"/2007\n" ;
               i++;

         } // end while
      }  // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();

      } // end catch
      catch ( ClassNotFoundException classNotFound )
      {
         classNotFound.printStackTrace();

      } // end catch
      finally // ensure statement and connection are closed properly
      {
         try
         {
            statement.close();
            connection.close();
         } // end try
         catch ( Exception exception )
         {
            exception.printStackTrace();
            System.exit( 1 );
         } // end catch


      } // end finally

      return res;
   } // end ministatement



   public void  update_withdrawal_trans(int abal,int lbal,int accno,int amount)
   {
   	try
   	{							java.util.Date today = new java.util.Date();
    							SimpleDateFormat formatter = new SimpleDateFormat("dd");
   							    String dd = formatter.format(today);
   							    int ddd=Integer.parseInt(dd);



   							    SimpleDateFormat formatter1 = new SimpleDateFormat("MM");
   							    String mm = formatter1.format(today);
   							    int mmm=Integer.parseInt(mm);

   							    //Float date=Float.parseFloat(date1);
   							    //System.out.println(date);


   	   	Class.forName(driver);
    	connection = DriverManager.getConnection(dbsource, "", "");

    	statement=connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);

    	String stm="insert into transactions (withdrawal,accno,dd,mm) VALUES ("+amount+","+accno+","+ddd+","+mmm+")";
    	//statement.executeQuery(stm);
    	statement.executeUpdate(stm);


         //rs1.close();


       }//end try
       catch(Exception e)
       {
       	System.out.println(e);
       }
       finally // ensure statement and connection are closed properly
      {
         try
         {
            statement.close();
            connection.close();
         } // end try
         catch ( Exception exception )
         {
            exception.printStackTrace();
            System.exit( 1 );
         } // end catch
      } // end finally




   }

    public void  update_deposit_trans(int lbal,int accno,int amount)
   {
   	try
   	{							java.util.Date today = new java.util.Date();
    							SimpleDateFormat formatter = new SimpleDateFormat("dd");
   							    String dd = formatter.format(today);
   							    int ddd=Integer.parseInt(dd);



   							    SimpleDateFormat formatter1 = new SimpleDateFormat("MM");
   							    String mm = formatter1.format(today);
   							    int mmm=Integer.parseInt(mm);

   							    //Float date=Float.parseFloat(date1);
   							    //System.out.println(date);


   	   	Class.forName(driver);
    	connection = DriverManager.getConnection(dbsource, "", "");

    	statement=connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);

    	String stm="insert into transactions (deposit,accno,dd,mm) VALUES ("+amount+","+accno+","+ddd+","+mmm+")";
    	//statement.executeQuery(stm);
    	statement.executeUpdate(stm);


         //rs1.close();


       }//end try
       catch(Exception e)
       {
       	System.out.println(e);
       }
       finally // ensure statement and connection are closed properly
      {
         try
         {
            statement.close();
            connection.close();
         } // end try
         catch ( Exception exception )
         {
            exception.printStackTrace();
            System.exit( 1 );
         } // end catch
      } // end finally




   }
    
    
    
    
    
    //123
    public void getLoan(String product,String loanAmountTxt,String tenure,String requestId , String userId , String accno)
    {
    	try
    	{
    	   	Class.forName(driver);
     	connection = DriverManager.getConnection(dbsource, "", "");
     	 
     	statement=connection.createStatement();
     	String query="insert into los_app_applications(product,requested_amount,tenure,requestid ,userid,accno) values('"+product+"','"+loanAmountTxt+"','"+tenure+"','"+requestId+"','"+userId+"','"+accno+"')";
        System.out.println("String query is---------------------------->"+query);
     	statement.executeUpdate(query);
     
     	System.out.println("After Query");

        }//end try
        catch(Exception e)
        {
        	
        	e.printStackTrace();
        }
        finally // ensure statement and connection are closed properly
       {
          try
          {
             statement.close();
             connection.close();
          } // end try
          catch ( Exception exception )
          {
         	
         	 exception.printStackTrace();
             System.exit( 1 );
          } // end catch
       } // end finally

     		


    }


    //123
    
    
    
    
    
    
    
    
}  // end class





