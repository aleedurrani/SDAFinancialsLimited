import java.util.ArrayList;
import java.io.File;

public abstract class Account {
	protected int acc_id=0;
	protected String acc_type;
	protected double acc_balance;
	protected String acc_holder_name;
	protected boolean dormant;
	protected ArrayList<TransactionLedger> transaction_list;
	
	Account(){
		acc_id=-1;
		setAcc_balance(100);
		setAcc_holder_name("");
		dormant=false;
		transaction_list= new ArrayList<TransactionLedger>();
	}
	Account(String n,String t,int o){
		acc_id=o;
		acc_balance=100;
		dormant=false;
		acc_type=t;
		setAcc_holder_name(n);
		transaction_list= new ArrayList<TransactionLedger>();
		
		
	}
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int i) {
		acc_id=i;
	}
	
	
	public abstract String getAcc_type(); 
	public abstract void setAcc_type(String acc_type);
	
	public double getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}
	public String getAcc_holder_name() {
		return acc_holder_name;
	}
	public void setAcc_holder_name(String acc_holder_name) {
		this.acc_holder_name = acc_holder_name;
	}
	public boolean isdormant() {
		return dormant;
	}
	public void printtransactions() {
		System.out.println("The transaction list of acc with id:"+ acc_id);
		for(TransactionLedger t:transaction_list){
			System.out.println("Transaction ID: "+ t.getTransaction_id()+" | Account ID:"+t.getTransaction_acc_id()+" | Account Type:"+ t.getTransaction_acc_type()+" | Transaction Type:"+t.getTransaction_type()+" | Date&Time:"+t.getTransaction_date_time()+" | Amount:"+t.getTransaction_amount());
		}
		System.out.println();
	}
	public void print_account() {
		System.out.print(" Account ID:"+acc_id+" | AccountType:"+acc_type+" | Account Balance:"+acc_balance+" | Dormant status:"+isdormant()+" | ");
		printtransactions();
	}
	public abstract void deposit(int tr_id,double a,File myfile);
	public abstract boolean withdrawl(int tr_id,double a,File myfile);
	

}
