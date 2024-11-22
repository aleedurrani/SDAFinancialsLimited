import java.util.ArrayList;
import java.io.File;

public class User {
	private String uni_id;
	private String address;
	private String password;
	public ArrayList<Account> user_accounts;
	
	User(){
		uni_id="";
		address="";
		user_accounts=new ArrayList <Account>();
		password="password";
	}
	User(String n, String a,String p, ArrayList<Account> l){
		uni_id=n;
		address=a;
		user_accounts=l;
		password=p;
		
	}
	User(String n,String a,String p){
		uni_id=n;
		address=a;
		password=p;
		user_accounts= new ArrayList <Account>();
	}
	public String getUni_id() {
		return uni_id;
	}
	public void setUni_id(String uni_id) {
		this.uni_id = uni_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void add_account(Saving a) {
		
		user_accounts.add(a);
		
		
		
	}
	public void add_account(Current a) {
		
		user_accounts.add(a);
		
	}
	
	public boolean acc_limit() {
		if(user_accounts.size()<3) {
			return true;
		}
		else return false;
	}
	public boolean remove_account(int i) {
		boolean fg=false;
		for(int i2=0;i2<user_accounts.size();i2++)
		   if(user_accounts.get(i2).getAcc_id()==i) {
			   user_accounts.remove(i2);
			   fg=true;
			   
		   }
		return fg;
	}
    
	public boolean withdrawl(int i,int tra_id,double amount, File m) {
		boolean f=false;
		for(Account acc:user_accounts)
		{
			   if(acc.getAcc_id()==i) {
				   f=acc.withdrawl(tra_id,amount,m);
			   }
		}
		return f;
	}
	public boolean deposit(int i,int tra_id,double amount,File m) {
		boolean flag=false;
		for(Account acc:user_accounts)
		{
			   if(acc.getAcc_id()==i) {
				   acc.deposit(tra_id,amount,m);
				   flag=true;
			   }
		}
		return flag;
	}
	public void print_acc(int i) {
		for(Account acc:user_accounts)
			   if(acc.getAcc_id()==i) {
				  acc.print_account();
			   }
	}
	public void print_accs() {
		for(Account acc:user_accounts)
			   
				  acc.print_account();
			   
	}
	public void print_transactions() {
		System.out.println();
		System.out.println("The Bank Statement of User ID: "+this.getUni_id()+" is: ");
		for(Account acc:user_accounts)
		{
			acc.printtransactions();
		}
	}
	public void print_acc_transaction(int i) {
		for(Account acc:user_accounts)
			   if(acc.getAcc_id()==i) {
				  acc.printtransactions();
			   }
	}
	public boolean account_exists(int i) {
		for(Account acc:user_accounts) {
			   if(acc.getAcc_id()==i) {
				  return true;
			   }
		}
		return false;
	}
	public boolean acc_status(int i) {
		for(Account acc:user_accounts) {
			   if(acc.getAcc_id()==i) {
				  if(acc.isdormant()==true) {
					  return true;
				  }
			   }
		}
		return false;
	}
	public double acc_balance(int i) {

		for(Account acc:user_accounts) {
			   if(acc.getAcc_id()==i) {
				  
				  return acc.getAcc_balance();
				  
				  }
			   
		}
		return -1;
		
		
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
